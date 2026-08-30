package patterns.strategy;

public interface AttackStrategy {
    void attack(Character target);
    String getName();
}