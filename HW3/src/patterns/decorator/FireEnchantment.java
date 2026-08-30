package patterns.decorator;

public class FireEnchantment implements Weapon {
    private Weapon weapon;

    public FireEnchantment(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int getDamage() {
        return weapon.getDamage() + 15;
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + "\nНаложено огненное зачарование.";
    }
}