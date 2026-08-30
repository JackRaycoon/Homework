package patterns.proxy;

public class GameServiceProxy implements GameService {
    private RealGameService realService;
    private boolean isAdmin;

    public GameServiceProxy(boolean isAdmin) {
        this.realService = new RealGameService();
        this.isAdmin = isAdmin;
    }

    @Override
    public void loadLevel(String levelName) {
        if (isAdmin) {
            realService.loadLevel(levelName);
        } else {
            System.out.println("Недостаточно прав для загрузки уровня");
        }
    }

    @Override
    public void saveGame() {
        realService.saveGame();
    }
}
