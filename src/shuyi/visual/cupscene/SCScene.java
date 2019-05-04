package shuyi.visual.cupscene;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import shuyi.Shuyi;
import shuyi.container.measuringcup.MeasureCupType;
import shuyi.container.shakecup.ShakeCupType;
import shuyi.operate.Operate;

public class SCScene extends CupScene {
    public SCScene(Button btnBack, Shuyi shuyi) {
        super(btnBack, shuyi);
    }

    Label lblShake = new Label("Shaking Machine Options:");

    Button btnShake = new Button("雪克机雪克");

    @Override
    void init() {
        cmbCupType.getItems().setAll(ShakeCupType.values());
        cmbCupType.getSelectionModel().select(0);
        container = shuyi.getShakeCup();
    }

    @Override
    public void refreshCurrentContain() {
        txtCurrentContain.setText(shuyi.getShakeCup().printCup());
        scrollPane.setContent(txtCurrentContain);
    }

    @Override
    void setCupAction() {
        cmbCupType.setOnAction(event -> {
            if (container.isEmpty()) {
                shuyi.setShakeCup(cmbCupType.getSelectionModel().getSelectedItem().getCup());
                container = shuyi.getShakeCup();
                setWarningMsg("Set Cup Successful", false);
                refreshLabel();
            } else {
                setWarningMsg("Cup not Empty!", true);
            }
        });
    }

    @Override
    void customLabelAndButtons() {
        HBox hBox = new HBox();
        hBox.getChildren().addAll(lblShake,btnShake);
        hBox.setSpacing(20);
        gridPane.add(hBox, 0, 7,3,1);
        btnShake.setOnAction(event -> {
            Operate.shake(container);
            refreshLabel();
        });
        setWarningMsg("Shake Successful", false);
        cmbIngredient.getSelectionModel().select(8);
        cmbIngredient.fireEvent(new ActionEvent());
    }
}
