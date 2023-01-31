package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.User;

public class AccountDAO {
	
	//データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:h2:C:/data/soueikai";
	private final String DB_USER = "sa";
	private final String DB_PASS = "janwool";
		
	public Account findByAccount(User user) {
			
		try (Connection conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS)) {
				
			//アカウントインスタンスを用意
			Account account = null;
				
			//SELECT文を準備
			String sql = "SELECT NAME, PASS, FROM ACCOUNT WHERE NAME = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
				
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
				
			//一致したユーザーが存在した場合
			//Accountインスタンスのフィールドにセット
			if (rs.next()) {
				//結果表からデータを取得
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				account.setName(name);
				account.setPass(pass);
				return account;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public int registerAccount(User user) {

		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
				
			//SELECT文準備
			String sql1 = "SELECT NAME FROM ACCOUNT WHERE NAME = ?)";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);
			pStmt1.setString(1, user.getName());
			
			//SELECT文を実行し結果を取得
			ResultSet rs = pStmt1.executeQuery();
				
			//同じアカウント名がなければINSERTする
			if(!(rs.next())) {
				//INSERT文を準備
				String sql2 = "INSERT INTO ACCOUNT (NAME, PASS) VALUES (?, ?)";
				PreparedStatement pStmt2 = conn.prepareStatement(sql2);
				pStmt2.setString(1, user.getName());
				pStmt2.setString(2, user.getPass());
				
				//INSERT文を実行し、結果を取得
				return pStmt2.executeUpdate();
				
			} else {
				return 0;
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
			
		}
}
