package utils;

import application.Main;

import java.util.ArrayList;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static boolean isCoordinateExist(int x, int y) {
        if ((x < 0 || x > Main.map.getWidth()) && (y < 0 || y > Main.map.getHeight())) {
            return Main.map.getCoordinate(x, y) != 1;
        }
        return false;
    }

}
