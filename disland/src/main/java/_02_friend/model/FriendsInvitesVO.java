package _02_friend.model;

public class FriendsInvitesVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public FriendsInvitesVO(){}  //不帶參數的建構子
	public FriendsInvitesVO(int Members_ID,int Members_ID2)
	{
		this.Members_ID = Members_ID;
		this.Members_ID2 = Members_ID2;
	}
	
	//====================private實例變數=============================
	private int FriendsInvites_ID;
	private int Members_ID;
	private int Members_ID2;
	//==============================================================
	
	//====================getter跟setter=============================
	
	public int getFriendsInvites_ID()
	{
		return FriendsInvites_ID;
	}
	public int getMembers_ID2()
	{
		return Members_ID2;
	}
	public void setMembers_ID2(int members_ID2)
	{
		Members_ID2 = members_ID2;
	}
	public void setFriendsInvites_ID(int friendsInvites_ID)
	{
		FriendsInvites_ID = friendsInvites_ID;
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
