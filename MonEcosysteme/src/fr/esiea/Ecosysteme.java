package fr.esiea;

import java.awt.GridLayout;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Point;
import java.lang.Runnable;

public class Ecosysteme extends JPanel implements Runnable
{
	private static final long serialVersionUID = 9059655539355281937L; //Indispensable mais je me demande à quoi ca sert
	
	private ArrayList<ArrayList<Emplacement>> listeEmplacements;
	public Thread threadEcosysteme;
	public Point position_alligator1;
	public Point position_alligator2;
	public Point position_alligator3;
	public Point position_grenouille1;
	public Point position_grenouille2;
	public Point position_grenouille3;
	public Point position_sauterelle1;
	public Point position_sauterelle2;
	public Point position_sauterelle3;
	public boolean ilResteDesAnimaux = true;
	
	public Ecosysteme()
	{
		setLayout(new GridLayout(15,15)); //On définit une grille de 15 sur 15
		this.listeEmplacements = new ArrayList<ArrayList<Emplacement>>(); //On initialise le tableau de tableau d' Emplacement
		
		for(int i=0; i<15; i++) //on parcourt le premier tableau, cad on parcourt les lignes de la grille
		{
			ArrayList<Emplacement> ligne = new ArrayList<Emplacement>();
			
			for(int j=0; j<15; j++) //on parcourt le deuxieme tableau, cad on parcourt les colonnes de la grille
			{
				Emplacement e = new Emplacement();
				//e.add(new Animal()); //Je commente mais ca marche
				ligne.add(e);
				add(e); //Ajout de l'Emplacement au container
			}
			
			listeEmplacements.add(ligne); //On écrase dans l'attribut listeEmplacements la ligne en cours par notre ligne fraîchement créée avec des Emplacements dedans
		}
		
		placerAnimauxAuDepart(); //Placement initial des animaux
		//deplacerUnAnimal(); //TEMPORAIRE
		threadEcosysteme = new Thread(this); //On initialise le thread, pas compris le this
		threadEcosysteme.start(); //On le démarre
System.out.println("dans le constructeur de ecosysteme");
	}
	
	public void placerAnimauxAuDepart()
	{
		ArrayList<ArrayList<Emplacement>> laListeDesEmplacements = this.listeEmplacements;
		
		//On place les alligators
		
		Alligator alligator1 = new Alligator(new Point(4,6)); //On le place au hasard
		int x1 = (int) alligator1.position.getX();
		int y1 = (int) alligator1.position.getY();
		laListeDesEmplacements.get(y1).get(x1).add(alligator1); //On parcourt les lignes puis les colonnes, donc get(y) puis get(x)
		this.position_alligator1 = new Point(4,6);
/*		
		Alligator alligator2 = new Alligator(new Point(11,11));
		int x2 = (int) alligator2.position.getX();
		int y2 = (int) alligator2.position.getY();
		laListeDesEmplacements.get(y2).get(x2).add(alligator2);
		this.position_alligator2 = new Point(11,11);
		
		Alligator alligator3 = new Alligator(new Point(12,3));
		int x3 = (int) alligator3.position.getX();
		int y3 = (int) alligator3.position.getY();
		laListeDesEmplacements.get(y3).get(x3).add(alligator3);
		this.position_alligator3 = new Point(12,3);
		
		//On place les grenouilles
		
		Grenouille grenouille1 = new Grenouille(new Point(2,2));
		x1 = (int) grenouille1.position.getX();
		y1 = (int) grenouille1.position.getY();
		laListeDesEmplacements.get(y1).get(x1).add(grenouille1);
		this.position_grenouille1 = new Point(2,2);

		Grenouille grenouille2 = new Grenouille(new Point(8,8));
		x2 = (int) grenouille2.position.getX();
		y2 = (int) grenouille2.position.getY();
		laListeDesEmplacements.get(y2).get(x2).add(grenouille2);
		this.position_grenouille2 = new Point(8,8);
		
		Grenouille grenouille3 = new Grenouille(new Point(14,14));
		x3 = (int) grenouille3.position.getX();
		y3 = (int) grenouille3.position.getY();
		laListeDesEmplacements.get(y3).get(x3).add(grenouille3);
		this.position_grenouille3 = new Point(14,14);
		
		//On place les sauterelles
		
		Sauterelle sauterelle1 = new Sauterelle(new Point(1,12));
		x1 = (int) sauterelle1.position.getX();
		y1 = (int) sauterelle1.position.getY();
		laListeDesEmplacements.get(y1).get(x1).add(sauterelle1);
		this.position_sauterelle1 = new Point(1,12);
		
		Sauterelle sauterelle2 = new Sauterelle(new Point(5,10));
		x2 = (int) sauterelle2.position.getX();
		y2 = (int) sauterelle2.position.getY();
		laListeDesEmplacements.get(y2).get(x2).add(sauterelle2);
		this.position_sauterelle2 = new Point(5,10);
		
		Sauterelle sauterelle3 = new Sauterelle(new Point(8,2));
		x3 = (int) sauterelle3.position.getX();
		y3 = (int) sauterelle3.position.getY();
		laListeDesEmplacements.get(y3).get(x3).add(sauterelle3);
		this.position_sauterelle3 = new Point(8,2);
*/	
		this.listeEmplacements = laListeDesEmplacements;
	}
	
