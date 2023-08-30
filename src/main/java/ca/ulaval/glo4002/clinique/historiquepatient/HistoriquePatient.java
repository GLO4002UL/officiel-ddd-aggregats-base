package ca.ulaval.glo4002.clinique.historiquepatient;

import java.time.LocalDate;
import java.util.Collection;

import static ca.ulaval.glo4002.clinique.historiquepatient.Main.A_FAIRE;

public class HistoriquePatient {

    private Collection<SejourHorsQuebec> sejoursHorsQuebec;
    private LocalDate dateNaissance;
    private LocalDate dateInscription;
    private LocalDate dateDeces;


    public HistoriquePatient(LocalDate dateNaissance) {

    }

    public boolean estValide() {
        throw A_FAIRE;
    }

    public void ajouterSejour(SejourHorsQuebec sejour) {
        throw A_FAIRE;
    }

    public void ajouterDeces(LocalDate dateDeces) {
        throw A_FAIRE;
    }

    public void ajouterInscriptionRAMQ(LocalDate dateInscription) {

    }
}
