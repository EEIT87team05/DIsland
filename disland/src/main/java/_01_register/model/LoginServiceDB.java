package _01_register.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_init.GlobalService;
import _02_friend.model.FriendsListVO;

public class LoginServiceDB
{
	static private List<MembersVO> memberList = new ArrayList<MembersVO>();
	
	
	private DataSource ds = null;
	
	public LoginServiceDB() throws NamingException, SQLException
	{
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		if (memberList.isEmpty())
		{
			populateMemberList(); // 此方法只會執行一次
		}
	}
	
	public void populateMemberList() throws SQLException
	{
		// 由Database讀取會員資料
		String sql = "SELECT * From Members";
		Connection connection = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		MembersVO mv = null;
		FriendsListVO fv = null;
		try
		{
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(sql);
			rs = pStmt.executeQuery();
			while (rs.next())
			{
				int memberId = rs.getInt("Members_ID");
				String account = rs.getString("Members_Account");
				String pswd =rs.getString("Members_Password");
				String name = rs.getString("Members_Name");
				String gender = rs.getString("Members_Gender");
				String constellation = rs.getString("Members_Constellation");
				String height = rs.getString("Members_Height");
				String weight = rs.getString("Members_Weight");
				String city = rs.getString("Members_City");
				String area = rs.getString("Members_Area");
				String relationshop = rs.getString("Members_RelationshipState");
				String job = rs.getString("Members_Job");
				String address = rs.getString("Members_Address");
				String itroduce = rs.getString("Members_Itroduce");
				mv = new MembersVO(memberId,account,pswd,name,gender,constellation,height,
									weight,city,area,relationshop,job,address,itroduce);

				memberList.add(mv);	
			}
		} finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (connection != null)
			{
				connection.close();
			}
		}
	}
	
	public MembersVO findrandommemberid(String Members_ID) throws SQLException, NamingException
	{
		
	
		// 由Database讀取會員資料
		String sql = "SELECT Members_ID,Members_Name,Members_Nickname,Members_Account,Members_Password,"
				+ "Members_Gender,Members_MainPicture,Members_VicePicture1,Members_VicePicture2,"
				+ "Members_Height,Members_Weight,Members_RelationshipState,"
				+ "Members_Sexuality,Members_City,Members_Area,Members_Address,Members_Telephone,"
				+ "Members_Constellation,Members_Birthday,Members_Itroduce,Members_Money,Members_FacebookAccount,"
				+ "Members_GoogleAccount,Members_isChecked,Members_isPay,Interests_ID,Members_Job,Members_isGetMail,"
				+ "Members_RegisetTime,Members_LastLoginTime "
				+ "FROM Members where Members_ID = ?";
		Connection connection = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		MembersVO mv = null;
		FriendsListVO fv = null;
		try
		{
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, Members_ID);
			rs = pStmt.executeQuery();
			while (rs.next())
			{
				int memberId = rs.getInt("Members_ID");
				String account = rs.getString("Members_Account");
				String pswd =rs.getString("Members_Password");
				String name = rs.getString("Members_Name");
				String gender = rs.getString("Members_Gender");
				String constellation = rs.getString("Members_Constellation");
				String height = rs.getString("Members_Height");
				String weight = rs.getString("Members_Weight");
				String city = rs.getString("Members_City");
				String area = rs.getString("Members_Area");
				String relationshop = rs.getString("Members_RelationshipState");
				String job = rs.getString("Members_Job");
				String address = rs.getString("Members_Address");
				String itroduce = rs.getString("Members_Itroduce");
				mv = new MembersVO(memberId,account,pswd,name,gender,constellation,height,
						weight,city,area,relationshop,job,address,itroduce);

				memberList.add(mv);	
				
			}
		} finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (connection != null)
			{
				connection.close();
			}
		}
		return mv;
	}
	
	
	public MembersVO checkIDPassword(String userId, String password)
	{
		// 檢查userId與password是否正確
		for (MembersVO mv : memberList)
		{
			if (mv.getMembers_Account().trim().equals(userId.trim()))
			{
				String mvpswd = mv.getMembers_Password();
				if (mvpswd.equals(password))
				{
					return mv;
				}
				else 
				{
					return null;
				}
			}
		}
		return null;
	}
	
	public List<MembersVO> getMemberList()
	{
		return memberList;
	}

	public void addNewMember(MembersVO mv)
	{
		memberList.add(mv);
	}
	
}
