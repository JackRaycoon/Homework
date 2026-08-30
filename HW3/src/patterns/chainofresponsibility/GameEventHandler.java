package patterns.chainofresponsibility;

public abstract class GameEventHandler {
    protected GameEventHandler nextHandler;

    public void setNext(GameEventHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handle(GameEvent event);
}