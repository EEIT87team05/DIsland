package _05_shoppingCart.model;

import java.sql.Date;

public class ShoppingDetailsVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public ShoppingDetailsVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int ShoppingDetails_ID;
	private int Members_ID;
	private int OrderLists_ID;
	private String ShoppingDetails_Address;
	private int ProductListingBook_ID;
	private int ProductListingFood_ID;
	private int ShoppingDetails_Quantity;
	private String ShoppingDetails_PaymentMethod;  //付款方式
	private Date ShoppingDetails_Date;  
	private double ShoppingDetails_Price;  //單價
	private String ShoppingDetails_isShipments;  //處理狀況
	//==============================================================
	
	//====================getter跟setter=============================
	public int getShoppingDetails_ID()
	{
		return ShoppingDetails_ID;
	}
	public void setShoppingDetails_ID(int shoppingDetails_ID)
	{
		ShoppingDetails_ID = shoppingDetails_ID;
	}
	public int getMembers_ID()
	{
		return Members_ID;
	}
	public void setMembers_ID(int members_ID)
	{
		Members_ID = members_ID;
	}
	public int getOrderLists_ID()
	{
		return OrderLists_ID;
	}
	public void setOrderLists_ID(int orderLists_ID)
	{
		OrderLists_ID = orderLists_ID;
	}
	public String getShoppingDetails_Address()
	{
		return ShoppingDetails_Address;
	}
	public void setShoppingDetails_Address(String shoppingDetails_Address)
	{
		ShoppingDetails_Address = shoppingDetails_Address;
	}
	public int getProductListingBook_ID()
	{
		return ProductListingBook_ID;
	}
	public void setProductListingBook_ID(int productListingBook_ID)
	{
		ProductListingBook_ID = productListingBook_ID;
	}
	public int getProductListingFood_ID()
	{
		return ProductListingFood_ID;
	}
	public void setProductListingFood_ID(int productListingFood_ID)
	{
		ProductListingFood_ID = productListingFood_ID;
	}
	public int getShoppingDetails_Quantity()
	{
		return ShoppingDetails_Quantity;
	}
	public void setShoppingDetails_Quantity(int shoppingDetails_Quantity)
	{
		ShoppingDetails_Quantity = shoppingDetails_Quantity;
	}
	public String getShoppingDetails_PaymentMethod()
	{
		return ShoppingDetails_PaymentMethod;
	}
	public void setShoppingDetails_PaymentMethod(String shoppingDetails_PaymentMethod)
	{
		ShoppingDetails_PaymentMethod = shoppingDetails_PaymentMethod;
	}
	public Date getShoppingDetails_Date()
	{
		return ShoppingDetails_Date;
	}
	public void setShoppingDetails_Date(Date shoppingDetails_Date)
	{
		ShoppingDetails_Date = shoppingDetails_Date;
	}
	public double getShoppingDetails_Price()
	{
		return ShoppingDetails_Price;
	}
	public void setShoppingDetails_Price(double shoppingDetails_Price)
	{
		ShoppingDetails_Price = shoppingDetails_Price;
	}
	public String getShoppingDetails_isShipments()
	{
		return ShoppingDetails_isShipments;
	}
	public void setShoppingDetails_isShipments(String shoppingDetails_isShipments)
	{
		ShoppingDetails_isShipments = shoppingDetails_isShipments;
	}
	
}
