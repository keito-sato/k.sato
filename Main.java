package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetHaikuLogic;
import model.Haiku;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//前回句会の俳句を取得してリクエストスコープに保存
				GetHaikuLogic getHaikuLogic = new GetHaikuLogic();
				List<Haiku> haikuList = getHaikuLogic.execute();
				request.setAttribute("haikuList", haikuList);
				
				//ログインしているかを確認するため
				//セッションスコープからユーザー情報を取得
				HttpSession session = request.getSession();
				User loginUser = (User) session.getAttribute("User");

				if(loginUser == null) { //ログインしてない場合、リダイレクト
					response.sendRedirect("/soueikai");
				} 
				else {					//ログイン済みの場合メイン画面にフォワード
					RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
					dispatcher.forward(request, response);
				}
	}

}
