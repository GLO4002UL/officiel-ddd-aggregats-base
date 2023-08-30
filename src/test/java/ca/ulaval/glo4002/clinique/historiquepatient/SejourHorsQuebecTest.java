package ca.ulaval.glo4002.clinique.historiquepatient;

import ca.ulaval.glo4002.clinique.historiquepatient.donneestest.Sejours;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SejourHorsQuebecTest {

    @Test
    public void deuxSejoursSontIdentiquesSiMemeValeurs() {
        assertEquals(Sejours.du1au10Janvier(), Sejours.du1au10Janvier());
        assertNotEquals(Sejours.du1au10Janvier(), Sejours.du5au15Janvier());
        assertNotEquals(Sejours.du1au10Janvier(), Sejours.du1au10Fevrier());
        assertNotEquals(Sejours.du1au10Janvier(), Sejours.du1au10JanvierTravail());
        assertNotEquals(Sejours.du1au10Janvier(), Sejours.du1au15Janvier());
    }

    @Test
    public void deuxSejoursIdentiquesSontSimulatines() {
        assertTrue(Sejours.du1au10Janvier().estSimultane(Sejours.du1au10Janvier()));
    }

    @Test
    public void deuxSejoursSontSimlulatnesSiDureeSeChevauche() {
        assertTrue(Sejours.du1au10Janvier().estSimultane(Sejours.du1au15Janvier()));
        assertTrue(Sejours.du1au15Janvier().estSimultane(Sejours.du1au10Janvier()));

        assertTrue(Sejours.du1au10Janvier().estSimultane(Sejours.du5au15Janvier()));
        assertTrue(Sejours.du5au15Janvier().estSimultane(Sejours.du1au10Janvier()));

        assertTrue(Sejours.du1au10Janvier().estSimultane(Sejours.du1au10JanvierTravail()));
        assertTrue(Sejours.du1au10JanvierTravail().estSimultane(Sejours.du1au10Janvier()));
    }

}