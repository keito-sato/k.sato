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
import model.PostHaikuLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//前回句会の俳句を取得してリクエストスコープに保存
		GetHaikuLogic getHaikuLogic = new GetHaikuLogic();
		List<Haiku> haikuList = getHaikuLogic.execute();
		request.setAttribute("haikuList", haikuList);
		
		//ログインしているかを確認するため
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if(loginUser == null) { //ログインしていない場合リダイレクト
			response.sendRedirect("/soueikai");
		} 
		else {	//ログイン済みの場合フォワード
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		String kigo = request.getParameter("kigo");
		String season = request.getParameter("season");
		int date = Integer.parseInt(request.getParameter("date"));
		
		if(text != null && text.length() != 0 && season != null && season.length() != 0 && date != 0) {
			//セッションスコープからユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			//俳句インスタンスのフィールドに情報をセット
			Haiku haiku = new Haiku(text,loginUser.getName(),kigo, season, date);
			
			//PostHaikuLogicインスタンス生成
			PostHaikuLogic postHaikuLogic = new PostHaikuLogic();
			
			//俳句を投稿
			int rs = postHaikuLogic.execute(haiku);
			
			//投稿出来なかった場合、エラーメッセージをリクエストスコープに保存
			if (rs == 0) {
				request.setAttribute("errorMsg", "正しく投稿出来ませんでした");
			}
		}else {
			//未入力情報がある場合、エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "入力されていない項目があります");
		}	
		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
	}
	
		
}
