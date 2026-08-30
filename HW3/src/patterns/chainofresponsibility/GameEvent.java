package patterns.chainofresponsibility;

public class GameEvent {
    EventType type;

    public GameEvent(EventType type) {
        this.type = type;
    }

    public enum EventType {
        UNKNOWN, HEAL, DAMAGE
    }

    public EventType getType() {
        return type;
    }
}
