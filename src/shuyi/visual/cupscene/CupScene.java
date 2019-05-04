package shuyi.visual.cupscene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import shuyi.Shuyi;
import shuyi.container.Container;
import shuyi.container.CupType;
import shuyi.container.cup.ProductCupType;
import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;
import shuyi.ingredient.addable.*;
import shuyi.operate.Operate;
import shuyi.operation.Values.*;
import shuyi.operation.operations.*;
import shuyi.visual.SceneSettings;

import java.util.ArrayList;

public class CupScene implements EventHandler<ActionEvent> {
    Button btnBack;
    Shuyi shuyi;
    Container container;
    Label lblToDos;
    Text txtCurrentContain;
    ScrollPane scrollPane = new ScrollPane();
    ComboBox<CupType> cmbCupType = new ComboBox<>();
    ComboBox<IngredientType> cmbIngredient = new ComboBox<>();

    ArrayList<IngredientButton> btnsIngredients = new ArrayList<>();

    Ingredient currentSelectedIngredient;

    TextField txtAmount = new TextField();
    Label lblAmountUnit = new Label("");
    TextField txtCustomAmount = new TextField();

    VBox vBox;
    HBox hBox;

    ArrayList<Button> btnSpoonValues = new ArrayList<>();
    ArrayList<Button> btnMeasuringCupValues = new ArrayList<>();
    ArrayList<Button> btnInexactValues = new ArrayList<>();
    ArrayList<Button> btnShakeCupValues = new ArrayList<>();
    ArrayList<Button> btnClipValues = new ArrayList<>();

    Button btnStir = new Button("搅拌");
    Button btnSkim = new Button("撇去浮沫");
    Button btnWideStraw = new Button("配粗吸管");
    Button btnFineStraw = new Button("配细吸管");
    Button btnSealTop = new Button("封杯");
    Button btnCapTop = new Button("加盖子");
    Button btnAddSpoon = new Button("配勺子");
    Button btnMash = new Button("捣碎");
    Button btnCraftTea = new Button("萃茶");
    Button btnSqueeze = new Button("手动压汁机挤压");

    GridPane gridPane = new GridPane();


    public CupScene(Button btnBack, Shuyi shuyi) {
        this.btnBack = btnBack;
        this.shuyi = shuyi;
        lblToDos = new Label(shuyi.getToMakeName());
        txtCurrentContain = new Text();
        init();
        cmbIngredient.getItems().addAll(IngredientType.values());

        txtAmount.setPromptText("Amount base on unit");
        txtCustomAmount.setPromptText("Custom amount (for example: pour till 8/10 of the cup)");

        vBox = getIngredientAmount();
        hBox = getIngredientsHBox();

        scrollPane.setContent(txtCurrentContain);

        refreshLabel();
        actions();
    }

    Label lblCupType = new Label("Current Cup Type: ");
    Label lblWarning = new Label();

    Button btnCupWarning = new Button("Empty cup");
    Button btnAdd = new Button("Add Ingredient");

    Label lblIngredientInstruction = new Label("请选择原料的类别:");
    Label lblCurrentSelect = new Label();

    void init() {
        cmbCupType.getItems().setAll(ProductCupType.values());
        cmbCupType.getSelectionModel().select(0);
        container = shuyi.getCup();
    }


    public Scene getScene() {
        customLabelAndButtons();

        gridPane.add(btnBack, 0, 0);
        gridPane.add(lblToDos, 0, 1, 3, 1);
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(lblCupType, cmbCupType, btnCupWarning);
        gridPane.add(hBox1, 1, 2, 2, 1);
        gridPane.add(scrollPane, 0, 2, 1, 2);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(lblIngredientInstruction, cmbIngredient, lblCurrentSelect);
        hBox2.setSpacing(20);

        gridPane.add(hBox2, 0, 4);

        gridPane.add(hBox, 0, 5, 3, 1);


        gridPane.add(txtCustomAmount, 1, 6);
        gridPane.add(lblWarning, 0, 6);
        gridPane.add(btnAdd, 2, 6);

        gridPane.add(vBox, 0, 8, 3, 3);

        gridPane.setVgap(10);
        gridPane.setHgap(20);

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(33);
        gridPane.getColumnConstraints().setAll(col, col, col);
        RowConstraints rowN = new RowConstraints();
        rowN.setPercentHeight(3);
        rowN.setMinHeight(10);
        RowConstraints rowWide = new RowConstraints();
        rowWide.setPercentHeight(30);
        gridPane.getRowConstraints().setAll(rowN, rowN, rowN, rowWide, rowN, rowN, rowN, rowN, rowN);
        gridPane.setPadding(new Insets(10, 10, 25, 25));

        Scene scene = new Scene(gridPane, SceneSettings.getScreenWidth(), SceneSettings.getScreenHeight());
        return scene;
    }

