package _02_friend.model;

import java.util.ArrayList;
import java.util.List;

//實作Serializable介面
public class FriendsListVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public FriendsListVO(){} //不帶參數的建構子
	public FriendsListVO(int Members_ID,int Mem_Members_ID2,String name)
	{
		this.Members_ID = Members_ID;
		this.Mem_Members_ID2 = Mem_Members_ID2;
		this.name = name;
	}
	
	//====================private實例變數=============================
	private int FriendsList_ID;
	private int Members_ID;
	private int Mem_Members_ID2;
	
	private String name;
	private List<FriendsListVO> friendsList = new ArrayList<FriendsListVO>();
	//==============================================================
	
	//====================getter跟setter=============================
	
	public int getFriendsList_ID()
	{
		return FriendsList_ID;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
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
	public int getMem_Members_ID2() {
		return Mem_Members_ID2;
	}
	public void setMem_Members_ID2(int mem_Members_ID2) {
		Mem_Members_ID2 = mem_Members_ID2;
	}
	public List<FriendsListVO> getFriendsList()
	{
		return friendsList;
	}
	public void setFriendsList(List<FriendsListVO> friendsList)
	{
		this.friendsList = friendsList;
	}
	
	
	
}
