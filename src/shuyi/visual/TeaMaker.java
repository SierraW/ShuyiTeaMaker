package shuyi.visual;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import shuyi.Shuyi;
import shuyi.product.Product;
import shuyi.product.ProductSeries;
import shuyi.product.ShuyiTealiciousTeas;
import shuyi.product.shuyi_tealicious.*;
import shuyi.visual.cupscene.CupScene;
import shuyi.visual.cupscene.MCScene;
import shuyi.visual.cupscene.SCScene;

public class TeaMaker extends Application {
    Shuyi shuyi = Shuyi.getInstance();

    Button btnBackCupScene = new Button("Back");
    Button btnBackMeasureCupScene = new Button("Back");
    Button btnBackShakeCupScene = new Button("Back");

    Button btnCup = new Button("成品杯子 - 点击进入设置界面");
    Button btnShakeCup = new Button("雪克杯 - 点击进入设置界面");

    ScrollPane scpMeasuringCup = new ScrollPane();
    ScrollPane scpMeasuringCup100 = new ScrollPane();
    ScrollPane scpOtherMC = new ScrollPane();
    ComboBox<ProductSeries> cmbSeries = new ComboBox<>();
    ComboBox<ShuyiTealiciousTeas> cmbTeas = new ComboBox<>();

    TeaMakerScene mainSceneController = new TeaMakerScene(btnCup,btnShakeCup,scpMeasuringCup,scpMeasuringCup100,shuyi,cmbSeries,cmbTeas);

    CupScene cupSceneController = new CupScene(btnBackCupScene, shuyi);
    MCScene measuringCupSceneController = new MCScene(btnBackMeasureCupScene, shuyi, scpOtherMC);
    SCScene shakingCupSceneController = new SCScene(btnBackShakeCupScene, shuyi);

    Scene mainScene;
    Scene cupScene;
    Scene mcScene;
    Scene scScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainScene = mainSceneController.getScene();
        cupScene = cupSceneController.getScene();
        mcScene = measuringCupSceneController.getScene();
        scScene = shakingCupSceneController.getScene();

        //button actions:
        btnCup.setOnAction(event -> {
            cupSceneController.refreshLabel();
            primaryStage.setScene(cupScene);
        });
        scpMeasuringCup.setOnMouseClicked(event -> {
            measuringCupSceneController.setLargeMeasureCup(true);
            measuringCupSceneController.refreshLabel();
            primaryStage.setScene(mcScene);
        });
        scpMeasuringCup100.setOnMouseClicked(event -> {
            measuringCupSceneController.setLargeMeasureCup(false);
            measuringCupSceneController.refreshLabel();
            primaryStage.setScene(mcScene);
        });
        scpOtherMC.setOnMouseClicked(event -> {
            if (measuringCupSceneController.isLargeMeasureCup()){
                measuringCupSceneController.setLargeMeasureCup(false);
                measuringCupSceneController.refreshLabel();
                primaryStage.setScene(mcScene);
            } else {
                measuringCupSceneController.setLargeMeasureCup(true);
                measuringCupSceneController.refreshLabel();
                primaryStage.setScene(mcScene);
            }
        });
        btnShakeCup.setOnAction(event -> {
            shakingCupSceneController.refreshLabel();
            primaryStage.setScene(scScene);
        });

        cmbSeries.setOnAction(event -> {
            switch (cmbSeries.getSelectionModel().getSelectedItem()) {
                case FRESH_CHEESE_TEA:
                    cmbTeas.getItems().setAll(FreshCheeseTea.values());
                    break;
                case FRESH_FRUIT_YAKULT:
                    cmbTeas.getItems().setAll(FreshFruitYakult.values());
                    break;
                case HANDMADE_FRESH_TEA:
                    cmbTeas.getItems().setAll(HandmadeFreshTea.values());
                    break;
                case FRESH_FRUITS_FRESH_TEA:
                    cmbTeas.getItems().setAll(FreshFruitsFreshTea.values());
                    break;
                case FULL_CUP:
                    cmbTeas.getItems().setAll(FullCup.values());
                    break;
                case NEW_PRODUCTS:
                    cmbTeas.getItems().setAll(NewProduct.values());
                    break;
                case MILK_TEA:
                default:
                    cmbTeas.getItems().setAll(MilkTea.values());
                    break;
            }
            cmbTeas.getSelectionModel().select(0);
        });
        cmbTeas.setOnAction(event -> {
            switch (cmbSeries.getSelectionModel().getSelectedItem()) {
                case FRESH_CHEESE_TEA:
                    shuyi.setProduct(new Product(cmbSeries.getSelectionModel().getSelectedItem(), FreshCheeseTea.values()[cmbTeas.getSelectionModel().getSelectedIndex()]));
                    break;
                case FRESH_FRUIT_YAKULT:
                    shuyi.setProduct(new Product(cmbSeries.getSelectionModel().getSelectedItem(), FreshFruitYakult.values()[cmbTeas.getSelectionModel().getSelectedIndex()]));
                    break;
                case HANDMADE_FRESH_TEA:
                    shuyi.setProduct(new Product(cmbSeries.getSelectionModel().getSelectedItem(), HandmadeFreshTea.values()[cmbTeas.getSelectionModel().getSelectedIndex()]));
                    break;
                case FRESH_FRUITS_FRESH_TEA:
                    shuyi.setProduct(new Product(cmbSeries.getSelectionModel().getSelectedItem(), FreshFruitsFreshTea.values()[cmbTeas.getSelectionModel().getSelectedIndex()]));
                    break;
                case FULL_CUP:
                    shuyi.setProduct(new Product(cmbSeries.getSelectionModel().getSelectedItem(), FullCup.values()[cmbTeas.getSelectionModel().getSelectedIndex()]));
                    break;
                case NEW_PRODUCTS:
                    shuyi.setProduct(new Product(cmbSeries.getSelectionModel().getSelectedItem(), NewProduct.values()[cmbTeas.getSelectionModel().getSelectedIndex()]));
                    break;
                case MILK_TEA:
                default:
                    shuyi.setProduct(new Product(cmbSeries.getSelectionModel().getSelectedItem(), MilkTea.values()[cmbTeas.getSelectionModel().getSelectedIndex()]));
                    break;
            }
            cupSceneController.refreshLabel();
            measuringCupSceneController.refreshLabel();
            shakingCupSceneController.refreshLabel();
            mainSceneController.refreshLabel();
        });

        btnBackCupScene.setOnAction(event -> {
            mainSceneController.refreshLabel();
            primaryStage.setScene(mainScene);
        });
        btnBackMeasureCupScene.setOnAction(event -> {
            mainSceneController.refreshLabel();
            primaryStage.setScene(mainScene);
        });
        btnBackShakeCupScene.setOnAction(event -> {
            mainSceneController.refreshLabel();
            primaryStage.setScene(mainScene);
        });

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

}
