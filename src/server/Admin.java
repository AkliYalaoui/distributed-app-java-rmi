package server;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
// import java.util.UUID;

public class Admin implements PersonneInterface {

    private ArrayList<Personne> listDesPersonnes;
    private static int counter = 1 ; 

    public Admin(){
        this.listDesPersonnes = new ArrayList<Personne>();
    }
    
    @Override
    public void ajouterPersonne(String nom,String prenom,LocalDate date,LocalDate rdv,Boolean hasCovid, String maladies) {
        // String identifiant = UUID.randomUUID().toString();
        Personne p = new Personne(String.valueOf(counter++),nom,prenom,date,rdv,hasCovid,maladies);
        listDesPersonnes.add(p);
        System.out.println(p);
    }
    @Override
    public List<Personne> getListDesPersonnes() {
        return this.listDesPersonnes;
    }

    @Override
    public Personne fetchPersonneById(String id) {
        Personne p = null;

        for (int i = 0; i < this.listDesPersonnes.size(); i++) {
            p = this.listDesPersonnes.get(i);
            if (p.getIdentifiant().equals(id))
                return p ;
        }

        return null;
    }

    @Override
    public boolean updateCarnetVaccination(String PersonneId, String vaccinName, String label, LocalDate injection,
            LocalDate dateNerdv, String dr){
        
        
        Personne p = this.fetchPersonneById(PersonneId);

        if (p != null){
            p.getCarnetDeVaccination().setVaccinName(vaccinName);
            p.getCarnetDeVaccination().setLabel(label);
            p.getCarnetDeVaccination().setVaccinatedBy(dr);
            p.getCarnetDeVaccination().setInjectionDate(injection);
            p.getCarnetDeVaccination().setDateOfNextVaccin(dateNerdv);

            return true;
        }

        return false;
    }

}
