package _02_friend.model;

import java.sql.Timestamp;

public class FriendsMessagesVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public FriendsMessagesVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int FriendsMessages_ID;
	private int Members_ID;
	private int Members_ID2;
	private String FriendsMessages_Message;
	private Timestamp FriendsMessages_Time;
	//==============================================================
	
	//====================getter跟setter=============================
	public int getFriendsMessages_ID()
	{
		return FriendsMessages_ID;
	}
	public void setFriendsMessages_ID(int friendsMessages_ID)
	{
		FriendsMessages_ID = friendsMessages_ID;
	}
	public int getMembers_ID()
	{
		return Members_ID;
	}
	public void setMembers_ID(int members_ID)
	{
		Members_ID = members_ID;
	}
	public int getMembers_ID2()
	{
		return Members_ID2;
	}
	public void setMembers_ID2(int members_ID2)
	{
		Members_ID2 = members_ID2;
	}
	public String getFriendsMessages_Message()
	{
		return FriendsMessages_Message;
	}
	public void setFriendsMessages_Message(String friendsMessages_Message)
	{
		FriendsMessages_Message = friendsMessages_Message;
	}
	public Timestamp getFriendsMessages_Time()
	{
		return FriendsMessages_Time;
	}
	public void setFriendsMessages_Time(Timestamp friendsMessages_Time)
	{
		FriendsMessages_Time = friendsMessages_Time;
	}
	
}
