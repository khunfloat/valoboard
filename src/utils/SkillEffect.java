package utils;

import application.Main;
import entity.base.Agent;

import java.util.ArrayList;

public class SkillEffect {

    public static ArrayList<Coordinate> getSkillEffectRange(Coordinate coordinate, int distance) {
        ArrayList<Coordinate> effectRange = new ArrayList<>();

        Coordinate topLeft = new Coordinate(coordinate.x - distance / 2, coordinate.y + distance / 2);

        for (int i=0; i < distance; i++) {
            for (int j=0; j < distance; j++) {
                if (Coordinate.isCoordinateExist(topLeft.x + i, topLeft.y - j)) {
                    effectRange.add(new Coordinate(topLeft.x + i, topLeft.y - j));
                }
            }
        }

        return effectRange;
    }

    public static ArrayList<Agent> getEffectAgent(Coordinate coordinate, int distance) {
        ArrayList<Agent> effectAgent = new ArrayList<>();

        ArrayList<Coordinate> effectRange = getSkillEffectRange(coordinate, distance);

        for (Agent attacker : Main.attackerAgentList) {
            if (effectRange.contains(attacker.getCoordinate())) {
                effectAgent.add(attacker);
            }
        }

        for (Agent defender : Main.defenderAgentList) {
            if (effectRange.contains(defender.getCoordinate())) {
                effectAgent.add(defender);
            }
        }

        return effectAgent;
    }
}
