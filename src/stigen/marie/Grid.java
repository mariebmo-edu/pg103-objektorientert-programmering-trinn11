package stigen.marie;

import java.util.ArrayList;

public class Grid {

    int x;
    int y;
    Cell[][] grid;
    boolean withGrid = true;

    ArrayList<Shape> shapes = new ArrayList<>();

    public Grid(int x, int y){
        this.x = x;
        this.y = y;
        this.grid = new Cell[x+1][y+1];

        emptyGrid();
    }

    public boolean isWithGrid() {
        return withGrid;
    }

    //Brukeren kan si om man vil ha med eller uten grid
    public void setWithGrid(boolean withGrid) {
        this.withGrid = withGrid;
    }

    //Printer griden.
    public void printGrid(){

        System.out.println("");
        for(int j=y; j>=0; j--){

            //Ser om tallet er større eller mindre enn 10 for å bestemme mellomrom mellom tall og grid
            if(j<10){
                System.out.print(j + " ");
            }
            else{
                System.out.print(j);
            }

            //Lager en ny string som er tom, samt en for whitespace (tom linje mellom radene)
            StringBuilder currentLine = new StringBuilder();
            currentLine.append(firstSpaceEmpty());
            StringBuilder whiteSpace = new StringBuilder();
            whiteSpace.append("      ");

            for(int i=0; i<=x; i++){
                if(grid[i][j].isFilled()){
                    currentLine.append(takenSpace());
                    whiteSpace.append(takenSpace());
                }
                else{
                    currentLine.append(emptySpace());
                    whiteSpace.append(whiteSpaceRow(x));
                }
            }


            System.out.println(currentLine.toString());
            System.out.println(whiteSpace.toString());
            System.out.println(whiteSpace.toString());

        }
        System.out.println(printXLine(x));
    }

    public String printXLine(int x){

        StringBuilder s = new StringBuilder();
        s.append("          ");

        for(int i=0; i<=x; i++){
            if(i<10){
                s.append(i).append("        ");
            }
            else{
                s.append(i).append("       ");
            }

        }

        return s.toString();
    }

    public void addPoint(int x, int y){
        grid[x][y].setFilled(true);
    }

    public void addShape(Shape s){
        shapes.add(s);
    }

    public void drawAllShapes(){
        for(Shape s : shapes){
            if(s instanceof Circle){
                drawShape((Circle)s);
            }
            else if(s instanceof Rectangle){
                drawShape((Rectangle)s);
            }

        }
    }

    //Draw Shape for rectangles
    private void drawShape(Rectangle r){

            int xPos = (int)r.getLowerLeftCorner().getX();
            int yPos = (int)r.getLowerLeftCorner().getY();
            int width = r.getWidth();
            int height = r.getHeight();
            boolean filled = r.isFilled();

        if(filled){
            for(int i=yPos; i<yPos+height; i++){
                for(int j=xPos; j<xPos+width; j++){
                    grid[j][i].setFilled(true);
                }
            }
        }
        else{
            for(int i=yPos; i<yPos+height; i++){
                for(int j=xPos; j<xPos+width; j++){

                    if(i==yPos || i==yPos+height-1){
                        grid[j][i].setFilled(true);
                    }
                    if(j==xPos ||j==xPos+width-1){
                        grid[j][i].setFilled(true);
                    }

                }
            }
        }
    }

    public Shape getShape(int index) {
        return shapes.get(index);
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    private void drawShape(Circle c){

        int radius = c.getRadius();
        boolean filled = c.isFilled();
        int circleX = (int)c.getCenterPoint().getX();
        int circleY = (int)c.getCenterPoint().getY();


        printCircle(radius, circleX, circleY);

        if(filled){
            while(radius>=0){
                printCircle(radius, circleX, circleY);
                radius--;
            }

        }

    }

    private void printCircle(int radius, int circleX, int circleY) {
        for(int i = 0; i < 360; i++){
            int cY = circleY + (int)Math.round(radius * Math.sin(i));
            int cX = circleX + (int)Math.round(radius * Math.cos(i));
            grid[cX][cY].setFilled(true);
        }
    }

    private String takenSpace(){
        if(withGrid){

            return "XXXXXXXXX";
        }
        return "XXXXXXXXX";
    }


    private String emptySpace(){
        if(withGrid){
            return "----|----";
        }
        return "         ";
    }

    private String whiteSpaceRow(int x){

        if(withGrid){
            return "    |    ";
        }
        return "         ";
    }

    private String firstSpaceEmpty(){
        if(withGrid){
            return "----";
        }
        return "    ";
    }

    public void emptyGrid(){
        for(int i=0; i<=y; i++){
            for(int j=0; j<=x; j++){
                grid[j][i] = new Cell();
            }
        }
    }


}
