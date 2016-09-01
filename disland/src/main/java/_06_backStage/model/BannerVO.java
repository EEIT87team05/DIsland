package _06_backStage.model;

import java.sql.Blob;
import java.sql.Clob;

public class BannerVO implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public BannerVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int Banner_ID;
	private Blob Banner_Picture;
	private Clob Banner_Message;
	//==============================================================
	
	//====================getter跟setter=============================
	public int getBanner_ID()
	{
		return Banner_ID;
	}
	public void setBanner_ID(int banner_ID)
	{
		Banner_ID = banner_ID;
	}
	public Blob getBanner_Picture()
	{
		return Banner_Picture;
	}
	public void setBanner_Picture(Blob banner_Picture)
	{
		Banner_Picture = banner_Picture;
	}
	public Clob getBanner_Message()
	{
		return Banner_Message;
	}
	public void setBanner_Message(Clob banner_Message)
	{
		Banner_Message = banner_Message;
	}
	
}
