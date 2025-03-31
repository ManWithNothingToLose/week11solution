package com.example.week11solution;

import java.util.List;

public class TeamRepository extends Repository<Team> {

    public TeamRepository(List<Team> teams) {
        super(teams); //
    }

    public List<Team> findTeamsByLeague(String league) {
        return filter(team -> team.getLeague().equals(league));
    }

    public List<Team> findByCountry(String country) {
        return filter(team -> team.getCountry().equals(country));
    }

    public List<Team> findTeamsFoundedBefore(int year) {
        return filter(team -> team.getFoundedYear() < year);
    }
}
