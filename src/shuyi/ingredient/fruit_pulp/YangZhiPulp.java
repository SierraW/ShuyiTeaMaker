package shuyi.ingredient.fruit_pulp;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class YangZhiPulp extends Ingredient {
    public YangZhiPulp() {
        super(IngredientType.FRUIT_PULP);
    }

    @Override
    public String getDescriptions() {
        return "杨枝浆";
    }

}
