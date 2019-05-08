package testIdlePleaseIgnore;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;



public class IdleGameController implements Initializable {
    //Misc
    private double points;
    private int sleepTime;
    //Amount of upgrades
    private int noClicker,noGenerator,noFarm,noFactory;
    //Amount of points per click or per second
    private int valueClick,valueGenerator,valueFarm,valueFactory;
    //Purchase Price
    private double priceClicker,priceGenerator,priceFarm,priceFactory;
    //Amount of upgrades
    private int noClickerUpgrade,noGeneratorUpgrade,noFarmUpgrade,noFactoryUpgrade;
    //Universal Upgrades
    private int timeWarp,moreMoney,reducedCost;

    //Point Box
    @FXML
    Label totalPoints;
    //Clicker Box
    @FXML
    Label noOfClickers,clickerPPC,purchasePriceClicker,clickerUpgradeCost;
    @FXML
    VBox clickerBoxUpgrades;
    //Generator Box
    @FXML
    Label noOfGenerators,generatorPPS,purchasePriceGenerator,generatorUpgradeCost;
    @FXML
    VBox generatorBox,generatorBoxUpgrades;
    //Farm Box
    @FXML
    Label noOfFarms,farmPPS,purchasePriceFarm,farmUpgradeCost;
    @FXML
    VBox farmBox,farmBoxUpgrades;
    //Generator Box
    @FXML
    Label noOfFactories,factoryPPS,purchasePriceFactory,factoryUpgradeCost;
    @FXML
    VBox factoryBox,factoryBoxUpgrades;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startTask();
        sleepTime = 1000;

        points = 0;

        noClicker = 1;
        valueClick = 1;
        noClickerUpgrade = 1;

        timeWarp = 1;
        moreMoney = 1;
        reducedCost = 1;
    }

    private void startTask() {
        Runnable task = () -> runTask();
        Thread backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }

    private void runTask(){
        while(true){
            try{
                Platform.runLater(() -> {
                    points += (valueGenerator + valueFarm + valueFactory);
                    setText(totalPoints,points);
                });
                sleep(sleepTime / timeWarp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pointClicker(ActionEvent actionEvent) {
        points += valueClick*noClickerUpgrade;
        setText(totalPoints,points);
    }

    public void purchaseClicker(ActionEvent actionEvent) {
        priceClicker = getText(purchasePriceClicker);
        if(priceClicker <= points){
            valueClick++;  noClicker++;
            setText(clickerPPC,valueClick);  setText(noOfClickers,noClicker);
            points = purchaseMade(points,priceClicker,totalPoints);
            priceClicker = calcCost(priceClicker,noClicker);
            setText(purchasePriceClicker,priceClicker);
        }
    }

    public void purchaseGenerator(ActionEvent actionEvent) {
        priceGenerator = getText(purchasePriceGenerator);
        if(priceGenerator <= points){
            valueGenerator+=5;  noGenerator++;
            setText(generatorPPS,valueGenerator);  setText(noOfGenerators,noGenerator);
            points = purchaseMade(points,priceGenerator,totalPoints);
            priceGenerator = calcCost(priceGenerator,noGenerator);
            setText(purchasePriceGenerator,priceGenerator);
        }
    }

    public void purchaseFarm(ActionEvent actionEvent) {
        priceFarm = getText(purchasePriceFarm);
        if(priceFarm <= points){
            valueFarm+=25;  noFarm++;
            setText(farmPPS,valueFarm);  setText(noOfFarms,noFarm);
            points = purchaseMade(points,priceFarm,totalPoints);
            priceFarm = calcCost(priceFarm,noFarm);
            setText(purchasePriceFarm,priceFarm);
        }
    }

    public void purchaseFactory(ActionEvent actionEvent) {
        priceFactory = getText(purchasePriceFactory);
        if(priceFactory <= points){
            valueFactory+=100;  noFactory++;
            setText(factoryPPS,valueFactory);  setText(noOfFactories,noFactory);
            points = purchaseMade(points,priceFactory,totalPoints);
            priceFactory = calcCost(priceFactory,noFactory);
            setText(purchasePriceFactory,priceFactory);
        }
    }

    public void purchaseClickerUpgrade(ActionEvent actionEvent) {
    }

    public void purchaseGeneratorUpgrade(ActionEvent actionEvent) {
    }

    public void purchaseFarmUpgrade(ActionEvent actionEvent) {
    }

    public void purchaseFactoryUpgrade(ActionEvent actionEvent) {
    }

    public void purchaseTickUpgrade(ActionEvent actionEvent) {
    }

    public void purchaseCostReductionUpgrade(ActionEvent actionEvent) {
    }

    public static void setText(Label l, double p){

        DecimalFormat d = new DecimalFormat(".##");
        l.setText(Double.toString(Double.parseDouble(d.format(p))));
    }

    public static double getText(Label l){
        double d;
        d = Double.parseDouble(l.getText());
        return d;
    }

    /**
     * use to calculate the remaining points after a purchase was made
     * @param p points var
     * @param c cost of the thing being bought
     * @param l point label
     * @return how many points are left
     */
    public static double purchaseMade(double p,double c,Label l){
        double rP;

        rP = p - c;
        setText(l,rP);

        return rP;
    }

    public static double calcCost(double c, int l){
        double r;

        r = c * Math.pow(1.01,l);

        return r;
    }
}
