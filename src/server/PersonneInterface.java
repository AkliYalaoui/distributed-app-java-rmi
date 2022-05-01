package server;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;


public interface PersonneInterface extends Remote{
    void ajouterPersonne(String nom,String prenom,LocalDate date,LocalDate rdv,Boolean hasCovid, String maladies) throws RemoteException;
    List<Personne> getListDesPersonnes() throws RemoteException;
    Personne fetchPersonneById(String id) throws RemoteException;
    boolean updateCarnetVaccination(String PersonneId,String vaccinName,String label,LocalDate injection,LocalDate dateNerdv, String dr) throws RemoteException;
}