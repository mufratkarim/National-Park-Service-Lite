package com.mka.americanparks.model;

public class Topics {
    private String id;
    private String name;

    public Topics(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Topics() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

