package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Haiku;

public class HaikuDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL =
		"jdbc:h2:C:/data/soueikai";
	private final String DB_USER = "sa";
	private final String DB_PASS = "janwool";
		
	public List<Haiku> findRecentHaiku() {
		List<Haiku> haikuList = new ArrayList();
		//データベース接続
		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文の準備
			String sql =
				"SELECT * from HAIKU WHERE dt = (SELECT MAX(dt) FROM HAIKU";
			PreparedStatement pStmt1 = conn.prepareStatement(sql);
			
			//SELECT文を実行
			ResultSet rs = pStmt1.executeQuery(); 
				
			//SELECT文の結果をArrayListに格納
			while (rs.next()) {
				String text = rs.getString("TEXT");
				String writer = rs.getString("WRITER");			
				Haiku haiku = new Haiku(text, writer);
				haikuList.add(haiku);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
			return haikuList;
		}
	
	public int createHaiku(Haiku haiku) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			
			//INSERT文の準備(idは自動連番なので指定しなくてもよい)
			String sql = "INSERT INTO HAIKU(TEXT, WRITER, KIGO, SEASON, DATE) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setString(1, haiku.getText());
			pStmt.setString(2, haiku.getWriter());
			pStmt.setString(3, haiku.getKigo());
			pStmt.setString(4, haiku.getSeason());
			pStmt.setInt(5, haiku.getDate());
			
			//INSERT文を実行(resultには追加された行数が代入される)
			int result = pStmt.executeUpdate();
			
			return result;
	
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
