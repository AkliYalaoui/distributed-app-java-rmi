package controllers;

import java.io.File;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import server.Personne;
import server.PersonneInterface;

public class PersonneDetailController implements Initializable {

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

    @FXML
    private DatePicker tfDateNe;

    @FXML
    private TextField tfDr;

    @FXML
    private DatePicker tfInjection;

    @FXML
    private TextField tfLabel;

    @FXML
    private TextField tfVaccinName;

    public static String PersonneId;

    @FXML
    void btnGoBackClicked(ActionEvent event) {

        Stage primarystage = (Stage) tfLabel.getScene().getWindow();

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

    @FXML
    void btnUpdateVaccinClicked(ActionEvent event) {
        
        String vaccinName = tfVaccinName.getText();
        String label = tfLabel.getText();
        LocalDate injection = tfInjection.getValue();
        LocalDate dateNe = tfDateNe.getValue();
    
        String dr = tfDr.getText();

        if( vaccinName.isBlank() || label.isBlank() || dr.isBlank() || injection == null || dateNe == null){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Vaccin Name, Label, Doctor Injection Date, Next Vaccin Date are all required");
            alert.show();
            return;
        }

        try {   
            Registry registry = LocateRegistry.getRegistry();
            PersonneInterface stub = (PersonneInterface) registry.lookup("admin");
            boolean updated =  stub.updateCarnetVaccination(PersonneId,vaccinName,label,injection,dateNe,dr);

            if (updated){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("Vaccination Information Have Been Updated successfully");
                alert.show();
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("An Error Occorued, Personne With ID " + PersonneId + " Not Found");
                alert.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Client exception" + e.toString());
            alert.show();
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

                tfVaccinName.setText(p.getCarnetDeVaccination().getVaccinName());
                tfInjection.setValue(p.getCarnetDeVaccination().getInjDate());
                tfLabel.setText(p.getCarnetDeVaccination().getLabel());
                tfDateNe.setValue(p.getCarnetDeVaccination().getDateOfNextVaccin());
                tfDr.setText(p.getCarnetDeVaccination().getVaccinatedBy());
            }

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Client exception" + e.toString());
            alert.show();
        }
    }

}
