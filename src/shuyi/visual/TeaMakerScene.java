package shuyi.visual;

import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import shuyi.Shuyi;
import shuyi.container.Cup;
import shuyi.container.MeasuringCup;
import shuyi.container.ShakeCup;
import shuyi.operate.Operate;
import shuyi.product.Product;
import shuyi.product.ProductSerializer;
import shuyi.product.ProductSeries;
import shuyi.product.ShuyiTealiciousTeas;
import shuyi.product.shuyi_tealicious.*;
import shuyi.visual.cupscene.CupScene;

import java.util.Optional;

public class TeaMakerScene {
    Shuyi shuyi;

    Label lblTitle = new Label("书亦烧仙草");
    ComboBox<ProductSeries> cmbSeries;
    ComboBox<ShuyiTealiciousTeas> cmbTeas;
    Label lblTodo = new Label("todo: shuyi shaoxiancao");

    Button btnCup;
    Button btnShakeCup;
    Button btnMeasuringCup;

    Button btnRandom = new Button("Random!");


    Button btnMixerCup = new Button("拿取成品杯子");
    Button btnMixerShakeCup = new Button("拿取雪克杯");
    Button btnMixerMeasuringCup = new Button("拿取500ml量杯");
    Button btnMixerMeasuringCup100 = new Button("拿取100ml量杯");
    Button btnMixerBothMeasuringCup = new Button("拿取两量杯");
    Button btnMixerClear = new Button("清空列表");
    Button btnMixerMix = new Button("倒入");

    Button btnSubmitCup = new Button("Submit your cup");
    Button btnNew = new Button("Start over");


    Text txtCup = new Text();
    Text txtShakeCup = new Text();
    Text txtMeasuringCup = new Text();
    Text txtMeasuringCup100 = new Text();

    ScrollPane scpCup = new ScrollPane();
    ScrollPane scpShakeCup = new ScrollPane();
    ScrollPane scpMeasuringCup;
    ScrollPane scpMeasuringCup100;

    Label lblMixer = new Label("Mix area: （上面的杯子倒入下面的杯子，先选择下面(要倒入)的杯子），点按下方杯子的按钮选择");
    Label lblMixerLeft = new Label("");
    Label lblMixerSymbol = new Label("↓↓↓↓Pour↓↓↓");
    Label lblMixerRight = new Label("");

    Label lblWarning = new Label("");

    Text txtResult = new Text("");
    Text txtAnswer = new Text("");
    ScrollPane scpResult = new ScrollPane();
    ScrollPane scpAnswer = new ScrollPane();

    Label lblCurrentTitle = new Label("");
    Button btnGetAnswer = new Button("Get Answer");
    Button btnWriteFile = new Button("Correct Answer(警告：该操作会用现有未提交的成品杯子覆盖已保存答案)");
    Button btnEmptyAnswer = new Button("Clear Answer");

    boolean twoMeasuringCupSelected = false;


    TeaMakerScene(Button btnCup, Button btnShakeCup, ScrollPane scpMeasuringCup, ScrollPane scpMeasuringCup100, Shuyi shuyi, ComboBox<ProductSeries> cmbSeries, ComboBox<ShuyiTealiciousTeas> cmbTeas) {
        this.shuyi = shuyi;
        this.btnCup = btnCup;
        this.btnShakeCup = btnShakeCup;
        this.scpMeasuringCup = scpMeasuringCup;
        this.scpMeasuringCup100 = scpMeasuringCup100;
        this.cmbSeries = cmbSeries;
        cmbSeries.getItems().addAll(ProductSeries.values());
        this.cmbTeas = cmbTeas;
        actions();
    }


