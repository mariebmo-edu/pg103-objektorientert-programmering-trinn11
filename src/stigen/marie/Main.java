package stigen.marie;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Grid grid = new Grid(25, 20);

        //grid.printGrid();

        Rectangle r = new Rectangle(2,4, "red", true, 12,10 );
        Square s = new Square(5, "green", false, 12, 3);
        Circle c = new Circle(4, "red", true, 6, 6);
        Circle c2 = new Circle(2, "green", false, 4, 13);

        grid.addShape(r);
        grid.addShape(s);
        grid.addShape(c);
        grid.addShape(c2);

        grid.drawAllShapes();
        grid.printGrid();
    }
}
