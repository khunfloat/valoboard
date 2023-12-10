package entity.agent;

import entity.base.Agent;

public abstract class Sentinel extends Agent {

    public final int DEFAULT_HP = 7;
    public final int DEFAULT_SHOOTING_DAMAGE = 3;
    public final int DEFAULT_SHOOTING_DISTANCE = 2;

    @Override
    public void setNewRound() {
        this.setActionAvailable(DEFAULT_ACTION);
        this.setFirstSkillAvailable(true);
        this.setSecondSkillAvailable(true);
        this.setHp(DEFAULT_HP);
        this.setShootingDamage(DEFAULT_SHOOTING_DAMAGE);
        this.setShootingDistance(DEFAULT_SHOOTING_DISTANCE);
        this.setSlowState(false);
    }

    @Override
    public void setHp(int hp) {
        if (hp <= 0) {
            super.setHp(0);
            return;
        } else if (hp >= DEFAULT_HP) {
            super.setHp(DEFAULT_HP);
            return;
        }

        super.setHp(hp);
    }
}
