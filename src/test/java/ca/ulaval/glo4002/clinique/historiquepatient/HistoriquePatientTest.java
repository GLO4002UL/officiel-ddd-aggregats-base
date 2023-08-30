package ca.ulaval.glo4002.clinique.historiquepatient;

import ca.ulaval.glo4002.clinique.historiquepatient.donneestest.Dates;
import ca.ulaval.glo4002.clinique.historiquepatient.donneestest.Sejours;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HistoriquePatientTest {

    private HistoriquePatient historique;

    @BeforeEach
    public void setup() {
        historique = new HistoriquePatient(Dates.LE_2000_01_01);
    }

    @Test
    public void unHistoriqueAvecUneDateDeNaissanceEstValide() {
        assertTrue(historique.estValide());
    }

    @Test
    public void unHistoriqueSansDateDeNaissanceEstInvalide() {
        assertFalse(new HistoriquePatient(null).estValide());
    }

    @Test
    public void unHistoriqueAvecUneDateDeDecesAvantNaissanceEstInvalide() {
        assertTrue(historique.estValide());
        historique.ajouterDeces(Dates.LE_1990_01_01);
        assertFalse(historique.estValide());
    }

    @Test
    public void unHistoriqueAvecDecesApresNaissanceEstValide() {
        historique.ajouterDeces(Dates.LE_2090_01_01);
        assertTrue(historique.estValide());
    }

    @Test
    public void unHistoriqueAvecUnSejourAvantNaissanceEstInvalide() {
        historique.ajouterSejour(Sejours.du1au10Janvier1990());
        assertFalse(historique.estValide());
    }

    @Test
    public void unHistoriqueAvecUnSejourApresDecesEstInvalide() {
        historique.ajouterDeces(Dates.LE_2090_01_01);
        historique.ajouterSejour(Sejours.du1au10Janvier2100());
        assertFalse(historique.estValide());
    }

    @Test
    public void unHistoriqueAvecSejoursQuiSeChevauchentEstInvalide() {
        historique.ajouterSejour(Sejours.du1au10Janvier());
        historique.ajouterSejour(Sejours.du1au15Janvier());
        assertFalse(historique.estValide());
    }

    @Test
    public void unHistoriqueAvecPlusieursSejoursDifferentsEstValide() {
        historique.ajouterSejour(Sejours.du1au10JanvierTravail());
        historique.ajouterSejour(Sejours.du1au10Fevrier());
        assertTrue(historique.estValide());
    }

    @Test
    public void unHistoriqueAvecInscriptionALaNaissanceEstValide() {
        historique.ajouterInscriptionRAMQ(Dates.LE_2000_01_01);
        assertTrue(historique.estValide());
    }

    @Test
    public void unHistoriqueAvecInscriptionEntreNaissanceEtDecesEstValide() {
        historique.ajouterInscriptionRAMQ(Dates.LE_2020_01_01);
        historique.ajouterDeces(Dates.LE_2090_01_01);
        assertTrue(historique.estValide());
    }

    @Test
    public void unHistoriqueAvecInscriptionAvantNaissanceEstInvalide() {
        historique.ajouterInscriptionRAMQ(Dates.LE_1990_01_01);
        assertFalse(historique.estValide());
    }

    @Test
    public void unHistoriqueAvecInscriptionApresDecesEstInvalide() {
        historique.ajouterDeces(Dates.LE_2090_01_01);
        historique.ajouterInscriptionRAMQ(Dates.LE_2090_01_01.plusDays(1));
        assertFalse(historique.estValide());
    }

}
