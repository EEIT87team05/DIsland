package _08_game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SecondStepVO implements Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public SecondStepVO(){}  //不帶參數的建構子
	
	public  SecondStepVO(Integer Members_ID,Integer Members_ID2) {
		this.Members_ID = Members_ID;
		this.Members_ID2 = Members_ID2;
	}
	
	//====================private實例變數=============================
	private Integer SecondStep_ID;
	private Integer Members_ID;
	private Integer Members_ID2;
	
	//==============================================================
	


	//====================getter跟setter=============================
	public Integer getSecondStep_ID()
	{
		return SecondStep_ID;
	}
	public void setSecondStep_ID(Integer secondStep_ID)
	{
		SecondStep_ID = secondStep_ID;
	}
	public Integer getMembers_ID()
	{
		return Members_ID;
	}
	public void setMembers_ID(Integer members_ID)
	{
		Members_ID = members_ID;
	}
	public Integer getMembers_ID2()
	{
		return Members_ID2;
	}
	public void setMembers_ID2(Integer members_ID2)
	{
		Members_ID2 = members_ID2;
	}
	
	
}
