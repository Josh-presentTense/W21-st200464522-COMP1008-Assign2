import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.UserCollection;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/collectionManagerMenuView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CollectionManager - Menu");
        stage.show();
    }
}
