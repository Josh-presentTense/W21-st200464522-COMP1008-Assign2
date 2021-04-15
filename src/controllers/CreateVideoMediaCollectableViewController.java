package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import models.VideoMedia;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateVideoMediaCollectableViewController implements Initializable {

    @FXML
    private TextField itemNameTextField;

    @FXML
    private TextField directorTextField;

    @FXML
    private TextField studioTextField;

    @FXML
    private ComboBox<String> itemConditionComboBox;

    @FXML
    private ComboBox<String> itemCategoryComboBox;

    @FXML
    private Spinner<Integer> itemPriceSpinner;

    @FXML
    private Spinner<Integer> episodesSpinner;

    @FXML
    private Spinner<Integer> runTimeSpinner;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private void submitButton() {
        try {
            VideoMedia videoMediaCollectable = new VideoMedia(
                    itemNameTextField.getText(),
                    itemPriceSpinner.getValue(),
                    itemConditionComboBox.getValue(),
                    itemCategoryComboBox.getValue(),
                    directorTextField.getText(),
                    studioTextField.getText(),
                    episodesSpinner.getValue(),
                    runTimeSpinner.getValue()
            );
            clearUserInput();
            errorMessageLabel.setText(videoMediaCollectable.toString());
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
        itemCategoryComboBox.getItems().addAll(DBUtility.getVideoMediaCategories());

        SpinnerValueFactory<Integer> priceValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 70);
        itemPriceSpinner.setValueFactory(priceValueFactory);
        itemPriceSpinner.setEditable(true);

        SpinnerValueFactory<Integer> episodesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 15);
        episodesSpinner.setValueFactory(episodesValueFactory);
        episodesSpinner.setEditable(true);

        SpinnerValueFactory<Integer> runTimeValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6000, 350);
        runTimeSpinner.setValueFactory(runTimeValueFactory);
        runTimeSpinner.setEditable(true);
    }

    /**
     * This method clears the user inputted Text Fields
     */
    private void clearUserInput() {
        itemNameTextField.clear();
        directorTextField.clear();
        studioTextField.clear();
    }
}
