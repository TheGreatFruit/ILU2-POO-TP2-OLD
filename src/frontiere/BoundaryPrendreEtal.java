package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		if(! controlPrendreEtal.verifierIdentite(nomVendeur)) {
			chaine.append("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village dpour commercer ici.\n");
			System.out.println(chaine.toString());
		} else {
			chaine.append("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.\n");
			System.out.println(chaine.toString());
			if(! controlPrendreEtal.resteEtals()) {
				chaine.append("Désolée " + nomVendeur + ", je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
				System.out.println(chaine.toString());
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("C'est parfait, il me reste un étal pour vous !\n");
		chaine.append("Il me faudrait quelques renseignements :\n");
		chaine.append("Quel produit souhaitez-vous vendre ?\n");
		String produit = Clavier.entrerChaine(chaine.toString());
		chaine.setLength(0);
		chaine.append("Combien souhaitez-vous en vendre ?\n");
		int nbProduit = Clavier.entrerEntier(chaine.toString());
		int nbEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit) + 1;
		chaine.setLength(0);
		if(nbEtal != -1) {
			chaine.append("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + nbEtal + "\n");
			System.out.println(chaine.toString());
		}
	}
}


