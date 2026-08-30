package patterns.adapter;

public interface GamePhysics {
    void applyForce(Vector3 force);
    void applyGravity(float strength);
}
