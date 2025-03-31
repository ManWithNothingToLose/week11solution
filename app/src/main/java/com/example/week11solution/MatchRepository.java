package com.example.week11solution;

import java.util.List;

public class MatchRepository extends Repository<Match> {

    public MatchRepository(List<Match> matches) {
        super(matches);
    }

    // Filter matches by team name (either home or away team)
    public List<Match> filterByTeam(String team) {
        return filter(match -> match.getHomeTeam().equals(team) || match.getAwayTeam().equals(team));
    }

    // Filter matches by league
    public List<Match> filterByLeague(String league) {
        return filter(match -> match.getLeague().equals(league));
    }

    // Filter matches by date
    public List<Match> filterByDate(String date) {
        return filter(match -> match.getDate().equals(date));
    }

    // Filter matches by total goals (home or away goals)
    public List<Match> filterByGoals(int goals) {
        return filter(match -> {
            String[] scores = match.getScore().split("-");
            int homeGoals = Integer.parseInt(scores[0].trim());
            int awayGoals = Integer.parseInt(scores[1].trim());
            return homeGoals == goals || awayGoals == goals;
        });
    }

    // You don't need to override filter again unless adding new functionality
}
