package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import models.Figure;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateFigureCollectableViewController implements Initializable {

    @FXML
    private TextField itemNameTextField;

    @FXML
    private TextField companyTextField;

    @FXML
    private TextField characterTextField;

    @FXML
    private TextField originTextField;

    @FXML
    private ComboBox<String> itemConditionComboBox;

    @FXML
    private ComboBox<String> itemCategoryComboBox;

    @FXML
    private ComboBox<String> scaleComboBox;

    @FXML
    private Spinner<Integer> itemPriceSpinner;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private void submitButton() {
        try {
            Figure figureCollectable = new Figure(
                    itemNameTextField.getText(),
                    itemPriceSpinner.getValue(),
                    itemConditionComboBox.getValue(),
                    itemCategoryComboBox.getValue(),
                    companyTextField.getText(),
                    characterTextField.getText(),
                    originTextField.getText(),
                    scaleComboBox.getValue()
            );
            int figure_ID = DBUtility.addNewFigure(figureCollectable);
            clearUserInput();
            errorMessageLabel.setText("F.ID: " + figure_ID + " " + figureCollectable.toString() + " Created");
        } catch (IllegalArgumentException e){
            errorMessageLabel.setText(e.getMessage());
        } catch (Exception e) {
            errorMessageLabel.setText("Make sure all fields are filled");
        }
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../views/collectionManagerMenuView.fxml", "CollectionManager - Menu");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorMessageLabel.setText("");

        itemConditionComboBox.getItems().addAll(DBUtility.getItemCondition());
        itemCategoryComboBox.getItems().addAll(DBUtility.getFigureCategories());
        scaleComboBox.getItems().addAll(DBUtility.getScaleClassifications());

        SpinnerValueFactory<Integer> priceValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5000, 200);
        itemPriceSpinner.setValueFactory(priceValueFactory);
        itemPriceSpinner.setEditable(true);
    }

    /**
     * This method clears the user inputted Text Fields
     */
    private void clearUserInput() {
        itemNameTextField.clear();
        companyTextField.clear();
        characterTextField.clear();
        originTextField.clear();
    }
}
