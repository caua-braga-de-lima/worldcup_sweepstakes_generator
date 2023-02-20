//CLASSE BOTAO DE NOVO - PROPRIEDADES DO BOTAO DE CRIAR UM NOVO BOLAO:
package client;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class NewButton implements ActionListener
{
	//ATRIBUTOS - RECEBE A JANELA PRINCIPAL E JANELA DE CADASTRO PARA TER CONTROLE SOBRE AMBAS:
	private MainWindow mainWindow;
	private SignUpWindow sWindow;
	
	//METODO - RETORNA O BOTAO:
	public JButton getButton(MainWindow mainWindow, SignUpWindow sWindow)
	{
		this.mainWindow = mainWindow;
		this.sWindow = sWindow;
		Button button = new Button();
		JButton newSSButton = button.newButton("New SweepStake", Color.blue); 
		newSSButton.addActionListener(this);
		
		return newSSButton;
	}

	//METODO DE EVENTO - MUDA A VISIBILIDADE DAS JANELAS E PERMITE A TROCA ENTRE ELAS: 
	public void actionPerformed(ActionEvent e) 
	{
		mainWindow.setVisible(false);
		this.sWindow.setVisible(true);
	}
}