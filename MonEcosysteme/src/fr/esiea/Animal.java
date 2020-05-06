package fr.esiea;

import java.awt.Point;
import javax.swing.JLabel;
import java.lang.Math;

public class Animal extends JLabel
{
	private static final long serialVersionUID = 4869988174141576297L; //Indispensable mais je me demande à quoi ca sert
	
	private String regime_alimentaire;
	public Point position; //Point définit les coordonnées X et Y de l'animal
	public Point anciennePosition; //Point qui définit l'ancien emplacement de l'animal
	public boolean mort;
	
	public Animal(Point position)
	{
		this.position = new Point(position);
		this.anciennePosition = new Point(position);
		this.mort = false;
	}
	
	public synchronized void se_deplacer() //déplacement aléatoire, je tente un synchronized mais pas sur que utile
	{
		Point positionAvantDeplacement = this.position;
		double x_avant = positionAvantDeplacement.getX();
		double y_avant = positionAvantDeplacement.getY();
		double x_apres = 0;
		double y_apres = 0;
		
		double pourDeplacementAleatoire = Math.random();
		
		if(pourDeplacementAleatoire < 0.25)
		{
			x_apres = x_avant - 1;
			y_apres = y_avant;
		}
		else if(pourDeplacementAleatoire >= 0.25 && pourDeplacementAleatoire < 0.5)
		{
			x_apres = x_avant + 1;
			y_apres = y_avant;
		}
		else if(pourDeplacementAleatoire >= 0.5 && pourDeplacementAleatoire < 0.75)
		{
			x_apres = x_avant;
			y_apres = y_avant - 1;
		}
		else if(pourDeplacementAleatoire >= 0.75 && pourDeplacementAleatoire <= 1)
		{
			x_apres = x_avant;
			y_apres = y_avant + 1;
		}
		
		int nouveau_x = (int) x_apres;
		int nouveau_y = (int) y_apres;
System.out.println("Deplacement : nouveau X : "+nouveau_x);
System.out.println("Deplacement : nouveau Y : "+nouveau_y);
		this.position.setLocation(nouveau_x, nouveau_y);
		
		int ancien_x = (int) x_avant;
		int ancien_y = (int) y_avant;
System.out.println("Deplacement : ancien X : "+ancien_x);
System.out.println("Deplacement : ancien Y : "+ancien_y);
		this.anciennePosition.setLocation(ancien_x, ancien_y);
		
		//Ecosysteme.deplacerAnimal(positionAvantDeplacement, new Point(nouveau_x, nouveau_y), new Alligator(new Point(nouveau_x, nouveau_y)));
		// CA CHIE CA AU DESSUS
	}
}
