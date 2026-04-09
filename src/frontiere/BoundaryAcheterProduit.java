package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		StringBuilder chaine = new StringBuilder();

		if (!controlAcheterProduit.verifIdentite(nomAcheteur)) {
			chaine.append("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.\n");
		} else {
			chaine.append("Quel produit voulez-vous acheter ?\n");
			String produit = Clavier.entrerChaine(chaine.toString());

			chaine.setLength(0);
			chaine.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");

			Gaulois[] listeVendeursProduit = controlAcheterProduit.trouverEtalsProduit(produit);

			for (int i = 0; i < listeVendeursProduit.length; i++) {
				chaine.append(i + " - " + listeVendeursProduit[i].getNom() + "\n");
			}

			int numVendeur = Clavier.entrerEntier(chaine.toString());
			String nomVendeur = listeVendeursProduit[numVendeur].getNom();

			chaine = new StringBuilder();
			chaine.append(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur + ".\n");
			chaine.append("Bonjour " + nomAcheteur + "\n");

			System.out.println(chaine.toString());
		}
	}
}