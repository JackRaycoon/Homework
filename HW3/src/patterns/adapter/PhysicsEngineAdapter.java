package patterns.adapter;

public class PhysicsEngineAdapter implements GamePhysics {
    private ExternalPhysicsEngine externalEngine;

    public PhysicsEngineAdapter() {
        this.externalEngine = new ExternalPhysicsEngine();
    }

    @Override
    public void applyForce(Vector3 force) {
        externalEngine.applyForceToObject(force.getX(), force.getY(), force.getZ());
    }

    @Override
    public void applyGravity(float strength) {
        externalEngine.applyForceToObject(0, -strength, 0);
    }
}