package CalculateFormula;

import Formula.Formula;
import Formula.OperatorCodeConvert;
import Value.Value;

public class CalcBracket
{
	public CalcBracket()
	{	}
	public Formula CalculateBracket(Formula data) throws Exception
	{
		 Value[] Values = new Value[data.GetChildFormula().length];
		 char[] OperatorCodes = new char[data.GetChildFormula().length];
		 int[] Indexs = new int[data.GetChildFormula().length];
		 for(int i = 0;i != data.GetChildFormula().length;i++)
		 {
			 OperatorCodes[i] = OperatorCodeConvert.ToChar(data.GetChildFormula()[i].GetOperatorCode());
			 Indexs[i] = data.GetChildFormula()[i].GetItemIndex();
			 Values[i] = CalculateValue(data.GetChildFormula()[i]);
		 }
		 for(int i = 0;i != data.GetChildFormula().length;i++)
		 {
			 data = InsertData(OperatorCodes[i] ,Values[i] ,Indexs[i] ,data);
		 }
		 return data;
	}                                                   
	Value CalculateValue(Formula data) throws Exception
	{
		CalculateFormula calc = new CalculateFormula();
		return calc.CalculateValue(data);
	}                                                  
	Formula InsertData(char Operator,Value Value,int Index ,Formula data) throws Exception
	{
		char[] operators = new char[data.GetData().length + 1];
		Value[] numbers = new Value[data.GetData().length + 1];
		int Shift = 0;
		
		operators[Index] = Operator;
		numbers[Index] = Value;
		for(int i = 0;i != data.GetData().length;)
		{
			if(i == Index && Shift == 0)
			{
				Shift++;
				continue;
			}
			operators[i + Shift] = data.GetData()[i].GetOperator_Char();
			numbers[i + Shift] = data.GetData()[i].GetNumber();
			i++;
		}
		try
		{
			return new Formula(operators ,numbers ,data.GetChildFormula() ,data.GetItemIndex(),data.GetOperatorCode());
		}
		catch(Exception e)
		{
			return new Formula(operators ,numbers ,data.GetChildFormula(), data.GetOperatorCode());
		}
	}
}