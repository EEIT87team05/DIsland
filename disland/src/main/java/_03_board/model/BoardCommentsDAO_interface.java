package _03_board.model;


import java.util.List;

public interface BoardCommentsDAO_interface {
	public int insert(Integer membersId, Integer messageBoardId,String boardCommentsContent);
	public List<BoardCommentsVO> getAll();
}
