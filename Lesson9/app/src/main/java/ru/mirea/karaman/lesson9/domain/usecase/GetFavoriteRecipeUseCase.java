package ru.mirea.karaman.lesson9.domain.usecase;

import ru.mirea.karaman.lesson9.domain.model.Recipe;
import ru.mirea.karaman.lesson9.domain.repository.RecipeRepository;

public class GetFavoriteRecipeUseCase {
    private final RecipeRepository recipeRepository;
    public GetFavoriteRecipeUseCase(RecipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }
    public Recipe execute() { return recipeRepository.getRecipe(); }
}