package model;

import dao.AccountDAO;

public class RegisterLogic {
		public boolean execute(User user) {			
			AccountDAO dao = new AccountDAO();
			int result = dao.registerAccount(user);
			return result != 0;
		}
}
