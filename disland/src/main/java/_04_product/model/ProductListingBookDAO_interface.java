package _04_product.model;

import java.sql.SQLException;
import java.util.*;

public interface ProductListingBookDAO_interface
{
	public void insert (ProductListingBookVO productListingBookVO) throws SQLException;
	public void update (ProductListingBookVO productListingBookVO) throws SQLException;
	public void delete (Integer ProductListingBook_ID) throws SQLException;
	public ProductListingBookVO findByPrimaryKey(Integer ProductListingBook_ID) throws SQLException;
	public List<ProductListingBookVO> getAll() throws SQLException;
	public int getRecordCounts() throws SQLException; //從資料庫ProductListingBook表格計算總共有幾本書
}
