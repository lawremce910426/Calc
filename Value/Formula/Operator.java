package Formula;


public class Operator
{
	OperatorCode Code;
	public Operator(OperatorCode code)
	{
		Code = code;
	}
	public Operator(char code)throws Exception
	{
		Code = OperatorCodeConvert.ToOperator(code);
	}
	public Operator()
	{
		Code = OperatorCode.Add;
	}
	public char GetCode_Char()throws Exception
	{
		return OperatorCodeConvert.ToChar(Code);
	}
	public OperatorCode GetCode_Operator()
	{
		return Code;
	}
	public enum OperatorCode
	{
		Add,
		Sub,
		Mul,
		Div
	}
}


