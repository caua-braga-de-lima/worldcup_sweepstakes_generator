//CLASSE DAO - IMPORTA OS DADOS DO BOLAO PARA O BANCO DE DADOS E VICE-VERSA:

package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import business.Player;
import business.SoccerTeam;
import business.SweepStakes;

/*DAO Data Access Object*/
public class SweepStakeDAO 
{
	//ATRIBUTO - RECEBE UMA LISTA DE BOLOES:
	private SweepStakes sweepStakes;
	
	public void setSweepStakes(SweepStakes sweepStakes) 
	{
		this.sweepStakes = sweepStakes;
	}
	
	//METODO - INSERE UM BOLAO NO BANCO DE DADOS:
	public void insertSweepStake(Player p) 
	{
		try {
			Connection conexao = new Connector().getConnection();

			PreparedStatement insert = conexao.prepareStatement("insert into bolao (nome, qua_sel1, qua_sel1_placar, qua_sel2, qua_sel2_placar, qua_sel3, qua_sel3_placar, qua_sel4, qua_sel4_placar, qua_sel5, qua_sel5_placar, qua_sel6, qua_sel6_placar, qua_sel7, qua_sel7_placar, qua_sel8, qua_sel8_placar, sem_sel1, sem_sel1_placar, sem_sel2, sem_sel2_placar, sem_sel3, sem_sel3_placar, sem_sel4, sem_sel4_placar, fin_sel1, fin_sel1_placar, fin_sel2, fin_sel2_placar, vencedor) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			insert.setString(1, p.getName());
			
			int aux1 = 2, aux2 = 3;
			for(SoccerTeam team : p.getQuarterTeams())
			{
				insert.setString(aux1, team.getName());
				insert.setInt(aux2, team.getScore());
				
				aux1 += 2;
				aux2 += 2;
			}
			
			int aux3 = 18, aux4 = 19;
			for(SoccerTeam team : p.getSemiTeams())
			{
				insert.setString(aux3, team.getName());
				insert.setInt(aux4, team.getScore());
				
				aux3 += 2;
				aux4 += 2;
			}
			
			int aux5 = 26, aux6 = 27;
			for(SoccerTeam team : p.getFinalTeams())
			{
				insert.setString(aux5, team.getName());
				insert.setInt(aux6, team.getScore());
				
				aux5 += 2;
				aux6 += 2;
			}
			
			insert.setString(30, p.getWinner().getName());
			insert.executeUpdate();

			conexao.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	//METODO - IMPORTA OS BOLOES CADASTRADOS NO BANCO DE DADOS:
	public ArrayList<Player> listSweepStakes() 
	{
		ArrayList<Player> sweepStakesList = new ArrayList<Player>();
		
		try {
			Connection conexao = new Connector().getConnection();

			ResultSet resultado = conexao.prepareStatement("select * from bolao").executeQuery();
			
			Player p;
			
			while(resultado.next()) 
			{
				p = new Player();
				p.setId(resultado.getInt("id"));
				p.setName(resultado.getString("nome"));
				ArrayList<SoccerTeam> quarterTeams = setQuarterTeams(resultado);
				p.setQuarterTeams(quarterTeams);
				ArrayList<SoccerTeam> semiTeams = setSemiTeams(resultado);
				p.setSemiTeams(semiTeams);
				ArrayList<SoccerTeam> finalTeams = setFinalTeams(resultado);
				p.setFinalTeams(finalTeams);
				p.setWinner(new SoccerTeam(resultado.getString("vencedor"), null, 0));
				sweepStakesList.add(p);
			}
			
			this.sweepStakes.setSweepStakesList(sweepStakesList);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		return sweepStakesList;
	}

	//METODO AUXILIARES:
	public ArrayList<SoccerTeam> setFinalTeams(ResultSet resultado) throws SQLException {
		ArrayList<SoccerTeam> finalTeams = new ArrayList<SoccerTeam>();
		finalTeams.add(new SoccerTeam(resultado.getString("fin_sel1"), null, resultado.getInt("fin_sel1_placar")));
		finalTeams.add(new SoccerTeam(resultado.getString("fin_sel2"), null, resultado.getInt("fin_sel2_placar")));
		return finalTeams;
	}


	public ArrayList<SoccerTeam> setSemiTeams(ResultSet resultado) throws SQLException 
	{
		ArrayList<SoccerTeam> semiTeams = new ArrayList<SoccerTeam>();
		semiTeams.add(new SoccerTeam(resultado.getString("sem_sel1"), null, resultado.getInt("sem_sel1_placar")));
		semiTeams.add(new SoccerTeam(resultado.getString("sem_sel2"), null, resultado.getInt("sem_sel2_placar")));
		semiTeams.add(new SoccerTeam(resultado.getString("sem_sel3"), null, resultado.getInt("sem_sel3_placar")));
		semiTeams.add(new SoccerTeam(resultado.getString("sem_sel4"), null, resultado.getInt("sem_sel4_placar")));
		return semiTeams;
	}


	public ArrayList<SoccerTeam> setQuarterTeams(ResultSet resultado) throws SQLException 
	{
		ArrayList<SoccerTeam> quarterTeams = new ArrayList<SoccerTeam>();
		
		quarterTeams.add(new SoccerTeam(resultado.getString("qua_sel1"),null, resultado.getInt("qua_sel1_placar")));
		quarterTeams.add(new SoccerTeam(resultado.getString("qua_sel2"),null, resultado.getInt("qua_sel2_placar")));
		quarterTeams.add(new SoccerTeam(resultado.getString("qua_sel3"),null, resultado.getInt("qua_sel3_placar")));
		quarterTeams.add(new SoccerTeam(resultado.getString("qua_sel4"),null, resultado.getInt("qua_sel4_placar")));
		quarterTeams.add(new SoccerTeam(resultado.getString("qua_sel5"),null, resultado.getInt("qua_sel5_placar")));
		quarterTeams.add(new SoccerTeam(resultado.getString("qua_sel6"),null, resultado.getInt("qua_sel6_placar")));
		quarterTeams.add(new SoccerTeam(resultado.getString("qua_sel7"),null, resultado.getInt("qua_sel7placar")));
		quarterTeams.add(new SoccerTeam(resultado.getString("qua_sel8"),null, resultado.getInt("qua_sel8_placar")));
		return quarterTeams;
	}

}
