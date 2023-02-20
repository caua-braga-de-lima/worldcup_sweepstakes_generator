//CLASSE DO BOTAO DE EXPORTAR - NAO FINALIZADA

package client;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ExportButton extends Button implements ActionListener
{
	public JButton getButton()
	{
		Button button = new Button();
		JButton exportButton = button.newButton("Export Sweepstake", Color.GREEN);
		exportButton.addActionListener(this);
		return exportButton;
	}
	public void actionPerformed(ActionEvent e) 
	{

		
	}

}