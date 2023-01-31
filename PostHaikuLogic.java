package model;

import dao.HaikuDAO;

public class PostHaikuLogic {
	public int execute(Haiku haiku) {
		HaikuDAO dao = new HaikuDAO();
		return dao.createHaiku(haiku);
		
	}
}
