package _03_board.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_init.GlobalService;

public class MessageBoardDAO implements MessageBoardDAO_interface {
	private static DataSource ds = null;
	private static final String insert_stmt = "insert into MessageBoard (Members_ID, MessageBoard_Content, MessageBoard_Name, MessageBoard_Picture, MessageBoard_BuildTime, MessageBoard_Counts, MessageBoard_Status, MessageBoard_Report) values (?,?,?,?,?,?,?,?)";

	private static final String update_ALL_stmt = "Update MessageBoard set MessageBoard_Content=?, MessageBoard_Picture=?, MessageBoard_FileName=?, MessageBoard_Counts=?, MessageBoard_Status=?, MessageBoard_Reports=? where MessageBoard_ID = ?";
	private static final String update_Counts_stmt = "Update MessageBoard set MessageBoard_Counts=? where MessageBoard_ID=?";
	private static final String update_Reports_stmt = "Update MessageBoard set MessageBoard_Reports=? where MessageBoard_ID=?";

	private static final String delete_stmt = "Delete from MessageBoard where MessageBoard_ID = ?";
	private static final String get_one_stmt = "Select * from MessageBoard where MessageBoard_ID = ?";
	private static final String get_all_stmt = "Select * from MessageBoard order by MessageBoard_BuildTime desc";

	static {
		try {
			// 要使用JNDI
			Context ctx = new InitialContext();
			// 取得連線物件
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public int insert(Integer members_ID, String MessageBoard_Content, String fileName, InputStream fin) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 定義格式不顯示毫秒
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// 獲取系統當前時間
		Timestamp now = new Timestamp(System.currentTimeMillis());
		int i = 0;

		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false); // 關閉自動交易

			pstmt = conn.prepareStatement(insert_stmt);
			pstmt.setInt(1, members_ID);
			pstmt.setString(2, MessageBoard_Content);
			pstmt.setString(3, fileName);
			pstmt.setBinaryStream(4, fin);
			pstmt.setTimestamp(5, now);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);

			i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("成功");
			} else {
				throw new SQLException("新增記錄數 : 0");
			}

			conn.commit();
			conn.setAutoCommit(true);// 開啟自動交易

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return i;
	}

	@Override
	public void updateAll(MessageBoardVO messageBoardVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(update_ALL_stmt);

			pstmt.setString(1, messageBoardVO.getMessageBoard_Content());
			pstmt.setBlob(2, messageBoardVO.getMessageBoard_Picture());
			pstmt.setString(3, messageBoardVO.getMessageBoard_Name());
			pstmt.setInt(4, messageBoardVO.getMessageBoard_Counts());
			pstmt.setInt(5, messageBoardVO.getMessageBoard_Status());
			pstmt.setInt(6, messageBoardVO.getMessageBoard_Report());
			pstmt.setInt(7, messageBoardVO.getMessageBoard_Id());

			i = pstmt.executeUpdate();
			System.out.println("update success count = " + i);

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void updateCounts(MessageBoardVO messageBoardVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(update_Counts_stmt);

			pstmt.setInt(1, messageBoardVO.getMessageBoard_Counts());
			pstmt.setInt(2, messageBoardVO.getMessageBoard_Id());

			i = pstmt.executeUpdate();
			System.out.println("update success count = " + i);

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void updateReports(MessageBoardVO messageBoardVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(update_Reports_stmt);

			pstmt.setInt(1, messageBoardVO.getMessageBoard_Report());
			pstmt.setInt(2, messageBoardVO.getMessageBoard_Id());

			i = pstmt.executeUpdate();
			System.out.println("update success count = " + i);

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(Integer getMessageBoard_Id) {
		MessageBoardVO messageBoardVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(delete_stmt);

			pstmt.setInt(1, messageBoardVO.getMessageBoard_Id());

			i = pstmt.executeUpdate();
			System.out.println("delete success count = " + i);

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public MessageBoardVO findByPrimaryKey(Integer messageBoard_Id) {
		MessageBoardVO messageBoardVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(get_one_stmt);

			pstmt.setInt(1, messageBoard_Id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				messageBoardVO = new MessageBoardVO();
				messageBoardVO.setMessageBoard_Id(rs.getInt("messageBoard_Id"));
				messageBoardVO.setMembers_Id(rs.getInt("members_Id"));
				messageBoardVO.setMessageBoard_Content(rs.getString("messageBoard_Content"));
				messageBoardVO.setMessageBoard_Name(rs.getString("messageBoard_Name"));
				messageBoardVO.setMessageBoard_Picture(rs.getBlob("messageBoard_Picture"));
				messageBoardVO.setMessageBoard_BuildTime(rs.getTimestamp("messageBoard_BuildTime"));
				messageBoardVO.setMessageBoard_Counts(rs.getInt("messageBoard_Counts"));
				messageBoardVO.setMessageBoard_Report(rs.getInt("messageBoard_Report"));
				messageBoardVO.setMessageBoard_Status(rs.getInt("messageBoard_Status"));
			}

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return messageBoardVO;
	}

	@Override
	public List<MessageBoardVO> getAll() {
		List<MessageBoardVO> list = new ArrayList<MessageBoardVO>();
		MessageBoardVO messageBoardVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(get_all_stmt);
			// pstmt.setInt(1, messageBoard_Id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// MessageBoardVO 也稱為Domain Objects
				messageBoardVO = new MessageBoardVO();
				messageBoardVO.setMessageBoard_Id(rs.getInt("messageBoard_Id"));
				messageBoardVO.setMembers_Id(rs.getInt("members_Id"));
				messageBoardVO.setMessageBoard_Content(rs.getString("messageBoard_Content"));
				messageBoardVO.setMessageBoard_Name(rs.getString("messageBoard_Name"));
				messageBoardVO.setMessageBoard_Picture(rs.getBlob("messageBoard_Picture"));
				messageBoardVO.setMessageBoard_BuildTime(rs.getTimestamp("messageBoard_BuildTime"));
				messageBoardVO.setMessageBoard_Counts(rs.getInt("messageBoard_Counts"));
				messageBoardVO.setMessageBoard_Report(rs.getInt("messageBoard_Report"));
				messageBoardVO.setMessageBoard_Status(rs.getInt("messageBoard_Status"));
				list.add(messageBoardVO);
			}

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return list;
	}

}