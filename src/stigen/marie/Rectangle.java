package stigen.marie;

import java.awt.*;

public class Rectangle extends Shape{

    int width;
    int height;
    MovablePoints lowerLeftCorner;
    MovablePoints upperRightCorner;


    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public Rectangle(int width, int height, String color, boolean filled, double x, double y){
        super(Color.getColor(color), filled);
        this.width = width;
        this.height = height;
        this.lowerLeftCorner = new MovablePoints(x, y);
        this.upperRightCorner = new MovablePoints(x+getWidth(), y+getHeight());
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getParameter() {
        return 2*getWidth() + 2*getHeight();
    }

    @Override
    public int getArea() {
        return getHeight()*getWidth();
    }

    public MovablePoints getLowerLeftCorner() {
        return lowerLeftCorner;
    }

    public void setLowerLeftCorner(MovablePoints lowerLeftCorner) {
        this.lowerLeftCorner = lowerLeftCorner;
    }
}
