package patterns.strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("Демонстрация паттерна Стратегия");

        Character warrior = new Character("Воин", 100);
        Character archer = new Character("Лучник", 80);

        AttackStrategy meleeAttack = new MeleeAttack();
        AttackStrategy rangedAttack = new RangedAttack();

        warrior.setAttackStrategy(meleeAttack);
        warrior.performAttack(archer);

        warrior.setAttackStrategy(rangedAttack);
        warrior.performAttack(archer);

        archer.setAttackStrategy(rangedAttack);
        archer.performAttack(warrior);

        archer.setAttackStrategy(meleeAttack);
        archer.performAttack(warrior);
    }
}