package model;

import dao.AccountDAO;

public class RegisterLogic {
		public boolean execute(User user) {			
			AccountDAO dao = new AccountDAO();
			int rs = dao.registerAccount(user);
			return rs != 0;
		}
}
