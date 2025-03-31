package com.example.week11solution;

public class Match implements SoccerEntity {

    private String homeTeam;
    private String awayTeam;
    private String score;
    private String league;
    private String date;
    private String stadium; // clearly added

    public Match(String homeTeam, String awayTeam, String score, String league, String date, String stadium) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.league = league;
        this.date = date;
        this.stadium = stadium;
    }

    @Override
    public String getId() {
        return homeTeam + "-" + awayTeam + "-" + date;
    }

    @Override
    public String getName() {
        return homeTeam + " vs " + awayTeam;
    }

    public String getHomeTeam() { return homeTeam; }
    public String getAwayTeam() { return awayTeam; }
    public String getScore() { return score; }
    public String getLeague() { return league; }
    public String getDate() { return date; }
    public String getStadium() { return stadium; } // clearly added getter
}