    Scene getScene() {
        refreshLabel();
        GridPane gridPane = new GridPane();

        gridPane.add(lblTitle, 0, 0);
        gridPane.add(cmbSeries, 1, 0);
        cmbSeries.setPromptText("View all series");
        gridPane.add(cmbTeas, 2, 0);
        cmbTeas.setPromptText("Teas (Please choose a series first)");
        gridPane.add(lblTodo, 0, 1, 2, 1);
        gridPane.add(btnRandom, 2, 1);

        gridPane.add(btnCup, 0, 2);
        gridPane.add(btnShakeCup, 1, 2);

        gridPane.add(scpCup, 0, 3);
        gridPane.add(scpShakeCup, 1, 3);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(scpMeasuringCup100, scpMeasuringCup);
        scpMeasuringCup.setPrefHeight(200);
        scpMeasuringCup100.setPrefHeight(200);
        vBox2.setSpacing(10);
        gridPane.add(vBox2, 2, 2, 1, 2);

        gridPane.add(lblMixer, 0, 4, 3, 1);

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(lblMixerRight, lblMixerSymbol, lblMixerLeft);

        gridPane.add(vBox1, 0, 5);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(btnMixerCup, btnMixerShakeCup, btnMixerBothMeasuringCup, btnMixerMeasuringCup, btnMixerMeasuringCup100);
        hBox.setSpacing(20);
        gridPane.add(hBox, 0, 6, 2, 1);

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(btnMixerClear, btnMixerMix);
        hBox1.setSpacing(20);
        gridPane.add(hBox1, 0, 7);

        gridPane.add(lblWarning, 2, 7);

        gridPane.add(btnSubmitCup, 0, 8);
        gridPane.add(btnNew, 2, 8);

        gridPane.add(scpResult, 0, 9);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(lblCurrentTitle, btnGetAnswer, btnEmptyAnswer, btnWriteFile);
        btnGetAnswer.setStyle("-fx-background-color: lightgreen");
        btnWriteFile.setStyle("-fx-background-color: pink");
        btnEmptyAnswer.setStyle("-fx-background-color: lightgreen");
        vBox.setSpacing(20);
        gridPane.add(scpAnswer, 1, 9);
        gridPane.add(vBox, 2, 9);


        ColumnConstraints col = new ColumnConstraints();

        RowConstraints rowN = new RowConstraints();
        rowN.setPercentHeight(5);
        RowConstraints rowWide = new RowConstraints();
        rowWide.setPercentHeight(30);
        gridPane.getRowConstraints().setAll(rowN, rowN, rowN, rowWide, rowN, rowN, rowN, rowN, rowN, rowWide);
        col.setPercentWidth(33);
        gridPane.setHgap(30);
        gridPane.setVgap(10);
        gridPane.getColumnConstraints().addAll(col, col, col);
        gridPane.setPadding(new Insets(10, 10, 25, 25));

        Scene scene = new Scene(gridPane, SceneSettings.getScreenWidth(), SceneSettings.getScreenHeight());
        return scene;
    }

    private void actions() {
        scpCup.setOnMouseClicked(event -> btnCup.fire());
        scpShakeCup.setOnMouseClicked(event -> btnShakeCup.fire());
        scpMeasuringCup.setOnMouseClicked(event -> btnMeasuringCup.fire());
        btnMixerCup.setOnAction(event -> {
            if (shuyi.addToMixer(shuyi.getCup())) {
                refreshLabel();
                setWarningMsg("Added to Mixer", false);
            } else {
                setWarningMsg("Already added to mixer or the mixer is full", true);
            }
        });
        btnMixerShakeCup.setOnAction(event -> {
            if (shuyi.addToMixer(shuyi.getShakeCup())) {
                refreshLabel();
                setWarningMsg("Added to Mixer", false);
            } else {
                setWarningMsg("Already added to mixer or the mixer is full", true);
            }
        });
        btnMixerMeasuringCup.setOnAction(event -> {
            if (shuyi.addToMixer(shuyi.getMeasuringCup())) {
                refreshLabel();
                setWarningMsg("Added to Mixer", false);
            } else {
                setWarningMsg("Already added to mixer or the mixer is full", true);
            }
        });
        btnMixerMeasuringCup100.setOnAction(event -> {
            if (shuyi.addToMixer(shuyi.getMeasuringCup100())) {
                refreshLabel();
                setWarningMsg("Added to Mixer", false);
            } else {
                setWarningMsg("Already added to mixer or the mixer is full", true);
            }
        });
        btnMixerBothMeasuringCup.setOnAction(event -> {
            twoMeasuringCupSelected = true;
            if (shuyi.addToMixer(null)) {
                refreshLabel();
                setWarningMsg("Added to Mixer", false);
            } else {
                setWarningMsg("Mixer error, (Measuring cup can not be on the bottom or the mixer is full)", true);
            }
        });
        btnMixerMix.setOnAction(event -> {
            if (shuyi.isReadyToMix()) {
                if (twoMeasuringCupSelected) {
                    Operate.pourIn(shuyi.getMixerLeft(), shuyi.getMeasuringCup100());
                    Operate.pourIn(shuyi.getMixerLeft(), shuyi.getMeasuringCup());
                } else {
                    Operate.pourIn(shuyi.getMixerLeft(), shuyi.getMixerRight());
                }
                setWarningMsg("Mixed!", false);

                btnMixerClear.fire();
            } else {
                setWarningMsg("Empty slot", true);
            }
        });
        btnMixerClear.setOnAction(event -> {
            shuyi.cleanMixer();
            twoMeasuringCupSelected = false;
            refreshLabel();
            setWarningMsg("Mixer empty successful", false);
        });
        btnNew.setOnAction(event -> {
            emptyAll();
            btnEmptyAnswer.fire();
        });
        btnRandom.setOnAction(event -> {
            shuyi.getProduct().random();
            refreshLabel();
            btnEmptyAnswer.fire();
        });
        btnSubmitCup.setOnAction(event -> {
            txtResult.setText(shuyi.getCup().printCup());
            emptyAll();
            btnGetAnswer.fire();
        });
        btnGetAnswer.setOnAction(event -> {
            try {
                Cup cup = ProductSerializer.read(shuyi.getProduct().getFile());
                txtAnswer.setText(cup.printCup());
            } catch (Exception e) {
                setWarningMsg("No such file", true);
            }
        });
        btnWriteFile.setOnAction(event -> {
            Alert alertConfirm = new Alert(Alert.AlertType.CONFIRMATION, "You sure you want to rewrite the answer with your current cup?", ButtonType.CANCEL,ButtonType.OK);
            alertConfirm.initModality(Modality.APPLICATION_MODAL);
            Optional<ButtonType> result = alertConfirm.showAndWait();
            if (result.get() == ButtonType.OK) {
                if (ProductSerializer.write(shuyi.getProduct().getFile(), shuyi.getCup())) {
                    setWarningMsg("Write File Successful", false);
                    emptyAll();
                } else {
                    setWarningMsg("Write File Failed", true);
                }
            }
        });
        btnEmptyAnswer.setOnAction(event -> {
            txtAnswer.setText("");
            txtResult.setText("");
        });
    }

