package application;

import entity.base.Agent;
import constant.map.Map;

import java.util.List;

public class Main {

    public static Map map = new Map();
    public static int roundCount = 0;
    public static boolean isSpikedefuse = false;
    public static List<Agent> defenderAgentList;
    public static List<Agent> attackerAgentList;


    public static void main(String[] args) {

//        select agent
        AgentSelection.makeSelection();

//        run gameCore
        GameCore.playGame();

    }


}