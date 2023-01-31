package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterLogic;
import model.User;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
				dispatcher.forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");	
		
		//値が適切でなければエラーメッセージをリクエストスコープに保存	
		if (name == null || name.length() > 10 || pass1 == null || pass1.length() > 6 || !(pass1.equals(pass2))) {
			request.setAttribute("errorMsg", "名前かパスワードが適切でありません");
		
		}else {
			//Userインスタンス(ユーザー情報)の生成
			User user = new User(name, pass1);
			
			//アカウント登録処理
			RegisterLogic registerLogic = new RegisterLogic();
			boolean rs = registerLogic.execute(user);
			
			//セッションスコープにuserを保存
			if (rs) { 
				HttpSession session = request.getSession();
				session.setAttribute("User", user);
			//登録できなかった場合エラーメッセージ表示
			} else {
				request.setAttribute("errorMsg", "アカウント登録できませんでした");
			}
		}
		//ログイン結果画面にフォワード
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("WEB-INF/jsp/registerResult.jsp");
			dispatcher.forward(request,  response);
				
	}

}
