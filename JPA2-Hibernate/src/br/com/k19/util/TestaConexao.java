package br.com.k19.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	public static void main(String agrs[]) throws SQLException {
	Connection con = new ConnectionFactory().getConnection();
	System.out.println("Conectado!");
	con.close();
	}
}