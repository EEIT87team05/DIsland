package _02_friend.model;

//實作Serializable介面
public class FriendsListVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public FriendsListVO(){} //不帶參數的建構子
	
	//====================private實例變數=============================
	private int FriendsList_ID;
	private int Members_ID;
	//==============================================================
	
	//====================getter跟setter=============================
	public int getFriendsList_ID()
	{
		return FriendsList_ID;
	}
	public void setFriendsList_ID(int friendsList_ID)
	{
		FriendsList_ID = friendsList_ID;
	}
	public int getMembers_ID()
	{
		return Members_ID;
	}
	public void setMembers_ID(int members_ID)
	{
		Members_ID = members_ID;
	}
	
}
