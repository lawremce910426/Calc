import Formula.Formula;
import Input.Input;
import Input.Input.ChangeLineCode;
import ResolveCommand.ResolveCommand;
import Value.Value;

/**
 * @author lawrence910426
 *
 */
public class Main {
 
	public static void main(String[] args)  { 
		
		try
		{
			//PrepareEffects();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		Input input = new Input(ChangeLineCode.SlashN);
		while(true)
			try {
				Output.Output.WriteLine("Command:"); 
				Formula formula = ResolveCommand.ToFormula(input.GetLine());
				formula = DeleteData(formula);
				CalculateFormula.CalculateFormula Calc = new CalculateFormula.CalculateFormula();
				Output.Output.WriteLine("The result is:\t");
				Output.Output.WriteLine(Calc.CalculateValue(formula));
				Output.Output.WriteLine("\n");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	static Formula DeleteData(Formula data) throws Exception
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
	static void PrepareEffects() throws Exception
	{
		Output.Output.WriteLine("Welcome to use Calc. Developer is lawrence.\n");
		Output.Output.WriteLine("Loading engine\n");Thread.sleep(1000);
		Output.Output.WriteLine(".");Thread.sleep(3000);
		Output.Output.WriteLine(".");Thread.sleep(1250);
		Output.Output.WriteLine(".");Thread.sleep(1750);
		Output.Output.WriteLine("\nFinish Loading.\n");
		Output.Output.WriteLine("\n------Command is available to run.-----\n");
		Output.Output.WriteLine("Please enter you command like this:\n");
		Output.Output.WriteLine("1 + 1\n");Thread.sleep(1000);
		Output.Output.WriteLine("Or\n1 - 1\n");Thread.sleep(1000);
		Output.Output.WriteLine("Or\n1 * 1\n");Thread.sleep(1000);
		Output.Output.WriteLine("Or\n1 / 1\n");Thread.sleep(1000);
		Output.Output.WriteLine("Now please type your command.\n");
	}
}
