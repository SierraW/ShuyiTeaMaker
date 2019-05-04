package shuyi.visual.cupscene;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import shuyi.Shuyi;
import shuyi.container.measuringcup.MeasureCupType;
import shuyi.ingredient.addable.*;
import shuyi.operate.Operate;
import shuyi.operation.operations.IngredientWithAmount;
import shuyi.visual.cupscene.CupScene;

public class MCScene extends CupScene {
    public MCScene(Button btnBack, Shuyi shuyi) {
        super(btnBack, shuyi);
    }

    @Override
    public void refreshCurrentContain() {
        txtCurrentContain.setText(shuyi.getMeasuringCup().printCup());
        scrollPane.setContent(txtCurrentContain);
    }

    @Override
    void init() {
        cmbCupType.getItems().setAll(MeasureCupType.values());
        cmbCupType.getSelectionModel().select(1);
        container = shuyi.getMeasuringCup();
    }

    @Override
    void setCupAction() {
        cmbCupType.setOnAction(event -> {
            if (container.isEmpty()) {
                shuyi.setMeasuringCup(cmbCupType.getSelectionModel().getSelectedItem().getCup());
                container = shuyi.getMeasuringCup();
                setWarningMsg("Set Cup Successful", false);
                refreshLabel();
            } else {
                setWarningMsg("Cup not Empty!", true);
            }
        });
    }

    @Override
    void customLabelAndButtons() {
        cmbIngredient.getSelectionModel().select(0);
        cmbIngredient.fireEvent(new ActionEvent());
    }
}
