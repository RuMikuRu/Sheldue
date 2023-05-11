package model;

import java.io.Serializable;
import java.util.LinkedList;

public class Route implements Serializable {
    private LinkedList<Point> pointList = new LinkedList<>();
    private int allTimes;

    public Route(LinkedList<Point> pointList) {
        this.pointList = pointList;
    }

    public Route() {
    }

    public void updateRoute() {
        if (this.pointList.size() >= 2) {
            calcTravelTime();
            allTimes = pointList.getLast().getArrivalTime() - pointList.getFirst().getDepartureTime();
        }
    }

    private void calcTravelTime() {
        int travelTimes;
        for (int i = 0; i < pointList.size() - 1; i++) {
            travelTimes = pointList.get(i + 1).getArrivalTime() - pointList.get(i).getDepartureTime();
            pointList.get(i).setTravelTime(travelTimes);
        }
    }

    public void add(Point point) {
        this.pointList.add(point);
        updateRoute();
    }

    public LinkedList<Point> getPointList() {
        return pointList;
    }

    public void setPointList(LinkedList<Point> pointList) {
        this.pointList = pointList;
    }

    public int getAllTimes() {
        return allTimes;
    }

    public void setAllTimes(int allTimes) {
        this.allTimes = allTimes;
    }
}
