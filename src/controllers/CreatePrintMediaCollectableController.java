package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import utilities.DBUtility;

import java.net.URL;
import java.util.ResourceBundle;

public class CreatePrintMediaCollectableController implements Initializable {

    @FXML
    private ComboBox<String> itemConditionComboBox;

    @FXML
    private ComboBox<String> itemCategoryComboBox;

    @FXML
    private Spinner itemPriceSpinner;

    @FXML
    private Spinner pageCountSpinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemConditionComboBox.getItems().addAll(DBUtility.getItemCondition());
        itemCategoryComboBox.getItems().addAll(DBUtility.getPrintMediaCategories());

        SpinnerValueFactory<Integer> priceValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 500, 15);
        itemPriceSpinner.setValueFactory(priceValueFactory);
        itemPriceSpinner.setEditable(true);

        SpinnerValueFactory<Integer> pageCountValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 500, 30);
        pageCountSpinner.setValueFactory(pageCountValueFactory);
        pageCountSpinner.setEditable(true);
    }
}
