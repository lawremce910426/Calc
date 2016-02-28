package Merger.MulDivAdapt;

public class EncryptBrac extends EncryptDecrypt {
	static KeysAndString encrypted;
	public EncryptBrac() {
		super();
	}
	
	public static KeysAndString Encrypt(String data)//由前而後，由內而外
	{
		return Adapt(new KeysAndString(
				new java.util.ArrayList<MulDivAdaptTable>()
				,data)
				);
	}
	static String insert(String _1,String _2, int offset)
	{
		StringBuffer b = new StringBuffer(_1);
		b.insert(offset ,_2);
		return b.toString();
	}
	static KeysAndString Adapt(KeysAndString data)
	{
		
			String dataCpy = data.data;
			java.util.ArrayList<String> dataCutted = new java.util.ArrayList<String>();
			java.util.ArrayList<Integer> dataCuttedIdx = new java.util.ArrayList<Integer>();
			java.util.ArrayList<MulDivAdaptTable> keys = new java.util.ArrayList<MulDivAdaptTable>();
			keys.addAll(data.Keys);
			
			while(true)
			{
				try 
				{
					int[] idxx = ResolveCommand.ResolveCommand.GetPairIndex(dataCpy);
					KeysAndString Changed = Adapt(
							new KeysAndString(new java.util.ArrayList<MulDivAdaptTable>()
									,dataCpy.substring(idxx[0] + 1 ,idxx[1])
									));
					keys.addAll(Changed.Keys);
					dataCpy = dataCpy.substring(0 ,idxx[0] + 1) + dataCpy.substring(idxx[1]);
					StringBuffer inserter = new StringBuffer(dataCpy);
					inserter.insert(idxx[0] + 1, Changed.data); 
					dataCpy = inserter.toString();
					//------必須把括弧先隱藏起來 避免dead loop 在要return時重組回來
					int[] idx = ResolveCommand.ResolveCommand.GetPairIndex(dataCpy);
					dataCutted.add(dataCpy.substring(idx[0] ,idx[1] + 1));
					dataCpy = dataCpy.substring(0 ,idx[0]) + dataCpy.substring(idx[1] + 1);
					dataCuttedIdx.add(idx[0]);
				}
				catch(Exception e)
				{

					for(int i = 0;i != dataCutted.size();i++)
						dataCpy = insert(dataCpy ,dataCutted.get(i) ,dataCuttedIdx.get(i));
					//--------------------------------------
					KeysAndString eax = EncryptDecrypt.Encrypt(dataCpy);
					keys.addAll(eax.Keys);
					return new KeysAndString(keys
							,eax.data);
				}
			}
		
			
			
	}
	
	

}