    void customLabelAndButtons() {
        cmbIngredient.getSelectionModel().select(4);
        cmbIngredient.fireEvent(new ActionEvent());
    }

    void setCupAction() {
        cmbCupType.setOnAction(event -> {
            if (container.isEmpty()) {
                shuyi.setCup(cmbCupType.getSelectionModel().getSelectedItem().getCup());
                container = shuyi.getCup();
                setWarningMsg("Set Cup Successful", false);
                refreshLabel();
            } else {
                setWarningMsg("Cup not Empty!", true);
            }
        });
    }

    void actions() {
        setCupAction();
        cmbIngredient.setOnAction(event -> {
            lblAmountUnit.setText(cmbIngredient.getSelectionModel().getSelectedItem().getOperationType().getUnit().toString());
//            switch (cmbIngredient.getSelectionModel().getSelectedItem()) {
//                case ICE:
//                    cmbIngredients.getItems().setAll(Ices.values());
//                    break;
//                case FRUIT_PULP:
//                    cmbIngredients.getItems().setAll(FruitPulps.values());
//                    break;
//                case MILK_TEA:
//                    cmbIngredients.getItems().setAll(MilkTeas.values());
//                    break;
//                case WATER:
//                    cmbIngredients.getItems().setAll(Waters.values());
//                    break;
//                case POWDER:
//                    cmbIngredients.getItems().setAll(Powders.values());
//                    break;
//                case SUGAR:
//                    cmbIngredients.getItems().setAll(Sugars.values());
//                    break;
//                case FRUIT:
//                    cmbIngredients.getItems().setAll(Fruits.values());
//                    break;
//                case TEA:
//                    cmbIngredients.getItems().setAll(Teas.values());
//                    break;
//                case CHEESE_CAP:
//                    cmbIngredients.getItems().setAll(CheeseCaps.values());
//                    break;
//                case INGREDIENT:
//                default:
//                    cmbIngredients.getItems().setAll(Ingredients.values());
//            }
//            cmbIngredients.getSelectionModel().select(0);

            refreshIngredientButton(cmbIngredient.getSelectionModel().getSelectedItem());
            enableValuesBtns(cmbIngredient.getSelectionModel().getSelectedItem());
        });
        btnCupWarning.setOnAction(event -> {
            container.empty();
            refreshLabel();
        });
        btnAdd.setOnAction(event -> {
            if (currentSelectedIngredient == null) {
                setWarningMsg("Please Select an ingredient", true);
                refreshLabel();
            } else {
                if (txtCustomAmount.getText().equals("")) {
                    float amount;
                    try {
                        amount = Float.parseFloat(txtAmount.getText());
                        try {
                            Operate.addIngredient(container, new IngredientWithAmount(currentSelectedIngredient, amount));
                            setWarningMsg("Add ingredient successful!", false);
                            refreshIngredientButton(cmbIngredient.getSelectionModel().getSelectedItem());
                            refreshLabel();
                        } catch (Exception e) {
                            setWarningMsg("Error", true);
                        }
                    } catch (Exception e) {
                        setWarningMsg("Please check the amount you enter", true);
                    }

                } else {
                    try {
                        Operate.addIngredient(container, new IngredientWithAmount(currentSelectedIngredient, txtCustomAmount.getText()));
                        setWarningMsg("Add ingredient successful!", false);
                        refreshIngredientButton(cmbIngredient.getSelectionModel().getSelectedItem());
                        refreshLabel();
                    } catch (Exception e) {
                        setWarningMsg("Error", true);
                    }
                }
            }
        });
        btnSkim.setOnAction(event -> {
            Operate.skim(container);
            refreshLabel();
        });
        btnStir.setOnAction(event -> {
            Operate.stir(container);
            refreshLabel();
        });
        btnSealTop.setOnAction(event -> {
            Operate.customOperation(container, AfterMadeOperations.SEAL_TOP.getOperation());
            refreshLabel();
        });
        btnCapTop.setOnAction(event -> {
            Operate.customOperation(container, AfterMadeOperations.CAP_TOP.getOperation());
            refreshLabel();
        });
        btnAddSpoon.setOnAction(event -> {
            Operate.customOperation(container, AfterMadeOperations.ADD_SPOON.getOperation());
            refreshLabel();
        });
        btnWideStraw.setOnAction(event -> {
            Operate.customOperation(container, AfterMadeOperations.WIDE_STRAW.getOperation());
            refreshLabel();
        });
        btnFineStraw.setOnAction(event -> {
            Operate.customOperation(container, AfterMadeOperations.FINE_STRAW.getOperation());
            refreshLabel();
        });
        btnMash.setOnAction(event -> {
            Operate.customOperation(container, new Mash());
            refreshLabel();
        });
        btnCraftTea.setOnAction(event -> {
            Operate.customOperation(container, new CraftTea());
            refreshLabel();
        });
        btnSqueeze.setOnAction(event -> {
            Operate.customOperation(container, new Squeeze());
            refreshLabel();
        });
    }

