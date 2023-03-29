package model;

import dao.AccountDAO;

public class LoginLogic {
	public boolean execute(User user) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByAccount(user);
		return account != null;
	}
}
