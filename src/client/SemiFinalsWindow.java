//CLASSE SEMIFINAIS - REFERENTE A JANELA DAS SEMIFINAIS:

package client;
import java.awt.BorderLayout;
import java.awt.Color;
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

public class SemiFinalsWindow extends JFrame implements ActionListener
{
	//ATRIBUTOS:
	private JPanel scorePanel;
	private FinalsWindow fWindow;
	private TextField auxField;
	private Player player;
	private ArrayList<SoccerTeam> qfWinners;
	private ArrayList<SoccerTeam> sfWinners;
	private ArrayList<TextField> textFields;
	
	//METODO CONSTRUTOR - RECEBE A JANELA DAS FINAIS PARA TER CONTROLE SOBRE ELA:
	public SemiFinalsWindow(FinalsWindow fWindow)
	{
		this.fWindow = fWindow;
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.black);
		this.setLayout(new BorderLayout());
		this.add(setLabel(), BorderLayout.NORTH);
		this.qfWinners = new ArrayList<SoccerTeam>();
		getPanelInfo();
		this.add(scorePanel);	
		Button button = new Button();
		JButton doneButton = button.newButton("DONE", Color.black);
		doneButton.addActionListener(this);
		this.add(doneButton, BorderLayout.SOUTH);
	}
	
	//METODO - RECEBE UM BOLAO:
	public void setPlayer(Player player) 
	{
		this.player = player;
	}

	//CONFIGURA AS INFORMACOES DO PAINEL DE PONTUACAO:
	public void getPanelInfo() 
	{
		this.scorePanel = new JPanel();
		this.textFields = new ArrayList<TextField>(); 
		scorePanel.setLayout(new GridLayout(2, 9));
		
		for(int i = 1; i <= 4; i++)
		{
			scorePanel.add(teamLabel());
			auxField = new TextField(3);
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
	
	//REALIZA O AUTOPREENCHIMENTO DOS CAMPOS DE TEXTOS COM AS SELECOES VENCEDORAS NA ETAPA ANTERIOR:
	public void autoFill()
	{
		int aux = -1;
		for(int i = 0; i < this.textFields.size(); i++)
		{
			if(i % 2 == 0)
			{
				aux++;
				this.textFields.get(i).setText(this.qfWinners.get(aux).getName());
			}
		}
	}
	
	//CONFIGURA O TEXTO DA JANELA:
	public JLabel setLabel() 
	{
		JLabel label = new JLabel();
		label.setText("SEMIFINALS - SET YOUR BET:");
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
	
	public void setQfWinners(ArrayList<SoccerTeam> qfWinners) 
	{
		this.qfWinners = qfWinners;
	}
	
	//RECEBE O INPUT DE PONTUACAO DO USUARIO:
	public void setTeamsScore() 
	{
		int aux = -1;
		for(int i = 0; i < this.textFields.size(); i++)
		{
			if(i % 2 != 0)
			{
				aux++;
				this.qfWinners.get(aux).setScore(Integer.parseInt(textFields.get(i).getText()));
			}
		}	
	}
	
	//COMPARA OS SCORES E RETORNA OS VENCEDORES:
	public ArrayList<SoccerTeam> getWinners()
	{
		this.sfWinners = new ArrayList<SoccerTeam>();
		SoccerTeam auxGame[] = new SoccerTeam[2];
		
		for(int i = 0, j = 1; i < this.qfWinners.size() && j < this.qfWinners.size(); i += 2, j += 2)
		{
			auxGame[0] = this.qfWinners.get(i);
			auxGame[1] = this.qfWinners.get(j);
			
			if(auxGame[0].getScore() > auxGame[1].getScore())
			{
				sfWinners.add(auxGame[0]);
			}
			else
			{
				sfWinners.add(auxGame[1]);
			}
		}
		
		this.player.setSemiTeams(qfWinners);
		return sfWinners;
	}
	
	//METODO DE EVENTO - VERIFICA SE TODOS OS CAMPOS ESTAO VAZIOS E INICIA A PROXIMA JANELA:
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
			getWinners();
			this.fWindow.setPlayer(this.player);
			this.fWindow.setSfWinners(this.getWinners());
			this.fWindow.autoFill();
			this.setVisible(false);
			this.fWindow.setVisible(true);
		}
	}
}
