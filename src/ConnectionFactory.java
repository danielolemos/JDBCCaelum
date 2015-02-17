
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class ConnectionFactory {
	
	public static java.sql.Connection  getConnection() throws SQLException{
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conectando ao Banco");
			return DriverManager.getConnection("jdbc:mysql://localhost/teste","root","Manosgana1");
			
		} catch (ClassNotFoundException e) {
			
			throw new SQLException(e.getMessage());
		}
		
		
		
		
		
	}

}
