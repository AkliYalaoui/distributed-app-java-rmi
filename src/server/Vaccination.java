package server;

import java.io.Serializable;
import java.time.LocalDate;

public class Vaccination  implements Serializable {
    
    private String vaccinName;
    private LocalDate injectionDate;
    private String label;
    private LocalDate  dateOfNextVaccin;
    private String vaccinatedBy;

    public Vaccination(String vaccinName,LocalDate injDate,String label,LocalDate dt,String vaccby){
        this.vaccinName = vaccinName;
        this.injectionDate = injDate;
        this.label = label;
        this.dateOfNextVaccin = dt;
        this.vaccinatedBy = vaccby;
    }

    public void setVaccinName(String v){
        this.vaccinName = v;
    }

    public String getVaccinName(){
        return this.vaccinName;
    }

    public void setVaccinatedBy(String vb){
        this.vaccinatedBy = vb;
    }

    public String getVaccinatedBy(){
        return this.vaccinatedBy;
    }

    public void setLabel(String l){
        this.label = l;
    }

    public String getLabel(){
        return this.label;
    }

    public void setInjectionDate(LocalDate d){
        this.injectionDate = d;
    }

    public LocalDate getInjDate(){
        return this.injectionDate;
    }

    public void setDateOfNextVaccin(LocalDate d){
        this.dateOfNextVaccin = d;
    }

    public LocalDate getDateOfNextVaccin(){
        return this.dateOfNextVaccin;
    }
}
