package entity.base;

import constant.team.Team;
import utils.Coordinate;

public abstract class Agent implements Skillable{

    private String name;
    private Team team;
    private int shootingDamage;
    private int actionAvailable;
    private int hp;
    private int shootingDistance;
    private boolean firstSkillAvailable;
    private boolean secondSkillAvailable;
    private boolean ultimateAvailable;
    private Coordinate coordinate;

    public void shoot(Agent enemy) {
//      must be check is in distance with SkillRange.getAvailableSkillRange() first with distance = 1
        if (actionAvailable >= 1) {
            enemy.setHp(enemy.getHp() - this.getShootingDamage());
            this.setActionAvailable(this.getActionAvailable() - 1);
        } else {
            System.out.println("Out of action");
        }
    };

    public void move(Coordinate destination) {
//      must be check is in distance with Movement.getAvailableMove() first

        if (actionAvailable >= 1) {
            this.setCoordinate(destination);
            this.setActionAvailable(this.getActionAvailable() - 1);
        } else {
            System.out.println("Out of action");
        }
    }

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

    public abstract void setNewRound();

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
        if (this.hp < 0) {
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
}
