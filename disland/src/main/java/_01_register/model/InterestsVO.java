package _01_register.model;

//實作Serializable介面
public class InterestsVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public InterestsVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int Interests_ID;
	private String Interests_Name;
	//==============================================================
	
	//====================getter跟setter=============================
	public int getInterests_ID()
	{
		return Interests_ID;
	}
	public void setInterests_ID(int interests_ID)
	{
		Interests_ID = interests_ID;
	}
	public String getInterests_Name()
	{
		return Interests_Name;
	}
	public void setInterests_Name(String interests_name)
	{
		Interests_Name = interests_name;
	}
}
