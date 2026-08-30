package patterns.proxy;

public class RealGameService implements GameService {
    @Override
    public void loadLevel(String levelName) {
        System.out.println("Загрузка уровня: " + levelName);
    }

    @Override
    public void saveGame() {
        System.out.println("Сохранение игры");
    }
}