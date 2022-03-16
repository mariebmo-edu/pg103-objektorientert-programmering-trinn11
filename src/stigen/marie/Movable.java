package stigen.marie;

public interface Movable {

    default void moveUp(double distance){}
    default void moveDown(double distance){}
    default void moveRight(double distance){}
    default void moveLeft(double distance){}
    default void moveByCoordinates(double up, double down, double left, double right){}
}
