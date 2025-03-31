package com.example.week11solution;

public class Player implements SoccerEntity {

    private String name;
    private int age;
    private String country;
    private String position;
    private String team;
    private int number;

    // Constructor clearly initializing all attributes
    public Player(String name, int age, String country, String position, String team, int number) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.position = position;
        this.team = team;
        this.number = number;
    }

    // clearly implement interface method getId
    @Override
    public String getId() {
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    // additional getters clearly defined
    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getPosition() {
        return position;
    }

    public String getteam() {
        return team;
    }

    public int getNumber() {
        return number;
    }
}
