//CLASSE JANELA PRINCIPAL - REFERENTE A JANELA DE MENU E O ENGLOBAMENTO DE TODAS AS OUTRAS JANELAS

package client;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import business.SweepStakes;
import data.SweepStakeDAO;

public class MainWindow extends JFrame
{
	//ATRIBUTOS - PAINEIS DA JANELA:
	private JPanel titlePanel;
	private MenuPanel menuPanel;
	
	//METODO CONSTRUTOR - CONFIGURA AS PROPRIEDADES GRAFICAS DA JANELA:
	public MainWindow()
	{
		this.setSize(600, 200);
		this.setLocationRelativeTo(null);
		this.setTitle("Sistema de Cadastro de Bolões da Copa - Cauã Braga de Lima - 536094");
		this.setLayout(new BorderLayout());
		this.titlePanel = new JPanel();
		getPanelInfo();
		this.add(titlePanel, BorderLayout.NORTH);
		getPanels();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	//METODO - REALIZA O ENCAPSULAMENTO DAS JANELAS DO PROGRAMA:
	public void getPanels() 
	{
		SweepStakes ssList = new SweepStakes();
		this.menuPanel = new MenuPanel();
		this.add(this.menuPanel.getPanel(this, new SignUpWindow(new QuarterFinalsWindow(new SemiFinalsWindow(new FinalsWindow()))), new ShowWindow()), BorderLayout.CENTER);
	}
	
	//METODO - CONFIGURA OS TEXTOS DA JANELA:
	public void getPanelInfo() 
	{
		this.titlePanel.setVisible(true);
		this.titlePanel.setBackground(Color.black);
		JLabel label = new JLabel();
		label.setText("WORLD CUP SWEEPSTAKES!");
		label.setForeground(Color.white);
		label.setFont(new Font("Google Sans", Font.BOLD, 30));
		this.titlePanel.add(label);
	}
}
