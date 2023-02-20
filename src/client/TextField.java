//CLASSE DE CAMPO DE TEXTO - AUXILIA NA INSTANCIA DOS CAMPOS DE TEXTO:

package client;
import javax.swing.JTextField;

public class TextField extends JTextField
{
	//METODO CONSTRUTOR:
	public TextField(int columns)
	{
		this.setColumns(columns);
	}
}
