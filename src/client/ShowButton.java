//CLASSE DO BOTAO DE MOSTRAR - NAO FINALIZADA:

package client;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import business.Player;
import business.SweepStakes;
import data.SweepStakeDAO;

public class ShowButton 
{
	private MainWindow mWindow;
	private ShowWindow sWindow;
	private SweepStakes ssList;
	
	public JButton getButton(MainWindow mWindow, ShowWindow sWindow, SweepStakes ssList)
	{
		this.ssList = ssList;
		this.mWindow = mWindow;
		this.sWindow = sWindow;
		Button button = new Button();
		return button.newButton("Show SweepStakes", Color.yellow);
	}
	public void actionPerformed(ActionEvent e) 
	{
		ArrayList<Player> aux = new ArrayList<Player>();
		aux = this.ssList.getDataSync().listSweepStakes();
		SweepStakes aux2 = new SweepStakes();
		aux2.setSweepStakesList(aux);
		this.sWindow.setSweepStakes(aux2);
		this.mWindow.setVisible(false);
		this.sWindow.setVisible(true);
		
		
	}

}
