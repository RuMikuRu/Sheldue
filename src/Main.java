import manager.RouteManager;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        RouteManager routeManager = new RouteManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Меню:\s
                1. Создать маршрут\s
                2. Показать список маршрутов и редактировать\s
                3. Сохранить маршруты\s
                0. Выход""");
        int k = scanner.nextInt();
        while (k != 0) {
            switch (k) {
                case 1 -> routeManager.createRoute();
                case 2 -> routeManager.editRoute();
                case 3 -> routeManager.saveRoutes();
                default -> System.out.println("""
                        Меню:\s
                        1. Создать маршрут\s
                        2. Показать список маршрутов и редактировать\s
                        3. Сохранить маршруты\s
                        0. Выход""");
            }
            System.out.println("""
                    Меню:\s
                    1. Создать маршрут\s
                    2. Показать список маршрутов и редактировать\s
                    3. Сохранить маршруты\s
                    0. Выход""");
            k = scanner.nextInt();
        }
    }
}