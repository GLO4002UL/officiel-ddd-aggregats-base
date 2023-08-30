package ca.ulaval.glo4002.clinique.historiquepatient;

import java.time.LocalDate;
import java.time.Period;

public class SejourHorsQuebec {
    private final LocalDate dateDepart;
    private final Period duree;
    private final MotifSejour motifSejour;

    public SejourHorsQuebec(LocalDate dateDepart, Period duree, MotifSejour motifSejour) {
        this.dateDepart = dateDepart;
        this.duree = duree;
        this.motifSejour = motifSejour;
    }

    public boolean estSimultane(SejourHorsQuebec sejour) {
        throw Main.A_FAIRE;
    }

    public enum MotifSejour {
        PERSONNEL, ETUDES_OU_TRAVAIL
    }
}
