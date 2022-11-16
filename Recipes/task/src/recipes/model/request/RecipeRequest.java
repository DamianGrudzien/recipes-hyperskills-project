package recipes.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import recipes.model.Recipe;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequest {
    @NotNull
    @NotBlank
    @NotEmpty
    String name;
    @NotNull
    @NotBlank
    @NotEmpty
    String description;
    @NotNull
    @NotBlank
    @NotEmpty
    String category;
    LocalDateTime date;
    @Size(min = 1)
    @NotNull
    List<String> ingredients;
    @Size(min = 1)
    @NotNull
    List<String> directions;

    @JsonIgnore
    public static Recipe mapRecipe(RecipeRequest recipeRequest) {
        Recipe recipe = new Recipe();
        recipe.setDate(LocalDateTime.now());
        recipe.setCategory(recipeRequest.getCategory());
        recipe.setDescription(recipeRequest.getDescription());
        recipe.setName(recipeRequest.getName());
        recipe.setIngredients(recipeRequest.getIngredients());
        recipe.setDirections(recipeRequest.getDirections());
        return recipe;
    }
}