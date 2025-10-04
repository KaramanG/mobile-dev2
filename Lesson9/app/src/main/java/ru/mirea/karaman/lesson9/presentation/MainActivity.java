package ru.mirea.karaman.lesson9.presentation;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.karaman.lesson9.R;
import ru.mirea.karaman.lesson9.data.repository.RecipeRepositoryImpl;
import ru.mirea.karaman.lesson9.domain.model.Recipe;
import ru.mirea.karaman.lesson9.domain.repository.RecipeRepository;
import ru.mirea.karaman.lesson9.domain.usecase.GetFavoriteRecipeUseCase;
import ru.mirea.karaman.lesson9.domain.usecase.SaveFavoriteRecipeUseCase;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private GetFavoriteRecipeUseCase getFavoriteRecipeUseCase;
    private SaveFavoriteRecipeUseCase saveFavoriteRecipeUseCase;
    private TextView resultTextView;
    private EditText nameEditText;
    private EditText cuisineEditText;
    private Button saveButton;
    private Button getButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Activity создана");

        RecipeRepository recipeRepository = new RecipeRepositoryImpl(getApplicationContext());
        getFavoriteRecipeUseCase = new GetFavoriteRecipeUseCase(recipeRepository);
        saveFavoriteRecipeUseCase = new SaveFavoriteRecipeUseCase(recipeRepository);

        resultTextView = findViewById(R.id.tv_result);
        nameEditText = findViewById(R.id.et_recipe_name);
        cuisineEditText = findViewById(R.id.et_recipe_cuisine);
        saveButton = findViewById(R.id.btn_save_recipe);
        getButton = findViewById(R.id.btn_get_recipe);

        saveButton.setOnClickListener(view -> saveRecipe());
        getButton.setOnClickListener(view -> getRecipe());
    }

    private void saveRecipe() {
        String name = nameEditText.getText().toString();
        String cuisine = cuisineEditText.getText().toString();
        Log.d(TAG, "Сохранение рецепта: " + name);

        Recipe recipe = new Recipe(name, cuisine);
        boolean result = saveFavoriteRecipeUseCase.execute(recipe);
        resultTextView.setText(String.format("Сохранение успешно: %s", result));
    }

    private void getRecipe() {
        Log.d(TAG, "Запрос на получение рецепта");
        Recipe recipe = getFavoriteRecipeUseCase.execute();
        Log.d(TAG, "Получен рецепт: " + recipe.getName());

        String recipeInfo = String.format("Название: %s\nКухня: %s", recipe.getName(), recipe.getCuisine());
        resultTextView.setText(recipeInfo);
    }
}