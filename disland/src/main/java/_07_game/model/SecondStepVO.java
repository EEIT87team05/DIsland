package _07_game.model;

import java.io.Serializable;

public class SecondStepVO implements Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public SecondStepVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int SecondStep_ID;
	private int Members_ID;
	private int Members_ID2;
	//==============================================================
	
	//====================getter跟setter=============================
	public int getSecondStep_ID()
	{
		return SecondStep_ID;
	}
	public void setSecondStep_ID(int secondStep_ID)
	{
		SecondStep_ID = secondStep_ID;
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
	
}
