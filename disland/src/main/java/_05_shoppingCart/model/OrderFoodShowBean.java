package _05_shoppingCart.model;

//按下結帳時要show出來的東西,不會跟資料庫有連結,就只是放著讓我拿而已
public class OrderFoodShowBean
{
	int ProductListingFood_ID = 1;			// 食品編號
	int Fqty = 0;    						// 食品購買數量
	double ProductListingFood_Price = 0;    // 食品單價
	double ProductListingFood_Discount = 1; // 食品折扣
	String ProductListingFood_Name;     	// 食品名
	String ProductListingFood_Firm;			// 製造公司
	
	// =============================================================
	
	public OrderFoodShowBean()
	{
		
	}
	
	public OrderFoodShowBean(int ProductListingFood_ID,int Fqty,double ProductListingFood_Price,
			double ProductListingFood_Discount,String ProductListingFood_Name,String ProductListingFood_Firm)
	{
		this.ProductListingFood_ID = ProductListingFood_ID;
		this.Fqty = Fqty;
		this.ProductListingFood_Price = ProductListingFood_Price;
		this.ProductListingFood_Discount = ProductListingFood_Discount;
		this.ProductListingFood_Name = ProductListingFood_Name;
		this.ProductListingFood_Firm = ProductListingFood_Firm;
	}
	
	// =============================================================

	public int getProductListingFood_ID()
	{
		return ProductListingFood_ID;
	}

	public void setProductListingFood_ID(int productListingFood_ID)
	{
		ProductListingFood_ID = productListingFood_ID;
	}

	public int getFqty()
	{
		return Fqty;
	}

	public void setFqty(int fqty)
	{
		Fqty = fqty;
	}

	public double getProductListingFood_Price()
	{
		return ProductListingFood_Price;
	}

	public void setProductListingFood_Price(double productListingFood_Price)
	{
		ProductListingFood_Price = productListingFood_Price;
	}

	public double getProductListingFood_Discount()
	{
		return ProductListingFood_Discount;
	}

	public void setProductListingFood_Discount(double productListingFood_Discount)
	{
		ProductListingFood_Discount = productListingFood_Discount;
	}

	public String getProductListingFood_Name()
	{
		return ProductListingFood_Name;
	}

	public void setProductListingFood_Name(String productListingFood_Name)
	{
		ProductListingFood_Name = productListingFood_Name;
	}

	public String getProductListingFood_Firm()
	{
		return ProductListingFood_Firm;
	}

	public void setProductListingFood_Firm(String productListingFood_Firm)
	{
		ProductListingFood_Firm = productListingFood_Firm;
	}
}
