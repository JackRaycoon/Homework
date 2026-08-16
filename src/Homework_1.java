import java.util.ArrayList;
import java.util.List;

public final class Characteristics {
    private final float STR, INT, AGI, CON;

    public Characteristics(float STR, float INT, float AGI, float CON) {
        this.STR = STR;
        this.INT = INT;
        this.AGI = AGI;
        this.CON = CON;
    }

    public float getSTR() {
        return STR;
    }
    public float getINT() {
        return INT;
    }
    public float getAGI() {
        return AGI;
    }
    public float getCON() {
        return CON;
    }
}

public final class Character {
    private final int ID;
    private final String NAME;
    private final Race RACE;
    private final Characteristics CHARACTERISTICS;
    private final List<Skill> SKILLS;

    public Character(int id, String name, Race race, Characteristics characteristics) {
        this.ID = id;
        this.NAME = name;
        this.RACE = race;
        this.CHARACTERISTICS = characteristics;
        this.SKILLS = Skill.GenerateSkillsList(id);
    }

    public int getID() {
        return ID;
    }
    public String getNAME() {
        return NAME;
    }
    public Race getRACE() {
        return RACE;
    }
    public Characteristics getCHARACTERISTICS() {
        return CHARACTERISTICS;
    }
    public List<Skill> getSKILLS() {
        return List.copyOf(SKILLS);
    }

    public void ShowInfo() {
        System.out.println("=== Информация о персонаже ===");
        System.out.printf("ID: %d%n", ID);
        System.out.printf("Имя: %s%n", NAME);
        System.out.printf("Раса: %s%n", RACE.getDisplayName());
        System.out.println("--- Характеристики ---");
        System.out.printf("  Сила (STR): %.0f%n", CHARACTERISTICS.getSTR());
        System.out.printf("  Интеллект (INT): %.0f%n", CHARACTERISTICS.getINT());
        System.out.printf("  Ловкость (AGI): %.0f%n", CHARACTERISTICS.getAGI());
        System.out.printf("  Телосложение (CON): %.0f%n", CHARACTERISTICS.getCON());
        System.out.println("--- Навыки ---");
        if (SKILLS.isEmpty()) {
            System.out.println("  Нет изученных навыков");
        } else {
            for (int i = 0; i < SKILLS.size(); i++) {
                System.out.printf("  %d. %s%n", i + 1, SKILLS.get(i));
            }
        }
        System.out.println("=============================");
    }

    public enum Race {
        HUMAN("Человек"),
        ELF("Эльф"),
        GOBLIN("Гоблин"),
        ORC("Орк"),
        DWARF("Дварф");

        private final String displayName;

        Race(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    //Заглушка, главное обеспечить иммутабельность, чтобы не понадобилась глубокая копия в getSKILLS()
    public final static class Skill{
        public static List<Skill> GenerateSkillsList(int charId) {
            return new ArrayList<Skill>();
        }
    }
}

void main() {
    Character boblin = new Character(129, "Боблин", Character.Race.GOBLIN, new Characteristics(1,1,3,1));
    boblin.ShowInfo();
}