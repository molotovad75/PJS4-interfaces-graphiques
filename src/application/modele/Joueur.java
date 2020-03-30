package application.modele;

public class Joueur {
	private String nom_joueur;
	private String nom_utilisateur;
	private String mdp_joueur;
	
	public String getNom_joueur() {
		return nom_joueur;
	}
	public void setNom_joueur(String nom_joueur) {
		this.nom_joueur = nom_joueur;
	}
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}
	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	public String getMdp_joueur() {
		return mdp_joueur;
	}
	public void setMdp_joueur(String mdp_joueur) {
		this.mdp_joueur = mdp_joueur;
	}
	
	public String toString() {
		return "C'est "+this.nom_joueur+" qui a pour vrai nom "+this.nom_utilisateur;
	}
}
