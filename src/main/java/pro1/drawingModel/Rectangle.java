package pro1.drawingModel;

import java.awt.*;

public class Rectangle extends WidthHeightShape {
    private String color;

    public Rectangle(int x, int y, int height, int width, String color) {
        super(x,y,height,width);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode(color));
        g.fillRect(x,y,width,height);
        g.drawString("I'm rectangle",x,y);
    }
}
