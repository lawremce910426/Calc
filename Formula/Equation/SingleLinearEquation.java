package Equation;

import Function.Function;
import Value.Value;

public class SingleLinearEquation {
	Function RightValue;
	Function LeftValue;
	public SingleLinearEquation(String data)//ex. x + 3 * 2 = 12
	{
		String left = data.split(" = ")[0];
		String right = data.split(" = ")[1];
		LeftValue = new Function(left);
		RightValue = new Function(right);
	}
	void Reduce()
	{
		
	}
}
