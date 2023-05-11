package model;

import java.io.Serializable;

public class Point implements Serializable {
    private String departurePoint; // пункт отправления
    private int departureTime; // время отправления
    private int arrivalTime; // время прибытия
    private String arrivalPoint; // пункт прибытия
    private int stopTime; // время стоянки на промежуточных станциях
    private int travelTime; // время в пути между промежуточными станциями

    // конструктор для создания нового маршрута
    public Point(String departurePoint, int departureTime, String arrivalPoint, int arrivalTime) {
        this.departurePoint = departurePoint;
        this.departureTime = departureTime;
        this.arrivalPoint = arrivalPoint;
        this.arrivalTime = arrivalTime;
        this.stopTime = this.departureTime - this.arrivalTime;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public int getStopTime() {
        return stopTime;
    }

    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }
}
