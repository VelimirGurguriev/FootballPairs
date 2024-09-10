package com.exam.FootballPairs.model;

public class Team {
    private long id;
    private String name;
    private String managerName;
    private String group;

    public Team() {
    }

    public Team(long id, String name, String managerName, String group) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
        this.group = group;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
