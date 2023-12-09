package utils;

import java.util.ArrayList;

public class SkillRange {
    public static ArrayList<Coordinate> getAvailableSkillRange(Coordinate coordinate, int distance) {
//  x-cross and +-cross around the agent

        ArrayList<Coordinate> result = new ArrayList<>();

        for (int i=1; i <= distance; i++) {

//          Straight
            if (Coordinate.isCoordinateExist(coordinate.x, coordinate.y + i)) {
                result.add(new Coordinate(coordinate.x, coordinate.y + i));
            }

            if (Coordinate.isCoordinateExist(coordinate.x, coordinate.y - i)) {
                result.add(new Coordinate(coordinate.x, coordinate.y - i));
            }

            if (Coordinate.isCoordinateExist(coordinate.x + i, coordinate.y)) {
                result.add(new Coordinate(coordinate.x + i, coordinate.y));
            }

            if (Coordinate.isCoordinateExist(coordinate.x - i, coordinate.y)) {
                result.add(new Coordinate(coordinate.x - i, coordinate.y));
            }

//          Cross

            if (Coordinate.isCoordinateExist(coordinate.x + i, coordinate.y + i)) {
                result.add(new Coordinate(coordinate.x + i, coordinate.y + i));
            }

            if (Coordinate.isCoordinateExist(coordinate.x + i, coordinate.y - i)) {
                result.add(new Coordinate(coordinate.x + i, coordinate.y - i));
            }

            if (Coordinate.isCoordinateExist(coordinate.x - i, coordinate.y + i)) {
                result.add(new Coordinate(coordinate.x - i, coordinate.y + i));
            }

            if (Coordinate.isCoordinateExist(coordinate.x - i, coordinate.y - i)) {
                result.add(new Coordinate(coordinate.x - i, coordinate.y - i));
            }
        }

        return result;
    }
}