    private HBox getIngredientsHBox() {
        for (int i = 0; i < Ingredients.values().length; i++) {
            IngredientButton ingredientButton = new IngredientButton();
            ingredientButton.setOnAction(this);
            btnsIngredients.add(ingredientButton);
        }

        HBox hBox = new HBox();

        hBox.getChildren().addAll(btnsIngredients);

        hBox.setSpacing(10);
        hBox.setMinWidth(800);

        return hBox;
    }

    private void refreshIngredientButton(IngredientType ingredientType) {
        Adable[] adables;
        switch (ingredientType) {
            case ICE:
                adables = Ices.values();
                break;
            case FRUIT_PULP:
                adables = (FruitPulps.values());
                break;
            case MILK_TEA:
                adables = (MilkTeas.values());
                break;
            case WATER:
                adables = (Waters.values());
                break;
            case POWDER:
                adables = (Powders.values());
                break;
            case SUGAR:
                adables = (Sugars.values());
                break;
            case FRUIT:
                adables = (Fruits.values());
                break;
            case TEA:
                adables = (Teas.values());
                break;
            case CHEESE_CAP:
                adables = (CheeseCaps.values());
                break;
            case NOTE:
                adables = (Note.values());
                break;
            case INGREDIENT:
            default:
                adables = (Ingredients.values());
        }
        for (int i = 0; i < btnsIngredients.size(); i++) {

            if (i < adables.length) {
                btnsIngredients.get(i).setAdable(adables[i]);
            } else {
                btnsIngredients.get(i).setAdable(null);
            }
            currentSelectedIngredient = null;
            btnsIngredients.get(i).setStyle("-fx-background-color: gainsboro;");
        }
    }

    private VBox getIngredientAmount() {

        for (Values values : SpoonValue.values()) {
            ValueButton valueButton = new ValueButton(values);
            valueButton.setOnAction(this);
            valueButton.setDisable(true);
            btnSpoonValues.add(valueButton);
        }

        for (Values values : MilliLiterValue.values()) {
            ValueButton valueButton = new ValueButton(values);
            valueButton.setOnAction(this);
            valueButton.setDisable(true);
            btnMeasuringCupValues.add(valueButton);
        }

        for (Values values : InexactValue.values()) {
            ValueButton valueButton = new ValueButton(values);
            valueButton.setOnAction(this);
            valueButton.setDisable(true);
            btnInexactValues.add(valueButton);
        }

        for (Values values : ShakeCupValue.values()) {
            ValueButton valueButton = new ValueButton(values);
            valueButton.setOnAction(this);
            valueButton.setDisable(true);
            btnShakeCupValues.add(valueButton);
        }

        for (Values values : ClipValue.values()) {
            ValueButton valueButton = new ValueButton(values);
            valueButton.setOnAction(this);
            valueButton.setDisable(true);
            btnClipValues.add(valueButton);
        }

        HBox hBox = new HBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();
        HBox hBox5 = new HBox();

        hBox.setSpacing(10);
        hBox1.setSpacing(10);
        hBox2.setSpacing(10);
        hBox3.setSpacing(10);
        hBox4.setSpacing(10);
        hBox5.setSpacing(10);


        hBox.getChildren().addAll(btnSpoonValues);
        hBox1.getChildren().addAll(btnMeasuringCupValues);
        hBox2.getChildren().addAll(btnInexactValues);
        hBox3.getChildren().addAll(btnShakeCupValues);
        hBox4.getChildren().addAll(btnClipValues);
        hBox5.getChildren().addAll(btnMash, btnCraftTea, btnStir, btnSkim, btnSqueeze, btnSealTop, btnCapTop, btnWideStraw, btnFineStraw, btnAddSpoon);

        Label lblSpoon = new Label("Spoon:");
        Label lblML = new Label("Measuring Cup:");
        Label lblIE = new Label("Inexact:");
        Label lblSC = new Label("Shake Cup:");
        Label lblCl = new Label("Clip:");
        Label lbl5 = new Label("操作:");
        return new VBox(lblSpoon, hBox, lblML, hBox1, lblIE, hBox2, lblSC, hBox3, lblCl, hBox4, lbl5, hBox5);
    }

