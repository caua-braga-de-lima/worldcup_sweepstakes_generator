//CLASSE CONECTOR - CONFIGURA A CONEXAO COM O BANCO DE DADOS:

package data;
import java.sql.*;

public class Connector 
{
	private String host;
	private String user;
	private String password;
	private String databank;

	public Connector() 
	{

		this.host = "localhost";
		this.databank = "prova03";
		this.user = "root";
		this.password = "";
	}

	public Connection getConnection() 
	{
		String url="jdbc:mysql://" + this.host + "/" + this.databank+"?verifyServerCertificate=false&useSSL=true";

		try 
		{
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) 
		{
			System.out.println("Connection with MySQL failed. :(");
			ex.printStackTrace();
		}
		return null;
	}

}
