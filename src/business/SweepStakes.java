//CLASSE LISTA DE BOLOES - REFERENTE AO OBJETO QUE RECEBE OS DADOS DO BANCO PARA A MEMORIA:

package business;
import java.util.ArrayList;

import client.ShowWindow;
import data.SweepStakeDAO;

public class SweepStakes 
{
	//ATRIBUTOS - LISTA DE BOLOES IMPORTADOS DO BANCO E LISTA DE BOLOES PARA IMPORTAR AO BANCO:
	private ArrayList<Player> sweepStakesList;
	private SweepStakeDAO dataSync;
	
	//GETTERS E SETTERS:
	public ArrayList<Player> getSweepStakesList() 
	{
		return sweepStakesList;
	}

	public void setSweepStakesList(ArrayList<Player> sweepStakesList) 
	{
		this.sweepStakesList = sweepStakesList;
	}
	
	public SweepStakeDAO getDataSync() 
	{
		return dataSync;
	}

	public void setDataSync(SweepStakeDAO dataSync) 
	{
		this.dataSync = dataSync;
	}

	

}
