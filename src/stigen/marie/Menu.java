package stigen.marie;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    static Grid grid = new Grid(25, 20);

    public static void handleMenu(){
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        printMenu();

        while(userInput != 5){
            userInput = Integer.parseInt(scanner.nextLine());

            handleUserChoice(userInput);
        }

    }

    public static void printMenu(){
        System.out.println("-----MENU------" +
                "1. Add Shape" +
                "2. Draw all shapes" +
                "3. Get shared area of squares" +
                "4. Move shape" +
                "5. Exit");
    }

    public static void handleUserChoice(int input){

        switch (input){
            case 1 -> addShape();
            case 2 -> drawShapes();
            case 3 -> getAreaOfSquares();
            case 4 -> moveShape();
            case 5 -> System.out.println("Exiting.");
            default -> System.out.println("Not valid command.");
        }
    }

    public static void initialize(){

        Rectangle r = new Rectangle(2,4, "red", true, 12,10 );
        Square s = new Square(5, "green", false, 12, 3);
        Circle c = new Circle(4, "red", true, 6, 6);
        Circle c2 = new Circle(2, "green", false, 4, 13);

        grid.addShape(r);
        grid.addShape(s);
        grid.addShape(c);
        grid.addShape(c2);

    }

    public static void drawShapes(){
        grid.drawAllShapes();
        grid.printGrid();
    }

    public static void addShape(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("type (rectangle, square, circle): ");
        String type = scanner.nextLine();
        System.out.println("colour: ");
        String color = scanner.nextLine();
        System.out.println("filled (y/n): ");
        String filled = scanner.nextLine();
        System.out.println("width/radius: ");
        int width = Integer.parseInt(scanner.nextLine());

        if(type.toLowerCase(Locale.ROOT).equals("rectangle")){
            System.out.println("height: ");
            int heigth = Integer.parseInt(scanner.nextLine());
            Rectangle r = new Rectangle(width, heigth, color, filled.equals("y"), 0, 0);

            grid.addShape(r);
        } else if (type.toLowerCase(Locale.ROOT).equals("square")){
            Square s = new Square(width, color, filled.equals("y"), 0, 0);
            grid.addShape(s);
        } else if (type.toLowerCase(Locale.ROOT).equals("circle")){
            Circle c = new Circle(width, color, filled.equals("y"), 0, 0);
            grid.addShape(c);
        } else {
            System.out.println("Something went wrong. Please try again.");
        }
    }

    public static void getAreaOfSquares(){

        double area = 0.0;
        for(Map.Entry<String, Shape> s : grid.shapes.entrySet()){
            if(s instanceof Square){
                area += ((Square) s).getArea();
            }
        }

        System.out.println("The area of all squares is: " + area);
    }

    public static void moveShape(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("which object would you like to move (id)?");
        String id = scanner.nextLine();
        System.out.println("How would you like to move the shape?");
        System.out.println("up: ");
        double up = Double.parseDouble(scanner.nextLine());
        System.out.println("down: ");
        double down = Double.parseDouble(scanner.nextLine());
        System.out.println("left: ");
        double left = Double.parseDouble(scanner.nextLine());
        System.out.println("right: ");
        double right = Double.parseDouble(scanner.nextLine());

        grid.shapes.get(id).moveByCoordinates(up, down, left, right);
        System.out.println("shape is moved");

    }


}
