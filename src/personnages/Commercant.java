package personnages;

public class Commercant extends Humain {

	private static final String BOISSON = "thé";

	public Commercant(String nom, int nbArgent) {
		super(nom, BOISSON, nbArgent);
	}

	public int seFaireExtorquer() {
		int argent = this.getArgent();
		perdreArgent(argent);
		parler("J’ai tout perdu! Le monde est trop injuste...");
		return argent;
	}

	public void recevoir(int argent) {
		gagnerArgent(argent);
		parler(argent + " sous! Je te remercie généreux donateur!");
	}
}