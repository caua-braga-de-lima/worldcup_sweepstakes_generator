//CLASSE JANELA DO VENCEDOR - REFERENTE A ULTIMA JANELA EXIBIDA NA GUIA DE CADASTRO DE BOLAO:

package client;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import business.SoccerTeam;

public class WinnerWindow extends JFrame
{
	//METODO CONSTRUTOR:
	public WinnerWindow(SoccerTeam winner)
	{
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(new JLabel("A SELEÇÃO VENCEDORA É " + winner.getName()), BorderLayout.NORTH);
		this.add(new JLabel(winner.getFlag()), BorderLayout.CENTER);
	}
}
