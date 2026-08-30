package patterns.decorator;

public class BasicSword implements Weapon {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Базовый меч";
    }
}