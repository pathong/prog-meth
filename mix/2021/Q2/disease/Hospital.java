package disease;

import java.util.ArrayList;
import util.Patient;
import util.SevereLevel;

public class Hospital {
    private ArrayList<Patient> patients;

    public Hospital(){
        patients = new ArrayList<Patient>();
    }

    public void admit(String firstname, String lastname, String id, String disease, boolean isVacinated){
        Disease d = null;
        switch (disease){
            case "Covid19":
                d = new Covid19();
                break;
            case "Delta":
                d = new Delta();
                break;
            case "Hypopnea":
                d = new Hypopnea();
                break;
        }
        Patient patient = new Patient(firstname,lastname,id,d,isVacinated);
        patients.add(patient);
    }

    public ArrayList<Patient> getCovidPatients(SevereLevel s){
        ArrayList<Patient> covidPatients = new ArrayList<Patient>();
        for(Patient patient:getPatients()){
            if(patient.getDisease() instanceof Covid19 || patient.getDisease() instanceof Delta){
                if(patient.getServeLevel()== s){
                    covidPatients.add(patient);
                }
            }
        }

        return covidPatients;

    }

    public ArrayList<Patient> getPatients(){return patients;}
}
