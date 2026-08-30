package patterns.adapter;

public class ExternalPhysicsEngine {
    public void applyForceToObject(float x, float y, float z) {
        System.out.println("Применение силы: " + x + ", " + y + ", " + z);
    }
}
