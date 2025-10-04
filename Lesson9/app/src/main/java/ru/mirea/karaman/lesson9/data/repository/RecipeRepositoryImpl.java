package ru.mirea.karaman.lesson9.data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import ru.mirea.karaman.lesson9.domain.model.Recipe;
import ru.mirea.karaman.lesson9.domain.repository.RecipeRepository;

public class RecipeRepositoryImpl implements RecipeRepository {
    private static final String PREFS_NAME = "RecipePrefs";
    private static final String KEY_RECIPE_NAME = "recipeName";
    private static final String KEY_RECIPE_CUISINE = "recipeCuisine";
    private final SharedPreferences sharedPreferences;

    public RecipeRepositoryImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean saveRecipe(Recipe recipe) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_RECIPE_NAME, recipe.getName());
        editor.putString(KEY_RECIPE_CUISINE, recipe.getCuisine());
        return editor.commit();
    }

    @Override
    public Recipe getRecipe() {
        String name = sharedPreferences.getString(KEY_RECIPE_NAME, "Рецепт не найден");
        String cuisine = sharedPreferences.getString(KEY_RECIPE_CUISINE, "Кухня не указана");
        return new Recipe(name, cuisine);
    }
}