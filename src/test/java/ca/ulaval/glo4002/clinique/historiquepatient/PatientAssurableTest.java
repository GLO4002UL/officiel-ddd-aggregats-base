package ca.ulaval.glo4002.clinique.historiquepatient;

import ca.ulaval.glo4002.clinique.historiquepatient.donneestest.Dates;
import ca.ulaval.glo4002.clinique.historiquepatient.donneestest.Patients;
import org.junit.jupiter.api.Test;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatientAssurableTest {


    @Test
    public void unPatientNonInscritEstNonAssure() {
        assertFalse(Patients.nonAssure().estAssure(Dates.LE_2000_01_01));
    }

    @Test
    public void unPatientInscritALaNaissanceEstAssure() {
        assertTrue(Patients.inscritALaNaissance().estAssure(Dates.LE_2000_01_01));
    }

    @Test
    public void unPatientEstNonAssureAvantSaNaissance() {
        assertFalse(Patients.inscritALaNaissance().estAssure(Dates.LE_2000_01_01.minusDays(1)));
    }

    @Test
    public void unPatientInscritEstAssureJusquauDeces() {
        var patientDecede = Patients.inscritALaNaissance();
        patientDecede.ajouterDeces(Dates.LE_2090_01_01);

        assertTrue(patientDecede.estAssure(Dates.LE_2090_01_01.minusDays(1)));
        assertFalse(patientDecede.estAssure(Dates.LE_2090_01_01));
    }

    @Test
    public void unPatientInscritQuiQuitteLeQuebecPourTravaillerResteAssure() {
        var patientInscrit = Patients.inscritALaNaissance();
        patientInscrit.ajouterTravailHorsQuebec(Dates.LE_2020_01_01, Period.ofDays(300));

        assertTrue(patientInscrit.estAssure(Dates.LE_2000_01_01));
        assertTrue(patientInscrit.estAssure(Dates.LE_2020_01_01.plusDays(1)));
        assertTrue(patientInscrit.estAssure(Dates.LE_2020_01_01.plusDays(300)));
        assertTrue(patientInscrit.estAssure(Dates.LE_2020_01_01.plusDays(301)));
    }

    @Test
    public void unPatientAssureQuiQuittePourMoinsDe183JoursResteAssure() {
        var patientInscrit = Patients.inscritALaNaissance();
        patientInscrit.ajouterVoyagePersoHorsQuebec(Dates.LE_2020_01_01, Period.ofDays(182));

        assertTrue(patientInscrit.estAssure(Dates.LE_2000_01_01));
        assertTrue(patientInscrit.estAssure(Dates.LE_2020_01_01.plusDays(1)));
        assertTrue(patientInscrit.estAssure(Dates.LE_2020_01_01.plusDays(182)));
        assertTrue(patientInscrit.estAssure(Dates.LE_2020_01_01.plusDays(183)));
    }

    @Test
    public void unPatientAssureQuiQuittePourPlusDe183JoursPerdSonAssuranceImmediatement() {
        var patientInscrit = Patients.inscritALaNaissance();
        patientInscrit.ajouterVoyagePersoHorsQuebec(Dates.LE_2020_01_01, Period.ofDays(183));

        assertTrue(patientInscrit.estAssure(Dates.LE_2000_01_01));
        assertFalse(patientInscrit.estAssure(Dates.LE_2020_01_01.plusDays(1)));
    }

    @Test
    public void unPatientAssureQuiQuittePourPlusDe183JoursEnPlusieursFoisPerdSonAssuranceAuDernierSejour() {
        var patientInscrit = Patients.inscritALaNaissance();
        patientInscrit.ajouterVoyagePersoHorsQuebec(Dates.LE_2020_01_01, Period.ofDays(180));
        patientInscrit.ajouterVoyagePersoHorsQuebec(Dates.LE_2020_01_01.plusDays(190), Period.ofDays(5));

        assertTrue(patientInscrit.estAssure(Dates.LE_2000_01_01));
        assertTrue(patientInscrit.estAssure(Dates.LE_2020_01_01));
        assertTrue(patientInscrit.estAssure(Dates.LE_2020_01_01.plusDays(180)));
        assertFalse(patientInscrit.estAssure(Dates.LE_2020_01_01.plusDays(190)));
    }

}
