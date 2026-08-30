package patterns.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("Демонстрация паттерна Декоратор");

        System.out.println("\nБазовое оружие:");
        Weapon basicSword = new BasicSword();
        System.out.println(basicSword.getDescription() + "\nУрон " + basicSword.getDamage());

        System.out.println("\nЗачарования:");
        Weapon fireSword = new FireEnchantment(new BasicSword());
        System.out.println(fireSword.getDescription() + "\nУрон " + fireSword.getDamage());

        Weapon sharpSword = new SharpEnchantment(new BasicSword());
        System.out.println(sharpSword.getDescription() + "\nУрон " + sharpSword.getDamage());

        System.out.println("\nМножественное зачарование:");
        Weapon legendarySword = new FireEnchantment(new SharpEnchantment(new BasicSword()));
        System.out.println(legendarySword.getDescription() + "\nУрон " + legendarySword.getDamage());

        System.out.println("\nПроверка динамики:");
        Weapon dynamicWeapon = new BasicSword();
        System.out.println("Изначально: " + dynamicWeapon.getDescription() + "\nУрон " + dynamicWeapon.getDamage());

        dynamicWeapon = new FireEnchantment(dynamicWeapon);
        System.out.println("После огненного зачарования: " + dynamicWeapon.getDescription() + "\nУрон " + dynamicWeapon.getDamage());

        dynamicWeapon = new SharpEnchantment(dynamicWeapon);
        System.out.println("После заточки: " + dynamicWeapon.getDescription() + "\nУрон " + dynamicWeapon.getDamage());
    }
}