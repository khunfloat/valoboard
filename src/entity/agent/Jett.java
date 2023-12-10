package entity.agent;

import constant.team.Team;
import entity.base.Agent;
import utils.Coordinate;

public class Jett extends Duelist {

    public Jett(String name, Team team) {
        super();
        this.setName(name);
        this.setTeam(team);
    }

    public void firstSkill(Agent enemy) {
        if ((this.getActionAvailable() >= SKILL_ACTION_COST) && (getFirstSkillAvailable())) {
            System.out.println("Cloud Burst");
            enemy.setShootingDamage(enemy.getShootingDamage() - 1);

            this.setActionAvailable(this.getActionAvailable() - SKILL_ACTION_COST);
            this.setFirstSkillAvailable(false);
        } else {
            System.out.println("Out of action");
        }
    }

    public void secondSkill(Coordinate destination) {
        if ((this.getActionAvailable() >= SKILL_ACTION_COST) && (getSecondSkillAvailable())) {
            System.out.println("Tail Wind");
            this.move(destination); // this method -1 action therefore we have to -1 action again

            this.setActionAvailable(this.getActionAvailable() - (SKILL_ACTION_COST - 1));
            this.setSecondSkillAvailable(false);
        } else {
            System.out.println("Out of action");
        }
    }

    public void ultimateSkill() {
        if ((this.getActionAvailable() >= ULTIMATE_ACTION_COST) && (getUltimateAvailable())) {
            System.out.println("Blade Storm");
            this.setShootingDistance(getShootingDistance() + 1);
            this.setShootingDamage(7);

            this.setActionAvailable(this.getActionAvailable() - ULTIMATE_ACTION_COST);
            this.setUltimateAvailable(false);
        } else {
            System.out.println("Out of action");
        }
    }
}
