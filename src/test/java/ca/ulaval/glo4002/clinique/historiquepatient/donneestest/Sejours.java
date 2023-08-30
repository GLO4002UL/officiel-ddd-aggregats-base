package ca.ulaval.glo4002.clinique.historiquepatient.donneestest;

import ca.ulaval.glo4002.clinique.historiquepatient.SejourHorsQuebec;

import java.time.Period;

public class Sejours {
    private static final Period DUREE_10_JOURS = Period.ofDays(10);

    public static SejourHorsQuebec du1au10Janvier() {
        return new SejourHorsQuebec(Dates.LE_2020_01_01, DUREE_10_JOURS, SejourHorsQuebec.MotifSejour.PERSONNEL);
    }

    public static SejourHorsQuebec du5au15Janvier() {
        return new SejourHorsQuebec(Dates.LE_2020_01_01.plusDays(5), DUREE_10_JOURS, SejourHorsQuebec.MotifSejour.PERSONNEL);
    }

    public static SejourHorsQuebec du1au10Fevrier() {
        return new SejourHorsQuebec(Dates.LE_2020_01_01.plusMonths(1), DUREE_10_JOURS, SejourHorsQuebec.MotifSejour.PERSONNEL);
    }

    public static SejourHorsQuebec du1au15Janvier() {
        return new SejourHorsQuebec(Dates.LE_2020_01_01, DUREE_10_JOURS.plusDays(5), SejourHorsQuebec.MotifSejour.PERSONNEL);
    }

    public static SejourHorsQuebec du1au10JanvierTravail() {
        return new SejourHorsQuebec(Dates.LE_2020_01_01, DUREE_10_JOURS, SejourHorsQuebec.MotifSejour.ETUDES_OU_TRAVAIL);
    }

    public static SejourHorsQuebec du1au10Janvier1990() {
        return new SejourHorsQuebec(Dates.LE_1990_01_01, DUREE_10_JOURS, SejourHorsQuebec.MotifSejour.PERSONNEL);
    }

    public static SejourHorsQuebec du1au10Janvier2100() {
        return new SejourHorsQuebec(Dates.LE_2100_01_01, DUREE_10_JOURS, SejourHorsQuebec.MotifSejour.PERSONNEL);
    }
}
