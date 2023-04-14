package services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DAOConn;
import entities.Conta;
import entities.Tarefa;
import entities.Transacao;
import entities.enums.TipoDeTransacao;
import services.TransacaoService;

public class ContaDAOService {

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
				carregaInfo(conta);
			} else {
				System.out.println("Erro ao iniciar");
				;
			}

		} catch (SQLException e) {
			System.out.println("Conta DAO: inicializar: " + e.getMessage());
		}

	}

	public void novaTransacaoBD(Transacao transacao, Integer usuarioId) {
		conn = new DAOConn().conectBD();
		String sql = "insert into transac (descricao, valor, tipo, data, usuario_id) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, transacao.getDesc());
			pstm.setDouble(2, transacao.getValor());
			pstm.setBoolean(3, transacao.getTipoDeTransacao());
			pstm.setString(4, transacao.getData());
			pstm.setInt(5, usuarioId);

			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			System.out.println("Conta DAO Nova Transacao: " + e.getMessage());
		}
	}

	public void novaTarefaBD(Tarefa tarefa, Integer usuarioId) {
		conn = new DAOConn().conectBD();
		String sql = "insert into tarefas (titulo, data, valor, usuario_id) values(?, ?, ?, ?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, tarefa.getTitulo());
			pstm.setString(2, tarefa.getData());
			pstm.setDouble(3, tarefa.getValor());
			pstm.setInt(4, usuarioId);

			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			System.out.println("Conta DAO Nova Tarefa: " + e.getMessage());
		}
	}

	public void carregaInfo(Conta conta) {
		TransacaoService service = new TransacaoService();
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
				Boolean tipo = rs.getBoolean("tipo");
				String data = rs.getString("data");
				service.novaTransacao(conta, new Transacao(id, valor, desc, data, TipoDeTransacao.valueOf(tipo)));
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
