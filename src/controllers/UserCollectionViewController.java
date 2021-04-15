package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.CollectibleCollection;
import utilities.DBUtility;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserCollectionViewController implements Initializable {

    @FXML
    private ListView<CollectibleCollection> collectionListView;

    @FXML
    private TableView<CollectibleCollection> collectionTableView;

    @FXML
    private TableColumn<CollectibleCollection, Integer> idTableColumn;

    @FXML
    private TableColumn<CollectibleCollection, String> itemNameTableColumn;

    @FXML
    private TableColumn<CollectibleCollection, Integer> priceTableColumn;

    @FXML
    private TableColumn<CollectibleCollection, String> conditionTableColumn;

    @FXML
    private TableColumn<CollectibleCollection, String> categoryTableColumn;

    @FXML
    private TableColumn<CollectibleCollection, ?> parameter1TableColumn;

    @FXML
    private TableColumn<CollectibleCollection, ?> parameter2TableColumn;

    @FXML
    private TableColumn<CollectibleCollection, ?> parameter3TableColumn;

    @FXML
    private TableColumn<CollectibleCollection, ?> parameter4TableColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            collectionListView.getItems().addAll(DBUtility.getPrintMediaFromDB());
            collectionListView.getItems().addAll(DBUtility.getVideoMediaFromDB());
            collectionListView.getItems().addAll(DBUtility.getFiguresFromDB());
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("collectible_ID"));
//        itemNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
//        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//        conditionTableColumn.setCellValueFactory(new PropertyValueFactory<>("itemCondition"));
//        categoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("collectibleCategory"));

        //parameter1TableColumn.setCellValueFactory(new PropertyValueFactory<>("collectible_ID"));

        //collectionTableView.setItems();
    }

    private void getParameter1TableColumn() {
        // get object class to determine what object we are working with
        // Probably need to make a method in DBUtility
    }
}
