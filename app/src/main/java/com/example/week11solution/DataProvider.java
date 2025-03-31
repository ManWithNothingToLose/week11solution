package com.example.week11solution;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<Player> createSamplePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Lionel Messi", 34, "Argentina", "Forward", "FC Barcelona", 10));
        players.add(new Player("Cristiano Ronaldo", 36, "Portugal", "Forward", "Juventus", 7));
        players.add(new Player("Robert Lewandowski", 32, "Poland", "Forward", "Bayern Munich", 9));
        return players; // Clearly added missing return statement
    }

    public static List<Team> createSampleTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("FC Barcelona", "Spain", "La Liga", "Camp Nou", 1899));
        teams.add(new Team("Manchester United", "England", "Premier League", "Old Trafford", 1878));
        teams.add(new Team("Bayern Munich", "Germany", "Bundesliga", "Allianz Arena", 1900));
        return teams; // Correct return statement clearly added
    }

    public static List<Match> createSampleMatches() { // Method name clearly fixed
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("FC Barcelona", "Real Madrid", "2-1", "La Liga", "2023-04-10", "Camp Nou"));
        matches.add(new Match("Manchester United", "Liverpool", "0-3", "Premier League", "2023-03-15", "Old Trafford"));
        matches.add(new Match("Bayern Munich", "Borussia Dortmund", "4-2", "Bundesliga", "2023-04-01", "Allianz Arena"));
        return matches; // Clearly added missing return statement
    }
}
