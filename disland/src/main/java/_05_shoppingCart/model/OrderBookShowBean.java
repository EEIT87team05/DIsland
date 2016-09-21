package _05_shoppingCart.model;

// 按下結帳時要show出來的東西,不會跟資料庫有連結,就只是放著讓我拿而已
public class OrderBookShowBean
{
	int ProductListingBook_ID = 1;			// 書本編號
	int Bqty = 0;    						// 書本購買數量
	double ProductListingBook_Price = 0;    // 書本單價
	double ProductListingBook_Discount = 1; // 書本折扣
	String ProductListingBook_Name;    	 	// 書名
	String ProductListingBook_Authors;  	// 作者
	
	// =============================================================
	
	public OrderBookShowBean()
	{
		
	}
	
	public OrderBookShowBean(int ProductListingBook_ID,int Bqty,double ProductListingBook_Price,
			double ProductListingBook_Discount,String ProductListingBook_Name,String ProductListingBook_Authors)
	{
		this.ProductListingBook_ID = ProductListingBook_ID;
		this.Bqty = Bqty;
		this.ProductListingBook_Price = ProductListingBook_Price;
		this.ProductListingBook_Discount = ProductListingBook_Discount;
		this.ProductListingBook_Name = ProductListingBook_Name;
		this.ProductListingBook_Authors = ProductListingBook_Authors;
	}

	// =============================================================
	
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
	public double getProductListingBook_Discount()
	{
		return ProductListingBook_Discount;
	}
	public void setProductListingBook_Discount(double productListingBook_Discount)
	{
		ProductListingBook_Discount = productListingBook_Discount;
	}
	public int getProductListingBook_ID()
	{
		return ProductListingBook_ID;
	}
	public void setProductListingBook_ID(int productListingBook_ID)
	{
		ProductListingBook_ID = productListingBook_ID;
	}
	public String getProductListingBook_Authors()
	{
		return ProductListingBook_Authors;
	}
	public void setProductListingBook_Authors(String productListingBook_Authors)
	{
		ProductListingBook_Authors = productListingBook_Authors;
	}
	public int getBqty()
	{
		return Bqty;
	}
	public void setBqty(int bqty)
	{
		Bqty = bqty;
	}
}
