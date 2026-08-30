package patterns.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("Демонстрация паттерна Адаптер");

        System.out.println("\nИспользование стороннего движка напрямую:");
        ExternalPhysicsEngine externalEngine = new ExternalPhysicsEngine();
        externalEngine.applyForceToObject(10.5f, 20.3f, 5.0f);

        System.out.println("\nИспользование нашего интерфейса через адаптер:");
        GamePhysics physicsEngine = new PhysicsEngineAdapter();

        Vector3 force = new Vector3(10.5f, 20.3f, 5.0f);
        physicsEngine.applyForce(force);

        System.out.println("\nПрименение гравитации:");
        physicsEngine.applyGravity(9.8f);

        System.out.println("\nФизические операции:");

        Vector3 jumpForce = new Vector3(0, 15.0f, 0);
        System.out.println("Прыжок:");
        physicsEngine.applyForce(jumpForce);

        Vector3 pushForce = new Vector3(-5.0f, 0, 3.0f);
        System.out.println("Толчок:");
        physicsEngine.applyForce(pushForce);

        System.out.println("Сильная гравитация:");
        physicsEngine.applyGravity(20.0f);
    }
}