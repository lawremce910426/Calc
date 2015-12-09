package NumberCalculating;

import Formula.Formula;
import ResolveCommand.ResolveCommand;
import Value.Value;
import Value.ValueReducer;

public class NumberCalculating {
	public NumberCalculating(){}
	public Value GetResult(String Input) throws Exception
	{
		ValueReducer.KillThread = false;
		Formula formula = ResolveCommand.ToFormula(Input);
		formula = DeleteData(formula);
		CalculateFormula.CalculateFormula Calc = new CalculateFormula.CalculateFormula();
		Value eax = Calc.CalculateValue(formula);
		while(!eax.Reduced){}
		ValueReducer.KillThread = true;
		return eax;
	}
	Formula DeleteData(Formula data) throws Exception
	{
		char[] operator = new char[data.GetData().length - 1];
		Value[] number = new Value[data.GetData().length - 1];
		for(int i = 1;i != data.GetData().length;i++)
		{
			operator[i - 1] = data.GetData()[i].GetOperator_Char();
			number[i - 1] = data.GetData()[i].GetNumber();
		}
		if(data.GetChildFormula() != null && data.GetOperatorCode() != null)
			return new Formula(
				operator,
				number,
				data.GetChildFormula(),
				data.GetOperatorCode()
				);
		if(data.GetChildFormula() != null && data.GetOperatorCode() == null)
			return new Formula(
				operator,
				number,
				data.GetChildFormula()
				);
		if(data.GetChildFormula() == null && data.GetOperatorCode() != null)
			return new Formula(
				operator,
				number,
				data.GetOperatorCode()
				);
		if(data.GetChildFormula() == null && data.GetOperatorCode() == null)
			return new Formula(
				operator,
				number
				);
		return null;
	}
}
