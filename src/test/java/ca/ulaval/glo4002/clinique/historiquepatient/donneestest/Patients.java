package ca.ulaval.glo4002.clinique.historiquepatient.donneestest;

import ca.ulaval.glo4002.clinique.historiquepatient.PatientAssurable;

public class Patients {

    public static PatientAssurable nonAssure() {
        return new PatientAssurable("Prenom Nom", Dates.LE_2000_01_01);
    }

    public static PatientAssurable inscritALaNaissance() {
        var patient = nonAssure();
        patient.ajouterInscriptionRAMQ(Dates.LE_2000_01_01);
        return patient;
    }
}
