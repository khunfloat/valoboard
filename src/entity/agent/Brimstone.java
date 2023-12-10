package entity.agent;

import application.Main;
import constant.team.Team;
import entity.base.Agent;
import utils.Coordinate;

import java.util.ArrayList;

public class Brimstone extends Controller {
    public Brimstone(String name, Team team) {
        super();
        this.setName(name);
        this.setTeam(team);
    }

    public void firstSkill() {
        if (this.getActionAvailable() >= SKILL_ACTION_COST && getFirstSkillAvailable()) {
            System.out.println("Beacon Orb");

            ArrayList<Agent> effectedAgents = utils.SkillEffect.getEffectAgent(this.getCoordinate(), 5);

            for (Agent agent : effectedAgents) {
                if (agent.getTeam() == this.getTeam()) {
                    agent.setShootingDamage(agent.getShootingDamage() + 2);
                }
            }

            this.setActionAvailable(this.getActionAvailable() - SKILL_ACTION_COST);
            this.setFirstSkillAvailable(false);
        } else {
            System.out.println("Out of action");
        }
    }

    public void secondSkill() {
        if (this.getActionAvailable() >= SKILL_ACTION_COST && getSecondSkillAvailable()) {
            System.out.println("Sky Smoke");

            if (this.getTeam() == Team.DEFENDER) {
                for (Agent enemy : Main.attackerAgentList) {
                    enemy.setShootingDamage(enemy.getShootingDamage() - 1);
                }
            } else {
                for (Agent enemy : Main.defenderAgentList) {
                    enemy.setShootingDamage(enemy.getShootingDamage() - 1);
                }
            }

            this.setActionAvailable(this.getActionAvailable() - SKILL_ACTION_COST);
            this.setSecondSkillAvailable(false);
        } else {
            System.out.println("Out of action");
        }
    }

    public void ultimateSkill(Coordinate coordinate) {
        if (this.getActionAvailable() >= ULTIMATE_ACTION_COST && getUltimateAvailable()) {
            System.out.println("Orbital Strike");

            ArrayList<Agent> effectedAgents = utils.SkillEffect.getEffectAgent(coordinate, 5);

            for (Agent agent : effectedAgents) {
                agent.setHp(agent.getHp() - 5);
            }

            this.setActionAvailable(this.getActionAvailable() - ULTIMATE_ACTION_COST);
            this.setUltimateAvailable(false);
        } else {
            System.out.println("Out of action");
        }
    }
}