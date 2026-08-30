package patterns.decorator;

public class SharpEnchantment implements Weapon {
    private Weapon weapon;

    public SharpEnchantment(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int getDamage() {
        return weapon.getDamage() + 5;
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + "\nЗаточено.";
    }
}