package Merger;

import Merger.MulDivAdapt.EncryptDecrypt;
import Merger.MulDivAdapt.KeysAndString;

public class Distributive
{
	
	public Distributive()
	{	}
	public String DoDistributive(String a)
	{
		KeysAndString key = EncryptDecrypt.Encrypt(a);
		return EncryptDecrypt.Decrypt(key);
	}
}




