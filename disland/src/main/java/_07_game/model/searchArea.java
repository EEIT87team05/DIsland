package _07_game.model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class searchArea implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public searchArea(){}  //不帶參數的建構子
	
	private int Members_ID;
	private String Members_Account;
	private String Members_Name;
	private String Members_City;
	private String Members_Area;
	private String Members_Gender;
	private String Members_Job;
	private Blob Members_MainPicture;
	List<searchArea> result = new ArrayList<searchArea>();
	Set<searchArea> resultset = new HashSet<searchArea>();
	
	public int hashCode()
	{
		int hash = 7;
		hash = 47* hash + Objects.hashCode(this.Members_ID);
		return hash;
	}
	
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final searchArea other = (searchArea) obj;
        if (!Objects.equals(this.Members_ID, other.Members_ID)) {
            return false;
        }
        return true;
    }
	
	
	public Set<searchArea> getResultset()
	{
		return resultset;
	}
	public void setResultset(Set<searchArea> resultset)
	{
		this.resultset = resultset;
	}
	public Blob getMembers_MainPicture()
	{
		return Members_MainPicture;
	}
	public void setMembers_MainPicture(Blob members_MainPicture)
	{
		Members_MainPicture = members_MainPicture;
	}
	public String getMembers_Job()
	{
		return Members_Job;
	}
	public void setMembers_Job(String members_Job)
	{
		Members_Job = members_Job;
	}
	public String getMembers_Account()
	{
		return Members_Account;
	}
	public void setMembers_Account(String members_Account)
	{
		Members_Account = members_Account;
	}
	public String getMembers_Gender()
	{
		return Members_Gender;
	}
	public void setMembers_Gender(String members_Gender)
	{
		Members_Gender = members_Gender;
	}
	public List<searchArea> getResult()
	{
		return result;
	}
	public void setResult(List<searchArea> result)
	{
		this.result = result;
	}
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
	
	
}
