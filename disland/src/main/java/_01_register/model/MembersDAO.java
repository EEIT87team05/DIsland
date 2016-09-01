package _01_register.model;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;

import _00_init.GlobalService;

public class MembersDAO implements MembersDAO_interface
{
	private DataSource ds = null;
	
	private static final String insert_stmt = "insert into Members (Members_Name,Members_Nickname,Members_Account,Members_Password,"
			+ "Members_Gender,Members_MainPicture,Members_VicePicture1,Members_VicePicture2,"
			+ "Members_Height,Members_Weight,Members_RelationshipState,"
			+ "Members_Sexuality,Members_City,Members_Area,Members_Address,Members_Telephone,"
			+ "Members_Constellation,Members_Birthday,Members_Itroduce,Members_Money,Members_FacebookAccount,"
			+ "Members_GoogleAccount,Members_isChecked,Members_isPay,Interests_ID,Members_Job,Members_isGetMail,"
			+ "Members_RegisetTime,Members_LastLoginTime) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String update_stmt = "Update Members (Members_Name=?, Members_Nickname=?, Members_Account=?, Members_Password=?,"
			+ "Members_Gender=?, Members_MainPicture=?, Members_VicePicture1=?, Members_VicePicture2=?,"
			+ "Members_Height=?, Members_Weight=?, Members_RelationshipState=?,"
			+ "Members_Sexuality=?, Members_City=?, Members_Area=?, Members_Address=?, Members_Telephone=?,"
			+ "Members_Constellation=?,Members_Birthday=?,Members_Itroduce=?,Members_Money=?,Members_FacebookAccount=?,"
			+ "Members_GoogleAccount=?,Members_isChecked=?,Members_isPay=?,Interests_ID=?,Members_Job=?,Members_isGetMail=?)"
			+ " where Members_ID = ?";
	
	private static final String delete_stmt = "Delete from Members where Members_ID = ?";
	
	private static final String get_one_stmt = "SELECT Members_Name,Members_Nickname,Members_Account,Members_Password,"
			+ "Members_Gender,Members_MainPicture,Members_VicePicture1,Members_VicePicture2,"
			+ "Members_Height,Members_Weight,Members_RelationshipState,"
			+ "Members_Sexuality,Members_City,Members_Area,Members_Address,Members_Telephone,"
			+ "Members_Constellation,Members_Birthday,Members_Itroduce,Members_Money,Members_FacebookAccount,"
			+ "Members_GoogleAccount,Members_isChecked,Members_isPay,Interests_ID,Members_Job,Members_isGetMail,"
			+ "Members_RegisetTime,Members_LastLoginTime "
			+ "FROM Members where Members_ID = ?";
	
	private static final String get_all_stmt = "SELECT m.*, i.Interests_Name FROM Members m JOIN Interests i ON m.Interests_ID = i.Interests_ID ORDER BY m.Members_ID";
	
	public MembersDAO() throws NamingException
	{
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}

	@Override
	synchronized public void insert(MembersVO memberVO, InputStream is, long size, String filename) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(insert_stmt);
			
			pstmt.setString(1, memberVO.getMembers_Name());     /*會員真實姓名*/	
			pstmt.setString(2, memberVO.getMembers_Nickname());/*會員暱稱*/
			pstmt.setString(3, memberVO.getMembers_Account()); /*會員帳號*/
			pstmt.setString(4, memberVO.getMembers_Password());/*會員密碼*/
			pstmt.setInt(5, memberVO.getMembers_Gender());
			
			//----------------要研究--------------------
			pstmt.setBinaryStream(6, is, size);
			pstmt.setBinaryStream(7, is, size);
			pstmt.setBinaryStream(8, is, size);
			//----------------------------------------
			
			pstmt.setString(9, memberVO.getMembers_Height());
			pstmt.setString(10, memberVO.getMembers_Weight());
			pstmt.setString(11, memberVO.getMembers_RelationshipState());
			pstmt.setString(12, memberVO.getMembers_Sexuality());
			pstmt.setString(13, memberVO.getMembers_City());
			pstmt.setString(14, memberVO.getMembers_Area());
			pstmt.setString(15, memberVO.getMembers_Address());
			pstmt.setString(16, memberVO.getMembers_Telephone());
			pstmt.setString(17, memberVO.getMembers_Constellation());
			pstmt.setDate(18, memberVO.getMembers_Birthday());
			pstmt.setClob(19, memberVO.getMembers_Itroduce());
			pstmt.setDouble(20, memberVO.getMembers_Money());
			pstmt.setString(21, memberVO.getMembers_FacebookAccount());
			pstmt.setString(22, memberVO.getMembers_GoogleAccount());
			pstmt.setInt(23, memberVO.getMembers_isChecked());
			pstmt.setInt(24, memberVO.getMembers_isPay());
			pstmt.setInt(25, memberVO.getInterests_ID());
			pstmt.setString(26, memberVO.getMembers_Job());
			pstmt.setInt(27, memberVO.getMembers_isGetMail());
			
			java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(28, now);
			
			java.sql.Timestamp last = new java.sql.Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(29, last);
			
			i = pstmt.executeUpdate();
			
			System.out.println("資料新增成功筆數 = " + i);
			
//			if (i == 1)
//			{
//				// 寫入成功，應該將MemberBean mem立即加入LoginService的memberList內
//				// 否則，最新的User將無法登入
//				mb.setPassword(GlobalService.getMD5Endocing(encrypedString));
//				memberList.add(mb);
//			} else
//			{
//				throw new SQLException("RegisterServiceDB:新增記錄數 : 0");
//			}
//			// System.out.println("新增一筆eMember紀錄，是否成功=" + r);
			
		}catch (SQLException e)
		{
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}finally
		{
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					System.err.println("關閉相關物件時發生例外: " + e);
				}
			}
		}
		
	}

	@Override
	synchronized public void update(MembersVO memberVO, InputStream is, long size, String filename)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(update_stmt);
			
			pstmt.setString(1, memberVO.getMembers_Name());     /*會員真實姓名*/	
			pstmt.setString(2, memberVO.getMembers_Nickname());/*會員暱稱*/
			pstmt.setString(3, memberVO.getMembers_Account()); /*會員帳號*/
			pstmt.setString(4, memberVO.getMembers_Password());/*會員密碼*/
			pstmt.setInt(5, memberVO.getMembers_Gender());
			
			//----------------要研究--------------------
			pstmt.setBinaryStream(6, is, size);
			pstmt.setBinaryStream(7, is, size);
			pstmt.setBinaryStream(8, is, size);
			//----------------------------------------
			
			pstmt.setString(9, memberVO.getMembers_Height());
			pstmt.setString(10, memberVO.getMembers_Weight());
			pstmt.setString(11, memberVO.getMembers_RelationshipState());
			pstmt.setString(12, memberVO.getMembers_Sexuality());
			pstmt.setString(13, memberVO.getMembers_City());
			pstmt.setString(14, memberVO.getMembers_Area());
			pstmt.setString(15, memberVO.getMembers_Address());
			pstmt.setString(16, memberVO.getMembers_Telephone());
			pstmt.setString(17, memberVO.getMembers_Constellation());
			pstmt.setDate(18, memberVO.getMembers_Birthday());
			pstmt.setClob(19, memberVO.getMembers_Itroduce());
			pstmt.setDouble(20, memberVO.getMembers_Money());
			pstmt.setString(21, memberVO.getMembers_FacebookAccount());
			pstmt.setString(22, memberVO.getMembers_GoogleAccount());
			pstmt.setInt(23, memberVO.getMembers_isChecked());
			pstmt.setInt(24, memberVO.getMembers_isPay());
			pstmt.setInt(25, memberVO.getInterests_ID());
			pstmt.setString(26, memberVO.getMembers_Job());
			pstmt.setInt(27, memberVO.getMembers_isGetMail());
			pstmt.setInt(28, memberVO.getMembers_ID());
			
			i = pstmt.executeUpdate();
			
			System.out.println("修改資料筆數 = " + i);
			
		} catch (SQLException e)
		{
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}finally
		{
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					System.err.println("關閉相關物件時發生例外: " + e);
				}
			}
		}
		
	}

	@Override
	synchronized public void delete(Integer members_ID)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(delete_stmt);
			
			pstmt.setInt(1, members_ID);
			i = pstmt.executeUpdate();
			
			System.out.println("刪除資料筆數 = " + i);
			
		} catch (SQLException e)
		{
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}finally
		{
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					System.err.println("關閉相關物件時發生例外: " + e);
				}
			}
		}
		
	}

	@Override
	synchronized public MembersVO findByPrimaryKey(Integer members_ID)
	{
		MembersVO memberVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(get_one_stmt);
			
			pstmt.setInt(1, members_ID);
			
			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				memberVO = new MembersVO();
				memberVO.setMembers_ID(rs.getInt("Members_ID"));
				memberVO.setMembers_Name(rs.getString("Members_Name"));
				memberVO.setMembers_Nickname(rs.getString("Members_Nickname"));
				memberVO.setMembers_Account(rs.getString("Members_Account"));
				memberVO.setMembers_Password(rs.getString("Members_Password"));
				memberVO.setMembers_Gender(rs.getInt("Members_Gender"));
				memberVO.setMembers_MainPicture(rs.getBlob("Members_MainPicture"));
				memberVO.setMembers_VicePicture1(rs.getBlob("Members_VicePicture1"));
				memberVO.setMembers_VicePicture2(rs.getBlob("Members_VicePicture2"));
				memberVO.setMembers_Height(rs.getString("Members_Height"));
				memberVO.setMembers_Weight(rs.getString("Members_Weight"));
				memberVO.setMembers_RelationshipState(rs.getString("Members_RelationshipState"));
				memberVO.setMembers_Sexuality(rs.getString("Members_Sexuality"));
				memberVO.setMembers_City(rs.getString("Members_City"));
				memberVO.setMembers_Area(rs.getString("Members_Area"));
				memberVO.setMembers_Address(rs.getString("Members_Address"));
				memberVO.setMembers_Telephone(rs.getString("Members_Telephone"));
				memberVO.setMembers_Constellation(rs.getString("Members_Constellation"));
				memberVO.setMembers_Birthday(rs.getDate("Members_Birthday"));
				memberVO.setMembers_Itroduce(rs.getClob("Members_Itroduce"));
				memberVO.setMembers_Money(rs.getDouble("Members_Money"));
				memberVO.setMembers_FacebookAccount(rs.getString("Members_FacebookAccount"));
				memberVO.setMembers_GoogleAccount(rs.getString("Members_GoogleAccount"));
				memberVO.setMembers_isChecked(rs.getInt("Members_isChecked"));
				memberVO.setMembers_isPay(rs.getInt("Members_isPay"));
				memberVO.setInterests_ID(rs.getInt("Interests_ID"));
				memberVO.setMembers_Job(rs.getString("Members_Job"));
				memberVO.setMembers_isGetMail(rs.getInt("Members_isGetMail"));
				memberVO.setMembers_RegisetTime(rs.getTimestamp("Members_RegisetTime"));
				memberVO.setMembers_LastLoginTime(rs.getTimestamp("Members_LastLoginTime"));		
			}
			
		} catch (SQLException e)
		{
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}finally
		{
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					System.err.println("關閉相關物件時發生例外: " + e);
				}
			}
		}
		
		return memberVO;
		
	}

	@Override
	synchronized public Collection<MembersVO> getAllMembers()
	{
		Collection<MembersVO> coll = new ArrayList<MembersVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(get_all_stmt);
			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				MembersVO memberVO = new MembersVO();
				memberVO.setMembers_ID(rs.getInt("Members_ID"));
				memberVO.setMembers_Name(rs.getString("Members_Name"));
				memberVO.setMembers_Nickname(rs.getString("Members_Nickname"));
				memberVO.setMembers_Account(rs.getString("Members_Account"));
				memberVO.setMembers_Password(rs.getString("Members_Password"));
				memberVO.setMembers_Gender(rs.getInt("Members_Gender"));
				memberVO.setMembers_MainPicture(rs.getBlob("Members_MainPicture"));
				memberVO.setMembers_VicePicture1(rs.getBlob("Members_VicePicture1"));
				memberVO.setMembers_VicePicture2(rs.getBlob("Members_VicePicture2"));
				memberVO.setMembers_Height(rs.getString("Members_Height"));
				memberVO.setMembers_Weight(rs.getString("Members_Weight"));
				memberVO.setMembers_RelationshipState(rs.getString("Members_RelationshipState"));
				memberVO.setMembers_Sexuality(rs.getString("Members_Sexuality"));
				memberVO.setMembers_City(rs.getString("Members_City"));
				memberVO.setMembers_Area(rs.getString("Members_Area"));
				memberVO.setMembers_Address(rs.getString("Members_Address"));
				memberVO.setMembers_Telephone(rs.getString("Members_Telephone"));
				memberVO.setMembers_Constellation(rs.getString("Members_Constellation"));
				memberVO.setMembers_Birthday(rs.getDate("Members_Birthday"));
				memberVO.setMembers_Itroduce(rs.getClob("Members_Itroduce"));
				memberVO.setMembers_Money(rs.getDouble("Members_Money"));
				memberVO.setMembers_FacebookAccount(rs.getString("Members_FacebookAccount"));
				memberVO.setMembers_GoogleAccount(rs.getString("Members_GoogleAccount"));
				memberVO.setMembers_isChecked(rs.getInt("Members_isChecked"));
				memberVO.setMembers_isPay(rs.getInt("Members_isPay"));
				memberVO.setInterests_ID(rs.getInt("Interests_ID"));
				memberVO.setMembers_Job(rs.getString("Members_Job"));
				memberVO.setMembers_isGetMail(rs.getInt("Members_isGetMail"));
				memberVO.setMembers_RegisetTime(rs.getTimestamp("Members_RegisetTime"));
				memberVO.setMembers_LastLoginTime(rs.getTimestamp("Members_LastLoginTime"));		
				coll.add(memberVO);
			}
		} catch (SQLException e)
		{
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}finally
		{
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException se)
				{
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (Exception e)
				{
					System.err.println("關閉相關物件時發生例外: " + e);
				}
			}
		}
		
		return coll;
	}
}
