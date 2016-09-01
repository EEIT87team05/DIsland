package _03_board.model;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;

public class MessageBoardVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public MessageBoardVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int MessageBoard_ID;
	private int Members_ID;
	private Clob MessageBoard_Context;  //塗鴉牆內容
	private Blob MessageBoard_Picture;  //塗鴉牆照片
	private Date MessageBoard_BuildTime; //貼文建立時間
	private int MessageBoard_Counts;  //按讚數
	private int MessageBoard_Status;  //貼文狀態，是否被檢舉
	//==============================================================

	//====================getter跟setter=============================
	public int getMessageBoard_ID()
	{
		return MessageBoard_ID;
	}
	public void setMessageBoard_ID(int messageBoard_ID)
	{
		MessageBoard_ID = messageBoard_ID;
	}
	public int getMembers_ID()
	{
		return Members_ID;
	}
	public void setMembers_ID(int members_ID)
	{
		Members_ID = members_ID;
	}
	public Clob getMessageBoard_Context()
	{
		return MessageBoard_Context;
	}
	public void setMessageBoard_Context(Clob messageBoard_Context)
	{
		MessageBoard_Context = messageBoard_Context;
	}
	public Blob getMessageBoard_Picture()
	{
		return MessageBoard_Picture;
	}
	public void setMessageBoard_Picture(Blob messageBoard_Picture)
	{
		MessageBoard_Picture = messageBoard_Picture;
	}
	public Date getMessageBoard_BuildTime()
	{
		return MessageBoard_BuildTime;
	}
	public void setMessageBoard_BuildTime(Date messageBoard_BuildTime)
	{
		MessageBoard_BuildTime = messageBoard_BuildTime;
	}
	public int getMessageBoard_Counts()
	{
		return MessageBoard_Counts;
	}
	public void setMessageBoard_Counts(int messageBoard_Counts)
	{
		MessageBoard_Counts = messageBoard_Counts;
	}
	public int getMessageBoard_Status()
	{
		return MessageBoard_Status;
	}
	public void setMessageBoard_Status(int messageBoard_Status)
	{
		MessageBoard_Status = messageBoard_Status;
	}
	
}
