package _05_shoppingCart.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingCart
{
	private Map<Integer, OrderBookShowBean> bookcart = new LinkedHashMap<>();
	private Map<Integer, OrderFoodShowBean> foodcart = new LinkedHashMap<>();
	
	public ShoppingCart(){}
	
	// =========================================================================
	
	public Map<Integer, OrderBookShowBean> getBookContent()
	{
		//${ShoppingCart.bookContent}
		return bookcart;
	}
	
	public Map<Integer, OrderFoodShowBean> getFoodContent()
	{
		//${ShoppingCart.foodContent}
		return foodcart;
	}
	
	// =========================================================================	
	
	//加入書本的車子
	public void addToBookCart(int ProductListingBook_ID, OrderBookShowBean obs)
	{
		
		if (obs.getBqty() <= 0)
		{
			return;
		}
		
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if (bookcart.get(ProductListingBook_ID) == null)
		{
			bookcart.put(ProductListingBook_ID, obs);
		}
		else
		{
			// 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			OrderBookShowBean obsb = bookcart.get(ProductListingBook_ID);
			// 加購的數量：obs.getQty()
			// 原有的數量：obsb.getQty()
			obsb.setBqty(obs.getBqty() + obsb.getBqty());
		}
	}
	
	//加入食品的車子
	public void addToFoodCart(int ProductListingFood_ID, OrderFoodShowBean ofs)
	{
		if (ofs.getFqty() <= 0)
		{
			return;
		}
		
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if (foodcart.get(ProductListingFood_ID) == null)
		{
			foodcart.put(ProductListingFood_ID, ofs);
		}
		else
		{
			// 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			OrderFoodShowBean ofsb = foodcart.get(ProductListingFood_ID);
			// 加購的數量：ofs.getQty()
			// 原有的數量：ofsb.getQty()
			ofsb.setFqty(ofs.getFqty() + ofsb.getFqty());
		}
	}

	// =========================================================================
	
	//修改商品數量(書)
	public boolean modifyBqty(int ProductListingBook_ID, OrderBookShowBean obs)
	{
		if (bookcart.get(ProductListingBook_ID) != null && obs.getBqty() > 0)
		{
			bookcart.put(ProductListingBook_ID, obs);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean modifyBqty(int ProductListingBook_ID,int newBqty)
	{
		if (bookcart.get(ProductListingBook_ID) != null)
		{
			OrderBookShowBean obs = bookcart.get(ProductListingBook_ID);
			obs.setBqty(newBqty);
			bookcart.put(ProductListingBook_ID, obs);
			return true;
		}
		else
		{
			return false;
		}
	}

	//修改商品數量(食品)
	public boolean modifyFqty(int ProductListingFood_ID, OrderFoodShowBean ofs)
	{
		if (foodcart.get(ProductListingFood_ID) != null && ofs.getFqty() > 0)
		{
			foodcart.put(ProductListingFood_ID, ofs);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean modifyFqty(int ProductListingFood_ID,int newFqty)
	{
		if (foodcart.get(ProductListingFood_ID) != null)
		{
			OrderFoodShowBean ofs = foodcart.get(ProductListingFood_ID);
			ofs.setFqty(newFqty);
			foodcart.put(ProductListingFood_ID, ofs);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// =========================================================================
	
	//刪除某項商品(書)
	public int deleteBook(int ProductListingBook_ID)
	{
		if (bookcart.get(ProductListingBook_ID) != null)
		{
			bookcart.remove(ProductListingBook_ID);
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	//刪除某項商品(食品)
	public int deletefood(int ProductListingFood_ID)
	{
		if (foodcart.get(ProductListingFood_ID) != null)
		{
			foodcart.remove(ProductListingFood_ID);
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	// =========================================================================
	
	public int getItemNumber()
	{
		//ShoppingCart.itemNumber
		int bn = bookcart.size();
		int fn = foodcart.size();
		int all = bn + fn;
		return all;
	}
	
	// =========================================================================
	
	// 計算購物車內所有商品的合計金額(每項商品的單價*數量的總和)
	public double getSubtotal()
	{
		double bookSubTotal = 0;
		double foodSubTotal = 0;
		Set<Integer> bSet = bookcart.keySet();
		Set<Integer> fSet = foodcart.keySet();
		
		for (Integer n : bSet)
		{
			double bPrice = bookcart.get(n).getProductListingBook_Price();
			double bDiscount = bookcart.get(n).getProductListingBook_Discount();
			int bQty = bookcart.get(n).getBqty();
			bookSubTotal += bPrice * bDiscount * bQty;
		}
		
		for (Integer n : fSet)
		{
			double fPrice = foodcart.get(n).getProductListingFood_Price();
			double fDiscount = foodcart.get(n).getProductListingFood_Discount();
			int fQty = foodcart.get(n).getFqty();
			foodSubTotal += fPrice * fDiscount * fQty;
		}
		
		return bookSubTotal + foodSubTotal;
	}
	
	// =========================================================================
}
