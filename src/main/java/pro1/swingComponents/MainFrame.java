package pro1.swingComponents;

import pro1.drawingModel.Drawable;
import pro1.drawingModel.Ellipse;
import pro1.drawingModel.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    DrawingPanel drawingPanel;
    private int lastX;
    private int lastY;

    public MainFrame(Drawable example) {
        setTitle("PRO1 Graphics");
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        drawingPanel = new DrawingPanel(example);
        add(drawingPanel, BorderLayout.CENTER );
        JPanel leftPanel = new JPanel();
        add(leftPanel, BorderLayout.WEST);
        leftPanel.setPreferredSize(
                new Dimension(200,0));
        JButton button1 = new JButton("Draw rectangle");
        leftPanel.add(button1);
        JCheckBox checkBox1 = new JCheckBox("Random color");
        leftPanel.add(checkBox1);
        Random random = new Random();
        button1.addActionListener((e)->{
            String color;
            if(checkBox1.isSelected())
            {
                String r = Integer.toHexString(random.nextInt(256));
                String g = Integer.toHexString(random.nextInt(256));
                String b = Integer.toHexString(random.nextInt(256));
                color = "#"+r+g+b;
            }
            else
            {
                color = "#000000";
            }
            drawingPanel.setImage(new Rectangle(
                    lastX,lastY,100,100,color
            ));
        });

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lastX = e.getX() - 400;
                lastY = e.getY() - 400;
            }
        });
    }
}