package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int nbArgent;
	protected int nbConnaissance;
	protected Humain[] memoire = new Humain[nbConnaissance];

	public Humain(String nom, String boissonFavorite, int nbArgent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.nbArgent = nbArgent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return nbArgent;
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") : " + texte);
	}

	public void boire() {
		parler("Mmm,  un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		if (nbArgent > prix) {
			parler("J ai " + nbArgent + " sous en poche. Je vais pouvoir m offrir " + bien +" à " + prix + " sous.");
			perdreArgent(prix);
			if (bien != null && bien.equals("une boisson")) {
				boire();
				}
		} else {
			parler("J n'ai plus que " + nbArgent + " sous en poche. Je ne  peux  meme pas m'offrir " + bien + " à "
					+ prix + " sous.");
		}
	}

	public int gagnerArgent(int gain) {
		nbArgent += gain;
		return nbArgent;
	}

	public int perdreArgent(int perte) {
		if ((nbArgent - perte) > 0) {
			nbArgent -= perte;
			return nbArgent;
		}
		return 0;
	}

	public void direBonjour() {
		parler("Bonjour ! je m'appelle " + nom + " et j aime boire du " + boissonFavorite);
	}
	
	public void memoriser(Humain humain) {
		
	}
	
	public void repondre(Humain humain1, Humain humain2) {
		humain2.direBonjour();
		humain2.memoriser(humain1);
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		repondre(this,autreHumain);
		memoriser
	}
	
}