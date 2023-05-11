package manager;

import model.Point;
import model.Route;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RouteManager {
    private List<Route> routes;

    public RouteManager() {
        this.routes = loadRoutes();
    }

    public void createRoute() {
        Scanner scanner = new Scanner(System.in);
        Route route = new Route();
        int k = 0;
        System.out.println("Введите новый маршрут");
        do {
            route.add(editPoint());
            System.out.println("Хотите дальше вводить? 1 - да, 0 - назад");
            k = scanner.nextInt();
        } while (k != 0);
        this.routes.add(route);
    }

    // метод для сохранения всех маршрутов в файл
    public void saveRoutes() {
        try {
            FileOutputStream fileOut = new FileOutputStream("routes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.routes);
            out.close();
            fileOut.close();
            System.out.println("Маршруты сохранены в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Route> loadRoutes() {
        List<Route> loadedRoutes = new ArrayList<>();

        try {
            FileInputStream fileIn = new FileInputStream("routes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            loadedRoutes = (List<Route>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedRoutes;
    }

    public void editRoute() {
        Scanner scanner = new Scanner(System.in);
        int numberRoute;
        int numberPoint;
        int k;
        System.out.println("Полный список маршрутов");
        printRoute();
        System.out.println("Желаете отредаетировать маршрут? 1 - да, любое другое число нет");
        k = scanner.nextInt();
        if(k==1) {
            numberRoute = scanner.nextInt();
            numberPoint = scanner.nextInt();

            Point editedPoint = editPoint();

            this.routes.get(numberRoute).getPointList().set(numberPoint, editedPoint);
            this.routes.get(numberRoute).updateRoute();
        }
    }

    private Point editPoint() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пункт отправления");
        String departurePoint = scanner.next();
        System.out.println("Введите время прибытия, если пункт начальный, то 0 ");
        int arrivalTime = scanner.nextInt();
        System.out.println("Введите время отправления, если пункт конечный, то 0");
        int departureTime = scanner.nextInt();
        System.out.println("Введите пункт прибытия");
        String arrivalPoint = scanner.next();
        return new Point(departurePoint, departureTime, arrivalPoint, arrivalTime);
    }

    private void printRoute() {
        for (int i = 0; i < routes.size(); i++) {
            System.out.println("Индекс маршрута " + i + " Маршрут следует " +
                    routes.get(i).getPointList().getFirst().getDeparturePoint() + " ------> " +
                    routes.get(i).getPointList().getLast().getArrivalPoint());
            for (int j = 0; j < routes.get(i).getPointList().size(); j++) {
                System.out.println("Номер пункта" + j + "\n" +
                        "Пункт отправления " + routes.get(i).getPointList().get(j).getDeparturePoint() + "\n" +
                        "Время отправления " + routes.get(i).getPointList().get(j).getDepartureTime() + "\n" +
                        "Время прибытия " + routes.get(i).getPointList().get(j).getArrivalTime() + "\n" +
                        "Пункт прибытия " + routes.get(i).getPointList().get(j).getArrivalPoint() + "\n" +
                        "Время стоянки " + routes.get(i).getPointList().get(j).getStopTime() + "\n" +
                        "Время пути до след станции " + routes.get(i).getPointList().get(j).getTravelTime() + "\n" +
                        " | \n" +
                        " | \n" +
                        " | \n" +
                        " V");
            }
        }
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
