package stigen.marie;

import java.awt.*;

public abstract class Shape implements Movable {
    private Color color = Color.red;
    private boolean filled = false;

    public Shape(){

    }

    public Shape(Color color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract int getParameter();
    public abstract int getArea();
}
