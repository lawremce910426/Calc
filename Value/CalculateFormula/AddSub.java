package CalculateFormula;

import Value.Value;

class CalcAddSub
{
	public CalcAddSub()
	{	}
	public Value CalculateAddSub(Formula.Formula data) throws Exception
	{
		Value CalcedValue = new Value("0");
		for(int i = 0;i != data.GetData().length;i++)
		{
			CalcedValue = Calculate.CalculateValue(CalcedValue,
					data.GetData()[i].GetNumber(),
					data.GetData()[i].GetOperator_OperatorCode());
		}
		return CalcedValue;
	}
}