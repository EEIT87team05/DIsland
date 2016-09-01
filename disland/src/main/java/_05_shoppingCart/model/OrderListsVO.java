package _05_shoppingCart.model;


import java.sql.Timestamp;

public class OrderListsVO implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public OrderListsVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int OrderLists_ID;
	private int Members_ID;
	private Timestamp OrderLists_Date;
	private double OrderLists_TotalAmount;
	//==============================================================
	
	//====================getter跟setter=============================
	public int getOrderLists_ID()
	{
		return OrderLists_ID;
	}
	public void setOrderLists_ID(int orderLists_ID)
	{
		OrderLists_ID = orderLists_ID;
	}
	public int getMembers_ID()
	{
		return Members_ID;
	}
	public void setMembers_ID(int members_ID)
	{
		Members_ID = members_ID;
	}
	public Timestamp getOrderLists_Date()
	{
		return OrderLists_Date;
	}
	public void setOrderLists_Date(Timestamp orderLists_Date)
	{
		OrderLists_Date = orderLists_Date;
	}
	public double getOrderLists_TotalAmount()
	{
		return OrderLists_TotalAmount;
	}
	public void setOrderLists_TotalAmount(double orderLists_TotalAmount)
	{
		OrderLists_TotalAmount = orderLists_TotalAmount;
	}
	
}
