package patterns.chainofresponsibility;

public class ChainDemo {
    public static void main(String[] args) {
        System.out.println("Демонстрация паттерна Цепочка обязанностей");

        GameEventHandler damageHandler = new DamageHandler();
        GameEventHandler healHandler = new HealHandler();

        damageHandler.setNext(healHandler);

        System.out.println("\nСобытие: DAMAGE");
        GameEvent damageEvent = new GameEvent(GameEvent.EventType.DAMAGE);
        damageHandler.handle(damageEvent);

        System.out.println("\nСобытие: HEAL");
        GameEvent healEvent = new GameEvent(GameEvent.EventType.HEAL);
        damageHandler.handle(healEvent);

        System.out.println("\nСобытие: UNKNOWN");
        GameEvent unknownEvent = new GameEvent(GameEvent.EventType.UNKNOWN);
        damageHandler.handle(unknownEvent);
    }
}