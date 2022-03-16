package stigen.marie;

public class Cell {

    boolean isFilled;

    public Cell(){
        this.isFilled = false;
    }

    public Cell(boolean isFilled){
        this.isFilled = isFilled;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }


}
