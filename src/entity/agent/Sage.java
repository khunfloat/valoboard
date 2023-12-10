package entity.agent;

import constant.team.Team;
import entity.base.Agent;

import java.util.ArrayList;

public class Sage extends Sentinel {

    public Sage(String name, Team team) {
        super();
        this.setName(name);
        this.setTeam(team);
    }

    public void firstSkill() {
        if (this.getActionAvailable() >= SKILL_ACTION_COST && getFirstSkillAvailable()) {
            System.out.println("Slow Orb");

            ArrayList<Agent> effectedAgents = utils.SkillEffect.getEffectAgent(this.getCoordinate(), 4);

            for (Agent agent : effectedAgents) {
                agent.setSlowState(true);
            }

            this.setActionAvailable(this.getActionAvailable() - SKILL_ACTION_COST);
            this.setFirstSkillAvailable(false);
        } else {
            System.out.println("Out of action");
        }
    }

    public void secondSkill(Agent ally) {
        if (ally.getTeam() == this.getTeam()) {
            if (this.getActionAvailable() >= SKILL_ACTION_COST && getSecondSkillAvailable()) {
                System.out.println("Healing Orb");
                ally.setHp(ally.getHp() + 5);

                this.setActionAvailable(this.getActionAvailable() - SKILL_ACTION_COST);
                this.setSecondSkillAvailable(false);
            } else {
                System.out.println("Out of action");
            }
        } else {
            System.out.println("Can't heal enemy");
        }
    }

    public void ultimateSkill(Agent ally) {
        if (ally.isDead() && ally.getTeam() == this.getTeam()) {
            if (this.getActionAvailable() >= ULTIMATE_ACTION_COST && getUltimateAvailable()) {
                System.out.println("Resurrection");

                ally.setDead(false);
                ally.setHp(3);

                this.setActionAvailable(this.getActionAvailable() - ULTIMATE_ACTION_COST);
                this.setUltimateAvailable(false);
            } else {
                System.out.println("Out of action");
            }
        } else {
            System.out.println("Can't resurrect enemy");
        }
    }
}
