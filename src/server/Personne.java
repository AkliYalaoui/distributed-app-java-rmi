package server;

import java.io.Serializable;
import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.Arrays;

public class Personne implements Serializable {

    private String identifiant;
    private String nom;
    private String prenom;
    private String maladies;
    private LocalDate date;
    private LocalDate rdv;
    private Boolean hasCovid;
    private String isAllowed;
    private Vaccination carnetDeVaccination;
    // private ArrayList<String> maladies;
    
    
    public Personne(String identifiant,String nom,String prenom,LocalDate date,LocalDate rdv,Boolean hasCovid ,String maladies) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.rdv = rdv;
        this.maladies = maladies;
        this.hasCovid = hasCovid;
        this.isAllowed = hasCovid ? "No":"Yes";
        this.carnetDeVaccination = new Vaccination(null, null, null, null, null);
        // this.maladies = new ArrayList<String>(Arrays.asList(maladies.split(",")));
    }

    @Override
    public String toString() {
        return this.identifiant + "#" + this.nom + "#" + this.prenom + "#" + this.date.toString() +"#" + this.hasCovid.toString() +"#" + this.maladies.toString();
    }

    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public String getDate(){
        return this.date.toString();
    }
    public String getRdv(){
        return this.rdv.toString();
    }
    public String getIdentifiant(){
        return this.identifiant;
    }
    public String getMaladies(){
        return this.maladies;
    }
    public Vaccination getCarnetDeVaccination(){
        return this.carnetDeVaccination;
    }
    public Boolean getHasCovid(){
        return this.hasCovid;
    }
    public String getIsAllowed(){
        return this.isAllowed;
    }
    
}
