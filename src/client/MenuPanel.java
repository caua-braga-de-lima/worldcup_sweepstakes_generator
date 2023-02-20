//CLASSE MENU - RETORNA O PAINEL DO MENU:

package client;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import business.SweepStakes;

public class MenuPanel extends JPanel
{
	private SweepStakes ssList;
	
	//METODO - RETORNA O PAINEL DO MENU:
	public JPanel getPanel(MainWindow mainWindow, SignUpWindow sWindow, ShowWindow showWindow)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.black);
		panel.add(new NewButton().getButton(mainWindow, sWindow));
		panel.add(new ShowButton().getButton(mainWindow, showWindow, this.ssList));
		panel.add(new ImportButton().getButton());
		panel.add(new ExportButton().getButton());
		
		return panel;
	}
	
	public void setSSlist(SweepStakes ssList)
	{
		this.ssList = ssList;
	}
}
