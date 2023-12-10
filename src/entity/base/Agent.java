package entity.base;

import constant.team.Team;
import utils.Coordinate;

public abstract class Agent implements Moveable {

    private String name;
    private Team team;
    private int shootingDamage;
    private int actionAvailable;
    private int hp;
    private int shootingDistance;
    private boolean firstSkillAvailable;
    private boolean secondSkillAvailable;
    private boolean ultimateAvailable;
    private boolean isDead;
    private Coordinate coordinate;
    private boolean isSlowState;
    public final int DEFAULT_ACTION = 3;
    public final int BASIC_ACTION_COST = 1;
    public final int SKILL_ACTION_COST = 2;
    public final int ULTIMATE_ACTION_COST = 3;

    public void shoot(Agent enemy) {
//      must be check is in distance with SkillRange.getAvailableSkillRange() first with distance = 1
        if (actionAvailable >= BASIC_ACTION_COST) {
            enemy.setHp(enemy.getHp() - this.getShootingDamage());
            this.setActionAvailable(this.getActionAvailable() - BASIC_ACTION_COST);
        } else {
            System.out.println("Out of action");
        }
    };

    public void move(Coordinate destination) {
//      must be check is in distance with Movement.getAvailableMove() first
        if (isSlowState()) {
            if (actionAvailable >= BASIC_ACTION_COST) {
                this.setCoordinate(destination);
                this.setActionAvailable(this.getActionAvailable() - BASIC_ACTION_COST);
            } else {
                System.out.println("Out of action");
            } }

        else {
            System.out.println("Can't move because of slow state");
        }
    }

    public abstract void setNewRound();

    public boolean getFirstSkillAvailable() {
        return firstSkillAvailable;
    }

    public void setFirstSkillAvailable(boolean firstSkillAvailable) {
        this.firstSkillAvailable = firstSkillAvailable;
    }

    public boolean getSecondSkillAvailable() {
        return secondSkillAvailable;
    }

    public void setSecondSkillAvailable(boolean secondSkillAvailable) {
        this.secondSkillAvailable = secondSkillAvailable;
    }

    public int getActionAvailable() {
        return actionAvailable;
    }

    public void setActionAvailable(int actionAvailable) {
        this.actionAvailable = actionAvailable;
    }

    public boolean getUltimateAvailable() {
        return ultimateAvailable;
    }

    public void setUltimateAvailable(boolean ultimateAvailable) {
        this.ultimateAvailable = ultimateAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShootingDamage() {
        return shootingDamage;
    }

    public void setShootingDamage(int shootingDamage) {
        this.shootingDamage = shootingDamage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp <= 0) {
            this.hp = 0;
            return;
        }

        this.hp = hp;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getShootingDistance() {
        return shootingDistance;
    }

    public void setShootingDistance(int shootingDistance) {
        this.shootingDistance = shootingDistance;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isSlowState() {
        return isSlowState;
    }

    public void setSlowState(boolean slowState) {
        isSlowState = slowState;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
