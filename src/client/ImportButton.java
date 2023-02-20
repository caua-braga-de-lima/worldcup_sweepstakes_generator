//CLASSE DO BOTAO DE IMPORTAR - NAO FINALIZADA

package client;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ImportButton extends Button implements ActionListener
{
	public JButton getButton()
	{
		Button button = new Button();
		JButton importButton = button.newButton("Import Sweepstake", Color.white);
		importButton.addActionListener(this);
		return importButton;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
	}

}