package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Haiku;
import model.PostHaikuLogic;
import model.User;

@WebServlet("/PostHaiku")
public class PostHaiku extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/postHaiku.jsp");
			dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
				request.setCharacterEncoding("UTF-8");
				String text = request.getParameter("text");
				String kigo = request.getParameter("kigo");
				String season = request.getParameter("season");
				String photoId = request.getParameter("photoId");
				
				if (!(text == null ||  kigo == null || season == null || photoId == null)) {	
					
					//セッションスコープからユーザー情報を取得
					HttpSession session = request.getSession();
					User loginUser = (User) session.getAttribute("User");
					
					//俳句インスタンスのフィールドに情報をセット
					Haiku haiku = new Haiku(text,loginUser.getName(),kigo, season, photoId);
					
					//PostHaikuLogicインスタンス生成
					PostHaikuLogic postHaikuLogic = new PostHaikuLogic();
					
					//俳句を投稿
					int rs = postHaikuLogic.execute(haiku);
					
					//リクエストスコープに俳句を保存
					request.setAttribute("haiku", haiku);
				
				}	
				//フォワード
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("WEB-INF/jsp/postHaikuResult.jsp");
					dispatcher.forward(request, response);
	}

}
