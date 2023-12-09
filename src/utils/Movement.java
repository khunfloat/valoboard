package utils;

import java.util.ArrayList;

public class Movement {
    
    public ArrayList<Coordinate> getAvailableMove(Coordinate coordinate){
//  move to 8 direction around the agent
        ArrayList<Coordinate> result = new ArrayList<>();

        Coordinate topLeft = new Coordinate(coordinate.x - 1, coordinate.y + 1);

        for (int i=0; i < 3; i++) {
            for (int j=0; j < 3; j++) {
                if (Coordinate.isCoordinateExist(topLeft.x + i, topLeft.y - j)) {
                    result.add(new Coordinate(topLeft.x + i, topLeft.y - j));
                }
            }
        }

        return result;
    }
}
