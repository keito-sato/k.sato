package model;

import java.util.List;

import dao.HaikuDAO;

public class GetHaikuLogic {
	public List<Haiku> execute() {
		HaikuDAO dao = new HaikuDAO();
		List<Haiku> haikuList = dao.findRecentHaiku();
		return haikuList;
	}
}
