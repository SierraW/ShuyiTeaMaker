package shuyi.visual.cupscene;

import javafx.scene.control.Button;
import shuyi.operation.Values.Values;
import shuyi.operation.operations.Amount;

public class ValueButton extends Button {
    private Values values;

    public Amount getValues() {
        return values.getValue();
    }

    public ValueButton(Values values) {
        super(values.toString());
        this.values = values;
    }

}
