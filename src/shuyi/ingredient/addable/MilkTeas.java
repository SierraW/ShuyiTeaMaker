package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;
import shuyi.ingredient.milktea.JasmineMilkTea;
import shuyi.ingredient.milktea.SignatureColdMilkTea;
import shuyi.ingredient.milktea.SignatureHotMilkTea;

public enum MilkTeas implements Adable {
    SignatureMilkTea_Cold, SignatureMilkTea_Hot, JasmineMilkTea, Milk;

    @Override
    public Ingredient getIngredient() {
        switch (this) {
            case Milk:
                return new Ingredient(IngredientType.MILK_TEA) {
                    @Override
                    public String getDescriptions() {
                        return "牛奶";
                    }
                };
            case JasmineMilkTea:
                return new JasmineMilkTea();
            case SignatureMilkTea_Hot:
                return new SignatureHotMilkTea();
            case SignatureMilkTea_Cold:
            default:
                return new SignatureColdMilkTea();
        }
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
