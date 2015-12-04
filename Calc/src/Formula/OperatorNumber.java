package Formula;

import Value.Value;

public class OperatorNumber
{
	Operator operator;
	Value Number;
	public OperatorNumber()
	{
		Number = new Value("0");
		operator = new Operator();
	}
	public OperatorNumber(Value i)
	{
		Number = new Value(i);
		operator = new Operator();
	}
	public OperatorNumber(char code ,Value i) throws Exception
	{
		Number = new Value(i);
		operator = new Operator(code);
	}
	public Operator.OperatorCode GetOperator_OperatorCode()
	{
		return operator.GetCode_Operator();
	}
	public char GetOperator_Char() throws Exception
	{
		return operator.GetCode_Char();
	}
	public Value GetNumber()
	{
		return Number;
	}
}