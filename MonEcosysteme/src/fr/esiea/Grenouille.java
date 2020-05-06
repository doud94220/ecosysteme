package fr.esiea;

import javax.swing.ImageIcon;
import java.awt.Point;

public class Grenouille extends Animal implements Runnable
{
	private static final long serialVersionUID = 1869988174141576298L; //Indispensable mais je me demande à quoi ca sert
	
	public Grenouille(Point position)
	{
		super(position);
		setIcon(new ImageIcon(getClass().getResource("/images/grenouille.png"))); //Charge l'image de l'url dans le container
	}
	
	public void run()
	{
		while(mort != true)
		{
			se_deplacer();
		}
	}
}
