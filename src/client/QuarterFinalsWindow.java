//CLASSE QUARTAS DE FINAL - REFERENTE À JANELA DAS QUARTAS DE FINAL:

package client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import business.Player;
import business.SoccerTeam;

public class QuarterFinalsWindow extends JFrame implements ActionListener
{
	//ATRIBUTOS:
	private JPanel scorePanel;
	private Player player;
	private SemiFinalsWindow sfWindow;
	private TextField auxField;
	private ArrayList<TextField> textFields;
	private ArrayList<SoccerTeam> quarterTeams;
	private ArrayList<SoccerTeam> qfWinners;
	
	//METODO CONSTRUTOR - RECEBE A JANELA DAS SEMIFINAIS PARA TER CONTROLE SOBRE ELA:
	public QuarterFinalsWindow(SemiFinalsWindow sfWindow)
	{
		this.sfWindow = sfWindow;
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.BLACK);
		this.quarterTeams = new ArrayList<SoccerTeam>();
		JLabel label = setLabel();
		this.add(label, BorderLayout.NORTH);
		getScorePanel();
		this.add(scorePanel);
		Button button = new Button();
		JButton doneButton = button.newButton("DONE", Color.black);
		doneButton.addActionListener(this);
		this.add(doneButton, BorderLayout.SOUTH);
	}
	
	//METODO - RECEBE UM BOLAO:
	public void setSweepStake(Player player) 
	{
		this.player = player;
	}
	
	//METODO - RETORNA AS SELEÇOES DAS QUARTAS:
	public ArrayList<SoccerTeam> getQuarterTeams() 
	{
		return quarterTeams;
	}
	
	//CONFIGURA O PAINEL DE TEXTO:
	public JLabel setLabel() 
	{
		JLabel label = new JLabel();
		label.setText("QUARTERFINALS - SET YOUR BET:");
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setForeground(Color.white);
		label.setFont(new Font("Google Sans", Font.BOLD, 30));
		return label;
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
	
	//METODO - CONFIGURA OS PAINEL DO PLACAR
	public void getScorePanel() 
	{
		this.scorePanel = new JPanel();
		this.textFields = new ArrayList<TextField>();
		scorePanel.setLayout(new GridLayout(4, 9, 2, 2));
		
		for(int i = 1; i <= 8; i++)
		{
			scorePanel.add(new JLabel("TEAM: "));
			this.auxField = new TextField(3);
			this.textFields.add(auxField);
			scorePanel.add(auxField);
			scorePanel.add(scoreLabel());
			this.auxField = new TextField(1);
			this.textFields.add(auxField);
			scorePanel.add(auxField);
			
			if(i % 2 != 0)
			{
				scorePanel.add(xSymbol());
			}
		}	
	}
	
	//METODO - VERIFICA SE O INPUT EH UM NUMERO:
	public static Boolean isNumeric(String string)
	{
		if(string.equals(null))
		{
			return false;
		}
		try 
		{
			Integer.parseInt(string);
		} 
		catch (NumberFormatException e) 
		{
			return false;
		}
		return true;
	}
	
	//CONFIGURA AS BANDEIRAS DAS SELECOES:
	public void setTeamsFlag() 
	{
		for(TextField field : this.textFields)
		{
			for(SoccerTeam team : this.quarterTeams)
			{
				if(isNumeric(field.getText()) == false)
				{
					if(field.getText().equals("BRA"))
					{
						team.setFlag(new ImageIcon(new ImageIcon("img/brasil.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					}
					else if(field.getText().equals("ARG"))
					{
						team.setFlag(new ImageIcon(new ImageIcon("img/argentina.jpeg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					}
					else if(field.getText().equals("CRO"))
					{
						team.setFlag(new ImageIcon(new ImageIcon("img/croacia.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					}
					else if(field.getText().equals("MAR"))
					{
						team.setFlag(new ImageIcon(new ImageIcon("img/marrocos.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					}
					else if(field.getText().equals("FRA"))
					{
						team.setFlag(new ImageIcon(new ImageIcon("img/franca.jpeg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					}
					else if(field.getText().equals("HOL"))
					{
						team.setFlag(new ImageIcon(new ImageIcon("img/holanda.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					}
					else if(field.getText().equals("ENG"))
					{
						team.setFlag(new ImageIcon(new ImageIcon("img/inglaterra.jpeg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					}
					else if(field.getText().equals("POR"))
					{

						team.setFlag(new ImageIcon(new ImageIcon("img/portugal.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					}
				}
			}
		}
	}
	
	//RETORNA OS VENCEDORES DE ACORDO COM A PONTUACAO INDICADA PELO USUARIO:
	public ArrayList<SoccerTeam> getWinners()
	{
		this.qfWinners = new ArrayList<SoccerTeam>();
		SoccerTeam auxGame[] = new SoccerTeam[2];
		
		for(int i = 0, j = 1; i < this.quarterTeams.size() && j < this.quarterTeams.size(); i += 2, j += 2)
		{
			auxGame[0] = this.quarterTeams.get(i);
			auxGame[1] = this.quarterTeams.get(j);
			
			if(auxGame[0].getScore() > auxGame[1].getScore())
			{
				qfWinners.add(auxGame[0]);
			}
			else
			{
				qfWinners.add(auxGame[1]);
			}
		}
		return qfWinners;
	}

	//RECEBE O INPUT DA PONTUACAO DE CADA SELECAO:
	public void setTeamsScore() 
	{
		int aux = -1;
		for(int i = 0; i < this.textFields.size(); i++)
		{
			if(isNumeric(textFields.get(i).getText()) == true)
			{	
				aux++;
				this.quarterTeams.get(aux).setScore(Integer.parseInt(textFields.get(i).getText()));
			}
		}
	}

	//ASSOCIA O INPUT DO USUARIO A UMA SELECAO:
	public void setTeamsName() 
	{
		for(TextField field : this.textFields)
		{
			if(isNumeric(field.getText()) == false)
			{
				this.quarterTeams.add(new SoccerTeam(field.getText(), null, 0));
			}
		}
		this.player.setQuarterTeams(quarterTeams);
	}
	
	//METODO DE EVENTO - COMPUTA OS RESULTADOS E INICIA A PROXIMA JANELA:
	public void actionPerformed(ActionEvent e) 
	{
		Boolean check = true;
		this.quarterTeams = new ArrayList<SoccerTeam>();
		
		//VERIFICA SE NENHUM CAMPO ESTA VAZIO:
		for(TextField field : this.textFields)
		{
			if(field.getText().equals(""))
			{
				check = false;
			}
		}
		
		if(check == true)
		{
			setTeamsName();
			setTeamsScore();
			setTeamsFlag();	
			this.sfWindow.setPlayer(this.player);
			this.sfWindow.setQfWinners(getWinners());
			this.sfWindow.autoFill();
			this.setVisible(false);
			this.sfWindow.setVisible(true);	
		}
	}


	
	
	
}
