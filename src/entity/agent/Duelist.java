package entity.agent;

import entity.base.Agent;

public abstract class Duelist extends Agent {

    public Duelist() {
        this.setShootingDamage(4);
        this.setShootingDistance(2);
    }

    @Override
    public void setNewRound() {
        this.setHp(6);
        this.setShootingDamage(4);
        this.setShootingDistance(2);
        this.setFirstSkillAvailable(true);
        this.setSecondSkillAvailable(true);
    }
}
