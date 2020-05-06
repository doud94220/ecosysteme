package fr.esiea;

import javax.swing.ImageIcon;
import java.awt.Point;
import java.lang.Runnable;

public class Alligator extends Animal implements Runnable
{
	private static final long serialVersionUID = 1869988174141576297L; //Indispensable mais je me demande à quoi ca sert
	
	public Thread threadAlligator;
	
	public Alligator(Point position)
	{
		super(position);
		setIcon(new ImageIcon(getClass().getResource("/images/alligator.jpg"))); //Charge l'image de l'url dans le container
		threadAlligator = new Thread(this); //Initialisation du thread, pas compris le this
		threadAlligator.start(); //Démarrage du thread
System.out.println("dans le constructeur de alligator");
	}
	
	public void run()
	{
System.out.println("dans le run de alligator");
int i = 0;

		while(mort != true)
		{
			System.out.println("i : "+i);
			
			se_deplacer();
			
			try
			{
				threadAlligator.sleep(2000); //Pour avoir le temps de visualiser les déplacements des animaux
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			i = i+1;
		}
	}
}
