package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import models.CollectibleCollection;
import models.PrintMedia;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreatePrintMediaCollectableController implements Initializable {

    @FXML
    private TextField itemNameTextField;

    @FXML
    private TextField authorTextField;

    @FXML
    private TextField illustratorTextField;

    @FXML
    private TextField publisherTextField;

    @FXML
    private ComboBox<String> itemConditionComboBox;

    @FXML
    private ComboBox<String> itemCategoryComboBox;

    @FXML
    private Spinner<Integer> itemPriceSpinner;

    @FXML
    private Spinner<Integer> pageCountSpinner;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private void submitButton() {
        try {
            PrintMedia printMediaCollectable = new PrintMedia(
                    itemNameTextField.getText(),
                    itemPriceSpinner.getValue(),
                    itemConditionComboBox.getValue(),
                    itemCategoryComboBox.getValue(),
                    authorTextField.getText(),
                    illustratorTextField.getText(),
                    publisherTextField.getText(),
                    pageCountSpinner.getValue()
            );
            DBUtility.addNewPrintMedia(printMediaCollectable);
            clearUserInput();
            errorMessageLabel.setText(printMediaCollectable.toString());
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
        itemCategoryComboBox.getItems().addAll(DBUtility.getPrintMediaCategories());

        SpinnerValueFactory<Integer> priceValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2000, 15);
        itemPriceSpinner.setValueFactory(priceValueFactory);
        itemPriceSpinner.setEditable(true);

        SpinnerValueFactory<Integer> pageCountValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2000, 30);
        pageCountSpinner.setValueFactory(pageCountValueFactory);
        pageCountSpinner.setEditable(true);
    }

    /**
     * This method clears the user inputted Text Fields
     */
    private void clearUserInput() {
        itemNameTextField.clear();
        authorTextField.clear();
        illustratorTextField.clear();
        publisherTextField.clear();
    }
}
