package personnages;

public class Yakuza extends Humain {
	private String nomClan;
	private int pointReputation = 0;
	
	public Yakuza (String nom, String boissonFavorite, int nbArgent, String nomClan) {
		super(nom, boissonFavorite, nbArgent);
		this.nomClan = nomClan;
	}
	
	public int getPointReputation() {
		return this.pointReputation;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par l� ?");
		parler( victime.getNom()+" si tu tiens � la vie donne moi ta bourse !");
		int vol = victime.seFaireExtorquer();
		int argent = getArgent();
		argent += vol;
		parler("J�ai piqu� les "+ vol +" sous de "+ victime.getNom() +", ce qui me fait " + argent +" sous dans ma poche. Hi ! Hi !");
		pointReputation ++ ;
		
	}
	
	public int perdre() {
		int argent = getArgent();
		perdreArgent(argent);
		this.pointReputation -= 1;
		parler("J�ai perdu mon duel et mes " + argent + " sous, snif... J'ai d�shonor� le clan de " + this.nomClan);
		return argent;
	}
	
	public void gagner(int gain) {
		gagnerArgent(gain); 
		this.pointReputation += 1;
		parler("Ce ronin pensait vraiment battre "+ this.getNom() + " du clan de "+ this.nomClan + " ? Je l'ai d�pouill� de ses " + gain + " sous");
	}
}