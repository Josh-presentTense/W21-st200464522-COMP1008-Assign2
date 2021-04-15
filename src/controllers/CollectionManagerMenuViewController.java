package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CollectionManagerMenuViewController implements Initializable {

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private void createNewEntry(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../views/createPrintMediaCollectableView.fxml", "CollectionManager - New Print Media Entry");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryComboBox.getItems().addAll(DBUtility.getEntryCategories());
    }
}
