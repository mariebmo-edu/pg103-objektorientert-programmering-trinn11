package stigen.marie;

public class Square extends Rectangle{


    public Square(int side) {
        super(side, side);
    }

    public Square(int side, String color, boolean filled, double x, double y) {
        super(side, side, color, filled, x, y);
    }
}
