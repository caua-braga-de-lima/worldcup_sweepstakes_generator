//CLASSE DO PARTICIPANTE - REFERENTE AS INFORMACOES DO USUARIO QUE FAZ O BOLAO:

package business;
import java.util.ArrayList;

public class Player 
{
	//ATRIBUTOS:
	private int id;
	private String name;
	private ArrayList<SoccerTeam> quarterTeams;
	private ArrayList<SoccerTeam> semiTeams;
	private ArrayList<SoccerTeam> finalTeams;
	private SoccerTeam winner;
	
	//GETTERS E SETTERS:
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String nome) 
	{
		this.name = nome;
	}
	public ArrayList<SoccerTeam> getQuarterTeams() 
	{
		return quarterTeams;
	}
	public void setQuarterTeams(ArrayList<SoccerTeam> quarterTeams) {
		this.quarterTeams = quarterTeams;
	}
	public ArrayList<SoccerTeam> getSemiTeams() 
	{
		return semiTeams;
	}
	public void setSemiTeams(ArrayList<SoccerTeam> semiTeams) 
	{
		this.semiTeams = semiTeams;
	}
	public ArrayList<SoccerTeam> getFinalTeams() 
	{
		return finalTeams;
	}
	public void setFinalTeams(ArrayList<SoccerTeam> finalTeams) 
	{
		this.finalTeams = finalTeams;
	}
	public SoccerTeam getWinner() 
	{
		return winner;
	}
	public void setWinner(SoccerTeam winner) 
	{
		this.winner = winner;
	}
	
	
	
}
