package stigen.marie;

import java.awt.*;

public class Circle extends Shape{

    int radius;
    MovablePoints centerPoint;

    public Circle(int radius, String color, boolean filled, double x, double y){
        super(Color.getColor(color), filled);
        this.radius = radius;
        this.centerPoint = new MovablePoints(x, y);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MovablePoints getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(MovablePoints centerPoint) {
        this.centerPoint = centerPoint;
    }

    @Override
    public int getParameter() {
        return 0;
    }

    @Override
    public int getArea() {
        return 0;
    }
}
