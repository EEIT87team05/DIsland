package _05_shoppingCart.model;

import java.util.Date;

public class ShoppingDetailsVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  
	public ShoppingDetailsVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int ShoppingDetails_ID;
	private int Members_ID;
	private int OrderLists_ID;
//	private String ShoppingDetails_Address;
	private int ProductListingBook_ID;
	private int ProductListingFood_ID;
	private int ShoppingDetails_BookQuantity;
	private int ShoppingDetails_FoodQuantity;
//	private String ShoppingDetails_PaymentMethod;  //付款方式
	private Date ShoppingDetails_Date;  
	private double ShoppingDetails_BookPrice;  //單價
	private double ShoppingDetails_FoodPrice;  //單價
	private String ShoppingDetails_isShipments;  //處理狀況
	
	private String ProductListingBook_Name;
	private String ProductListingFood_Name;
	private double ProductListingBook_Discount;
	private double ProductListingFood_Discount;
	
	
	//==============================================================
	
	//********舊的***************************************************
	
//	public ShoppingDetailsVO(int Members_ID,int OrderLists_ID,String ShoppingDetails_Address,
//			int ProductListingBook_ID,int ProductListingFood_ID,int ShoppingDetails_BookQuantity,
//			int ShoppingDetails_FoodQuantity,String ShoppingDetails_PaymentMethod,Date ShoppingDetails_Date,
//			double ShoppingDetails_BookPrice,double ShoppingDetails_FoodPrice,String ShoppingDetails_isShipments)
//	{
//		this.Members_ID = Members_ID;
//		this.OrderLists_ID = OrderLists_ID;
//		this.ShoppingDetails_Address = ShoppingDetails_Address;
//		this.ProductListingBook_ID = ProductListingBook_ID;
//		this.ProductListingFood_ID = ProductListingFood_ID;
//		this.ShoppingDetails_BookQuantity = ShoppingDetails_BookQuantity;
//		this.ShoppingDetails_FoodQuantity = ShoppingDetails_FoodQuantity;		
//		this.ShoppingDetails_PaymentMethod = ShoppingDetails_PaymentMethod;
//		this.ShoppingDetails_Date = ShoppingDetails_Date;
//		this.ShoppingDetails_BookPrice = ShoppingDetails_BookPrice;
//		this.ShoppingDetails_FoodPrice = ShoppingDetails_FoodPrice;
//		this.ShoppingDetails_isShipments = ShoppingDetails_isShipments;
//	}
	
	//******************************************************************
	
	public ShoppingDetailsVO(int Members_ID,int OrderLists_ID,
			int ProductListingBook_ID,int ProductListingFood_ID,int ShoppingDetails_BookQuantity,
			int ShoppingDetails_FoodQuantity,Date ShoppingDetails_Date,
			double ShoppingDetails_BookPrice,double ShoppingDetails_FoodPrice,String ShoppingDetails_isShipments,
			String ProductListingBook_Name,String ProductListingFood_Name,double ProductListingBook_Discount,
			double ProductListingFood_Discount)
	{
		this.Members_ID = Members_ID;
		this.OrderLists_ID = OrderLists_ID;
		this.ProductListingBook_ID = ProductListingBook_ID;
		this.ProductListingFood_ID = ProductListingFood_ID;
		this.ShoppingDetails_BookQuantity = ShoppingDetails_BookQuantity;
		this.ShoppingDetails_FoodQuantity = ShoppingDetails_FoodQuantity;		
		this.ShoppingDetails_Date = ShoppingDetails_Date;
		this.ShoppingDetails_BookPrice = ShoppingDetails_BookPrice;
		this.ShoppingDetails_FoodPrice = ShoppingDetails_FoodPrice;
		this.ShoppingDetails_isShipments = ShoppingDetails_isShipments;
		this.ProductListingBook_Name = ProductListingBook_Name;
		this.ProductListingFood_Name = ProductListingFood_Name;
		this.ProductListingBook_Discount = ProductListingBook_Discount;
		this.ProductListingFood_Discount = ProductListingFood_Discount;
	}
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
//	public String getShoppingDetails_Address()
//	{
//		return ShoppingDetails_Address;
//	}
//	public void setShoppingDetails_Address(String shoppingDetails_Address)
//	{
//		ShoppingDetails_Address = shoppingDetails_Address;
//	}
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
	
	public int getShoppingDetails_BookQuantity()
	{
		return ShoppingDetails_BookQuantity;
	}

	public void setShoppingDetails_BookQuantity(int shoppingDetails_BookQuantity)
	{
		ShoppingDetails_BookQuantity = shoppingDetails_BookQuantity;
	}

	public int getShoppingDetails_FoodQuantity()
	{
		return ShoppingDetails_FoodQuantity;
	}

	public void setShoppingDetails_FoodQuantity(int shoppingDetails_FoodQuantity)
	{
		ShoppingDetails_FoodQuantity = shoppingDetails_FoodQuantity;
	}

//	public String getShoppingDetails_PaymentMethod()
//	{
//		return ShoppingDetails_PaymentMethod;
//	}
//	public void setShoppingDetails_PaymentMethod(String shoppingDetails_PaymentMethod)
//	{
//		ShoppingDetails_PaymentMethod = shoppingDetails_PaymentMethod;
//	}
	public Date getShoppingDetails_Date()
	{
		return ShoppingDetails_Date;
	}
	public void setShoppingDetails_Date(Date shoppingDetails_Date)
	{
		ShoppingDetails_Date = shoppingDetails_Date;
	}
	
	public double getShoppingDetails_BookPrice()
	{
		return ShoppingDetails_BookPrice;
	}

	public void setShoppingDetails_BookPrice(double shoppingDetails_BookPrice)
	{
		ShoppingDetails_BookPrice = shoppingDetails_BookPrice;
	}

	public double getShoppingDetails_FoodPrice()
	{
		return ShoppingDetails_FoodPrice;
	}

	public void setShoppingDetails_FoodPrice(double shoppingDetails_FoodPrice)
	{
		ShoppingDetails_FoodPrice = shoppingDetails_FoodPrice;
	}

	public String getShoppingDetails_isShipments()
	{
		return ShoppingDetails_isShipments;
	}
	public void setShoppingDetails_isShipments(String shoppingDetails_isShipments)
	{
		ShoppingDetails_isShipments = shoppingDetails_isShipments;
	}
	public String getProductListingBook_Name()
	{
		return ProductListingBook_Name;
	}
	public void setProductListingBook_Name(String productListingBook_Name)
	{
		ProductListingBook_Name = productListingBook_Name;
	}
	public String getProductListingFood_Name()
	{
		return ProductListingFood_Name;
	}
	public void setProductListingFood_Name(String productListingFood_Name)
	{
		ProductListingFood_Name = productListingFood_Name;
	}
	public double getProductListingBook_Discount()
	{
		return ProductListingBook_Discount;
	}
	public void setProductListingBook_Discount(double productListingBook_Discount)
	{
		ProductListingBook_Discount = productListingBook_Discount;
	}
	public double getProductListingFood_Discount()
	{
		return ProductListingFood_Discount;
	}
	public void setProductListingFood_Discount(double productListingFood_Discount)
	{
		ProductListingFood_Discount = productListingFood_Discount;
	}
	
}
