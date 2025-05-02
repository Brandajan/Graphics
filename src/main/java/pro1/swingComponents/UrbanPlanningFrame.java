package pro1.swingComponents;

import pro1.drawingModel.Drawable;
import pro1.drawingModel.House;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UrbanPlanningFrame extends JFrame {
    private DrawingPanel drawingPanel; //panel for drawing
    private JTextField colorTextField; //textfield for requesting color
    private String currentColor = "#000000"; //default color is black

    public UrbanPlanningFrame() {
        //setting up the window
        setTitle("Urban Planning");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); //horizontal arrangement
        add(leftPanel, BorderLayout.WEST);//adding that panel to window
        leftPanel.setPreferredSize(new Dimension(200, 0));

        colorTextField = new JTextField("#000000",10); //text field
        leftPanel.add(new JLabel("Choose color: "));
        leftPanel.add(colorTextField); //adding textfield to panel
        //reset button
        JButton resetButtor = new JButton("Reset");
        leftPanel.add(resetButtor);

        drawingPanel = new DrawingPanel(new Drawable() {
            @Override
            public void draw(Graphics2D g) {
                for (Drawable house : drawingPanel.getHouses()){
                    house.draw(g);
                }
            }
        });
        add(drawingPanel, BorderLayout.CENTER); //adding panel to window

        resetButtor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.clearHouses();
                drawingPanel.repaint();
            }
        });
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String colorCode = colorTextField.getText(); //getting color from textfield
                try {
                    Color color = Color.decode(colorCode); //decoding the color
                    currentColor = colorCode; //if color valid, set
                } catch (NumberFormatException ex) {
                    currentColor = "#000000"; //if color not valid, use black
                }//getting xy from click
                int x = e.getX() - 400;
                int y = e.getY() - 400;
                //adding the house with right color
                drawingPanel.addHouse(new House(x,y,currentColor));
                drawingPanel.repaint(); //repaint to add the house
            }
        });
    }
}

