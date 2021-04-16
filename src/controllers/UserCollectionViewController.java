package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import models.CollectibleCollection;
import models.Figure;
import models.PrintMedia;
import models.VideoMedia;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserCollectionViewController implements Initializable {

    @FXML
    private ListView<CollectibleCollection> collectionListView;

    @FXML
    private CheckBox printMediaCheckBox;

    @FXML
    private CheckBox videoMediaCheckBox;

    @FXML
    private CheckBox figureCheckBox;

    @FXML
    private Label priceLabel;

    @FXML
    private Label conditionLabel;

    @FXML
    private Label categoryLabel;

    @FXML
    private Label param1NameLabel;

    @FXML
    private Label param2NameLabel;

    @FXML
    private Label param3NameLabel;

    @FXML
    private Label param4NameLabel;

    @FXML
    private Label param1Label;

    @FXML
    private Label param2Label;

    @FXML
    private Label param3Label;

    @FXML
    private Label param4Label;

    @FXML
    private GridPane itemInfoGridPane;

    private CollectibleCollection itemSelected;

    private PrintMedia pmSelected;

    private VideoMedia vmSelected;

    private Figure fgSelected;

    private int collectableItemID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        printMediaCheckBox.setSelected(true);
        videoMediaCheckBox.setSelected(true);
        figureCheckBox.setSelected(true);

        try {
            collectionListView.getItems().addAll(DBUtility.getPrintMediaFromDB());
            collectionListView.getItems().addAll(DBUtility.getVideoMediaFromDB());
            collectionListView.getItems().addAll(DBUtility.getFiguresFromDB());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        itemInfoGridPane.setVisible(false);
    }

    /**
     * On Update View button press, update the list view depending on what checkboxes were ticked
     */
    @FXML
    private void updateView(ActionEvent event) throws SQLException {
        collectionListView.getItems().clear();

        if (printMediaCheckBox.isSelected())
            collectionListView.getItems().addAll(DBUtility.getPrintMediaFromDB());

        if (videoMediaCheckBox.isSelected())
            collectionListView.getItems().addAll(DBUtility.getVideoMediaFromDB());

        if (figureCheckBox.isSelected())
            collectionListView.getItems().addAll(DBUtility.getFiguresFromDB());

        itemInfoGridPane.setVisible(false);
    }

    /**
     * On Back button press, go back to menu
     */
    @FXML
    private void backButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../views/collectionManagerMenuView.fxml", "CollectionManager - Menu");
    }

    /**
     * On Delete button press, delete selected listview item from DB
     */
    @FXML
    private void deleteButton(ActionEvent event) throws SQLException {
        itemSelected = collectionListView.getSelectionModel().getSelectedItem();

        if (itemSelected != null && itemSelected.getClass() == PrintMedia.class) {
            pmSelected = (PrintMedia) collectionListView.getSelectionModel().getSelectedItem();
            collectableItemID = pmSelected.getPrint_media_ID();

            DBUtility.deleteCollectableItem("PrintMedia", collectableItemID);
            resetUserCollectionPage();
        }

        if (itemSelected != null && itemSelected.getClass() == VideoMedia.class) {
            vmSelected = (VideoMedia) collectionListView.getSelectionModel().getSelectedItem();
            collectableItemID = vmSelected.getVideo_media_ID();

            DBUtility.deleteCollectableItem("VideoMedia", collectableItemID);
            resetUserCollectionPage();
        }

        if (itemSelected != null && itemSelected.getClass() == Figure.class) {
            fgSelected = (Figure) collectionListView.getSelectionModel().getSelectedItem();
            collectableItemID = fgSelected.getFigure_ID();

            DBUtility.deleteCollectableItem("Figure", collectableItemID);
            resetUserCollectionPage();
        }
    }

    /**
     * This method resets the page
     */
    private void resetUserCollectionPage() {
        collectionListView.getItems().clear();

        printMediaCheckBox.setSelected(true);
        videoMediaCheckBox.setSelected(true);
        figureCheckBox.setSelected(true);

        try {
            collectionListView.getItems().addAll(DBUtility.getPrintMediaFromDB());
            collectionListView.getItems().addAll(DBUtility.getVideoMediaFromDB());
            collectionListView.getItems().addAll(DBUtility.getFiguresFromDB());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        itemInfoGridPane.setVisible(false);
    }

    /**
     * This method is run whenever an item is selected on the list view
     */
    @FXML
    private void getInfoFromSelectedItem() {
        itemSelected = collectionListView.getSelectionModel().getSelectedItem();

        if (itemSelected != null && itemSelected.getClass() == PrintMedia.class) {
            itemInfoGridPane.setVisible(true);
            pmSelected = (PrintMedia) collectionListView.getSelectionModel().getSelectedItem();
            priceLabel.setText(String.format("$%d", pmSelected.getPrice()));
            conditionLabel.setText(pmSelected.getItemCondition());
            categoryLabel.setText(pmSelected.getCollectibleCategory());

            param1NameLabel.setText("Author:");
            param2NameLabel.setText("Illustrator:");
            param3NameLabel.setText("Publisher:");
            param4NameLabel.setText("Page Count:");

            param1Label.setText(pmSelected.getAuthor());
            param2Label.setText(pmSelected.getIllustrator());
            param3Label.setText(pmSelected.getPublisher());
            param4Label.setText(String.format("%d", pmSelected.getPageCount()));
        }

        if (itemSelected != null && itemSelected.getClass() == VideoMedia.class) {
            itemInfoGridPane.setVisible(true);
            vmSelected = (VideoMedia) collectionListView.getSelectionModel().getSelectedItem();
            priceLabel.setText(String.format("$%d", vmSelected.getPrice()));
            conditionLabel.setText(vmSelected.getItemCondition());
            categoryLabel.setText(vmSelected.getCollectibleCategory());

            param1NameLabel.setText("Director:");
            param2NameLabel.setText("Studio:");
            param3NameLabel.setText("Episodes:");
            param4NameLabel.setText("Run Time (min):");

            param1Label.setText(vmSelected.getDirector());
            param2Label.setText(vmSelected.getStudio());
            param3Label.setText(String.format("%d", vmSelected.getEpisodes()));
            param4Label.setText(String.format("%d", vmSelected.getRunTime()));
        }

        if (itemSelected != null && itemSelected.getClass() == Figure.class) {
            itemInfoGridPane.setVisible(true);
            fgSelected = (Figure) collectionListView.getSelectionModel().getSelectedItem();
            priceLabel.setText(String.format("$%d", fgSelected.getPrice()));
            conditionLabel.setText(fgSelected.getItemCondition());
            categoryLabel.setText(fgSelected.getCollectibleCategory());

            param1NameLabel.setText("Company:");
            param2NameLabel.setText("Character:");
            param3NameLabel.setText("Origin:");
            param4NameLabel.setText("Scale:");

            param1Label.setText(fgSelected.getCompanyName());
            param2Label.setText(fgSelected.getCharacterName());
            param3Label.setText(fgSelected.getOrigin());
            param4Label.setText(fgSelected.getScale());
        }
    }
}
