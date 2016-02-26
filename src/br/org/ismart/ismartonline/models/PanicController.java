package br.org.ismart.ismartonline.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PanicController {

	@RequestMapping("vQtDNoCxpCa8QIAZPWeIMt4hPuLwZ8a")
	public void batch() throws SQLException, InterruptedException {

		final Connection dbConnection = getDBConnection();

		for (int i = 0; i < array.length; i++) {

			if (i % 10 == 0)
				Thread.sleep(3000);

			System.out.println(array[i]);
			PreparedStatement preparedStatement = dbConnection.prepareStatement(array[i]);

			preparedStatement.executeUpdate();
		}

	}

	private Connection getDBConnection() {

		Connection dbConnection = null;

		String dbName = System.getProperty("RDS_DB_NAME");
		String userName = System.getProperty("RDS_USERNAME");
		String password = System.getProperty("RDS_PASSWORD");
		String hostname = System.getProperty("RDS_HOSTNAME");
		String port = System.getProperty("RDS_PORT");

//		 String dbName = "ismartonline";
//		 String userName = "root";
//		 String password = "";
//		 String hostname = "localhost";
//		 String port = "3306";

		String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(jdbcUrl, userName, password);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;
	}

	String array[] = {

			"INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('AMANDA CLARO VAZ DE OLIVEIRA','1','2016','Manhã','SP','3','amandaclaro02@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			/*
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('Aluno teste 8','8','2016','Manhã','RJ','0','alunoteste8@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('Aluno teste 9','9','2016','Manhã','RJ','1','alunoteste9@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('Aluno teste 1 em','1','2016','Manhã','RJ','2','alunoteste1em@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * 
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('AARON HENRIQUES NEVES','8','2016','Manhã','RJ','54708','aaron.henriquess@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('AGATHA TENORIO MARQUEZINI','8','2016','Manhã','SP','58271','veruskaya@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALBERT LUCAS S.FREIRES','8','2016','Manhã','RJ','58055','acf2011@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALEXANDER AUGUSTO MACHADO GOULART','8','2016','Manhã','SJC','55630','alexander-augusto@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALYNE DANIELLE TELES DE BARROS','8','2016','Manhã','SP','63163','alynebarros1240@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALYNE SILVA OS SANTOS','8','2016','Manhã','SP','64329','aly.silva.ass49@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA BEATRIZ DE OLIVEIRA DE CARVALHO','8','2016','Manhã','RJ','59126','luz_68@terra.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA BEATRIZ MARIOZI ROCHA DE SOUZA','8','2016','Manhã','SP','59646','annabiamariozi@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA BEATRIZ RIBEIRO COSTA','8','2016','Manhã','RJ','53377','mnalvaa@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA CAROLINA ALMEIDA CRUZ','8','2016','Manhã','SP','61592','luciene.profissional@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA CAROLINY CARVALHO VIEIRA','8','2016','Manhã','SP','59647','vieiraanacaroliny@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA CLARA CUNHA MONTEIRO','8','2016','Manhã','SJC','59854','rubia-cunha@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA JÚLIA DOS SANTOS','8','2016','Manhã','SJC','53591','anajsantos2014@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA PAULA DE OLIVEIRA SOUZA','8','2016','Manhã','SJC','54121','ana_souz3@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA REGINA MAGALHAES FERNANDES','8','2016','Manhã','SP','56842','louri_fernandes@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANNA JULIA ARANTES MORAES','8','2016','Manhã','SP','59948','annacaju02@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BEATRIZ BRITO CAMARGO PINTO','8','2016','Manhã','SP','62281','faguta8@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BEATRIZ VITÓRIA DE LIMA','8','2016','Manhã','SJC','53631','beatriz.limasm@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNA ALVES VITORINO','8','2016','Manhã','RJ','60081','beatriz_alves00@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNA ARAUJO PEREIRA','8','2016','Manhã','SP','57264','bruna.araujo.pereiras2@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNA VILAS BOAS NUNES DA SILVA','8','2016','Manhã','SJC','61975','cris_33_vilasboas@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNO LEAL VIEIRA','8','2016','Manhã','SP','53846','brunolealvieira@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CAHUÊ DE ASSIS','8','2016','Manhã','SJC','53047','lizandreassis.assis@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CAIO RIBEIRO DE PAULA','8','2016','Manhã','SJC','60456','maomadepaula@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CAIO VICTOR BARCELLAR FERREIRA','8','2016','Manhã','SJC','53427','eli.barcellar@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CAMILA SOARES DE PROENÇA','8','2016','Manhã','SJC','58239','camilaaasoaresss@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CAROLINA KAORI ISHIKAWA','8','2016','Manhã','SJC','59860','ale.ishikawa@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CAUA WILLIAN ZIMMER DE FARIA','8','2016','Manhã','SJC','55825','fbn.rod@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DANIEL ECCARD BASTOS VIVAS','8','2016','Manhã','RJ','59590','daniel.gamer360@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DANIEL LOPES DOS SANTOS FARIA','8','2016','Manhã','RJ','59923','dan5vive@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('EDUARDO ALVES CARVALHO','8','2016','Manhã','SJC','56297','eduardo15022003@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ELLEN DAS GRAÇAS GOMES ROCUMBACK','8','2016','Manhã','SP','58762','rose_meire99@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ELOISE DE CASSIA GOMES','8','2016','Manhã','SP','57435','clelogomes@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ERICK MICHEL RODRIGUES SILVA','8','2016','Manhã','SJC','53562','asas.daimaginacao@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FELIPE MELO DA SILVA','8','2016','Manhã','RJ','61728','felipemelodasilva36@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FERNANDA DE OLIVEIRA PEREIRA','8','2016','Manhã','SJC','55890','fefeop@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FERNANDO EMILIANO CARNEIRO DE AMORIM','8','2016','Manhã','RJ','59634','magalialves@oi.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FILIPE JUAN CAMPOS DOS SANTOS GOIS','8','2016','Manhã','SP','59934','pedroefilipe@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FLÁVIA PERES DE PAULA','8','2016','Manhã','SJC','56113','flaviap_familia@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FRANCIELLE QUEIROZ CELESTINO','8','2016','Manhã','SP','59824','nanda_la10@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL BARBOSA DE MORAIS','8','2016','Manhã','SP','62106','gabriel500morais@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL HENRIQUE DE SOUZA MENDES','8','2016','Manhã','SP','55559','bielhmendes2014@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL PIRES RODRIGUES RIBEIRO EVANGELISTA','8','2016','Manhã','SJC','63124','sandrapires_sp@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL RAFAEL ARAGAO SANTOS','8','2016','Manhã','RJ','58779','gabrielrafael17@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIELA FERREIRA AUGUSTO','8','2016','Manhã','RJ','64581','alessandra.0509@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GEOVANNA MOURA SOARES','8','2016','Manhã','SP','62109','gemsoares2013@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIULIA DE OLIVEIRA DORTA','8','2016','Manhã','SP','60067','giulia.dorta@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIULLIA GOMES SERAFIM','8','2016','Manhã','SP','60771','giulliagomes1401@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUILHERME CARDOSO DA SILVA','8','2016','Manhã','SJC','53795','andrenunessilva@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUILHERME LANZAS LEAL','8','2016','Manhã','SP','59689','fgllanzas@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUSTAVO CHALO NUNES','8','2016','Manhã','RJ','58889','nuneschalo@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUSTAVO SAMASSA PENHA','8','2016','Manhã','SP','58270','gsamassa@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUSTAVO SANTOS DA SILVA','8','2016','Manhã','SJC','55930','preta.mar30@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('HENRIQUE DO NASCIMENTO MOURA FERREIRA','8','2016','Manhã','SP','64277','mpatriciamoura@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('IARA GOMES DE ALCÂNTARA MATIAS','8','2016','Manhã','SJC','54578','mcarol.alcantara@live.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('IASMIN FERNANDES DA SILVA','8','2016','Manhã','SJC','57783','iiasmin.nandes@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ICARO SANTOS NOGUEIRA','8','2016','Manhã','SJC','54535','resantosnog@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISABELA DE SOUZA OLIVEIRA','8','2016','Manhã','SJC','54238','lisouza.oliveira@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISABELLA GASPAR TERESO','8','2016','Manhã','SP','61751','sueli.miranda611@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISABELLE CATHERINE CLARA RODRIGUES MARTINS','8','2016','Manhã','RJ','57559','lucianar.martins@outlook.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JENNIFER LUIZA CARVALHO TELES','8','2016','Manhã','SP','63166','jennifercavte@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JÉSSICA MARIANA DA SILVA SANTOS','8','2016','Manhã','SP','54065','idivan-santos@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JHONATHAN TURQUETTI DE OLIVEIRA','8','2016','Manhã','SP','59637','nislaine.flp@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JOÃO PEDRO DE MORAES GALVÃO','8','2016','Manhã','SJC','52970','rjgalvao@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JOAO PEDRO TEOFILO GUILHERME','8','2016','Manhã','SJC','54993','titicojustin@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JUAN PABLO BERTOLUCI FELIX','8','2016','Manhã','SP','53004','cassandrabertoluci@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JÚLIA CORRÁ MONTEIRO FERREIRA','8','2016','Manhã','SJC','57630','julia.corra@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JÚLIA NAARA DA SILVA FREITAS','8','2016','Manhã','SP','54175','naarafreitas17@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JULIA RODRIGUES DA CUNHA','8','2016','Manhã','SJC','55821','beth.r.cunha@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JULIANA DE MELO DA SILVA','8','2016','Manhã','RJ','54527','josytacolandia@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JULIO CESAR BATISTA DE OLIVEIRA','8','2016','Manhã','SP','53156','kellymyranda@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KARIN KOIDE','8','2016','Manhã','SJC','54151','suehat@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KAUANE FAZIO MARTINS','8','2016','Manhã','SP','53949','kauanefazio@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KAUANY APARECIDA PEREIRA DE ALMEIDA','8','2016','Manhã','SJC','60934','kausam763@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KEMILLY QUINTINA DE JESUS GONCALVES','8','2016','Manhã','SP','61786','kemilly.milly@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LAILA MELO VIEIRA','8','2016','Manhã','SP','61730','ilcoignacio@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LAIS MARIA DA SILVA','8','2016','Manhã','RJ','55427','luana_silva_2011@live.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LARA BIANCA FERNANDES SANTOS LOURO','8','2016','Manhã','SJC','58102','isabelfernandes570@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LARISSA AIKO SILVA KUMISAKI','8','2016','Manhã','SJC','58614','vanikumisaki@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LARISSA CHAVES DOS SANTOS','8','2016','Manhã','SJC','54965','rlllsantos@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LARISSA DA SILVA MEIRELES MACHADO','8','2016','Manhã','SP','59690','luciano.mauco@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LAURA MACHADO MANTOVANI','8','2016','Manhã','SJC','53482','dani.m.mantovani@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LESLIE LIANDRA DUARTE DA ROSA','8','2016','Manhã','SJC','53765','abcleslieldr@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LETÍCIA AZEVEDO LEITE CORRÊA','8','2016','Manhã','RJ','62035','vetekka@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LORENA DIAS ANTONIO DA SILVA','8','2016','Manhã','RJ','60363','lu.silvacosta03@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUAN VINICIUS ROCHA','8','2016','Manhã','SP','56845','rochaluanvinicius@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUANA ITATI SOVERÓN PESSANHA','8','2016','Manhã','RJ','58568','itatisoveron@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS COSTA DE ALMEIDA','8','2016','Manhã','SP','60047','lucas.costadealmeida.5@facebook.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS DE SOUZA RODRIGUES JUNIOR','8','2016','Manhã','SP','61742','lucas.jr310303@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS LOPES RIBEIRO','8','2016','Manhã','SP','57415','lucas_lopes.1@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS NAVARRO DOS SANTOS','8','2016','Manhã','SJC','54795','lukinha.ln.ln@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIS HENRIQUE DA SILVA VENCESLAU','8','2016','Manhã','SJC','55798','williamvenceslau@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIZ CLAUDIO DOS SANTOS GOMES','8','2016','Manhã','SJC','61184','maria.santosgomes@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIZ DE BARROS NETO','8','2016','Manhã','SJC','53410','secr.elaine@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIZ FERNANDO DE OLIVEIRA QUEIROZ','8','2016','Manhã','SP','59640','luizfernandoqueiroz2102@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIZ GUILHERME BOAVENTURA DA SILVA','8','2016','Manhã','SJC','53800','luizguilhermeboa@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIZA CARVALHO DE OLIVEIRA','8','2016','Manhã','RJ','64059','july.ana654@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARCELO LEONARDO DA SILVA','8','2016','Manhã','RJ','63645','zmarcelo027@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARCELO OLIVEIRA BELLO DA ROCHA','8','2016','Manhã','RJ','55545','lucyene.bello@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARCOS VINICIUS FARIA','8','2016','Manhã','SJC','58859','mvfkinho960@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA EDUARDA BRITO BARBOSA PAULO','8','2016','Manhã','SJC','56377','madubbp@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA EDUARDA DOS SANTOS SILVA','8','2016','Manhã','SJC','57682','dri_ss2000@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA EDUARDA OLIVEIRA TEIXEIRA DA SILVA','8','2016','Manhã','SP','61743','edu2704@terra.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA EDUARDA PEREIRA CAMARGO','8','2016','Manhã','SJC','58192','meduardacamargo@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA GABRIELA GARCIA DOS SANTOS REIS','8','2016','Manhã','SJC','54041','mariagabrielareis@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA LUISA ARAUJO DA SILVA','8','2016','Manhã','SP','61229','mlaraujo2805@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA WANESSA ALVES FERREIRA','8','2016','Manhã','RJ','58980','wanessalves765@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARILIA ISABEL ARAUJO DA SILVA','8','2016','Manhã','SJC','59353','monivitoria07@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARINA FERNANDA MACIEL COITO','8','2016','Manhã','SJC','58099','marina.fernanda.2015.marina@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEUS BUENO LIMA','8','2016','Manhã','SJC','56320','matheus.nike1@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEUS FELIPE DOS SANTOS','8','2016','Manhã','SJC','58262','matheusfelipe2002.santos@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MELISSA DA SILVA KOSHIYAMA','8','2016','Manhã','SP','55154','millaks@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MELISSA DINIZ DE CASTRO','8','2016','Manhã','SJC','64173','melicadc@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MELISSA ISABELLE MARTINS CABRAL','8','2016','Manhã','SJC','60846','mulancabral@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MILENA CRISTINA GALDINO MATTHIESEN','8','2016','Manhã','RJ','56440','mimi.galdino20@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MILLENA IHARA IVASAKI','8','2016','Manhã','SP','61235','dri.mimi@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NATASHA CLEMENTE SANTOS DE ANDRADE','8','2016','Manhã','RJ','60082','alexander.andrade@globo.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NICHOLAS LIMA DE OLIVEIRA LEITE','8','2016','Manhã','SP','60023','nikin60@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NICOLAS FERREIRA FERNANDES','8','2016','Manhã','SJC','53587','nanda_barrossjc@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PATRYCK VIEIRA SANS','8','2016','Manhã','SP','62502','myrnasans@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PEDRO DE MELO PINHEIRO PINTO','8','2016','Manhã','RJ','58981','pedrodemelorj@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PEDRO HENRIQUE DOS SANTOS JANUÁRIO','8','2016','Manhã','SJC','52986','pedro.hsj21@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PEDRO HENRIQUE MARTINS NEVES','8','2016','Manhã','SJC','56388','pedorom@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PEDRO LUCAS SILVA DE OLIVEIRA','8','2016','Manhã','RJ','59611','pedrolucasleblon@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('POLIANA MARINHO DOS SANTOS','8','2016','Manhã','SP','53085','malves7471@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAFAEL BARRIONUEVO DE SOUZA','8','2016','Manhã','RJ','60044','ellenisalves@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAISSA ARAUJO SANTOS','8','2016','Manhã','SJC','54912','d-carla-santos@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAPHAEL  VICTOR DA SILVA DE ALMEIDA','8','2016','Manhã','RJ','64355','victor10raph@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAUL MOURÃO SILVA','8','2016','Manhã','SP','62119','fernando.noemia@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAWAN CERQUEIRA RIOS','8','2016','Manhã','SP','54070','orla.rios@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RENAN DA SILVA DIAS','8','2016','Manhã','RJ','61982','lindarjaol@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RENATA MARQUES DO NASCIMENTO','8','2016','Manhã','SP','58387','fmdonascimento@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RODRIGO DE ALMEIDA OLIVEIRA','8','2016','Manhã','SJC','53976','leila.lmd@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SABRINA RAMOS DE MORAIS DA COSTA','8','2016','Manhã','SP','56909','catiaaprmcosta@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SAMARA LETICIA PEREIRA','8','2016','Manhã','SJC','54245','broinhausa@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SAMUEL GOMES DE SOUZA RODRIGUES','8','2016','Manhã','RJ','58987','samuelzinho69920163@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SOPHIA SANTOS VALVERDE MAGALHÃES','8','2016','Manhã','SP','57442','sophiavalverdeverde@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('TALITA CRISTINA MARINHO PEREIRA','8','2016','Manhã','RJ','62963','talitacmarinho@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('TAMIRES AYMEE DE MOURA SERAFIM','8','2016','Manhã','SJC','53743','tamires_aymee@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THAYNA MOREIRA DE PAULA','8','2016','Manhã','SJC','60929','deboratlgn10@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THAYSSA FERREIRA DE ARAÚJO','8','2016','Manhã','RJ','56076','tfa2003@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THIAGO AKIRA NAKAYAMA','8','2016','Manhã','SP','59270','cristinaamiga@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THIAGO MARTINS BENINCA','8','2016','Manhã','RJ','53333','rtb2004@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THIAGO RODRIGUES DO NASCIMENTO','8','2016','Manhã','RJ','64508','thiagonascimento2080@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THIAGO RUFO ATÍLIO DE OLIVEIRA','8','2016','Manhã','RJ','63093','thiagorufo293@yahoo.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VICTOR HUGO REIS DE ALMEIDA','8','2016','Manhã','SP','58985','r_velasquez@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VICTÓRIA ALEXANDRA CHINA','8','2016','Manhã','SJC','61873','vicchina2013@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VITOR BENÍCIO DE OLIVEIRA','8','2016','Manhã','RJ','61308','vitorbenicio2002@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VITÓRIA FERNANDES','8','2016','Manhã','SP','56728','vivi.oliver2003@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VITORIA MANOELLA PEREIRA CAETANO','8','2016','Manhã','SJC','62585','mercado_castroadm@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('WILLIAM KELVIN DA SILVA','8','2016','Manhã','SJC','54137','fabiordsi@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('WILNER MENDES MOTTA','8','2016','Manhã','RJ','53370','wilner.m.motta@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('YASMIN OLIVEIRA VIEIRA','8','2016','Manhã','SJC','55236','ameninadosolhosda.mamae@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALESSANDRA AVELINO DE SOUZA','9','2016','Manhã','RJ','43256','alessandra.souza.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALICE MARQUES OLIVEIRA','9','2016','Manhã','SP','42759','alice.marques.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('AMANDA MAIUMI RODRIGUES ANDON','9','2016','Manhã','SP','44048','amanda.andon.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA BEATRIZ RENTAS ROMERO','9','2016','Manhã','SP','42248','ana.romero.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA CAROLINA DE LIMA RODRIGUES','9','2016','Manhã','RJ','47891','karol_jovemfla@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA CLARA LOPES MARTINS','9','2016','Manhã','RJ','47797','lopesclara99@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA CLARA REBOUÇAS DA SILVA','9','2016','Manhã','RJ','40970','anaclara.silva.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANDRÉ CLEMENTE CATARINA COSTA','9','2016','Manhã','SJC','44185','andre.costa.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANDRESSA RAMBALDI MARCELLI','9','2016','Manhã','SP','47230','andressa.marcelli.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANDRESSA RAYANE DA SILVA OLIVEIRA','9','2016','Manhã','SJC','41244','andressa.oliveira.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANDREZA SILVA LIMA','9','2016','Manhã','SP','42789','Andreza.lima.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANTONIA GEOVANA AGUIAR DE OLIVEIRA','9','2016','Manhã','SP','47282','antonia.oliveira.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ARLEY DE SOUSA DA COSTA','9','2016','Manhã','RJ','42574','arley.costa.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ARTHUR DE SOUZA SOBRINHO','9','2016','Manhã','RJ','46306','arthur.sobrinho.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BARBARA REIS PRADO','9','2016','Manhã','SJC','43609','barbara.prado.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BEATRIZ BRITO DA COSTA SILVA','9','2016','Manhã','SJC','41151','beatriz.brito.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BIANCA APARECIDA NUNES NASCIMENTO','9','2016','Manhã','SJC','41603','bianca.nunes.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BIANCA BARBOSA DA SILVA','9','2016','Manhã','SP','45171','bianca.barbosa.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRENO DOMINGOS DA SILVA','9','2016','Manhã','RJ','52154','breno.silva.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNO HENRIQUE DE FARIA','9','2016','Manhã','SJC','43056','bruno.faria.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CAMILA SACOMAN GONZALES DOS SANTOS','9','2016','Manhã','SP','44221','camila.sacoman@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CAROLINE LOPES FERREIRA','9','2016','Manhã','SJC','44259','CarolineLopes.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CASSIA DANDARA MELO DA SILVA','9','2016','Manhã','SJC','50902','cassia.silva.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DANIEL ALVES DOS SANTOS','9','2016','Manhã','SJC','46771','danieldada51@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DANIEL DA SILVA MIRANDA','9','2016','Manhã','RJ','52716','daniel.miranda@live.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DANIELLE VENINA MARTINS MODESTO','9','2016','Manhã','SP','43913','danielle.modesto.smart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DEIVID MAYCON BRANDÃO SILVA','9','2016','Manhã','SP','45175','deivid.silva.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('EDUARDO YUKIO MAKITA','9','2016','Manhã','SP','46761','eduardo.makita.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ELIENAI FEITOSA ALVES GARRIDO','9','2016','Manhã','SJC','48397','elienai.garrido.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FERNANDA CASSEMIRO FERNANDES','9','2016','Manhã','RJ','46520','fernanda.fernandes.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL PEIXOTO VALERIANO','9','2016','Manhã','SP','43986','gabriel.valeriano.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL PIRES NOVAKOSKI','9','2016','Manhã','SJC','42136','gabriel.novakoski.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL VIEIRA MARCOLINO','9','2016','Manhã','SP','49628','gabriel.marcolino.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIELA RODRIGUEZ MONTEIRO','9','2016','Manhã','SP','46433','gabriela.monteiro.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIELLY LOPES SOUSA','9','2016','Manhã','SP','48481','gabrielly.sousa.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIOVANNA MENDES ANDRADE ','9','2016','Manhã','SJC','52269','edsonafa@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIOVANNA RABELLO','9','2016','Manhã','SJC','43932','giovanna.rabello.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIOVANNA SANTOS COPPOLA','9','2016','Manhã','SP','42658','giovanna.coppola.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIULYA CABRAL DOS SANTOS','9','2016','Manhã','RJ','49427','giulya.santos.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUILHERME DIAS MOREIRA','9','2016','Manhã','SJC','44213','guilherme.dias.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUILHERME LOPES CALUZ DA SILVA','9','2016','Manhã','SP','41771','gui_caluz@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUSTAVO THEODORO MARQUES','9','2016','Manhã','SJC','47172','gustavo.marques.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('HUGO LINHARES OLIVEIRA','9','2016','Manhã','SP','43317','hugo.oliveira.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('IGOR DANIEL FRANÇA MARCONDES','9','2016','Manhã','SP','42585','igor.marcondes.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('IGOR LEONARDO TEIXEIRA DOS SANTOS JUNIOR','9','2016','Manhã','SP','42438','igorjunior.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISABELA BENHAMI MAGALHAES','9','2016','Manhã','SP','47279','isabela.magalhaes.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISADORA SILVA DA CRUZ','9','2016','Manhã','RJ','47798','isadoras249@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JANAINA DA SILVA DOURADO','9','2016','Manhã','SP','47251','janaina.dourado.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JOANA ESPIRITO SANTO OLIVEIRA ','9','2016','Manhã','RJ','45312','cidonic@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JOAO OTAVIO LIMA OLIVEIRA','9','2016','Manhã','SJC','43898','meugeniacoliveira@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JONATAS REIS RODRIGUES DOS SANTOS','9','2016','Manhã','SP','42532','jocharada@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JOSE ALEPHER ALVES CARVALHO DA COSTA','9','2016','Manhã','SP','50285','jose.alepher.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JÚLIA BEATRIZ VALENTIM RIBEIRO','9','2016','Manhã','SJC','41851','julia.valentimribeiro.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JULIA DE MORAIS BORGES','9','2016','Manhã','SJC','44107','julia.borges.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JULIANA FERNANDES','9','2016','Manhã','SJC','45624','juliana.fernandes.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JULIANA MAYUME FRANKLIN DE SOUZA INOUE','9','2016','Manhã','SP','43356','mayumeinoue.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KAREN PEREIRA FONTES','9','2016','Manhã','SP','52336','karen.fontes.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KAUE ALEXANDRE MATEUS DE OLIVEIRA','9','2016','Manhã','SP','42439','marcia_tk@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KEYLLA SILVA DOS SANTOS','9','2016','Manhã','RJ','47746','keylla.santos.silva.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LARISSA SANTANA UMBELINO THEODORO','9','2016','Manhã','SJC','50691','larissa.theodoro.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LAURA GIOVANNA DOS SANTOS','9','2016','Manhã','RJ','52162','laura.santos.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LAYSA MINELLY DE OLIVEIRA LIMA','9','2016','Manhã','SP','44170','laysa.lima.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LEONARDO ALVES MIGUEL','9','2016','Manhã','SP','43997','leonardo.miguel.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LEONARDO DOS SANTOS ROCHA','9','2016','Manhã','SJC','42518','leonardo.rocha.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LEONARDO PEREIRA DA SILVA','9','2016','Manhã','SP','52385','claudia@grupoavtech.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LEONARDO RODRIGUES OLIVEIRA','9','2016','Manhã','RJ','51462','leonardo.oliveira.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LETICIA CANDIDO DE ABREU','9','2016','Manhã','SP','48300','leticia.abreu.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LETICIA DIAS DE CASTRO NASCIMENTO','9','2016','Manhã','RJ','47163','leticia.nascimento.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LIEW HENRIQUE GONÇALVES','9','2016','Manhã','RJ','50318','liewgoncalves.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUANA DE SOUZA','9','2016','Manhã','RJ','49178','Luana.souza.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS BARBOSA MARTINES','9','2016','Manhã','SP','44677','lucas.martines.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS GABRIEL DE ANDRADE LIMA','9','2016','Manhã','SJC','44310','Lucas.andrade.lima.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS GABRIEL DOS SANTOS MOREIRA','9','2016','Manhã','SJC','42561','lia.mlsm@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIS EDUARDO GUIMARÃES DA SILVA','9','2016','Manhã','SJC','50354','Luis.ismart2015@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIZ DANIEL LIMA NUNES','9','2016','Manhã','RJ','46054','luiz.nunes.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIZ HENRIQUE SILVA OLIVEIRA','9','2016','Manhã','SP','41401','geraldosilvaoliveira1@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARCELLE PEREIRA CARVALHO FALCÃO','9','2016','Manhã','RJ','45442','marcelle.falcao.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARCO AURÉLIO SANTOS','9','2016','Manhã','SP','50849','narutomarco2013@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARCOS ANTONIO DE LIMA JUNIOR','9','2016','Manhã','RJ','49610','marcos.junior.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARCUS VINICIUS FERNANDES AIRES','9','2016','Manhã','SP','48664','marcusaires.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA CLARA COSTA DA ROCHA','9','2016','Manhã','SJC','48803','maria.rocha.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA FERNANDA DE SOUZA GUARNIERI','9','2016','Manhã','SP','43023','maria.guarnieri.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA OLÍVIA COSTA JALOTO','9','2016','Manhã','SP','43333','maria.olivia.jaloto.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIANA LIMA OLIVEIRA','9','2016','Manhã','SJC','43897','marianalima.oliveira.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARINA REIS DE OLIVEIRA','9','2016','Manhã','SP','52570','marina.oliveira.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEUS REZENDE DOS ANJOS','9','2016','Manhã','RJ','46772','matheus.anjos.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEWS FARIA PONTES','9','2016','Manhã','SP','42231','mathews.pontes@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MAYARA PEREIRA BRITO','9','2016','Manhã','SJC','46845','mmdpb@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MIGUEL SOUZA MENDES','9','2016','Manhã','SP','50019','miguel.mendes.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MIQUEIAS ARNALDO CANDIDO DA SILVA','9','2016','Manhã','SP','51042','miqueias.silva.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NATHALIA DA SILVA NASCIMENTO','9','2016','Manhã','SP','51755','nathalianascimento.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NATHALIA FERNANDES DE SOUSA','9','2016','Manhã','SJC','43855','nathalia.sousafernandes.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NICOLAS SOARES TELLES','9','2016','Manhã','SJC','49716','nicolas.telles.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('OSCAR ALVES JONSON NETO','9','2016','Manhã','SJC','41054','oscar.alves.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PEDRO AUGUSTO MOTA COIMBRA','9','2016','Manhã','SP','50755','pedro.coimbra.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PEDRO LUCAS TEIXEIRA MARQUES','9','2016','Manhã','RJ','44570','pedrotjc@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PIETRO GAMA PAWLUK','9','2016','Manhã','SP','48502','pietro.pawluk.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PRISCILLA BRANDT COELHO','9','2016','Manhã','SP','50245','priscillacoelho.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAFAEL DOMINGUES','9','2016','Manhã','SP','42688','rafael.domingues2002@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAFAEL PEREIRA SILVA','9','2016','Manhã','SP','51762','rafael.silva.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAFAEL SANTOS DE MELO','9','2016','Manhã','SJC','49561','rafael.melo.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAFAELA ALEXANDRINO DE SOUZA','9','2016','Manhã','RJ','50346','rafaela.alexandrino.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAFAELA CARVALHO DA PAIXAO','9','2016','Manhã','SJC','41617','rafaela.paixaocarvalho.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAFHAEL ALEXANDRE DINIZ','9','2016','Manhã','SP','51980','rafhael.diniz.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAISSA FATIMA ROSA DE MELO','9','2016','Manhã','SJC','42159','raissa.melo.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAMON ESTENIO SILVA','9','2016','Manhã','SJC','48644','ramon.estenio@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAPHAEL VALIM RANGEL','9','2016','Manhã','RJ','42286','alvamariavalim@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RENAN GABRIEL PEREZ ULRICHSEN','9','2016','Manhã','RJ','52531','RENAN.ULRICHSEN.ISMART@GMAIL.COM','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ROBERTA MASTRANGELO DE SENA','9','2016','Manhã','SJC','50263','ROBERTA.SENA.ISMART@GMAIL.COM','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RODRIGO PEREIRA SILVA','9','2016','Manhã','SP','51763','rodrigo.silva.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SABRINA COSTA CURSINO DA SILVA','9','2016','Manhã','SJC','46123','sabrina.silva.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SARA ALMEIDA DA SILVA ','9','2016','Manhã','SJC','47341','sara.silva.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SARAH AMARAL DE CASTRO','9','2016','Manhã','SJC','43066','sarah.castro.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SARAH MARIA CARDOZO RIBEIRO','9','2016','Manhã','SJC','47331','sarahribeiro.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('STEPHANI ANDRADE DE OLIVEIRA','9','2016','Manhã','SJC','41242','stephani.andrade.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('TALITA YURIKA HATAYAMA TAGUSAGAWA','9','2016','Manhã','SP','48414','talita.tagusagawa.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THAIS RODRIGUES DOS SANTOS','9','2016','Manhã','SJC','43936','thais.santos.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THASSYANA CASTRO DE CARVALHO','9','2016','Manhã','RJ','41173','thassyana.carvalho.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THIAGO SANTANA DA SILVA','9','2016','Manhã','SP','51421','thiago.silva.ismart13@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VANUZA RIBEIRO SANTIAGO','9','2016','Manhã','RJ','43253','vanuza.santiago.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VICTOR DE ALMEIDA SEGANTIM','9','2016','Manhã','SP','48373','victorsegantim.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VICTORIA DE FREITAS PEREIRA','9','2016','Manhã','RJ','50428','victoriapereira.smart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VITOR LUCAS BEDHUN BRITO SANTANA','9','2016','Manhã','SP','52344','vitor.santana.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('WALLACE OLIVEIRA LEITE','9','2016','Manhã','RJ','43953','wallace-olk@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('WANESSA JUNQUEIRA NETO','9','2016','Manhã','RJ','42654','wanessa.junqueira.ismart@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('YAMAN LEAL RODRIGUES','9','2016','Manhã','SP','52622','yaman127891@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('YASMIN VICTORINO CARVALHO','9','2016','Manhã','RJ','52265','mari.victorino@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALANA BEATRIZ OLIVEIRA DO NASCIMENTO','1','2016','Manhã','SP','63306','andrepedronasc@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALICIA RODRIGUES DOS SANTOS','1','2016','Manhã','SP','59091','taniagomesr@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALLINE OLIVEIRA DE QUEIROGA','1','2016','Manhã','SP','58195','alline.wayland@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ÁLVARO LUIS DA SILVA MONGES','1','2016','Manhã','Cotia','59900','alvaro.monges@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('AMANDA MUNIZ BARBOSA','1','2016','Manhã','RJ','56294','amandamuniz2000@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('AMANDA SOUSA OLIVEIRA SILVA','1','2016','Manhã','SP','52996','anderson2621@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA BEATRIZ DA SILVA','1','2016','Manhã','SP','61201','beatrizb.09.bs94@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA BEATRIZ MESQUITA DA COSTA','1','2016','Manhã','RJ','57867','andreamscosta@uol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA CAROLINE DE LIMA SOUSA','1','2016','Manhã','RJ','64050','indiaac1507@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA MARIA TEIXEIRA DE CASTRO','1','2016','Manhã','SP','53110','ana-teixera@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANNA BEATRIZ OLASAGASTI PIGNATARI','1','2016','Manhã','RJ','62202','mc.olasagasti@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BEATRIZ DA SILVA ALMEIDA PEREIRA','1','2016','Manhã','SP','53714','emanoelvitor01@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BEATRIZ DE LIMA CORREIA','1','2016','Manhã','RJ','56342','beatriz.pqt@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BEATRIZ LAISA DA SILVA TEIXEIRA','1','2016','Manhã','SP','59250','beatrizlaste@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRENDA BEBIANO ARAUJO','1','2016','Manhã','SP','56626','brendabebi@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRENDA MENDES LIMA','1','2016','Manhã','SP','54746','brenda_mendes@outlook.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNA PEREIRA CAVALCANTI','1','2016','Manhã','RJ','54770','cavalcanti.leosh@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNO ALFREDO ISSA','1','2016','Manhã','SP','53009','analuciaissa@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNO ALVES SANTANA','1','2016','Manhã','SP','54026','raycouler@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNO GOMES PEREIRA','1','2016','Manhã','RJ','57681','brunootaku2@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CAIO RODRIGUES DE OLIVEIRA','1','2016','Manhã','SP','54358','oliveira.caio17@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CAMILA TEIXEIRA DONOLA','1','2016','Manhã','SP','54855','camila05donola@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CARINA GOMES DA SILVA','1','2016','Manhã','SP','54597','carina_gsih@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CARLOS GABRIEL DE FREITAS FLORES FERREIRA','1','2016','Manhã','SP','53995','carlos.freitas15@outlook.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CECILIA DOURADO STENICO','1','2016','Manhã','SP','56267','cida_stenico@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CÉLIA REGINA SANTOS CAVALCANTI','1','2016','Manhã','Cotia','55184','jospcavalcanti@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('CINTHIA MITIKO SAKUGAWA','1','2016','Manhã','SP','53065','paulasakugawa@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DANIEL BRASIL NUNES REIS AZEVEDO','1','2016','Manhã','RJ','63807','daniel.mogli.db@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DARA DO NASCIMENTO DINIZ','1','2016','Manhã','RJ','59121','rafadndiniz@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DAVID KEVYN MATIAS DE SOUZA','1','2016','Manhã','SP','63267','david-kevyn@live.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DELAILA CAROLINE FERREIRA REIS','1','2016','Manhã','Cotia','54875','delailacfr@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('EDSON DE SALES JUNIOR','1','2016','Manhã','SP','61880','salgoflavia@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ELAINE SILVA DE SOUZA','1','2016','Manhã','RJ','58529','elainesouza2000@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ELIZA SILVA BORGES','1','2016','Manhã','RJ','63359','shirleyfour23@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ELLEN LEAL MOREIRA DA SILVA','1','2016','Manhã','SP','57625','ellenaieuaki@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('EMILLY ALBERTO SOUZA','1','2016','Manhã','SP','53272','timaotico@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ERICK FERNANDES PERROTTI','1','2016','Manhã','SP','57983','vera.perrotti@terra.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('EVELYN BEATRIZ DOS SANTOS','1','2016','Manhã','SP','53636','luciane.santosg@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FELIPE PAES VIEIRA','1','2016','Manhã','Sorocaba','54000','mil_modas@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FELIPE RODRIGUES SANDES','1','2016','Manhã','SP','62814','fe.mota2001@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FERNANDA CELIA BELLA','1','2016','Manhã','Cotia','64190','fernandaceliabella@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FERNANDA HELENA FERNANDES FERREIRA','1','2016','Manhã','SP','53373','mhelenadstos@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL JOBSTRAIBIZER MENEZES','1','2016','Manhã','SP','54610','gajome7@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL LUCENA DE MATTOS','1','2016','Manhã','SP','61336','gabriellucenamattos@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL PINHEIRO DE SOUZA','1','2016','Manhã','SP','54966','gabriel.pds2001@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL RIBEIRO KUIABÁ','1','2016','Manhã','SP','59678','alexandreckuiaba@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL RODRIGUES EUGENIO','1','2016','Manhã','SP','61769','gabrielreugenio@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIELA FERNANDES EING','1','2016','Manhã','SP','57879','gabby.eing@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIOVANNA COSTA DA SILVA','1','2016','Manhã','SP','59849','claudi_ene@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIOVANNA DA CONCEIÇÃO GONÇALVES','1','2016','Manhã','RJ','58363','giovanna.dc@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIOVANNA DOS SANTOS VIEIRA','1','2016','Manhã','SP','58334','jokapipoca@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIULIA LAURIELLO PINHEIRO','1','2016','Manhã','SP','53248','japinheiro7@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUILHERME VIDAL LEMOS','1','2016','Manhã','RJ','53322','guividallemos@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUSTAVO SILVA SANTOS','1','2016','Manhã','SP','63916','gustavo.familiasss@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('IGOR DE JESUS SANTOS','1','2016','Manhã','RJ','64025','igordejesussantos@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('INARA BORGES DE SOUZA SILVA','1','2016','Manhã','SP','57384','marlene.bsilva@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISABELA ORTEGA FERNANDES','1','2016','Manhã','SP','63773','isabelaortegaf@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISABELLE DE OLIVEIRA CRAVALHO SILVA','1','2016','Manhã','SP','52934','genacarvalho@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISABELLE POLLYANA CHAVES LIMA','1','2016','Manhã','RJ','59084','katiadcl1972@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISADORA LEME DE JESUS RODRIGUES','1','2016','Manhã','SP','53646','juleme@feal.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JANAINA VIEIRA MUNIZ','1','2016','Manhã','SP','60054','dungafavela@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JÉSSICA UTZERI PEIXOTO','1','2016','Manhã','RJ','63682','efiziopeixoto@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JOÃO VITOR CARVALHO SILVA','1','2016','Manhã','SP','60506','joaomessi101@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JOÃO VITOR SANTOS PINHO','1','2016','Manhã','SP','52948','joserobertopinho@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JONAS SILVA BRITO','1','2016','Manhã','SP','63208','jonas.sb18@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JUAN FRANKLIN DOS SANTOS DE OLIVEIRA','1','2016','Manhã','SP','58851','juanfranklinsantos@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JULIANA KELLY RIBEIRO GOMES','1','2016','Manhã','RJ','55137','julianakellyribeirogomes@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JULIO CÉSAR FERREIRA GOUVEIA','1','2016','Manhã','RJ','59544','nicefalves@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KARINA DE ALMEIDA MACIEL','1','2016','Manhã','SP','59224','karina.almeida09@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KEPHANIE LOIAHA ANTUNES DE MORAES','1','2016','Manhã','Sorocaba','64089','kephanie_loiha@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KURT GUTERRES BARRETO','1','2016','Manhã','SP','60125','kurt.guterres@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LAIS BERNARDINO PESSOA','1','2016','Manhã','SP','58650','fabi_fabianna@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LAIZ OLIVEIRA LEITE SILVA','1','2016','Manhã','SP','59848','claudiatina@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LARA BARRETO DE OLIVEIRA','1','2016','Manhã','SP','58870','roberta.senna@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LARYSSA TATIANE TEIXEIRA COSTA','1','2016','Manhã','SP','54237','lala.tatilove@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LAURA DA SILVA BIAGGIOLI','1','2016','Manhã','SP','63915','biaggiolij@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LEONARDO HENRIQUE CARVALHO LIRA','1','2016','Manhã','SP','57828','starsbike@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LETICIA VANDONI CARILLO','1','2016','Manhã','SP','57034','whatslovelovelove@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LEYLANE GIMENEZ FLORES','1','2016','Manhã','RJ','63316','gbsflores@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LIVIA FERNANDES DE MORAIS','1','2016','Manhã','SP','53118','leticia_leleta12@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUANA SANTOS NUNES','1','2016','Manhã','SP','64011','luanas.nunes01@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS JALLES DE ANDRADE','1','2016','Manhã','SP','63580','lucasjalles68@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS MANOEL MARTINS DE SOUZA','1','2016','Manhã','RJ','53522','lukinhas.slk8@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS QUEIROZ VIEIRA','1','2016','Manhã','SP','61502','lucas.q.v@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIZ EDUARDO FOX RODRIGUES DE OLIVEIRA','1','2016','Manhã','RJ','59266','luiz-eduardo-mar@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIZ HENRIQUE FREITAS DA SILVA','1','2016','Manhã','SP','63890','luizjogabola@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIZA BARRETO GONÇALVES','1','2016','Manhã','SP','53821','lbarreto0001@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUMA ROCHA DOURADO','1','2016','Manhã','SP','59715','lumarocha.lr@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MAIARA RODRIGUES DA SILVA','1','2016','Manhã','RJ','60289','joao.maiara1@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MANUELA QUEIROZ DE SOUZA','1','2016','Manhã','SP','63770','glemanuela03@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARCOS VINICIUS CAVALCANTE','1','2016','Manhã','SP','62259','viniciustabunito@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA ALICE SOARES ROBERTO DA SILVA','1','2016','Manhã','SP','63817','m.roberto.silva2015@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA EDUARDA SILVA NASCIMENTO','1','2016','Manhã','SP','59623','du505@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA ISABEL SERINOLLI DE OLIVEIRA','1','2016','Manhã','SP','52962','micheletarologa@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA VITÓRIA DE OLIVEIRA SOUSA','1','2016','Manhã','RJ','54955','melandia.oliveira@yahoo.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIANNA SILVA JOÃO','1','2016','Manhã','SP','59006','mariannajoao10@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARYELLE PACHECO DOS SANTOS','1','2016','Manhã','RJ','63342','anielle_pacheco@yahoo.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEUS BORBA DE ANDRADE','1','2016','Manhã','Cotia','56699','matborba@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEUS FERRO','1','2016','Manhã','SP','54464','theusferro@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEUS MOREIRA DO NASCIMENTO','1','2016','Manhã','RJ','60782','matheus.moreira.jpa@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MAXIMILIANO AFONSO RAMOS','1','2016','Manhã','SP','63540','maxprimoloko@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MIGUEL MORAIS SILVA','1','2016','Manhã','SP','62214','miguel.morais1@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MILENA PARAISO DE CAMARGO','1','2016','Manhã','SP','62538','milenaparaisocamargo@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MILENE SOUZA DO ESPÍRITO SANTO','1','2016','Manhã','SP','54336','milenesouza541@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MIRELA SILVA GONDIM','1','2016','Manhã','Cotia','53508','mirela.gondim360@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MOISÉS MIRANDA SANTANA','1','2016','Manhã','SP','57083','moi_sesms@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NATHAN FELINTO DE LIMA','1','2016','Manhã','SP','64291','nathannathanlima@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NAYARA CARVALHO DOS SANTOS','1','2016','Manhã','RJ','55443','nayhsantos36@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NICOLAS HENRIQUE ARAUJO PEREIRA','1','2016','Manhã','Cotia','54920','nicolashenrique4142@outlook.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PEDRO ARTUR DE MENDONÇA RODRIGUES','1','2016','Manhã','RJ','63101','arturdsk@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('POLYANNA DELLA VIOLLA GROPPO','1','2016','Manhã','Sorocaba','61392','polyannagroppo@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAFAEL ALVES CABRAL','1','2016','Manhã','Cotia','63969','raalcabral@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAFAEL DE OLIVEIRA RAMOS','1','2016','Manhã','RJ','55234','rafaellegal22334474@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAIZA LIMA SILVA','1','2016','Manhã','SP','52975','ranasilva@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAYSSA MATIAS GONZAGA','1','2016','Manhã','SP','53824','rayssa_matias@outlook.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('REBECA GUTIERRES TAVARES DE ALMEIDA','1','2016','Manhã','SP','60387','rebeca.gutierres.08@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('REBECCA HADDAD DE AGUIAR','1','2016','Manhã','SP','54935','becky13092000@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RODRIGO BOTEGUIM PETTER','1','2016','Manhã','Cotia','54006','suzeteabpetter@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SABRINA FAGUNDES SOUZA DE OLIVEIRA','1','2016','Manhã','Cotia','54467','sabrinafagundes610@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SABRINA RAQUEL DE GODOY','1','2016','Manhã','SP','60183','kurt.nirvana_67@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SARA BEATRIZ DE JEZUZ DA SILVA','1','2016','Manhã','RJ','61084','sarabeatriz78@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SUELLEN DA COSTA MARTINS','1','2016','Manhã','RJ','54380','susudoabv@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('TALISSA GONÇALVES ALBERTINI','1','2016','Manhã','Sorocaba','53040','tataalbertini@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('TAYNA RIOS ESPINOSA','1','2016','Manhã','SP','57208','tayna.angels@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THABATA CAPUZZO','1','2016','Manhã','SP','59209','adrianacapuzzo@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THAINA CAVALARI SIQUEIRA','1','2016','Manhã','SP','62386','thainacavalari@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ULISSES CARVALHO','1','2016','Manhã','RJ','62576','josemerebc@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VENICIUS DE LIMA SOARES','1','2016','Manhã','SP','55679','venicic@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VICTOR DE LIMA SOARES','1','2016','Manhã','SP','55678','limacictor@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VICTOR HUGO TEIXEIRA ZANONI','1','2016','Manhã','SP','61835','victorzanoni@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VICTORIA DO VALLE RAMOS','1','2016','Manhã','Cotia','54817','vidracariacaucaia@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VINÍCIUS RODRIGO RAGONHA RIBEIRO','1','2016','Manhã','SP','62614','ritadiasruiz@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VITORIA RITA RAFAELA OLIVEIRA SILVA','1','2016','Manhã','SP','55475','vitinha544@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VIVIAN OLIVEIRA VIEIRA','1','2016','Manhã','RJ','57221','vivi2000.vov@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('WALLACE DAMASIO RIBEIRO','1','2016','Manhã','RJ','57856','wiltonlima312@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('WILLIAM SILVA AZEVEDO','1','2016','Manhã','SP','55296','william988.ws@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('WILLIAN DA SILVA SENA','1','2016','Manhã','RJ','54950','sthefaniesena@r7.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('YAGO GOMES DE AMORIM','1','2016','Manhã','SP','58876','yago.amorin1@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('YTALO WILLIAM DE JESUS DA GLORIA','1','2016','Manhã','SP','61174','ytalo_will@live.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('YURI YONAMINE CAVALCANTE DOS SANTOS','1','2016','Manhã','SP','56602','yurihai000@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('YURI GARCIA TORRENS','1','2016','Manhã','SP','70','yurigarciatorrens@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JULIA QUEIROZ NEGRI','1','2016','Manhã','SJC','30','julianegri@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('FRANCIELE MARIA DE FATIMA AMANCIO','1','2016','Manhã','SJC','16','fatinha.amancio@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIELLA ANDREA HIAGON MELLADO','1','2016','Manhã','SP','18','gabriellahiagon@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUILHERME NUNES AMARAL DOS SANTOS','1','2016','Manhã','SP','21','guilhermenunes1910@outlook.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LAIS CRISTINA GONÇALVES ROSA','1','2016','Manhã','SP','32','laiscgr11@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PRISCILA COSTA BLAZ','1','2016','Manhã','SP','53','lucblaz@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALEX ALVES CARVALHO DA COSTA','1','2016','Manhã','SP','1','alex.alves_br@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS WENZL FERNANDES MARTINS','1','2016','Manhã','SP','40','tanufe@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LAILA CÂMARA MAIA','1','2016','Manhã','SJC','31','levania@fabiolamolina.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEUS DA FONTE','1','2016','Manhã','SP','47','matheus_dafonte@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('EMILLY BRITO ALVES DA SILVA','1','2016','Manhã','SP','140','josangela_silva@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIELA MARROCCO GONÇALVES BEZERRA','1','2016','Manhã','SP','17','gabrielamarrocco2@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JOEL DA SILVA JUNIOR','1','2016','Manhã','SP','27','junior-226@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('EVELYN LORRAINE DA SILVA','1','2016','Manhã','SJC','15','evelyn.lorraine@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JULIANA KÉSSYA ARAUJO CLETO','1','2016','Manhã','RJ','83','juju.cleto@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUILHERME PEREIRA BRAZ','1','2016','Manhã','SP','22','val.quiria10@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEUS WENZL FERNANDES MARTINS','1','2016','Manhã','SP','49','fernandesmariana@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SÂMELA CESAR DA SILVA','1','2016','Manhã','SP','58','Belezaeternamente@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('YASMIN AHMAD ABOU ADILE','1','2016','Manhã','SP','69','liaadelino@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNO CARLOS OLIVEIRA DA SILVA','1','2016','Manhã','SJC','11','franoziana@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KELVIN RIBEIRO NOVAIS','1','2016','Manhã','SP','137','relianaekelvin@yahoo.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('WILSON LEONARDO MARCIELO CHAVES','1','2016','Manhã','SP','68','wilsonleonardo1@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('HELEN SABRINA BRAZ DE LIMA','1','2016','Manhã','RJ','79','helsabrinacarvalho@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIANA ALEXANDRINO DE OLIVEIRA','1','2016','Manhã','RJ','89','julyoliveira@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS VENCESLAU DOS SANTOS','1','2016','Manhã','SP','39','lucas007venceslau@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('VINICIUS ARAUJO','1','2016','Manhã','SP','65','dugavin42@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIOVANNA COSTA NUNES DE FREITAS','1','2016','Manhã','SP','19','solscosta@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GIOVANNA ROCHA BARBOSA','1','2016','Manhã','SP','20','gigi_pop10@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUILHERME BATISTA BIBIANO','1','2016','Manhã','SP','101','anacarolica@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RENATO TEIXEIRA LINS JUNIOR','1','2016','Manhã','SP','55','renatojr.lins13@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('SANDY CAMILA LEITE MACEDO','1','2016','Manhã','SJC','59','sandy.tkd@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS PEREIRA PACHECO','1','2016','Manhã','SP','38','lucaspacheco747@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NARAYNÃ PONCIANO NUNES','1','2016','Manhã','SP','50','toligadonis@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('NATALÍ GREGÓRIO DO NASCIMENTO','1','2016','Manhã','RJ','94','natyfofinha02@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARYANA ASSIS TRIGUEIRO','1','2016','Manhã','RJ','92','maryana.assis2000@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THAINARA ALVES DE ANDRADE CRUZ','1','2016','Manhã','SP','63','thainara_alves100@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA JULIA MARTINS OLIVEIRA','1','2016','Manhã','SJC','6','anajuliam253@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('KARINE LOPES DE MORAES','1','2016','Manhã','RJ','84','KLM2001karine@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIANA VICTORINO BARCELLOS','1','2016','Manhã','RJ','91','mv.barcellos36@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISABELA CRISTINA DE OLIVEIRA','1','2016','Manhã','SJC','25','Isabelacristina264@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA ALICE GONÇALVES DO NASCIMENTO','1','2016','Manhã','RJ','71','adriana.alice14@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIANA DOS SANTOS ARAÚJO','1','2016','Manhã','SJC','109','marianadossantosaraujo@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ALINE CONCEIÇÃO DA SILVA','1','2016','Manhã','SP','2','alinnemoreninha2011@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANANDA SPERENDIO LIMA','1','2016','Manhã','SJC','7','anandinha.slima@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LEONARDO HENRIQUE MORI','1','2016','Manhã','SP','35','leonardomori_@outlook.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIA ELISA VENDRUSCOLO','1','2016','Manhã','SP','44','maria_vendruscolo@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARIANA DE BARROS VIEIRA','1','2016','Manhã','RJ','90','mariana.b.v.2000@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNA PEREIRA DE MELO','1','2016','Manhã','SP','10','bruna.melo2013@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ISABELLA HORTENCIA DA SILVA','1','2016','Manhã','SP','26','isabellah.d.s@outlook.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('THIAGO PACIOS DE QUEIROZ','1','2016','Manhã','SP','64','silmarapacios@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GABRIEL TORRES E SILVA','1','2016','Manhã','RJ','78','roneymarciosantos@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JOÃO PAULO CALHEIROS ESTEVES','1','2016','Manhã','RJ','80','calheirosesteves@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ENZO COLHADO BIOLCATTI','1','2016','Manhã','SP','14','ebiolcatti@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANA CAROLINA RIBEIRO DO NASCIMENTO','1','2016','Manhã','SP','5','ananascimento0902@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RAFAELA MELEZ QUEIROZ','1','2016','Manhã','SP','54','rafax1910@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS OLIVEIRA ASSUNÇÃO','1','2016','Manhã','SP','37','lucasthoughts@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('HENRIQUE SILVA ARAÚJO','1','2016','Manhã','SP','24','joscilia2304@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PAULO VITOR CARDOSO PEREIRA SILVA','1','2016','Manhã','SP','51','paulo-vitorcardoso@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('WENDELL GABRIEL ABRANTES DO NASCIMENTO','1','2016','Manhã','SJC','66','leila_abrantes@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEUS BRAGA RIBEIRO','1','2016','Manhã','SJC','46','mb_ribeiro2000@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('ANDERSON LAGE FORTUNATO','1','2016','Manhã','RJ','72','kekakirk@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUIS GUILHERME COELHO BUENO','1','2016','Manhã','SJC','41','luzienescoelho@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARCOANTONIO VELA CCOLLCCA','1','2016','Manhã','SP','42','antoniovelachalas@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('EDUARDO GABRIEL MATIAS DE ARAUJO','1','2016','Manhã','RJ','76','katiapussy@bol.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RODRIGO MARINS BARBOSA','1','2016','Manhã','RJ','95','roselanemarins@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRENO OLIVEIRA PINTO ARANTES','1','2016','Manhã','SJC','9','breno_yondaimeb@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNA DA SILVA ODORICO','1','2016','Manhã','SP','129','bodorico45@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PEDRO PAULO TAVARES DE OLIVEIRA','1','2016','Manhã','SP','52','rosedeide@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUKAS HENRIQUE PACHECO RODRIGUES','1','2016','Manhã','SP','136','lukinhas.pitu@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DANIEL DIAS CRUZ','1','2016','Manhã','SP','13','danieldias.cruz5@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MARCOS VINICIOS LIROA LIMA','1','2016','Manhã','SP','130','marcos_booh@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('HENRIQUE CORRÁ MONTEIRO FERREIRA','1','2016','Manhã','SJC','103','henrique.corra@yahoo.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('JUAN KEVERSON AMÂNCIO ROCHA','1','2016','Manhã','SP','28','juan9dinamicos@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LARISSA BARBOSA NUNES','1','2016','Manhã','SP','99','estrelarissa@ig.com.br','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BRUNA MENEZES DE PAULA','1','2016','Manhã','RJ','74','zan.souza@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('DANIEL CORDEIRO DA SILVA','1','2016','Manhã','SP','116','danielcordeiro69@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('GUSTAVO DOS SANTOS PAULO','1','2016','Manhã','SP','141','gustavopaulo05@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('IAGO LUIS XAVIER MACHADO','1','2016','Manhã','SJC','132','machadolw@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('MATHEUS PEREIRA QUIRINO','1','2016','Manhã','SP','135','lu.pq@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('PEDRO HENRIQUE FELIX DA COSTA','1','2016','Manhã','SJC','124','pedro.felixcosta12@hotmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('RODRIGO KENNITI LOPES MAKIYAMA','1','2016','Manhã','SP','56','rodrigolopeszx@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('LUCAS NEVES CARVALHO DE MELLO','1','2016','Manhã','RJ','87','lucas.neves.carvalho@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 * ,
			 * "INSERT INTO User_iol (name, ano, turma, turno, unidade, ismartId, login, password) VALUES ('BEATRIZ GOMES ROVELINO DE SOUZA','1','2016','Manhã','SP','62898','biarovelino@gmail.com','$2a$10$u9D4zHxfupbNrHQ.zXV3n.jPtHQ5W1oG5th5FMMeXVEY20cMsvKCi'); "
			 */
	};
}
