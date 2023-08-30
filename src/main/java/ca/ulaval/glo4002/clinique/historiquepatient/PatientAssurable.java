package ca.ulaval.glo4002.clinique.historiquepatient;

import java.time.LocalDate;
import java.time.Period;

import static ca.ulaval.glo4002.clinique.historiquepatient.Main.A_FAIRE;

public class PatientAssurable {

    private final String nom;
    private final HistoriquePatient historique;

    public PatientAssurable(String nom, LocalDate dateNaissance) {
        this.nom = nom;
        historique = new HistoriquePatient(dateNaissance);
    }

    public boolean estAssure(LocalDate date) {
        throw A_FAIRE;
    }

    public void ajouterInscriptionRAMQ(LocalDate dateInscription) {
        throw A_FAIRE;
    }

    public void ajouterDeces(LocalDate dateDeces) {
        throw A_FAIRE;
    }

    public void ajouterTravailHorsQuebec(LocalDate dateDepart, Period dureeDepart) {
        throw A_FAIRE;
    }

    public void ajouterVoyagePersoHorsQuebec(LocalDate date202011, Period period) {
        throw A_FAIRE;
    }
}
