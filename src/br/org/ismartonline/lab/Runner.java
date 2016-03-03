package br.org.ismartonline.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Runner {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://aauswgzgsgv0m7.c6dlimqsrzhh.sa-east-1.rds.amazonaws.com:3306/ebdb";
	private static final String DB_USER = "dbuserroot";
	private static final String DB_PASSWORD = "JPMarce1AndB3t0I4theV1ctory";
	
//	private static final String DB_CONNECTION = "jdbc:mysql://localhost/ismartonline";
//	private static final String DB_USER = "root";
//	private static final String DB_PASSWORD = "";
	
//	private static final String DB_DRIVER = "org.postgresql.Driver";
//
//	private static final String DB_CONNECTION = "jdbc:postgresql://ec2-54-83-205-164.compute-1.amazonaws.com:3306/d5o3nnta4kub3v";
//	private static final String DB_USER = "riyftbkdiioudz";
//	private static final String DB_PASSWORD = "Nt9wov_Emy1w1Xsx1jtKQVjrWN";
	
	
	public static void main(String[] args) throws IOException, SQLException {
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		
		System.out.println(crypt.encode("ismart2016"));
		
		
//		Path caminho = Paths.get("/Users/juliocvidal/Documents/jv-tech/ismart/dados-alunos/Planilha-Cadastro-Geekie-2016.xlsx");
//		Stream<String> linhas = Files.lines(caminho);

		Path caminho = Paths.get(System.getProperty("user.home"), "Documents/jv-tech/ismart/dados-alunos/alunos.csv");
		//Stream<String> linhas = Files.lines(caminho);
		
		//final Connection dbConnection = getDBConnection();;
		
		
		
		List<String> alunosComErro = new ArrayList<>();
		
		BufferedReader br = null;
		
		int cont = 0;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("alunos.csv"));

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				
				
				String[] linha = ((String) sCurrentLine).split(",");
				
				String insertTableSQL = "\"INSERT INTO User_iol "
						+ "(name, ano, turma, turno, unidade, ismartId, login, password) VALUES "
						+ "('"+linha[0]+"','"+linha[1]+"','"+linha[2]+"','"+linha[3]+"','"+linha[4]+"','"+linha[5]+"','"+linha[6]+"',"
						+ "'$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); \", ";
				
				System.out.println(insertTableSQL);
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
//		linhas.forEach(linhaBruta -> {
////			System.out.println(linhaBruta);
//			String[] linha = ((String) linhaBruta).split(",");
//			
//			PreparedStatement preparedStatement = null;
//			
//			try{
//				
//				String insertTableSQL = "INSERT INTO User_iol "
//						+ "(name, ano, turma, turno, unidade, ismartId, login, password) VALUES "
//						+ "('"+linha[0]+"','"+linha[1]+"','"+linha[2]+"','"+linha[3]+"','"+linha[4]+"','"+linha[5]+"','"+linha[6]+"',"
//						+ "'$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi');";
//				
//				System.out.println(insertTableSQL);
//				
//			} catch (Exception e){
//				alunosComErro.add(linhaBruta);
//			}
//			
//			
//
//			
////			try {
////				preparedStatement = dbConnection.prepareStatement(insertTableSQL);
////				
////				preparedStatement.setString(1, linha[0]);
////				preparedStatement.setString(2, linha[1]);
////				preparedStatement.setString(3, linha[2]);
////				preparedStatement.setString(4, linha[3]);
////				preparedStatement.setString(5, linha[4]);
////				preparedStatement.setString(6, linha[5]);
////				preparedStatement.setString(7, linha[6]);
////				preparedStatement.setString(8, "$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi");
////				
////				preparedStatement.executeUpdate();
////				
////			} catch (Exception e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			} 
//			
//			//$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi
//
//			// execute insert SQL stetement
//
////			System.out.println("Record is inserted into User_iol table!");
//		});
		
		//System.out.println("\n\n############# Alunos com Erro ###########");
		
		for (String string : alunosComErro) {
			System.out.println(string);
		}
		
		
//		Iterator<String> linhaIt = linhas.iterator();
//
//		Connection dbConnection = null;
//		PreparedStatement preparedStatement = null;
//
//		String insertTableSQL = "INSERT INTO User_iol"
//				+ "(name, ano, turma, turno, unidade, ismartId, login, password) VALUES"
//				+ "(?,?,?,?,?,?,?,?)";
//
//		try {
//			dbConnection = getDBConnection();
//			
//			
//			while (linhaIt.hasNext()){
//				
//				String[] linha = linhaIt.next().split(",");
//				
//				System.out.println(linha[0]);
//				
//				preparedStatement = dbConnection.prepareStatement(insertTableSQL);
//	
//				preparedStatement.setString(1, linha[0]);
//				preparedStatement.setString(1, linha[1]);
//				preparedStatement.setString(1, linha[2]);
//				preparedStatement.setString(1, linha[3]);
//				preparedStatement.setString(1, linha[4]);
//				preparedStatement.setString(1, linha[5]);
//				preparedStatement.setString(1, linha[6]);
//				preparedStatement.setString(1, "$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi");
//				
//				//$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi
//	
//				// execute insert SQL stetement
////				preparedStatement.executeUpdate();
//	
//				System.out.println("Record is inserted into User_iol table!");
//			}
//
//		} catch (SQLException e) {
//
//			System.out.println(e.getMessage());
//
//		} finally {
//
//			if (preparedStatement != null) {
//				preparedStatement.close();
//			}
//
//			if (dbConnection != null) {
//				dbConnection.close();
//			}
//
//		}
		
	}
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}


}
