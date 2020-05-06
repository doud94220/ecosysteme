package fr.esiea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class Emplacement extends JPanel //Emplacement correspond à une case de la grille
{
	private static final long serialVersionUID = -8314038422413542993L; //Indispensable mais je me demande à quoi ca sert

	public Emplacement()
	{
		setLayout(new GridLayout(1,0)); //On définit qu'un Emplacmeent c'est une case ou plutot une case de la grille
		setSize(32,32); //On définit la case à 32*32 pixels
		setPreferredSize(new Dimension(48, 48)); //Bizarre, mais utile, car agrandit la grille
		setBorder(BorderFactory.createLineBorder(Color.black)); //Marquer les bordures de la grille (y compris celles à l'intérieur) en noir
	}
}
