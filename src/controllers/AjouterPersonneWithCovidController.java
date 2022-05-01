package controllers;

import java.io.File;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import server.Personne;
import server.PersonneInterface;

public class AjouterPersonneWithCovidController implements Initializable {

    @FXML
    private Label DiLabel;

    @FXML
    private Label DobLabel;

    @FXML
    private Label LnLabel;

    @FXML
    private Label RdvLabel;

    @FXML
    private Label fLabel;

    @FXML
    private Label idLabel;


    public static String PersonneId;

    @FXML
    void btnGoBackClicked(ActionEvent event) {

        Stage primarystage = (Stage) idLabel.getScene().getWindow();

        try {
            URL url = new File("src/resources/fxml/Mainscene.fxml").toURI().toURL();
            Parent root;
            root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            primarystage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {   
            Registry registry = LocateRegistry.getRegistry();
            PersonneInterface stub = (PersonneInterface) registry.lookup("admin");
            Personne p =  stub.fetchPersonneById(PersonneId);
            if(p != null){
                DiLabel.setText(p.getMaladies());
                DobLabel.setText(p.getDate());
                RdvLabel.setText(p.getRdv());
                fLabel.setText(p.getPrenom());
                LnLabel.setText(p.getNom());
                idLabel.setText(p.getIdentifiant());
            }

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Client exception" + e.toString());
            alert.show();
        }
    }

}
