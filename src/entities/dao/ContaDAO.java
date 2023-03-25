package entities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Conta;
import services.DAOConn;

public class ContaDAO {

	Connection conn = null;

	public ResultSet autenticacaoConta(Conta objContaDTO) {
		conn = new DAOConn().conectBD();

		try {
			String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objContaDTO.getNome());
			pstm.setString(2, objContaDTO.getSenha());
			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException e) {
			System.out.println("ContaDAO Autenticação: " + e);
			return null;
		}
	}

	public void cadastrarConta(Conta objContaDTO) {
		conn = new DAOConn().conectBD();
		try {
			String sql = "insert into usuario (nome_usuario, senha_usuario) values (?, ?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objContaDTO.getNome());
			pstm.setString(2, objContaDTO.getSenha());

			pstm.execute();
			pstm.close();

		} catch (Exception e) {
			System.out.println("ContaDAO Cadastro" + e.getMessage());
		}

	}

	public void iniciarConta(Conta conta) {
		conn = new DAOConn().conectBD();

		try {
			String sql = "select * from usuario WHERE nome_usuario = ? and senha_usuario = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, conta.getNome());
			pstm.setString(2, conta.getSenha());
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				conta.setUsuarioId(rs.getInt("id_usuario"));
				conta.setNome(rs.getString("nome_usuario"));
				conta.setSenha(rs.getString("senha_usuario"));
				conta.setSaldo(0.0);
				conta.setSaldoDespesa(0.0);
				conta.setSaldoReceita(0.0);
				carregaInfo(conta);
			} else {
				System.out.println("Erro ao iniciar");
				;
			}

		} catch (SQLException e) {
			System.out.println("Conta DAO: inicializar: " + e.getMessage());
		}

	}

	public void novaTransacaoBD(Double valor, String desc, String data, boolean tipo, Integer usuarioId) {
		conn = new DAOConn().conectBD();
		String sql = "insert into transac (descricao, valor, tipo, data, usuario_id) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, desc);
			pstm.setDouble(2, valor);
			pstm.setBoolean(3, tipo);
			pstm.setString(4, data);
			pstm.setInt(5, usuarioId);

			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			System.out.println("Conta DAO Nova Transacao: " + e.getMessage());
		}
	}

	public void novaTarefaBD(String titulo, String data, Double valor, Integer usuarioId) {
		conn = new DAOConn().conectBD();
		String sql = "insert into tarefas (titulo, data, valor, usuario_id) values(?, ?, ?, ?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, titulo);
			pstm.setString(2, data);
			pstm.setDouble(3, valor);
			pstm.setInt(4, usuarioId);

			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			System.out.println("Conta DAO Nova Tarefa: " + e.getMessage());
		}
	}

	public void carregaInfo(Conta conta) {
		conn = new DAOConn().conectBD();
		String sql = "select * from transac WHERE usuario_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, conta.getUsuarioId());
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Integer id = rs.getInt("id_transac");
				String desc = rs.getString("descricao");
				Double valor = rs.getDouble("valor");
				boolean tipo = rs.getBoolean("tipo");
				String data = rs.getString("data");
				conta.novaTransacao(id, valor, desc, data, tipo);
			}

		} catch (SQLException e) {
			System.out.println("Conta DAO Carrega: " + e.getMessage());
		}
	}

	public void removeNoBD(Integer id) {
		conn = new DAOConn().conectBD();
		String sql = "DELETE FROM transac WHERE transac.id_transac = ?";
		try {

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			System.out.println("Conta DAO Deleta: " + e.getMessage());
		}
	}
	
	public void limparDados(Integer id) {
		limparDadosDeTransacao(id);
		limparDadosDeTarefa(id);
	}
	
	public void limparDadosDeTarefa(Integer usuarioId) {
		conn = new DAOConn().conectBD();
		String sql = "DELETE FROM tarefas WHERE usuario_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, usuarioId);
			
			pstm.execute();
			pstm.close();
			
			
		} catch (SQLException e) {
			System.out.println("Conta DAO Limpar Dados: " + e.getMessage());
		}
	}

	public void limparDadosDeTransacao(Integer usuarioId) {
		conn = new DAOConn().conectBD();
		String sql = "DELETE FROM transac WHERE usuario_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, usuarioId);
			
			pstm.execute();
			pstm.close();
			
			
		} catch (SQLException e) {
			System.out.println("Conta DAO Limpar Dados: " + e.getMessage());
		}
	}

}
