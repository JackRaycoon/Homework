package patterns.strategy;

public class Character {
    private AttackStrategy attackStrategy;
    private String name;
    private int power;

    public Character(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
        System.out.printf("%s меняет стратегию атаки на %s%n", name, attackStrategy.getName());
    }

    public void performAttack(Character target) {
        System.out.printf("%s атакует!", name);
        attackStrategy.attack(target);
    }
}
