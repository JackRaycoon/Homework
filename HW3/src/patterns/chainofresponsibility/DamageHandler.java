package patterns.chainofresponsibility;

public class DamageHandler extends GameEventHandler {
    @Override
    public void handle(GameEvent event) {
        if (event.getType() == GameEvent.EventType.DAMAGE) {
            System.out.println("Обработка урона");
        } else if (nextHandler != null) {
            nextHandler.handle(event);
        }
    }
}