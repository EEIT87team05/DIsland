package _05_shoppingCart.model;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderListsVO implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;  
	public OrderListsVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int OrderLists_ID;
	private int Members_ID;
	private Date OrderLists_Date;
	private String OrderLists_Address;
	private String OrderLists_PaymentMethod;
	private double OrderLists_TotalAmount;
	List<ShoppingDetailsVO> details = new ArrayList<ShoppingDetailsVO>();
	//==============================================================

	//********舊的***************************************************
//	public OrderListsVO(int Members_ID,Date OrderLists_Date,double OrderLists_TotalAmount)
//	{
//		this.Members_ID = Members_ID;
//		this.OrderLists_Date = OrderLists_Date;
//		this.OrderLists_TotalAmount = OrderLists_TotalAmount;
//	}
	
	//**************************************************************
	
	public OrderListsVO(int Members_ID,Date OrderLists_Date,String OrderLists_Address,
			String OrderLists_PaymentMethod,double OrderLists_TotalAmount,List<ShoppingDetailsVO> details)
	{
		this.Members_ID = Members_ID;
		this.OrderLists_Date = OrderLists_Date;
		this.OrderLists_Address = OrderLists_Address;
		this.OrderLists_PaymentMethod = OrderLists_PaymentMethod;
		this.OrderLists_TotalAmount = OrderLists_TotalAmount;
		this.details = details;
	}
	
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
	
	
	public String getOrderLists_Address()
	{
		return OrderLists_Address;
	}

	public void setOrderLists_Address(String orderLists_Address)
	{
		OrderLists_Address = orderLists_Address;
	}

	public String getOrderLists_PaymentMethod()
	{
		return OrderLists_PaymentMethod;
	}

	public void setOrderLists_PaymentMethod(String orderLists_PaymentMethod)
	{
		OrderLists_PaymentMethod = orderLists_PaymentMethod;
	}

	public Date getOrderLists_Date()
	{
		return OrderLists_Date;
	}
	public void setOrderLists_Date(Date orderLists_Date)
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
	public List<ShoppingDetailsVO> getDetails()
	{
		return details;
	}
	public void setDetails(List<ShoppingDetailsVO> details)
	{
		this.details = details;
	}

}
