package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CollectionManagerMenuViewController implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private void createNewEntry(ActionEvent event) throws IOException {
        //Checks what has been selected from the ComboBox to navigate to the correct view file
        if (categoryComboBox.getSelectionModel().isEmpty())
            errorMessageLabel.setText("Please select an entry category");
        else if (categoryComboBox.getValue().equals("Comic book, Manga"))
            SceneChanger.changeScenes(event, "../views/createPrintMediaCollectableView.fxml", "CollectionManager - New Print Media Entry");
        else if (categoryComboBox.getValue().equals("TV show, Movie, Cartoon, Anime"))
            SceneChanger.changeScenes(event, "../views/createVideoMediaCollectableView.fxml", "CollectionManager - New Video Media Entry");
        else if (categoryComboBox.getValue().equals("Figure, Statue"))
            SceneChanger.changeScenes(event, "../views/createFigureCollectableView.fxml", "CollectionManager - New Figure Entry");
    }

    @FXML
    private void viewButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../views/userCollectionView.fxml", "CollectionManager - User Collection");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorMessageLabel.setText("");
        categoryComboBox.getItems().addAll(DBUtility.getEntryCategories());
    }
}
