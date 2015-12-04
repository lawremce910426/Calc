package CalculateFormula;

import Formula.Operator;
import Value.Value;

class CalcMulDivFirst
{
	public Formula.Formula CalculateMulDiv(Formula.Formula data)
	{
		while(true)
		{
			try
			{
				Operator.OperatorCode[] MulDiv = new Operator.OperatorCode[2];
				MulDiv[0] = Operator.OperatorCode.Mul;MulDiv[1] = Operator.OperatorCode.Div;
				int Index = FindFirst(data ,MulDiv);
				Value value = Calculate.CalculateValue(data.GetData()[Index - 1].GetNumber(),
						data.GetData()[Index].GetNumber(),
						data.GetData()[Index].GetOperator_OperatorCode());
						//i sets the first operator in + so Index will least be 1
				data = DeleteIndexWriteValue(Index,value,data);
			}
			catch(Exception e)
			{
				return data;
			}
		}
	}
	
	
	Formula.Formula DeleteIndexWriteValue(int Index,Value Value,Formula.Formula OldData) throws Exception
	{
		//----------------prepare to create a new Formula.------------------------
		char[] Operators = new char[OldData.GetData().length - 1];
				//because Index is going to be delete, so we must - 1
		Value[] Numbers = new Value[OldData.GetData().length - 1];
				//so do the numbers.
		int Shift = 0;
		for(int i = 0;i != OldData.GetData().length - 1;)
		{
			if(i == Index && Shift == 0){ Shift++; continue; }
			Operators[i] = OldData.GetData()[i + Shift].GetOperator_Char();
			Numbers[i] = OldData.GetData()[i + Shift].GetNumber();
			i++;
		}
		Numbers[Index - 1] = Value;
		return new Formula.Formula(Operators, Numbers);
	}

	
	int FindFirst(Formula.Formula data ,Operator.OperatorCode[] code) throws Exception
	{
		for(int i = 0;i != data.GetData().length;i++)
		{
			if(IsAny(code ,data.GetData()[i].GetOperator_OperatorCode())) return i;
		}
		throw new Exception("Unable to find the code.");
	}
	
	
	boolean IsAny(Operator.OperatorCode[] a,Operator.OperatorCode b)
	{
		for(int i = 0;i != a.length;i++)
		{
			if(a[i] == b)return true;
		}
		return false;
	}
}