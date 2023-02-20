//CLASSE DA JANELA DE MOSTRAR BOLOES - NAO FINALIZADA

package client;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import business.Player;
import business.SoccerTeam;
import business.SweepStakes;

public class ShowWindow extends JFrame
{
	private SweepStakes sweepStakes;

	public ShowWindow()
	{
		this.setSize(800, 600);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		getPanelInfo(panel);
		this.add(panel);
	}

	public void getPanelInfo(JPanel panel) 
	{
		panel.setLayout(new FlowLayout());
		
		try
		{
			for(Player player : this.sweepStakes.getSweepStakesList())
			{
				panel.add(new JLabel("NOME: " + player.getName() + " ID: " + player.getId()));
				getTeamsInfo(panel, player);
			}
		}catch(Exception e)
		{
			
		}
		
	}

	public void getTeamsInfo(JPanel panel, Player player) 
	{
		for(SoccerTeam team : player.getQuarterTeams())
		{
			panel.add(new JLabel(team.getName() + " " + team.getScore()));
		}
		
		for(SoccerTeam team : player.getSemiTeams())
		{
			panel.add(new JLabel(team.getName() + " " + team.getScore()));
		}
		
		for(SoccerTeam team : player.getFinalTeams())
		{
			panel.add(new JLabel(team.getName() + " " + team.getScore()));
		}
		
		panel.add(new JLabel(player.getWinner().getName()));
	}
	
	public void setSweepStakes(SweepStakes sweepStakes) 
	{
		this.sweepStakes = sweepStakes;
	}
	
}
