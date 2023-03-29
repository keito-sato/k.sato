package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
						
		//値が適切でなければエラーメッセージをリクエストスコープに保存
		if (!(name == null || name.length() > 10 || pass == null || pass.length() > 6)) {
									
			//Userインスタンス(ユーザー情報)の生成
			User user = new User(name, pass);
			LoginLogic loginLogic = new LoginLogic();
			boolean isLogin = loginLogic.execute(user);
					
			//ログイン成功時、ユーザー情報をセッションスコープに保存
			if (isLogin) { 
				HttpSession session = request.getSession();
					session.setAttribute("User", user);
			}
		}
		//メインサーブレットにフォワード
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
				dispatcher.forward(request,  response);
	}

}
