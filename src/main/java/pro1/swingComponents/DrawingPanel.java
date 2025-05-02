package pro1.swingComponents;
import pro1.drawingModel.Drawable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private List<Drawable> houses = new ArrayList<>(); //list of all houses, that should be shown
    Drawable image;

    public DrawingPanel(Drawable image) {
        this.image = image;
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(400,400); //middle
        g.drawLine(-5000,0,5000,0); //horizontal
        g.drawLine(0,-5000,0,5000); //vertical

        for(Drawable house : houses) {
            house.draw((Graphics2D)g);
        }
    }
    public void addHouse(Drawable house) {//adding house to list
        houses.add(house);
    }
    public void clearHouses() {//erase all houses
        houses.clear();
    }
    public List<Drawable> getHouses() {//return all houses
        return houses;
    }
    public void setImage(Drawable image)
    {
        this.image = image;
        repaint();
    }
}