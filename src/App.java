import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args); 
    }

    @Override     
   public void start(Stage primarystage) throws Exception { 
     
        try{

            URL url = new File("src/resources/fxml/Mainscene.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);

            primarystage.setTitle("Gestion de Vaccination");
            primarystage.setScene(scene);
            primarystage.setResizable(false);
            primarystage.show();
        } catch(Exception e){
            e.printStackTrace();
        }
   }
}
