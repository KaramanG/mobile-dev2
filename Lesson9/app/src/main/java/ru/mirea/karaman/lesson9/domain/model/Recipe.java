package ru.mirea.karaman.lesson9.domain.model;

public class Recipe {
    private final String name;
    private final String cuisine;

    public Recipe(String name, String cuisine) {
        this.name = name;
        this.cuisine = cuisine;
    }

    public String getName() { return name; }
    public String getCuisine() { return cuisine; }
}