    void enableValuesBtns(IngredientType ingredientType) {
        boolean btnsSpoonDisable = false;
        boolean btnsMLDisable = false;
        boolean btnsIEDisable = false;
        boolean btnsSCDisable = false;
        boolean btnsCLDisable = true;
        switch (ingredientType) {
            case WATER:
                btnsSpoonDisable = true;
                break;
            case TEA:
                btnsSpoonDisable = true;
                break;
            case MILK_TEA:
                btnsSpoonDisable = true;
                break;
            case FRUIT_PULP:
                btnsSpoonDisable = true;
                btnsIEDisable = true;
                btnsSCDisable = true;
                break;
            case ICE:
                btnsSpoonDisable = true;
                break;
            case SUGAR:
                btnsSpoonDisable = true;
                btnsIEDisable = true;
                btnsSCDisable = true;
                break;
            case FRUIT:
                btnsIEDisable = true;
                btnsMLDisable = true;
                btnsSCDisable = true;
                btnsCLDisable = false;
                break;
            case CHEESE_CAP:
                btnsMLDisable = true;
                btnsSCDisable = true;
                btnsSpoonDisable = true;
                break;
            case POWDER:
                btnsIEDisable = true;
                btnsMLDisable = true;
                btnsSCDisable = true;
                btnsCLDisable = true;
                break;
            case INGREDIENT:
                btnsMLDisable = true;
                btnsSCDisable = true;
                break;
            case NOTE:
            default:
                btnsSpoonDisable = true;
                btnsMLDisable = true;
                btnsIEDisable = true;
                btnsSCDisable = true;
                btnsCLDisable = true;
        }

        for (Button button : btnSpoonValues) {
            button.setDisable(btnsSpoonDisable);
        }

        for (Button button : btnMeasuringCupValues) {
            button.setDisable(btnsMLDisable);
        }

        for (Button button : btnInexactValues) {
            button.setDisable(btnsIEDisable);
        }

        for (Button button : btnShakeCupValues) {
            button.setDisable(btnsSCDisable);
        }

        for (Button button : btnClipValues) {
            button.setDisable(btnsCLDisable);
        }
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof ValueButton) {
            if (currentSelectedIngredient == null) {
                setWarningMsg("Please Select an ingredient", true);
                refreshLabel();
                return;
            }
            Operate.addIngredient(container, new IngredientWithAmount(currentSelectedIngredient, ((ValueButton) event.getSource()).getValues()));
            setWarningMsg("add successful", false);
            refreshLabel();
        } else if (event.getSource() instanceof IngredientButton) {
            refreshIngredientButton(cmbIngredient.getSelectionModel().getSelectedItem());
            ((IngredientButton) event.getSource()).setStyle("-fx-background-color: grey");
            currentSelectedIngredient = ((IngredientButton) event.getSource()).getIngredient();
            if (currentSelectedIngredient != null) {
                lblCurrentSelect.setText("目前选择：" + currentSelectedIngredient.getDescriptions());
            } else {
                lblCurrentSelect.setText("");
            }
        }
    }

    public void refreshLabel() {
        txtCustomAmount.setText("");
        lblToDos.setText(shuyi.getToMakeName());
        refreshCurrentContain();
        if (currentSelectedIngredient != null) {
            lblCurrentSelect.setText("目前选择：" + currentSelectedIngredient.getDescriptions());
        } else {
            lblCurrentSelect.setText("");
        }
    }

    public void refreshCurrentContain() {
        txtCurrentContain.setText(shuyi.getCup().printCup());
        scrollPane.setContent(txtCurrentContain);
    }

    void setWarningMsg(String msg, boolean isWarning) {
        lblWarning.setText("");
        if (isWarning) {
            lblWarning.setStyle("-fx-text-fill: red");
        } else {
            lblWarning.setStyle("-fx-text-fill: green");
        }
        lblWarning.setText(msg);
    }

}
