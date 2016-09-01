package _07_game.model;

import java.io.Serializable;

public class FirstStepVO implements Serializable
{
	private static final long serialVersionUID = 1L;  //沒寫不會怎樣,寫了更好
	public FirstStepVO(){}  //不帶參數的建構子
	
	//====================private實例變數=============================
	private int FirstStep_ID;
	private int Members_ID;
	private int Mem_IDisSelected1;
	private int Mem_IDisSelected2;
	private int Mem_IDisSelected3;
	private int Mem_IDisSelected4;
	private int Mem_IDisSelected5;
	private int Mem_IDisSelected6;
	//==============================================================
	
	//====================getter跟setter=============================
	public int getFirstStep_ID()
	{
		return FirstStep_ID;
	}
	public void setFirstStep_ID(int firstStep_ID)
	{
		FirstStep_ID = firstStep_ID;
	}
	public int getMembers_ID()
	{
		return Members_ID;
	}
	public void setMembers_ID(int members_ID)
	{
		Members_ID = members_ID;
	}
	public int getMem_IDisSelected1()
	{
		return Mem_IDisSelected1;
	}
	public void setMem_IDisSelected1(int mem_IDisSelected1)
	{
		Mem_IDisSelected1 = mem_IDisSelected1;
	}
	public int getMem_IDisSelected2()
	{
		return Mem_IDisSelected2;
	}
	public void setMem_IDisSelected2(int mem_IDisSelected2)
	{
		Mem_IDisSelected2 = mem_IDisSelected2;
	}
	public int getMem_IDisSelected3()
	{
		return Mem_IDisSelected3;
	}
	public void setMem_IDisSelected3(int mem_IDisSelected3)
	{
		Mem_IDisSelected3 = mem_IDisSelected3;
	}
	public int getMem_IDisSelected4()
	{
		return Mem_IDisSelected4;
	}
	public void setMem_IDisSelected4(int mem_IDisSelected4)
	{
		Mem_IDisSelected4 = mem_IDisSelected4;
	}
	public int getMem_IDisSelected5()
	{
		return Mem_IDisSelected5;
	}
	public void setMem_IDisSelected5(int mem_IDisSelected5)
	{
		Mem_IDisSelected5 = mem_IDisSelected5;
	}
	public int getMem_IDisSelected6()
	{
		return Mem_IDisSelected6;
	}
	public void setMem_IDisSelected6(int mem_IDisSelected6)
	{
		Mem_IDisSelected6 = mem_IDisSelected6;
	}
	
}
