package Input;

class TranslateMsg
{
	char[] RawMsg;
	char[] NewMsg;
	public TranslateMsg(char[] Raw)
	{
		RawMsg = Raw;
	}
	public char[] GetMsg()
	{
		return NewMsg;
	}
	public void GetMsg(char[] msg)
	{
		msg = NewMsg;
	}
	
	
	
	
	
	public void Translate(Input.ChangeLineCode ChangeCode)
	{
		char EndingChar = 0;
		try {
			EndingChar = ChangeCodeToChar(ChangeCode);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		for(int i = 0;i != RawMsg.length;)
		{
			if(RawMsg[i] == EndingChar)
			{
				WriteGoods(i - 1);
				break;
			}
			i++;
		}
	}
	
	
	
	
	
	char ChangeCodeToChar(Input.ChangeLineCode ChangeCode)throws Exception
	{
		switch(ChangeCode){
			case SlashN:
				return '\n';
			case SlashR:
				return '\r';
			case Slash0:
				return '\0';
			default:
				throw new Exception("Found a ChangeLineCode is not SlashN,SlashR,Slash0");
		}
	}
	
	
	
	
	
	void WriteGoods(int GarbageIndex)//after(not with) garbage index, those are all garbage data.
	{
		NewMsg = new char[GarbageIndex];
		for(int i = 0;i != GarbageIndex;)
		{
			NewMsg[i] = RawMsg[i++];
		}
	}
	
	
}