package shuyi.visual.cupscene;

import javafx.scene.control.Button;
import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.operation.Values.Values;
import shuyi.operation.operations.Amount;

public class IngredientButton extends Button {
    private Adable adable;

    public Ingredient getIngredient() {
        return adable.getIngredient();
    }

    public IngredientButton(Adable adable) {
        super(adable.toString());
        this.adable = adable;
    }

    public IngredientButton() {
        super();
        this.adable = null;
        setDisable(true);
    }

    public void setAdable(Adable adable) {
        if (adable == null) {
            this.adable = adable;
            setDisable(true);
            setVisible(false);
            return;
        }
        this.adable = adable;
        setText(adable.toString());
        setDisable(false);
        setVisible(true);
    }
}
