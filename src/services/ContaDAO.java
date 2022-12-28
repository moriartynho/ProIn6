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
			String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ? and saldo = ? and despesa = ? and receita = ?";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objContaDTO.getNome());
			pstm.setString(2, objContaDTO.getSenha());
			pstm.setDouble(3, objContaDTO.getSaldo());
			pstm.setDouble(4, objContaDTO.getSaldoDespesa());
			pstm.setDouble(5, objContaDTO.getSaldoReceita());
			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException e) {
			System.out.println("ContaDAO Autenticação" + e);
			return null;
		}
	}

	public void cadastrarConta(Conta objContaDTO) {
		conn = new DAOConn().conectBD();
		try {
			String sql = "insert into usuario (nome_usuario, senha_usuario, saldo, despesa, receita) values (?, ? , ?, ?, ?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objContaDTO.getNome());
			pstm.setString(2, objContaDTO.getSenha());
			pstm.setDouble(3, objContaDTO.getSaldo());
			pstm.setDouble(4, objContaDTO.getSaldoDespesa());
			pstm.setDouble(5, objContaDTO.getSaldoReceita());

			pstm.execute();
			pstm.close();

		} catch (Exception e) {
			System.out.println("ContaDAO Cadastro" + e.getMessage());
		}

	}

	public ArrayList<Conta> pesquisarConta() {
		conn = new DAOConn().conectBD();
		String sql="select * from usuario";
		ResultSet rs;

		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Conta objContaDTO = new Conta();
				objContaDTO.setUsuarioId(rs.getInt("id_usuario"));
				objContaDTO.setNome(rs.getString("nome"));
				objContaDTO.setSaldo(rs.getDouble("saldo"));
				objContaDTO.setSaldoDespesa(rs.getDouble("despesa"));
				objContaDTO.setSaldoReceita(rs.getDouble("receita"));
				
				list.add(objContaDTO);
				
			}
			
		} catch (SQLException e) {
			System.out.println("ContaDAO Pesquisar: " + e.getMessage());
		}
		
		return list;

	}
}
