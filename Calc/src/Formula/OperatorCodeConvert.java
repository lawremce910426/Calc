package Formula;

public class OperatorCodeConvert
{
	public static Operator.OperatorCode ToOperator(char c)throws Exception
	{
		switch(c)
		{
			case '+':
				return Operator.OperatorCode.Add;
			case '-':
				return Operator.OperatorCode.Sub;
			case '*':
				return Operator.OperatorCode.Mul;
			case '/':
				return Operator.OperatorCode.Div;
			default:
				throw new Exception("Charactor is not +,-,*,/");
		}
	}
	public static char ToChar(Operator.OperatorCode c)throws Exception
	{
		switch(c)
		{
			case Add:
				return '+';
			case Sub:
				return '-';
			case Mul:
				return '*';
			case Div:
				return '/';
			default:
				throw new Exception("Charactor is not Add,Sub,Mul,Div");
		}
	}
}