package com.example.week11solution;

import java.util.List;

public class PlayerRepository extends Repository<Player> {

    public PlayerRepository(List<Player> players) {
        super(players);
    }

    public List<Player> findByName(String name) {
        return filter(player -> player.getName().equalsIgnoreCase(name));
    }

    public List<Player> findByCountry(String country) {
        return filter(player -> player.getCountry().equalsIgnoreCase(country));
    }

    public List<Player> findByPosition(String position) {
        return filter(player -> player.getPosition().equalsIgnoreCase(position));
    }

    public List<Player> findYoungerThan(int age) {
        return filter(player -> player.getAge() < age);
    }

    public List<Player> findOlderThan(int age) {
        return filter(player -> player.getAge() > age);
    }
}
