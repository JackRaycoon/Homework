package patterns.strategy;

public class MeleeAttack implements AttackStrategy {
    @Override
    public void attack(Character target) {
        System.out.println("Ближняя атака мечом");
    }

    @Override
    public String getName() {
        return "ближняя атака";
    }
}
