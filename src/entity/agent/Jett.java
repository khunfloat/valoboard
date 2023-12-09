package entity.agent;

import constant.team.Team;

public class Jett extends Duelist {

    public Jett(String name, Team team) {
        super();
        this.setName(name);
        this.setTeam(team);
    }

    @Override
    public void firstSkill() {
        if (this.getActionAvailable() >= 2) {
            System.out.println("Cloud Burst");
        }
    }

    @Override
    public void secondSkill() {

    }

    @Override
    public void thirdSkill() {

    }
}
