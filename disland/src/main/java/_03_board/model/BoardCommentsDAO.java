package _03_board.model;

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

public class BoardCommentsDAO implements BoardCommentsDAO_interface {
	private static DataSource ds = null;
	private static final String insert_stmt = "insert into BoardComments (Members_ID, MessageBoard_ID, BoardComments_Content, BoardComments_Status, BoardComments_Report, BoardComments_BuildTime) values (?,?,?,?,?,?)";
	private static final String get_all_stmt = "Select * from BoardComments order by BoardComments_BuildTime desc";
	
	static{
		try{
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		}catch(NamingException e){
			e.printStackTrace();
		}
	}

	public int insert(Integer membersId, Integer messageBoardId, String boardCommentsContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 獲取系統當前時間
		Timestamp now = new Timestamp(System.currentTimeMillis());
		int i = 0;

		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false); // 關閉自動交易

			pstmt = conn.prepareStatement(insert_stmt);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, messageBoardId);
			pstmt.setString(3, boardCommentsContent);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setTimestamp(6, now);

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
	public List<BoardCommentsVO> getAll() {
		List<BoardCommentsVO> boardCommentsList = new ArrayList<BoardCommentsVO>();
		BoardCommentsVO boardCommentsVO = null;

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
				// BoardCommentsVO 也稱為Domain Objects
				boardCommentsVO = new BoardCommentsVO();
				boardCommentsVO.setBoardComments_Id(rs.getInt("boardComments_Id"));
				boardCommentsVO.setMembers_Id(rs.getInt("members_Id"));
				boardCommentsVO.setMessageBoard_Id(rs.getInt("messageBoard_Id"));
				boardCommentsVO.setBoardComments_Content(rs.getString("boardComments_Content"));
				boardCommentsVO.setBoardComments_Reports(rs.getInt("boardComments_Report"));
				boardCommentsVO.setBoardComments_Status(rs.getInt("boardComments_Status"));
				boardCommentsVO.setBoardComments_BuildTime(rs.getTimestamp("boardComments_BuildTime"));
				boardCommentsList.add(boardCommentsVO);
			}

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
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

		return boardCommentsList;
	}

}
