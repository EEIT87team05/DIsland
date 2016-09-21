package _03_board.model;

import java.util.List;

public class BoardCommentsService {
	private BoardCommentsDAO_interface dao;
	
	public BoardCommentsService(){
		dao = new BoardCommentsDAO();
	}
	
	public List<BoardCommentsVO> getAll(){
		return dao.getAll();
	}
}
