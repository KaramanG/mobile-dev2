package ru.mirea.karaman.lesson9.domain.usecase;

import ru.mirea.karaman.lesson9.domain.model.Recipe;
import ru.mirea.karaman.lesson9.domain.repository.RecipeRepository;

public class SaveFavoriteRecipeUseCase {
    private final RecipeRepository recipeRepository;
    public SaveFavoriteRecipeUseCase(RecipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }
    public boolean execute(Recipe recipe) {
        if (recipe.getName().isEmpty()) { return false; }
        return recipeRepository.saveRecipe(recipe);
    }
}