	//TEMPORAIRE - Pour tester un déplacement (celui de la dernière sauterelle)
	/*public void deplacerUnAnimal()
	{
		ArrayList<ArrayList<Emplacement>> laListeDesEmplacements = this.listeEmplacements;
		Sauterelle sauterelle_a_deplacer = (Sauterelle) laListeDesEmplacements.get(2).get(8).getComponent(0);
		sauterelle_a_deplacer.se_deplacer();
		Point nouvelle_position = sauterelle_a_deplacer.position;
		int nouveau_x = (int) nouvelle_position.getX();
		int nouveau_y = (int) nouvelle_position.getY();
		laListeDesEmplacements.get(nouveau_y).get(nouveau_x).add(sauterelle_a_deplacer);
	}*/
	
	//Je sais pas comment je vais l'utiliser
	/*public void deplacerAnimal(Point A, Point B, Animal animal)
	{
		ArrayList<ArrayList<Emplacement>> laListeDesEmplacements = this.listeEmplacements;
		
		int x_A = (int) A.getX();
		int y_A = (int) A.getY();
		laListeDesEmplacements.get(y_A).get(x_A).removeAll();
		
		int x_B = (int) B.getX();
		int y_B = (int) B.getY();
		laListeDesEmplacements.get(y_B).get(x_B).add(animal);
	}*/
	
	public void run()
	{
System.out.println("dans le run de ecosysteme");
int j = 0;
		////////////////////////////////// Ici faudrait qu'on lise la liste des animaux à déplacer dans l'écosystème (faudrait trouver 
		////////////////////////////////// point départ, point arrivée, type animal)
		
		///// On déplace l'alligator1 suivant son déplacement dans le thread Alligator
		while(ilResteDesAnimaux == true)
		{
			System.out.println("j : "+j);
			
			ArrayList<ArrayList<Emplacement>> laListeDesEmplacements = this.listeEmplacements;
			
			//Récupérer position de l'alligator1, stockée dans les attributs de la classe Ecosysteme
			int x = (int) this.position_alligator1.getX();
			int y = (int) this.position_alligator1.getY();
System.out.println("Position X de l' Alligator stockée dans les attributs de la classe Ecosysteme : "+x);
System.out.println("Position Y de l' Alligator stockée dans les attributs de la classe Ecosysteme : "+y);
			Alligator alligator1 = (Alligator) laListeDesEmplacements.get(y).get(x).getComponent(0);
			
			Point positionActuelle = alligator1.position;
System.out.println("Position X actuelle de l'Alligator : "+positionActuelle.getX());
System.out.println("Position Y actuelle de l'Alligator : "+positionActuelle.getY());
			Point positionAncienne = alligator1.anciennePosition;
System.out.println("Position X ancienne de l'Alligator : "+positionAncienne.getX());
System.out.println("Position X ancienne de l'Alligator : "+positionAncienne.getY());
			
			int x_ancien = (int) positionAncienne.getX();
			int y_ancien = (int) positionAncienne.getY();
			laListeDesEmplacements.get(y_ancien).get(x_ancien).removeAll(); //vider l'ancien emplacement
			
			int x_actuel = (int) positionActuelle.getX();
			int y_actuel = (int) positionActuelle.getY();
			laListeDesEmplacements.get(y_actuel).get(x_actuel).add(alligator1);
			
			this.position_alligator1 = positionActuelle; //On met à jour la position de l'Alligator

System.out.println("Position X de l' Alligator MAJ, stockée dans les attributs de la classe Ecosysteme : "+this.position_alligator1.getX());
System.out.println("Position Y de l' Alligator MAJ, stockée dans les attributs de la classe Ecosysteme : "+this.position_alligator1.getY());

			try
			{
				threadEcosysteme.sleep(2000); //Pour avoir le temps de visualiser les déplacements des animaux
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			j = j+1;
		}
	}
}
