import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;



public class TestaInsere {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		contato.setNome("Pedro");
		contato.setEndereco("Rua Pedro, número Trinta");
		contato.setEmail("pedrolemos@hotmail.com");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		System.out.println("Gravado");
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato2 : contatos) {
			System.out.println("Nome : " + contato2.getNome());
			System.out.println("Email : " + contato2.getEmail());
			System.out.println("Endereço : " + contato2.getEndereco());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YY");
			System.out.println("Data de Nascimento : " + sdf.format(contato2.getDataNascimento().getTime) + "\n");
		}

	}

}
