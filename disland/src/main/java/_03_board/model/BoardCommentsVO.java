package _03_board.model;

import java.sql.Date;

public class BoardCommentsVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public BoardCommentsVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int BoardComments_ID;
	private int MessageBoard_ID;
	private int BoardComments_Context;
	private int Members_ID;
	private int BoardComments_Status;  //貼文狀態，是否被檢舉
	private Date BoardComments_BuildTime;
	//==============================================================

	//====================getter跟setter=============================
	public int getBoardComments_ID()
	{
		return BoardComments_ID;
	}
	public void setBoardComments_ID(int boardComments_ID)
	{
		BoardComments_ID = boardComments_ID;
	}
	public int getMessageBoard_ID()
	{
		return MessageBoard_ID;
	}
	public void setMessageBoard_ID(int messageBoard_ID)
	{
		MessageBoard_ID = messageBoard_ID;
	}
	public int getBoardComments_Context()
	{
		return BoardComments_Context;
	}
	public void setBoardComments_Context(int boardComments_Context)
	{
		BoardComments_Context = boardComments_Context;
	}
	public int getMembers_ID()
	{
		return Members_ID;
	}
	public void setMembers_ID(int members_ID)
	{
		Members_ID = members_ID;
	}
	public int getBoardComments_Status()
	{
		return BoardComments_Status;
	}
	public void setBoardComments_Status(int boardComments_Status)
	{
		BoardComments_Status = boardComments_Status;
	}
	public Date getBoardComments_BuildTime()
	{
		return BoardComments_BuildTime;
	}
	public void setBoardComments_BuildTime(Date boardComments_BuildTime)
	{
		BoardComments_BuildTime = boardComments_BuildTime;
	}

}
