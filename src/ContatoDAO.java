import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;



public class ContatoDAO {
	
	private Connection connection;
	
	public ContatoDAO(){
		
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void adiciona(Contato contato){
		
		String sql = "insert into contatos(nome, email, endereco, dt_nascimento) values(?, ?, ?, ?)";
		
		try {
			//PreparedStatement para Inserção
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			//seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			
			//executa
			stmt.execute();
			stmt.close();
			
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Contato> getLista(){
		try{
			
			List<Contato> contatos = new ArrayList<Contato>();
			java.sql.PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			
			while(rs.next()){
				//Criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//Adiciona o objeto a lista
				contatos.add(contato);
				
			}
			
			rs.close();
			stmt.close();
			return contatos;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
;