package patterns.chainofresponsibility;

public class HealHandler extends GameEventHandler {
    @Override
    public void handle(GameEvent event) {
        if (event.getType() == GameEvent.EventType.HEAL) {
            System.out.println("Обработка лечения");
        } else if (nextHandler != null) {
            nextHandler.handle(event);
        }
    }
}