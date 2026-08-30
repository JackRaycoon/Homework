package patterns.strategy;

public class RangedAttack implements AttackStrategy {
    @Override
    public void attack(Character target) {
        System.out.println("Дальняя атака луком");
    }

    @Override
    public String getName() {
        return "дальняя атака";
    }
}
