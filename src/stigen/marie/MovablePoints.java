package stigen.marie;

public class MovablePoints implements Movable{

    double y = 0;
    double x = 0;

    public MovablePoints(double x, double y) {
        this.y = y;
        this.x = x;
    }

    public void moveByCoordinates(double up, double down, double left, double right){
        moveUp(up);
        moveDown(down);
        moveLeft(left);
        moveRight(right);
    }

    @Override
    public void moveUp(double distance) {
        y += distance;
    }

    @Override
    public void moveDown(double distance) {
        y -= distance;

    }

    @Override
    public void moveRight(double distance) {
        x += distance;

    }

    @Override
    public void moveLeft(double distance) {
        x -= distance;

    }

    @Override
    public String toString() {
        return "MovePoints{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
