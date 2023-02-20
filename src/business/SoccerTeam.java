//CLASSE SELECAO - REFERENTE A CADA SELECAO DE FUTEBOL INSTANCIADA:

package business;
import javax.swing.ImageIcon;

public class SoccerTeam 
{
	//ATRIBUTOS - NOME, PONTUACAO E BANDEIRA:
	private String name;
	private ImageIcon flag;
	private int score;
	
	//METODO CONSTRUTOR:
	public SoccerTeam(String name, ImageIcon flag, int score)
	{
		this.name = name;
		this.flag = flag;
		this.score = score;
	}
	
	//METODO CONSTRUTOR AUXILIAR:
	public SoccerTeam()
	{
		
	}

	//GETTERS E SETTERS:
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public ImageIcon getFlag() 
	{
		return flag;
	}

	public void setFlag(ImageIcon flag) 
	{
		this.flag = flag;
	}

	public int getScore() 
	{
		return score;
	}

	public void setScore(int score) 
	{
		this.score = score;
	}
}
