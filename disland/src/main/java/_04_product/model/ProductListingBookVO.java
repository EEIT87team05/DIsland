package _04_product.model;

import java.sql.Blob;
import java.sql.Date;

public class ProductListingBookVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public ProductListingBookVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int ProductListingBook_ID;
	private String ProductListingBook_Name;
	private double ProductListingBook_Price;
	private float ProductListingBook_Discount;
	private int ProductListingBook_Quantity;
	private Date ProductListingBook_Publishedate;
	private String ProductListingBook_Publisher; 
	private Blob ProductListingBook_Picture;
	private String ProductListingBook_Authors;
	private String ProductListingBook_Des;  //書本簡介
	//==============================================================

	//====================getter跟setter=============================
	public int getProductListingBook_ID()
	{
		return ProductListingBook_ID;
	}
	public void setProductListingBook_ID(int productListingBook_ID)
	{
		ProductListingBook_ID = productListingBook_ID;
	}
	public String getProductListingBook_Name()
	{
		return ProductListingBook_Name;
	}
	public void setProductListingBook_Name(String productListingBook_Name)
	{
		ProductListingBook_Name = productListingBook_Name;
	}
	public double getProductListingBook_Price()
	{
		return ProductListingBook_Price;
	}
	public void setProductListingBook_Price(double productListingBook_Price)
	{
		ProductListingBook_Price = productListingBook_Price;
	}
	public float getProductListingBook_Discount()
	{
		return ProductListingBook_Discount;
	}
	public void setProductListingBook_Discount(float productListingBook_Discount)
	{
		ProductListingBook_Discount = productListingBook_Discount;
	}
	public int getProductListingBook_Quantity()
	{
		return ProductListingBook_Quantity;
	}
	public void setProductListingBook_Quantity(int productListingBook_Quantity)
	{
		ProductListingBook_Quantity = productListingBook_Quantity;
	}
	public Date getProductListingBook_Publishedate()
	{
		return ProductListingBook_Publishedate;
	}
	public void setProductListingBook_Publishedate(Date productListingBook_Publishedate)
	{
		ProductListingBook_Publishedate = productListingBook_Publishedate;
	}
	public String getProductListingBook_Publisher()
	{
		return ProductListingBook_Publisher;
	}
	public void setProductListingBook_Publisher(String productListingBook_Publisher)
	{
		ProductListingBook_Publisher = productListingBook_Publisher;
	}
	public Blob getProductListingBook_Picture()
	{
		return ProductListingBook_Picture;
	}
	public void setProductListingBook_Picture(Blob productListingBook_Picture)
	{
		ProductListingBook_Picture = productListingBook_Picture;
	}
	public String getProductListingBook_Authors()
	{
		return ProductListingBook_Authors;
	}
	public void setProductListingBook_Authors(String productListingBook_Authors)
	{
		ProductListingBook_Authors = productListingBook_Authors;
	}
	public String getProductListingBook_Des()
	{
		return ProductListingBook_Des;
	}
	public void setProductListingBook_Des(String productListingBook_Des)
	{
		ProductListingBook_Des = productListingBook_Des;
	}
	
}
