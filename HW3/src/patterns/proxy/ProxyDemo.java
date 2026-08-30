package patterns.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("Демонстрация паттерна Прокси");

        // Создаем прокси для обычного пользователя
        System.out.println("\nОбычный пользователь:");
        GameService userService = new GameServiceProxy(false);

        userService.loadLevel("level1");
        userService.saveGame();
        userService.loadLevel("secret_level");

        System.out.println("\nАдминистратор:");
        GameService adminService = new GameServiceProxy(true);

        adminService.loadLevel("level1");
        adminService.saveGame();
        adminService.loadLevel("secret_level");
    }
}