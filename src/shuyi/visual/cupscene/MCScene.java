package shuyi.visual.cupscene;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import shuyi.Shuyi;
import shuyi.container.measuringcup.MeasureCupType;
import shuyi.ingredient.addable.*;
import shuyi.operate.Operate;
import shuyi.operation.operations.IngredientWithAmount;
import shuyi.visual.cupscene.CupScene;

public class MCScene extends CupScene {
    private boolean isLargeMeasureCup = true;
    private ScrollPane scpOtherMC;
    private Label lblGoto;

    public MCScene(Button btnBack, Shuyi shuyi, ScrollPane scpOtherMC) {
        super(btnBack, shuyi);
        lblGoto = new Label();
        this.scpOtherMC = scpOtherMC;
        scpOtherMC.setContent(txtCurrentContain);
    }

    private Text txtOtherMC;

    @Override
    public void refreshCurrentContain() {

        if (isLargeMeasureCup) {
            txtCurrentContain.setText(shuyi.getMeasuringCup().printCup());
            container = shuyi.getMeasuringCup();
            txtOtherMC.setText(shuyi.getMeasuringCup100().printCup());

            scpOtherMC.setStyle("-fx-background-color: dodgerblue");
            scrollPane.setStyle("-fx-background-color: orange");
            if (lblGoto != null) {
                lblGoto.setText("点击窗口前往100毫升量杯：");
            }

        } else {
            txtCurrentContain.setText(shuyi.getMeasuringCup100().printCup());
            container = shuyi.getMeasuringCup100();
            txtOtherMC.setText(shuyi.getMeasuringCup().printCup());

            if (scpOtherMC != null) {
                scpOtherMC.setStyle("-fx-background-color: orange;");
            }
            scrollPane.setStyle("-fx-background-color: dodgerblue");
            if (lblGoto != null) {
                lblGoto.setText("点击窗口前往500毫升量杯：");
            }
        }
    }

    public void setLargeMeasureCup(boolean largeMeasureCup) {
        isLargeMeasureCup = largeMeasureCup;
    }

    public boolean isLargeMeasureCup() {
        return isLargeMeasureCup;
    }

    @Override
    void init() {
        cmbCupType.getItems().setAll(MeasureCupType.values());
        cmbCupType.getSelectionModel().select(1);
        txtOtherMC = new Text();
    }

    @Override
    void customLabelAndButtons() {
        cmbIngredient.getSelectionModel().select(0);
        cmbIngredient.fireEvent(new ActionEvent());
    }

    @Override
    void gripPaneCupTypeChange() {
        gridPane.add(btnCupWarning, 1, 2);
        scpOtherMC.setContent(txtOtherMC);
        gridPane.add(lblGoto, 2, 2);
        gridPane.add(scpOtherMC, 2, 3);
    }
}
