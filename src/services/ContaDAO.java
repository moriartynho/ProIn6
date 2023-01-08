package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Conta;

public class ContaDAO {

	Connection conn = null;
	ArrayList<Conta> list = new ArrayList<>();

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
				conta.setSaldo(rs.getDouble("saldo"));
				conta.setSaldoDespesa(rs.getDouble("despesa"));
				conta.setSaldoReceita(rs.getDouble("receita"));
			} else {
				System.out.println("Erro ao iniciar");;
			}

		} catch (SQLException e) {
			System.out.println("Conta DAO: inicializar: " + e.getMessage());
		}
		

	}

	public void atualizaDados(Conta conta) {
		conn = new DAOConn().conectBD();
		String sql = "UPDATE usuario SET saldo = ?, despesa = ?, receita = ? WHERE usuario.id_usuario = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, conta.getSaldo());
			pstm.setDouble(2, conta.getSaldoDespesa());
			pstm.setDouble(3, conta.getSaldoReceita());
			pstm.setInt(4, conta.getUsuarioId());
			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			System.out.println("Conta DAO Atualiza: " + e.getMessage());
		}
	}
}
