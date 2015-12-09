/**
 * 
 */
/**
  * @author lawrence910426
 *
 */
package ResolveCommand;

import java.util.ArrayList;
import Value.Value;


public class ResolveCommand
{
	public ResolveCommand(){	}
	/**
	 * @param Command
	 * @return
	 * @throws Exception
	 */
	public static Formula.Formula ToFormula(String Command) throws Exception
	{
		return ToFormulaBracket("0 + " + Command ,-1 ,'+');
	}
	public static Formula.Formula ToFormulaBracket(String Command ,int ChildItemIndex ,char BracketOperator) throws Exception
	{
		ArrayList<Formula.Formula> data = new ArrayList<Formula.Formula>();
		try
		{
			while(true)
			{	
				char operator = Command.charAt(GetPairIndex(Command)[0] - 2); 
				String[] CuttedString = CutString( 
						GetPairIndex(Command)[0] 
						,GetPairIndex(Command)[1] 
						,Command
						);
				data.add(
						ToFormulaBracket(
								CuttedString[0]
								,data.size() + CuttedString[1].split(" ").length / 2//because the 0 +
								,operator
								)
						); 
				Command = CuttedString[1] + CuttedString[2];
			}
		}
		catch(Exception e)
		{
			String[] SplitedData = Command.split(" ");
			char[] operator = new char[SplitedData.length / 2 + 1];operator[0] = '+';
			Value[] number = new Value[SplitedData.length / 2 + 1];
			for(int i = 0;i != SplitedData.length;i++)
			{
				if(i % 2 == 0)number[i / 2] = new Value(SplitedData[i]);
				else operator[i / 2 + 1] = SplitedData[i].charAt(0);
			}
			if(data.size() == 0)return new Formula.Formula
					(operator ,
					   number ,
					   ChildItemIndex,
					   Formula.OperatorCodeConvert.ToOperator(BracketOperator)
					   );
			Formula.Formula[] dataArr = (Formula.Formula[]) data.toArray(new Formula.Formula[0]);
			return new Formula.Formula(operator ,
					number ,
					dataArr ,
					ChildItemIndex,
					Formula.OperatorCodeConvert.ToOperator(BracketOperator)
					);
		}
	}
	static int[] GetPairIndex(String data)
	{
		int[] ret = new int[2];ret[0] = -1;ret[1] = -1;
		
		
		int Depth = 0,i = 0;
		while(true)
		{
			if(ret[0] == -1 && data.charAt(i) == '(')ret[0] = i;
			if(data.charAt(i) == '(')Depth++;
			if(data.charAt(i) == ')')Depth--;
			if(Depth == 0 && data.charAt(i) == ')')break;
			i++;
		}
		ret[1] = i;
		return ret;
	}
	static String[] CutString(int StartIndex,int EndIndex ,String data)
	//The [0] is StartIndex(without) -> EndIndex(without)
	{
		String eax = "";
		for(int i = StartIndex + 1;i != EndIndex;i++)
		{
			eax += data.charAt(i);
		} 
		String dataFront = "";
		for(int i = 0;i != StartIndex - 2;i++)
		{
			dataFront += data.charAt(i);
		} 
		String dataEnd = "";
		try
		{
			for(int i = EndIndex + 2;i != data.length();i++)
			{
				dataEnd += data.charAt(i);
			} 
		}
		catch(Exception e)
		{	}
		String[] ret = new String[3];ret[0] = eax;ret[1] = dataFront;ret[2] = dataEnd;
 		return ret;
	}
	
}