package _03_board.model;

import java.util.List;


public class MessageBoardService {
	private MessageBoardDAO_interface dao;
	
	public MessageBoardService() {
			dao = new MessageBoardDAO();
	}

	public List<MessageBoardVO> getAll(){
		return dao.getAll();
	}
}
