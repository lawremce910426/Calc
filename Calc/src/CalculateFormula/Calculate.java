package CalculateFormula;

import Formula.Operator;
import Value.Value;


public class Calculate
{
	public static Value CalculateValue(Value a, Value b,Operator.OperatorCode code) throws Exception
	{
		switch(code)
		{
			case Add:
				return a.ADD(b);
			case Sub:
				return a.SUB(b);
			case Mul:
				return a.MUL(b);
			case Div:
				return a.DIV(b);
			default:
				throw new Exception("a code is not add,sub,mul,div.");
		}
	}
} 