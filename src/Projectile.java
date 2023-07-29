import javafx.scene.shape.Polygon;

public class Projectile extends Character {
    private final double speedLimit;

    public Projectile(int x, int y) {
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
        speedLimit=0.6;
    }

    @Override
    public void accelerate() {
        super.accelerate();
        double speed = super.getMovement().magnitude();
        // After using the speedlimit idea on the ship i realized that it could be good for projectiles as well
        if (speed > speedLimit) {
            super.setMovement(super.getMovement().normalize().multiply(speedLimit));
        }
    }
}
