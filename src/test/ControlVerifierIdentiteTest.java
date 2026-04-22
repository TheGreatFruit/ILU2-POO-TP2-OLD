package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controleur.ControlEmmenager;
import controleur.ControlVerifierIdentite;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	@Test
	void testControlVerifierIdentite() {
		Village village = new Village("Village gaulois 1", 10, 5);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village );
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

}
