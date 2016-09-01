package _04_product.model;

import java.sql.Blob;
import java.sql.Date;

public class ProductListingFoodVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public ProductListingFoodVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int ProductListingFood_ID;
	private String ProductListingFood_Name;
	private double ProductListingFood_Price;
	private float ProductListingFood_Discount;
	private int ProductListingFood_Quantity;
	private Date ProductListingFood_ManuFacture;  //製造日期
	private Date ProductListingFood_Expiredate;  //到期日
	private Blob ProductListingFood_Picture;
	private String ProductListingFood_Firm;  //製造商
	private String ProductListingFood_Des; //食品簡介
	//==============================================================

	//====================getter跟setter=============================
	public int getProductListingFood_ID()
	{
		return ProductListingFood_ID;
	}
	public void setProductListingFood_ID(int productListingFood_ID)
	{
		ProductListingFood_ID = productListingFood_ID;
	}
	public String getProductListingFood_Name()
	{
		return ProductListingFood_Name;
	}
	public void setProductListingFood_Name(String productListingFood_Name)
	{
		ProductListingFood_Name = productListingFood_Name;
	}
	public double getProductListingFood_Price()
	{
		return ProductListingFood_Price;
	}
	public void setProductListingFood_Price(double productListingFood_Price)
	{
		ProductListingFood_Price = productListingFood_Price;
	}
	public float getProductListingFood_Discount()
	{
		return ProductListingFood_Discount;
	}
	public void setProductListingFood_Discount(float productListingFood_Discount)
	{
		ProductListingFood_Discount = productListingFood_Discount;
	}
	public int getProductListingFood_Quantity()
	{
		return ProductListingFood_Quantity;
	}
	public void setProductListingFood_Quantity(int productListingFood_Quantity)
	{
		ProductListingFood_Quantity = productListingFood_Quantity;
	}
	public Date getProductListingFood_ManuFacture()
	{
		return ProductListingFood_ManuFacture;
	}
	public void setProductListingFood_ManuFacture(Date productListingFood_ManuFacture)
	{
		ProductListingFood_ManuFacture = productListingFood_ManuFacture;
	}
	public Date getProductListingFood_Expiredate()
	{
		return ProductListingFood_Expiredate;
	}
	public void setProductListingFood_Expiredate(Date productListingFood_Expiredate)
	{
		ProductListingFood_Expiredate = productListingFood_Expiredate;
	}
	public Blob getProductListingFood_Picture()
	{
		return ProductListingFood_Picture;
	}
	public void setProductListingFood_Picture(Blob productListingFood_Picture)
	{
		ProductListingFood_Picture = productListingFood_Picture;
	}
	public String getProductListingFood_Firm()
	{
		return ProductListingFood_Firm;
	}
	public void setProductListingFood_Firm(String productListingFood_Firm)
	{
		ProductListingFood_Firm = productListingFood_Firm;
	}
	public String getProductListingFood_Des()
	{
		return ProductListingFood_Des;
	}
	public void setProductListingFood_Des(String productListingFood_Des)
	{
		ProductListingFood_Des = productListingFood_Des;
	}

}
