package _03_board.model;

import java.io.InputStream;
import java.util.*;

public interface MessageBoardDAO_interface {
	public int insert(Integer Members_ID, String MessageBoard_Content, String fileName, InputStream fin);
	public void updateAll(MessageBoardVO messageBoardVO);
	public void updateCounts(MessageBoardVO messageBoardVO);
	public void updateReports(MessageBoardVO messageBoardVO);
	public void delete(Integer messageBoard_Id);
	public MessageBoardVO findByPrimaryKey(Integer messageBoard_Id);
	public List<MessageBoardVO> getAll();
}
