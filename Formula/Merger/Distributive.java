package Merger;

import Merger.MulDivAdapt.EncryptDecrypt;
import Merger.MulDivAdapt.KeysAndString;
import Merger.MulDivAdapt.MulDivAdaptMgr;
import Merger.MulDivAdapt.MulDivAdaptTable;

public class Distributive
{
	
	public Distributive()
	{	}
	public String DoDistributive(String a)
	{
		return EncryptDecrypt.Encrypt(a).data;
	}
	public KeysAndString MulBrackDistri(String data)//not multiple level bracket
	{
		//��EncryptBrac�o�� ��̤��h ��encrypt ��̫�(��ӬA�������)����A�٭�
		while(true)
			try
			{
				int[] idx = ResolveCommand.ResolveCommand.GetPairIndex(data);
				String Inside = data.substring(idx[0] + 1 ,idx[1]);
				KeysAndString encrypted = MulBrackDistri(Inside);
				DistributiveMul distriMgr = new DistributiveMul();
				String result = distriMgr.MulToMul(encrypted.data);
				return 
						new KeysAndString(
								new java.util.ArrayList<MulDivAdaptTable>()
								,EncryptDecrypt.Decrypt(new KeysAndString(encrypted.Keys ,result))
								);
			}
			catch(Exception e)
			{
				//no brackets
				KeysAndString result = EncryptDecrypt.Encrypt(data);
				return result;
			}
	}
}




