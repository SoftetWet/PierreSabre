package personnages;

public class Ronin extends Humain {

	private int attributHonneur = 1;

	public Ronin(String nom, String boissonFavorite, int nbArgent) {
		super(nom, boissonFavorite, nbArgent);
	}

	public void donner(Commercant beneficiaire) {
		int argent = getArgent();
		int adonner = argent/10;
		parler(beneficiaire.getNom() + " prend ces " + adonner + " sous.");
		beneficiaire.recevoir(adonner);
	}

	public void provoquer(Yakuza adversaire) {
		int force = this.attributHonneur * 2;
		int argent = getArgent();
		if (force >= adversaire.getPointReputation()) {
			parler("Je t'ai retrouv� vermine, tu vas payer pour ce que tu as fait � ce pauvre" + " marchand!");
			parler("Je t�ai eu petit yakusa!");
			gagnerArgent(adversaire.perdre());
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(argent);
			perdreArgent(argent);
		}
	}
}