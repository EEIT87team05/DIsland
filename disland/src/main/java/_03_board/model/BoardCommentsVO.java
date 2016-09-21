package _03_board.model;

import java.sql.Timestamp;

public class BoardCommentsVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L; // 沒寫不會怎樣,寫了更好

	public BoardCommentsVO() {
	} // 不帶參數的建構子

	// ====================private實例變數=============================

	private Integer boardComments_Id; // 1.評論版編號
	private Integer members_Id; // 2.會員編號
	private Integer messageBoard_Id; // 3.訊息板編號
	private String boardComments_Content; // 4.評論版內容
	private Integer boardComments_Reports; // 5.評論板 檢舉數
	private Integer boardComments_Status; // 6.評論版狀態，是否被隱藏 1為隱藏 0為無隱藏
	private Timestamp boardComments_BuildTime; // 7.評論版建構時間

	// ==============================================================

	// ====================getter跟setter=============================
	// 1.評論版編號
	public Integer getBoardComments_Id() {
		return boardComments_Id;
	}
	public void setBoardComments_Id(Integer boardComments_Id) {
		this.boardComments_Id = boardComments_Id;
	}

	
	// 2.會員編號
	public Integer getMembers_Id() {
		return members_Id;
	}
	public void setMembers_Id(Integer members_Id) {
		this.members_Id = members_Id;
	}
	
	
	// 3.訊息板編號
	public Integer getMessageBoard_Id() {
		return messageBoard_Id;
	}
	public void setMessageBoard_Id(Integer messageBoard_Id) {
		this.messageBoard_Id = messageBoard_Id;
	}

	
	// 4.評論版內容
	public String getBoardComments_Content() {
		return boardComments_Content;
	}
	public void setBoardComments_Content(String boardComments_Content) {
		this.boardComments_Content = boardComments_Content;
	}


	// 5.評論板 檢舉數
	public Integer getBoardComments_Reports(){
		return boardComments_Reports;
	}	
	public void setBoardComments_Reports(Integer boardComments_Reports){
		this.boardComments_Reports = boardComments_Reports;
	}
	
	
	// 6.評論版狀態，是否被隱藏 1為隱藏 0為無隱藏
	public Integer getBoardComments_Status() {
		return boardComments_Status;
	}
	public void setBoardComments_Status(Integer boardComments_Status) {
		this.boardComments_Status = boardComments_Status;
	}

	
	// 7.評論版建構時間
	public Timestamp getBoardComments_BuildTime() {
		return boardComments_BuildTime;
	}
	public void setBoardComments_BuildTime(Timestamp boardComments_BuildTime) {
		this.boardComments_BuildTime = boardComments_BuildTime;
	}

}
