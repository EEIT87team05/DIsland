package _04_product.model;

import java.sql.Blob;
import java.sql.Date;

//Java提供一種機制叫做序列化，通過有序的格式或者位元組序列持久化java物件，其中包含物件的資料，還有物件的型別，和儲存在物件中的資料型別。
//所以，如果我們已經序列化了一個物件，那麼它可以被讀取並通過物件的型別和其他資訊進行反序列化，並最終獲取物件的原型。
//那麼哪裡會需要序列化呢？序列化通常在需要通過網路傳輸資料，或者儲存物件到檔案的場合使用。這裡說的資料是物件而不是文字。
//現在的問題是，我們的網路架構和硬碟都只能識別二進位制和位元組，而不能識別Java物件。
//序列化就是把Java物件中的value/states翻譯為位元組，以便通過網路傳輸或者儲存。另外，反序列化就是通過讀取位元組碼，並把它翻譯回java物件。
public class ProductListingBookVO implements java.io.Serializable
{
	//serialVersionUID作用：序列化時為了保持版本的兼容性，即在版本升級時反序列化仍保持對象的唯一性。
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public ProductListingBookVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private Integer ProductListingBook_ID;
	private String ProductListingBook_Name;
	private Double ProductListingBook_Price;
	private Float ProductListingBook_Discount;
	private Integer ProductListingBook_Quantity;
	private Date ProductListingBook_Publishedate;
	private String ProductListingBook_Publisher; 
	private Blob ProductListingBook_Picture;
	private String ProductListingBook_Authors;
	private String ProductListingBook_Des;  //書本簡介
	
	private String  discountStr;
	
	//==============================================================
	
	public Integer getProductListingBook_ID() {
		return ProductListingBook_ID;
	}
	public String getDiscountStr() {
		return discountStr;
	}
	public void setDiscountStr(String discountStr) {
		this.discountStr = discountStr;
	}
	public void setProductListingBook_ID(Integer productListingBook_ID) {
		ProductListingBook_ID = productListingBook_ID;
	}
	public String getProductListingBook_Name() {
		return ProductListingBook_Name;
	}
	public void setProductListingBook_Name(String productListingBook_Name) {
		ProductListingBook_Name = productListingBook_Name;
	}
	public Double getProductListingBook_Price() {
		return ProductListingBook_Price;
	}
	public void setProductListingBook_Price(Double productListingBook_Price) {
		ProductListingBook_Price = productListingBook_Price;
	}
	public Float getProductListingBook_Discount() {
		return ProductListingBook_Discount;
	}
	public void setProductListingBook_Discount(Float productListingBook_Discount) {
		ProductListingBook_Discount = productListingBook_Discount;
		if (productListingBook_Discount == 1) {
			discountStr = "";
		} else {
			int dnt = (int)(productListingBook_Discount * 100);
			if (dnt % 10 == 0) {
				discountStr = (dnt / 10) + "折";
			} else {
				discountStr = " "  + dnt + "折";
			} 
			
		}
	}
	public Integer getProductListingBook_Quantity() {
		return ProductListingBook_Quantity;
	}
	public void setProductListingBook_Quantity(Integer productListingBook_Quantity) {
		ProductListingBook_Quantity = productListingBook_Quantity;
	}
	public Date getProductListingBook_Publishedate() {
		return ProductListingBook_Publishedate;
	}
	public void setProductListingBook_Publishedate(Date productListingBook_Publishedate) {
		ProductListingBook_Publishedate = productListingBook_Publishedate;
	}
	public String getProductListingBook_Publisher() {
		return ProductListingBook_Publisher;
	}
	public void setProductListingBook_Publisher(String productListingBook_Publisher) {
		ProductListingBook_Publisher = productListingBook_Publisher;
	}
	public Blob getProductListingBook_Picture() {
		return ProductListingBook_Picture;
	}
	public void setProductListingBook_Picture(Blob productListingBook_Picture) {
		ProductListingBook_Picture = productListingBook_Picture;
	}
	public String getProductListingBook_Authors() {
		return ProductListingBook_Authors;
	}
	public void setProductListingBook_Authors(String productListingBook_Authors) {
		ProductListingBook_Authors = productListingBook_Authors;
	}
	public String getProductListingBook_Des() {
		return ProductListingBook_Des;
	}
	public void setProductListingBook_Des(String productListingBook_Des) {
		ProductListingBook_Des = productListingBook_Des;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//====================getter跟setter=============================
	

	
}
