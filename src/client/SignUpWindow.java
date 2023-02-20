//CLASSE JANELA DE CADASTRO - RESPONSAVEL PELO CADASTRO DO NOME DO USUARIO DO BOLAO:

package client;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import business.Player;

public class SignUpWindow extends JFrame implements ActionListener
{
	//ATRIBUTOS:
	private Player player;
	private TextField textField;
	private QuarterFinalsWindow qfWindow;
	
	//METODO CONSTRUTOR - RECEBE A JANELA DAS QUARTAS DE FINAL PARA TER CONTROLE SOBRE ELA:
	public SignUpWindow(QuarterFinalsWindow qfWindow)
	{
		this.qfWindow = qfWindow;
		this.setSize(300, 100);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.black);
		this.setTitle("Sistema de Cadastro de Bolões da Copa - Cauã Braga de Lima - 536094");
		this.setLayout(new FlowLayout());
		getWindowInfo();
		Button button = new Button();
		JButton sendButton = button.newButton("OK", Color.white);
		sendButton.addActionListener(this);
		this.add(sendButton);
	}

	//CONFIGURA O TEXTO DA JANELA:
	public void getWindowInfo() 
	{
		JLabel label = new JLabel("ENTER YOUR NAME: ");
		label.setForeground(Color.white);
		label.setFont(new Font("Google Sans", Font.BOLD, 20));
		this.add(label);
		this.textField = new TextField(5);
		this.add(textField);
	}

	//METODO DE EVENTO - GUARDA O NOME DO JOGADOR NO BOLAO E INICIA A PROXIMA JANELA:
	public void actionPerformed(ActionEvent e) 
	{
		if(!this.textField.getText().equals(""))
		{
			this.player = new Player();
			player.setName(textField.getText());
			this.qfWindow.setSweepStake(this.player);
			this.setVisible(false);
			qfWindow.setVisible(true);
		}

	}
}
