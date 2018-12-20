/*
 * Sahijkar Sanghara
 * 991427007
 * 
 */
package bagelshop;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BagelController {

    //bagel
    @FXML
    private RadioButton white;

    @FXML
    private RadioButton whole;

    @FXML
    private TextField quantityBagel;

    //coffee
    @FXML
    private RadioButton noneCoffee;

    @FXML
    private RadioButton regular;

    @FXML
    private RadioButton cappaccino;

    @FXML
    private RadioButton cafe;

    @FXML
    private TextField quantityCoffee;

    //toppings
    @FXML
    private CheckBox cheese;

    @FXML
    private CheckBox butter;

    @FXML
    private CheckBox bJam;

    @FXML
    private CheckBox rJam;

    @FXML
    private CheckBox pJelly;

    //price summary
    @FXML
    private Label subtotal;

    @FXML
    private Label tax;

    @FXML
    private Label total;

    //buttons
    @FXML
    private Button calculate;

    @FXML
    private Button reset;

    @FXML
    private Button exit;

    @FXML
    private Button receipt;

    private int value;

    private double price;

    private double taxAmount;

    @FXML
    public void initialize() {
        makeDisabled(true);

    }

    @FXML
    public double newBagelOrder() {
        if (white.isSelected()) {
            Integer value = Integer.valueOf(quantityBagel.getText());
            price = value * 1.25;
            return price;

        } else if (whole.isSelected()) {
            Integer value = Integer.valueOf(quantityBagel.getText());
            price = value * 1.50;
            return price;
        }
        return price = 0;
    }

    public double newCoffeeOrder() {
        if (noneCoffee.isSelected()) {
            Integer value = Integer.valueOf(quantityCoffee.getText());
            value = 0;
            return price = 0;
        } else if (regular.isSelected()) {
            Integer value = Integer.valueOf(quantityCoffee.getText());
            price = value * 1.25;
            return price;
        } else if (cappaccino.isSelected()) {
            Integer value = Integer.valueOf(quantityCoffee.getText());
            price = value * 2.00;
            return price;
        } else if (cafe.isSelected()) {
            Integer value = Integer.valueOf(quantityCoffee.getText());
            price = value * 1.75;
            return price;
        }
        return price = 0;
    }

    public double newToppingsOrder() {
        price = 0;
        if (cheese.isSelected()) {
            price += 0.50;
        }
        if (butter.isSelected()) {
            price += 0.25;
        }
        if (bJam.isSelected()) {
            price += 0.75;
        }
        if (rJam.isSelected()) {
            price += 0.75;
        }
        if (pJelly.isSelected()) {
            price += 0.75;
        }
        return price;
    }

    @FXML
    public void calculateCost(ActionEvent Action) {
        double bagelAmount = newBagelOrder();
        double coffeeAmount = newCoffeeOrder();
        double toppingsAmount = newToppingsOrder();
        double totalCost = bagelAmount + coffeeAmount + toppingsAmount;

        String Total = String.format("$%6.2f", totalCost);

        subtotal.setText("" + Total);

        taxAmount = totalCost * 0.13;

        String Tax = String.format("$%5.2f", taxAmount);
        tax.setText("" + Tax);

        double totalAmount = totalCost + taxAmount;

        String SalesAmount = String.format("$%6.2f", totalAmount);
        total.setText("" + SalesAmount);
    }

    public void resetBagel() {
        white.setSelected(false);
        whole.setSelected(false);
        quantityBagel.setText("");
        quantityCoffee.setText("");
    }

    public void resetCoffee() {
        noneCoffee.setSelected(false);

        regular.setSelected(false);

        cappaccino.setSelected(false);

        cafe.setSelected(false);
    }

    public void resetToppings() {

        cheese.setSelected(false);

        butter.setSelected(false);

        bJam.setSelected(false);

        rJam.setSelected(false);

        pJelly.setSelected(false);

    }

    public void resetCost() {
        subtotal.setText("$0.00");
        tax.setText("$0.00");
        total.setText("$0.00");

    }

    @FXML
    public void resetForm(ActionEvent Action) {
        resetBagel();
        resetCoffee();
        resetToppings();
        resetCost();
        initialize();
    }

    @FXML
    public void exitForm(ActionEvent Action) {
        Stage finish = (Stage) exit.getScene().getWindow();
        finish.close();
    }

    public void makeDisabled(boolean disable) {

        noneCoffee.setDisable(disable);

        regular.setDisable(disable);

        cappaccino.setDisable(disable);

        cafe.setDisable(disable);

        cheese.setDisable(disable);

        butter.setDisable(disable);

        bJam.setDisable(disable);

        rJam.setDisable(disable);

        pJelly.setDisable(disable);
    }

    @FXML
    public void chooseWhite(ActionEvent Action) {
        makeDisabled(false);
    }

    @FXML
    public void chooseWheat(ActionEvent Action) {
        makeDisabled(false);
    }
    
    java.util.Date date = new java.util.Date();

    @FXML
    public void printer(ActionEvent event) throws FileNotFoundException {

        try {
            System.out.println("Printing to file...Success!");

            PrintWriter writer = new PrintWriter("receipt.txt", "UTF-8");

            writer.println("**********WELCOME TO SHERIDAN BAGEL SHOP**********");
            writer.println(date.toString());
            writer.println("Item:\t\t\tQty\tAmount");
            if (white.isSelected()) {
                writer.print("White Bagel\t\t");
                writer.print(quantityBagel.getText() + "\t");
                writer.println((1.25 * Double.parseDouble(quantityBagel.getText())));
                writer.println("Toppings:");
                if (cheese.isSelected()) {
                    writer.print("  Cream Cheese\t\t");
                    writer.print(quantityBagel.getText());
                    writer.println("\t" + 0.50 * Double.parseDouble(quantityBagel.getText()));
                }
                if (butter.isSelected()) {
                    writer.print("  Butter\t\t");
                    writer.print(quantityBagel.getText());
                    writer.println("\t" + 0.25 * Double.parseDouble(quantityBagel.getText()));
                }
                if (bJam.isSelected()) {
                    writer.print("  Blueberry Jam\t\t");
                    writer.print(quantityBagel.getText());
                    writer.println("\t" + 0.75 * Double.parseDouble(quantityBagel.getText()));
                }
                if (rJam.isSelected()) {
                    writer.print("  Raspberry Jam\t\t");
                    writer.print(quantityBagel.getText());
                    writer.println("\t" + 0.75 * Double.parseDouble(quantityBagel.getText()));
                }
                if (pJelly.isSelected()) {
                    writer.print("  Peach Jelly\t\t");
                    writer.print(quantityBagel.getText());
                    writer.println("\t" + 0.75 * Double.parseDouble(quantityBagel.getText()));
                }
                if (regular.isSelected()) {
                    writer.print("Regular Coffee\t\t");
                    writer.print(Integer.parseInt(quantityCoffee.getText()));
                    writer.println("\t" + 1.25 * Integer.parseInt(quantityCoffee.getText()));
                }
                if (cappaccino.isSelected()) {
                    writer.print("Cappaccino Coffee\t\t");
                    writer.print(Integer.parseInt(quantityCoffee.getText()));
                    writer.println("\t" + 2.00 * Integer.parseInt(quantityCoffee.getText()));
                }
                if (cafe.isSelected()) {
                    writer.print("Cafe Au Lait\t\t");
                    writer.print(Integer.parseInt(quantityCoffee.getText()));
                    writer.println("\t" + 1.25 * Integer.parseInt(quantityCoffee.getText()));
                }
            }
            if (whole.isSelected()) {
                writer.print("Whole Bagel\t\t");
                writer.print(quantityBagel.getText() + "\t");
                writer.println((1.50 * Double.parseDouble(quantityBagel.getText())));
                writer.println("Toppings:");
                if (cheese.isSelected()) {
                    writer.print("  Cream Cheese\t\t");
                    writer.print(quantityBagel.getText());
                    writer.println("\t" + 0.50 * Double.parseDouble(quantityBagel.getText()));
                }
                if (butter.isSelected()) {
                    writer.print("  Butter\t\t");
                    writer.print(quantityBagel.getText());
                    writer.println("\t" + 0.25 * Double.parseDouble(quantityBagel.getText()));
                }
                if (bJam.isSelected()) {
                    writer.print("  Blueberry Jam\t\t");
                    writer.print(quantityBagel.getText());
                    writer.println("\t" + 0.75 * Double.parseDouble(quantityBagel.getText()));
                }
                if (rJam.isSelected()) {
                    writer.print("  Raspberry Jam\t\t");
                    writer.print(quantityBagel.getText());
                    writer.println("\t" + 0.75 * Double.parseDouble(quantityBagel.getText()));
                }
                if (pJelly.isSelected()) {
                    writer.print("  Peach Jelly\t\t");
                    writer.print(quantityBagel.getText());
                    writer.println("\t" + 0.75 * Double.parseDouble(quantityBagel.getText()));
                }
                if (regular.isSelected()) {
                    writer.print("Regular Coffee\t\t");
                    writer.print(Integer.parseInt(quantityCoffee.getText()));
                    writer.println("\t" + 1.25 * Integer.parseInt(quantityCoffee.getText()));
                }
                if (cappaccino.isSelected()) {
                    writer.print("Cappaccino Coffee\t");
                    writer.print(Integer.parseInt(quantityCoffee.getText()));
                    writer.println("\t" + 2.00 * Integer.parseInt(quantityCoffee.getText()));
                }
                if (cafe.isSelected()) {
                    writer.print("Cafe Au Lait\t\t");
                    writer.print(Integer.parseInt(quantityCoffee.getText()));
                    writer.println("\t" + 1.25 * Integer.parseInt(quantityCoffee.getText()));
                }
            }
            writer.println("\t\t\t\t-----------");
            writer.println("Pretax Total\t\t\t" + subtotal.getText());
            writer.println("Sales Tax 13%\t\t\t" + tax.getText());
            writer.println("Total Sale   \t\t\t" + total.getText());
            writer.println("*********THANK YOU FOR YOUR ORDER*********");

            writer.close();
        } catch (Exception localException) {
            System.out.println("Error writing to file");

        }
    }
}
