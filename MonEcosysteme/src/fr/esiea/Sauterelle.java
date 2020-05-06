package fr.esiea;

import javax.swing.ImageIcon;
import java.awt.Point;

public class Sauterelle extends Animal implements Runnable
{
	private static final long serialVersionUID = 1869988174141576293L; //Indispensable mais je me demande à quoi ca sert
	
	public Sauterelle(Point position)
	{
		super(position);
		setIcon(new ImageIcon(getClass().getResource("/images/sauterelle.jpg"))); //Charge l'image de l'url dans le container
	}
	
	public void run()
	{
		while(mort != true)
		{
			se_deplacer();
		}
	}
}
