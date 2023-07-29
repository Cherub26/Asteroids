import javafx.scene.shape.Polygon;

public class Ship extends Character {
    private final double speedLimit;

    public Ship(int x, int y) {
        super(new Polygon(-5, -5, 10, 0, -5, 5), x, y);
        speedLimit=0.3;
    }

    @Override
    public void accelerate() {
        super.accelerate();
        double speed = super.getMovement().magnitude();
        /* I found it that the ship goes so fast that the game pretty much just breaks so
        * i have set it up so that ship has a certain speed limit
        */
        if (speed > speedLimit) {
            super.setMovement(super.getMovement().normalize().multiply(speedLimit));
        }
    }

    @Override
    public void move() {
        super.move();
        //This is to make it so the ship slows down
        super.setMovement(super.getMovement().multiply(0.995));
    }
}