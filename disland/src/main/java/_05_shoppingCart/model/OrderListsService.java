package _05_shoppingCart.model;

import java.sql.SQLException;
import java.util.Collection;

import javax.naming.NamingException;

public class OrderListsService
{
	private OrderListsDAO_interface dao;
	
	public OrderListsService() throws NamingException
	{
		dao = new OrderListsDAO();
	}
	
	public void insertOrderLists(OrderListsVO olv) throws SQLException
	{
		dao.insertOrderLists(olv);
	}
	
	public OrderListsVO getOrder(int OrderLists_ID) throws SQLException
	{
		return dao.getOrder(OrderLists_ID);
	}
	
	public Collection<OrderListsVO> getAllOrders() throws SQLException
	{
		return dao.getAllOrders();
	}
	
	public Collection<OrderListsVO> getMemberOrders() throws SQLException
	{
		return dao.getMemberOrders();
	}
}
