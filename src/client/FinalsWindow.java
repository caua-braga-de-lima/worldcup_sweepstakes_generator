//CLASSE FINAIS - REFERENTE A JANELA DAS FINAIS:

package client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import business.Player;
import business.SoccerTeam;
import business.SweepStakes;
import data.SweepStakeDAO;

public class FinalsWindow extends JFrame implements ActionListener
{
	//ATRIBUTOS:
	private JPanel scorePanel;
	private TextField auxField;
	private Player player;
	private ArrayList<TextField> textFields;
	private ArrayList<SoccerTeam> sfWinners;
	private SoccerTeam winner;
	private SweepStakeDAO dataSync;

	//METODO CONSTRUTOR:
	public FinalsWindow()
	{
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.black);
		this.setLayout(new BorderLayout());
		this.add(setLabel(), BorderLayout.NORTH);
		getPanelInfo();
		this.add(scorePanel, BorderLayout.CENTER);
		Button button = new Button();
		JButton doneButton = button.newButton("DONE", null);
		doneButton.addActionListener(this);
		this.add(doneButton, BorderLayout.SOUTH);
	}
	
	//RECEBE E RETORNA O BOLAO DE ACESSO PARA O BANCO:
	public SweepStakeDAO getDataSync() 
	{
		return dataSync;
	}
	
	public void setDataSync(SweepStakeDAO dataSync) 
	{
		this.dataSync = dataSync;
	}
	
	public void setPlayer(Player player) 
	{
		this.player = player;
	}
	
	//CONFIGURA AS INFORMACOES DO PAINEL:
	public void getPanelInfo() 
	{
		this.scorePanel = new JPanel();
		this.textFields = new ArrayList<TextField>();
		scorePanel.setLayout(new GridLayout(1, 2));
		
		for(int i = 1; i <= 2; i++)
		{
			scorePanel.add(teamLabel());
			//para syncar com o bolao, receba um como parametro
			this.auxField = new TextField(3);
			this.textFields.add(auxField);
			scorePanel.add(auxField);
			scorePanel.add(scoreLabel());
			auxField = new TextField(1);
			this.textFields.add(auxField);
			scorePanel.add(auxField);
			
			if(i % 2 != 0)
			{
				scorePanel.add(xSymbol());
			}
		}
	}
	
	//CONFIGURAO TEXTO DA JANELA:
	public JLabel setLabel() 
	{
		JLabel label = new JLabel();
		label.setText("FINALS - SET YOUR BET:");
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setForeground(Color.white);
		label.setFont(new Font("Google Sans", Font.BOLD, 30));
		return label;
	}
	
	//CONFIGURA OS VENCEDORES:
	public void setSfWinners(ArrayList<SoccerTeam> sfWinners) 
	{
		this.sfWinners = sfWinners;
		this.player.setFinalTeams(sfWinners);
	}
	
	//METODOS AUXILIARES:
	public JLabel teamLabel()
	{
		return new JLabel("TEAM: ");
	}
	
	public JLabel scoreLabel()
	{
		return new JLabel("SCORE: ");
	}
	
	public JLabel xSymbol()
	{
		return new JLabel("X");
	}
	
	//REALIZA O AUTOPREENCHIMENTO DOS CAMPOS DE TEXTO:
	public void autoFill()
	{
		int aux = -1;
		for(int i = 0; i < this.textFields.size(); i++)
		{
			if(i % 2 == 0)
			{
				aux++;
				this.textFields.get(i).setText(this.sfWinners.get(aux).getName());
			}
		}
	}
	
	//ASSOCIA O INPUT DO USUARIO A PONTUACAO DAS SELECOES:
	public void setTeamsScore() 
	{
		int aux = -1;
		for(int i = 0; i < this.textFields.size(); i++)
		{
			if(i % 2 != 0)
			{
				aux++;
				this.sfWinners.get(aux).setScore(Integer.parseInt(textFields.get(i).getText()));
			}
		}	
	}
	
	//RETORNA O VENCEDOR:
	public SoccerTeam getWinner()
	{
		if(this.sfWinners.get(0).getScore() > this.sfWinners.get(1).getScore())
		{
			this.winner = this.sfWinners.get(0);
			this.player.setWinner(winner);
		}
		else
		{
			this.winner = this.sfWinners.get(1);
			this.player.setWinner(winner);
		}
		
		return this.winner;
	}

	//METODO DE EVENTO - INICIA A JANELA FINAL E IMPORTA OS DADOS PARA O BANCO:
	public void actionPerformed(ActionEvent e) 
	{
		Boolean check = true;
		
		for(TextField field : this.textFields)
		{
			if(field.getText().equals(""))
			{
				check = false;
			}
		}
		
		if(check == true)
		{
			setTeamsScore();
			getWinner();
			
			SweepStakeDAO sweepStake = new SweepStakeDAO();
			sweepStake.insertSweepStake(this.player);
			this.setVisible(false);
			WinnerWindow window = new WinnerWindow(getWinner());
//			this.dataSync.insertSweepStake(this.player);
//			this.setVisible(false);
//			WinnerWindow window = new WinnerWindow(getWinner());

		}
		
	}
}

