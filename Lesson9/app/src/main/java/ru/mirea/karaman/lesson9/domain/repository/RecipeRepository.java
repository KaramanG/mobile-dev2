package ru.mirea.karaman.lesson9.domain.repository;

import ru.mirea.karaman.lesson9.domain.model.Recipe;

public interface RecipeRepository {
    boolean saveRecipe(Recipe recipe);
    Recipe getRecipe();
}
