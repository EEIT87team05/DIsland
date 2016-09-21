package _01_register.model;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;

//實作Serializable介面
public class MemberBean implements java.io.Serializable
{
	
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public MemberBean(){}  //不帶參數的建構子
	
	public MemberBean(
			int Members_ID,String Members_Account,String Members_Password,
			String Members_Name,String Members_Gender,String Members_Constellation,
			String Members_Height,String Members_Weight,String Members_City,
			String Members_Area,String Members_RelationshipState,
			String Members_Job,String Members_Address)
	{
		this.Members_ID = Members_ID;
		this.Members_Account = Members_Account;
		this.Members_Password = Members_Password;
		this.Members_Name = Members_Name;
		this.Members_Gender = Members_Gender;
		this.Members_Constellation = Members_Constellation;
		this.Members_Height = Members_Height;
		this.Members_Weight = Members_Weight;
		this.Members_City = Members_City;
		this.Members_Area = Members_Area;
		this.Members_RelationshipState = Members_RelationshipState;
		this.Members_Job = Members_Job;
		this.Members_Address = Members_Address;
	}
	public MemberBean(//註冊要用到的資料(請參照資料庫欄位)
			 int Members_ID,/*not null*/
			 String Members_Name,/*not null*/
			 String Members_Nickname,/*not null*/
			 String Members_Account,/*not null*/
			 String Members_Password,/*not null*/
			 String Members_Gender,/*not null*/
			 Blob Members_MainPicture,/*not null*/
			 String Members_Height,/*not null*/
			 String Members_Weight,/*not null*/
			 String Members_RelationshipState,/*not null*/
			 String Members_Sexuality,
			 String Members_City,
			 String Members_Area,
			 String Members_Address,
			 String Members_Telephone,
			 String Members_Constellation,/*not null*/
			 Date Members_Birthday,/*not null*/
			 Clob Members_Itroduce,
			 String Members_Job,
			 Double Members_Money,
			 String Members_FacebookAccount,
			 String Members_GoogleAccount,
			 int Members_isChecked,
			 int Members_isPay,
			 int Interests_ID,
			 Timestamp Members_RegisetTime,
			 Timestamp Members_LastLoginTime )
	{
		this.Members_ID = Members_ID;
		this.Members_Name = Members_Name;
		this.Members_Nickname = Members_Nickname;
		this.Members_Account = Members_Account;
		this.Members_Password = Members_Password;
		this.Members_Gender = Members_Gender;
		this.Members_MainPicture = Members_MainPicture;
		this.Members_Height = Members_Height;
		this.Members_Weight = Members_Weight;
		this.Members_RelationshipState = Members_RelationshipState;
		this.Members_Sexuality = Members_Sexuality;
		this.Members_City = Members_City;
		this.Members_Area = Members_Area;
		this.Members_Address = Members_Address;
		this.Members_Telephone = Members_Telephone;
		this.Members_Constellation = Members_Constellation;
		this.Members_Birthday = Members_Birthday;
		this.Members_Itroduce = Members_Itroduce;
		this.Members_Money = Members_Money;
		this.Members_FacebookAccount = Members_FacebookAccount;
		this.Members_GoogleAccount = Members_GoogleAccount;
		this.Members_isChecked = Members_isChecked;
		this.Members_isPay = Members_isPay;
		this.Interests_ID = Interests_ID;
		this.Members_RegisetTime = Members_RegisetTime;
		this.Members_LastLoginTime = Members_LastLoginTime;
		
		

		
	}
	
	//====================private實例變數(DB欄位名稱-30個)=============================
	private int Members_ID;/*not null*/
	private String Members_Name;/*not null*/
	private String Members_Nickname;/*not null*/
	private String Members_Account;/*not null*/
	private String Members_Password;/*not null*/
	private String Members_Gender;/*not null*/
	private Blob Members_MainPicture;/*not null*/
	private Blob Members_VicePicture1;
	private Blob Members_VicePicture2;
	private String Members_Height;/*not null*/
	private String Members_Weight;/*not null*/
	private String Members_RelationshipState;/*not null*/
	private String Members_Sexuality;
	private String Members_City;/*not null*/
	private String Members_Area;/*not null*/
	private String Members_Address;
	private String Members_Telephone;
	private String Members_Constellation;/*not null*/
	private Date Members_Birthday;/*not null*/
	private Clob Members_Itroduce;
	private Double Members_Money;
	private String Members_FacebookAccount;
	private String Members_GoogleAccount;
	private int Members_isChecked;
	private int Members_isPay;
	private int Interests_ID;
	private String Members_Job;
	private int Members_isGetMail;
	private Timestamp Members_RegisetTime;
	private Timestamp Members_LastLoginTime;
	//==============================================================

	//====================getter跟setter=============================
	public int getMembers_ID()
	{
		return Members_ID;
	}
	public void setMembers_ID(int members_ID)
	{
		Members_ID = members_ID;
	}
	public String getMembers_Name()
	{
		return Members_Name;
	}
	public void setMembers_Name(String members_Name)
	{
		Members_Name = members_Name;
	}
	public String getMembers_Nickname()
	{
		return Members_Nickname;
	}
	public void setMembers_Nickname(String members_Nickname)
	{
		Members_Nickname = members_Nickname;
	}
	public String getMembers_Account()
	{
		return Members_Account;
	}
	public void setMembers_Account(String members_Account)
	{
		Members_Account = members_Account;
	}
	public String getMembers_Password()
	{
		return Members_Password;
	}
	public void setMembers_Password(String members_Password)
	{
		Members_Password = members_Password;
	}
	
