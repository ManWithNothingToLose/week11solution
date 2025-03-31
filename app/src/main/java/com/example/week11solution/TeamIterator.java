package com.example.week11solution;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;
public class TeamIterator implements Iterator<Team> {
    private List<Team> teams;
    private int position = 0;

    public TeamIterator(List<Team> teams) {
        this.teams = teams;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < teams.size();
    }

    @Override
    public Team next() {
        if (hasNext()) {
            throw new NoSuchElementException("no teams available to show");
        }
        return teams.get(position++);

    }
}

