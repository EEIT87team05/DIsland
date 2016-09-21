package _05_shoppingCart.model;

import java.sql.SQLException;
import java.util.Collection;

public interface OrderListsDAO_interface
{
	public void insertOrderLists(OrderListsVO olv) throws SQLException;
	public OrderListsVO getOrder(int OrderLists_ID) throws SQLException;
	public Collection<OrderListsVO> getAllOrders() throws SQLException;
	public Collection<OrderListsVO> getMemberOrders() throws SQLException;
}
