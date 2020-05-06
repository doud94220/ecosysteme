package fr.esiea;

import javax.swing.JFrame;
import java.awt.Point;

public class LancerAppli
{
	public static void main(String[] args) //PI si on met pas static et 'Strings[] args' pas possible de "run as java application" le prgm
	{
		Ecosysteme ecosysteme = new Ecosysteme();
		JFrame jframe = new JFrame();
		jframe.add(ecosysteme);
		jframe.pack(); //Rendre visible la jframe
		jframe.setLocationRelativeTo(null); //Placer le jframe au centre de l'écran
		jframe.setVisible(true);
	}
}
