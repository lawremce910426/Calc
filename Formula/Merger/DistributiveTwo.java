package Merger;

import ResolveCommand.ResolveCommand;

public class DistributiveTwo {
	public DistributiveTwo(){}
	public String OpenBracketTwo(String data)
										  	 ///		3 * (x + 3)
	//只允許兩項相乘 初項不可有括弧 不過括弧內可以有無限多項
	//括弧內請確定沒有乘除符號
	{
		int[] idx = ResolveCommand.GetPairIndex(data);
		if(isNumber(data.charAt(0))){
			//data.charAt(2) = '*' || '/'
			String BracketFormula = data.substring(idx[0] + 1 ,idx[1]);
			String ret = "";
			
			char operatorData = data.charAt(FirstOperatorIdx(data ,0));
			while(true)
			{
				char operatorBrac = BracketFormula.charAt(FirstOperatorIdx(BracketFormula ,0));
				ret += data.substring(0 ,FirstOperatorIdx(data ,0) - 1) + " "
						+ operatorData + " "
						+ BracketFormula.substring(0 ,FirstOperatorIdx(BracketFormula ,0) - 1);
				BracketFormula = BracketFormula.substring(FirstOperatorIdx(BracketFormula ,0) + 2);
				ret += " " + operatorBrac + " ";
				if(FirstOperatorIdx(BracketFormula ,0) == -1){
					ret += data.substring(0 ,FirstOperatorIdx(data ,0) - 1) + " "
							+ operatorData + " "
							+ BracketFormula;
					break;
				}
			}
			return ret;
		}
		else//it gotta be a bracket
		{
			return "";
		}
	}
	int FirstOperatorIdx(String data,int begin)
	{
		for(int i = begin;i != data.length();i++)
			if(isOperator(data.charAt(i)))
					return i;
		return -1;//might happend
	}
	boolean isOperator(char dat)
	{
		return (dat == '+' || dat == '-' || dat == '/' || dat == '*' ? true : false);
	}
	boolean isNumber(char dat)
	{
		try
		{
			Integer.valueOf(dat);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
