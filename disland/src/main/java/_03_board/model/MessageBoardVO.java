package _03_board.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class MessageBoardVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L; // 沒寫不會怎樣,寫了更好

	public MessageBoardVO() {
	} // 不帶參數的建構子

	// ====================private實例變數=============================
	
	private Integer messageBoard_Id; // 1.訊息板 編號
	private Integer members_Id; // 2.會員編號
	private String messageBoard_Content; // 3.訊息板內容
	private String messageBoard_Name; // 4.訊息板 圖片檔案名稱
	private Blob messageBoard_Picture; // 5.訊息板圖片(Binary)
	private Timestamp messageBoard_BuildTime; // 6.訊息板貼文建立時間
	private Integer messageBoard_Counts; // 7.按讚數
	private Integer messageBoard_Report; // 8.訊息板 檢舉數
	private Integer messageBoard_Status; // 9.貼文狀態，是否被隱藏 1為隱藏 0為無隱藏
	
	// ==============================================================

	// ====================getter跟setter=============================
	
	//1.訊息板 編號
	public Integer getMessageBoard_Id() {
		return messageBoard_Id;
	}
	public void setMessageBoard_Id(Integer messageBoard_Id) {
		this.messageBoard_Id = messageBoard_Id;
	}

	
	//2.會員編號
	public Integer getMembers_Id() {
		return members_Id;
	}
	public void setMembers_Id(Integer members_Id) {
		this.members_Id = members_Id;
	}
	
	
	//3.訊息板內容
	
	public String getMessageBoard_Content() {
		return messageBoard_Content;
	}
	public void setMessageBoard_Content(String messageBoard_Content) {
		this.messageBoard_Content = messageBoard_Content;
	}

	
	//4.訊息板 圖片檔案名稱
	public String getMessageBoard_Name(){
		return messageBoard_Name;
	}
	public void setMessageBoard_Name(String messageBoard_Name){
		this.messageBoard_Name = messageBoard_Name;
	}
	
	
	//5.訊息板圖片(Binary)
	public Blob getMessageBoard_Picture() {
		return messageBoard_Picture;
	}
	public void setMessageBoard_Picture(Blob messageBoard_Picture) {
		this.messageBoard_Picture = messageBoard_Picture;
	}

	
	//6.訊息板貼文建立時間
	public Timestamp getMessageBoard_BuildTime() {
		return messageBoard_BuildTime;
	}
	public void setMessageBoard_BuildTime(Timestamp messageBoard_BuildTime) {
		this.messageBoard_BuildTime = messageBoard_BuildTime;
	}

	
	//7.按讚數
	public Integer getMessageBoard_Counts(){
		return messageBoard_Counts;
	}
	public void setMessageBoard_Counts(Integer messageBoard_Counts){
		this.messageBoard_Counts = messageBoard_Counts;
	}
	
	
	//8.訊息板 檢舉數
	public Integer getMessageBoard_Report(){
		return messageBoard_Report;
	}
	public void setMessageBoard_Report(Integer messageBoard_Report){
		this.messageBoard_Report = messageBoard_Report;
	}
	
	
	//9.貼文狀態，是否被隱藏 1為隱藏 0為無隱藏
	public Integer getMessageBoard_Status() {
		return messageBoard_Status;
	}
	public void setMessageBoard_Status(Integer messageBoard_Status) {
		this.messageBoard_Status = messageBoard_Status;
	}

}
