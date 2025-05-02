package pro1.drawingModel;

import java.awt.*;

public class House extends XYShape {
    private String color;
    public House(int x, int y, String color) {
        super(x,y); //calling constructor XYshape
        this.color = color; //save color
    }
    //draw method
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode(color)); //setting color based on code
        g.fillRect(x,y,50,50); //draw rectangle
        g.setColor(Color.BLACK); //setting color to black
        g.drawRect(x,y,50,50); //draw "obrys"
        g.drawLine(x,y,x + 25,y - 25); //left side of roof
        g.drawLine(x + 50, y, x+25,y-25); //right side of roof
        g.drawLine(x, y + 50, x+ 50, y + 50); //base of the roof
    }
}
