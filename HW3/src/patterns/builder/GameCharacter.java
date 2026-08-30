package patterns.builder;

public class GameCharacter {
    private String name;
    private int health;
    private int mana;
    private String weapon;

    private GameCharacter() {
        this.name = "Безымянный";
        this.health = 100;
        this.mana = 50;
        this.weapon = "Кулаки";
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public String getWeapon() {
        return weapon;
    }


    public void displayInfo() {
        System.out.println("Информация о персонаже:");
        System.out.println("Имя: " + name);
        System.out.println("Здоровье: " + health);
        System.out.println("Мана: " + mana);
        System.out.println("Оружие: " + weapon);
    }

    public static class Builder {
        private GameCharacter character;

        public Builder() {
            this.character = new GameCharacter();
        }

        public Builder setName(String name) {
            if (name != null && !name.trim().isEmpty()) {
                character.name = name;
            } else {
                System.out.println("Ошибка: имя не может быть пустым");
            }
            return this;
        }

        public Builder setHealth(int health) {
            if (health > 0) {
                character.health = health;
            } else {
                System.out.println("Ошибка: здоровье должно быть положительным");
            }
            return this;
        }

        public Builder setMana(int mana) {
            if (mana >= 0) {
                character.mana = mana;
            } else {
                System.out.println("Ошибка: мана не может быть отрицательной");
            }
            return this;
        }

        public Builder setWeapon(String weapon) {
            if (weapon != null && !weapon.trim().isEmpty()) {
                character.weapon = weapon;
            } else {
                System.out.println("Ошибка: оружие не может быть пустым");
            }
            return this;
        }

        public GameCharacter build() {
            if (character.name.equals("Безымянный")) {
                System.out.println("Предупреждение: персонаж создается с именем по умолчанию");
            }

            System.out.println("Создание персонажа завершено: " + character.name);
            character.displayInfo();
            return character;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}