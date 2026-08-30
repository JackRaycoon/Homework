package patterns.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        System.out.println("Демонстрация паттерна Строитель");

        GameCharacter warrior = new GameCharacter.Builder()
                .setName("Артур")
                .setHealth(150)
                .setMana(50)
                .setWeapon("Двуручный меч")
                .build();

        GameCharacter mage = new GameCharacter.Builder()
                .setName("Мерлин")
                .setHealth(80)
                .setMana(200)
                .setWeapon("Посох")
                .build();

        GameCharacter archer = new GameCharacter.Builder()
                .setName("Леголас")
                .setHealth(100)
                .setMana(70)
                .setWeapon("Лук")
                .build();

        System.out.println("\nNPC:");
        GameCharacter npc = new GameCharacter.Builder()
                .setName("Торговец")
                .setHealth(50)
                .build();
    }
}