    private void emptyAll() {
        shuyi.emptyAll();
        refreshLabel();
    }

    public void refreshLabel() {
        txtAnswer.setText("");

        scpAnswer.setContent(txtAnswer);

        if (shuyi.getCup().isEmpty()) {
            scpCup.setStyle("-fx-background-color: pink");
        } else {
            scpCup.setStyle("-fx-background-color: green");
        }

        if (shuyi.getMeasuringCup().isEmpty()) {
            scpMeasuringCup.setStyle("-fx-background-color: pink");
        } else {
            scpMeasuringCup.setStyle("-fx-background-color: green");
        }

        if (shuyi.getMeasuringCup100().isEmpty()) {
            scpMeasuringCup100.setStyle("-fx-background-color: pink");
        } else {
            scpMeasuringCup100.setStyle("-fx-background-color: green");
        }

        if (shuyi.getShakeCup().isEmpty()) {
            scpShakeCup.setStyle("-fx-background-color: pink");
        } else {
            scpShakeCup.setStyle("-fx-background-color: green");
        }
        lblCurrentTitle.setText(shuyi.getToMakeName());
        lblTodo.setText(shuyi.getToMakeName());
        txtCup.setText(shuyi.getCup().printCup());
        txtShakeCup.setText(shuyi.getShakeCup().printCup());
        txtMeasuringCup.setText(shuyi.getMeasuringCup().printCup());
        txtMeasuringCup100.setText(shuyi.getMeasuringCup100().printCup());

        scpCup.setContent(txtCup);
        scpMeasuringCup.setContent(txtMeasuringCup);
        scpMeasuringCup100.setContent(txtMeasuringCup100);
        scpShakeCup.setContent(txtShakeCup);
        scpResult.setContent(txtResult);

        if (shuyi.getMixerLeft() != null) {
            lblMixerLeft.setText(shuyi.getMixerLeft().getName());
            lblMixerLeft.setStyle("-fx-background-color: honeydew;");
        } else {
            lblMixerLeft.setText("Empty");
            lblMixerLeft.setStyle("-fx-background-color: pink");
        }
        if (shuyi.getMixerRight() != null) {
            lblMixerRight.setText(shuyi.getMixerRight().getName());
            lblMixerRight.setStyle("-fx-background-color: honeydew");
        } else {
            lblMixerRight.setText("Empty");
            lblMixerRight.setStyle("-fx-background-color: pink");
        }
    }

    private void setWarningMsg(String msg, boolean isWarning) {
        if (isWarning) {
            lblWarning.setStyle("-fx-text-fill: red;");
        } else {
            lblWarning.setStyle("-fx-text-fill: green;");
        }
        lblWarning.setText(msg);
    }
}