	public String getMembers_Gender()
	{
		return Members_Gender;
	}

	public void setMembers_Gender(String members_Gender)
	{
		Members_Gender = members_Gender;
	}

	public Blob getMembers_MainPicture()
	{
		return Members_MainPicture;
	}
	public void setMembers_MainPicture(Blob members_MainPicture)
	{
		Members_MainPicture = members_MainPicture;
	}
	public Blob getMembers_VicePicture1()
	{
		return Members_VicePicture1;
	}
	public void setMembers_VicePicture1(Blob members_VicePicture1)
	{
		Members_VicePicture1 = members_VicePicture1;
	}
	public Blob getMembers_VicePicture2()
	{
		return Members_VicePicture2;
	}
	public void setMembers_VicePicture2(Blob members_VicePicture2)
	{
		Members_VicePicture2 = members_VicePicture2;
	}
	public String getMembers_Height()
	{
		return Members_Height;
	}
	public void setMembers_Height(String members_Height)
	{
		Members_Height = members_Height;
	}
	public String getMembers_Weight()
	{
		return Members_Weight;
	}
	public void setMembers_Weight(String members_Weight)
	{
		Members_Weight = members_Weight;
	}
	public String getMembers_RelationshipState()
	{
		return Members_RelationshipState;
	}
	public void setMembers_RelationshipState(String members_RelationshipState)
	{
		Members_RelationshipState = members_RelationshipState;
	}
	public String getMembers_Sexuality()
	{
		return Members_Sexuality;
	}
	public void setMembers_Sexuality(String members_Sexuality)
	{
		Members_Sexuality = members_Sexuality;
	}
	public String getMembers_City()
	{
		return Members_City;
	}
	public void setMembers_City(String members_City)
	{
		Members_City = members_City;
	}
	public String getMembers_Area()
	{
		return Members_Area;
	}
	public void setMembers_Area(String members_Area)
	{
		Members_Area = members_Area;
	}
	public String getMembers_Address()
	{
		return Members_Address;
	}
	public void setMembers_Address(String members_Address)
	{
		Members_Address = members_Address;
	}
	public String getMembers_Telephone()
	{
		return Members_Telephone;
	}
	public void setMembers_Telephone(String members_Telephone)
	{
		Members_Telephone = members_Telephone;
	}
	public String getMembers_Constellation()
	{
		return Members_Constellation;
	}
	public void setMembers_Constellation(String members_Constellation)
	{
		Members_Constellation = members_Constellation;
	}
	public Date getMembers_Birthday()
	{
		return Members_Birthday;
	}
	public void setMembers_Birthday(Date members_Birthday)
	{
		Members_Birthday = members_Birthday;
	}
	
	public Clob getMembers_Itroduce()
	{
		return Members_Itroduce;
	}

	public void setMembers_Itroduce(Clob members_Itroduce)
	{
		Members_Itroduce = members_Itroduce;
	}

	public Double getMembers_Money()
	{
		return Members_Money;
	}
	public void setMembers_Money(Double members_Money)
	{
		Members_Money = members_Money;
	}
	public String getMembers_FacebookAccount()
	{
		return Members_FacebookAccount;
	}
	public void setMembers_FacebookAccount(String members_FacebookAccount)
	{
		Members_FacebookAccount = members_FacebookAccount;
	}
	public String getMembers_GoogleAccount()
	{
		return Members_GoogleAccount;
	}
	public void setMembers_GoogleAccount(String members_GoogleAccount)
	{
		Members_GoogleAccount = members_GoogleAccount;
	}
	public int getMembers_isChecked()
	{
		return Members_isChecked;
	}
	public void setMembers_isChecked(int members_isChecked)
	{
		Members_isChecked = members_isChecked;
	}
	public int getMembers_isPay()
	{
		return Members_isPay;
	}
	public void setMembers_isPay(int members_isPay)
	{
		Members_isPay = members_isPay;
	}
	public int getInterests_ID()
	{
		return Interests_ID;
	}
	public void setInterests_ID(int interests_ID)
	{
		Interests_ID = interests_ID;
	}
	public String getMembers_Job()
	{
		return Members_Job;
	}
	public void setMembers_Job(String members_Job)
	{
		Members_Job = members_Job;
	}
	public int getMembers_isGetMail()
	{
		return Members_isGetMail;
	}
	public void setMembers_isGetMail(int members_isGetMail)
	{
		Members_isGetMail = members_isGetMail;
	}
	public Timestamp getMembers_RegisetTime()
	{
		return Members_RegisetTime;
	}
	public void setMembers_RegisetTime(Timestamp members_RegisetTime)
	{
		Members_RegisetTime = members_RegisetTime;
	}
	public Timestamp getMembers_LastLoginTime()
	{
		return Members_LastLoginTime;
	}
	public void setMembers_LastLoginTime(Timestamp members_LastLoginTime)
	{
		Members_LastLoginTime = members_LastLoginTime;
	}
	
}
