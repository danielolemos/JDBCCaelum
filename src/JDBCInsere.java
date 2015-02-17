
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;



public class JDBCInsere {

	public static void main(String[] args) {
		
		//conectando
		Connection con = null;
		
		 
		try {
			
			con = ConnectionFactory.getConnection();
			//cria uma PreparedStatement
			String sql = "insert into contatos (nome, email, endereco, dt_nascimento) values (?, ?, ?, ?)";
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			
			//preenche os valores
			stmt.setString(1, "daniel");
			stmt.setString(2, "daniel@caelum.com.br");
			stmt.setString(3, "R. Sabonas 3185 cj57");
			
			java.sql.Date dataParaGravar = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			stmt.setDate(4, dataParaGravar);
			
			
			//executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		
		
		
		
		
		
		
		

	}

}
