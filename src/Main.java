import Formula.Formula;
import Function.Function;
import Input.Input;
import Input.Input.ChangeLineCode;
import Merger.Distributive;
import Merger.MulDivAdapt.EncryptBrac;
import Merger.MulDivAdapt.EncryptDecrypt;
import Merger.MulDivAdapt.MulDivAdaptMgr;
import NumberCalculating.NumberCalculating;
import ResolveCommand.ResolveCommand;
import Value.Value;

/**
 * @author lawrence910426
 *
 */
public class Main {
 
	public static void main(String[] args)  { 
		//------unit test prepare area--------------------------
		Distributive d = new Distributive();
		d.MulBrackDistri("(x * (x + 3))");
		//------------------------------------------------------
		
		/*try
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
				Output.Output.WriteLine("Select type of service(\'formula\' or \'calc\') >"); 
				String eax = input.GetLine();
				if(eax.equals("formula"))
					while(true){
						Output.Output.WriteLine("If you want to use other service,please enter 'exit'.\n");
						Output.Output.WriteLine("Enter your calculate function/equation >"); 
						String ebx = input.GetLine();
						if(ebx == "exit")break;
						Function calc = new Function(ebx);
						if(!calc.issingle){
							Value[] ValueList = new Value[calc.UnknownList.length];
							for(int i = 0;i != calc.UnknownList.length;i++)
							{
								Output.Output.WriteLine("Enter the value of the unknown number \'" + calc.UnknownList[i] + "\' >");
								Value number = new Value(input.GetLine());
								ValueList[i] = number;
							}
							Output.Output.WriteLine("The result is:\t");
							Output.Output.WriteLine(calc.PutIn(ValueList) + "\n");
						}
						else
						{
							Output.Output.WriteLine("Enter the value of the unknown number >");
							Value number = new Value(input.GetLine());
							Output.Output.WriteLine(calc.PutIn(number) + "\n");
						}
					}
				if(eax.equals("calc"))
					while(true){
						Output.Output.WriteLine("If you want to use other service,please enter 'exit'.\n");
						Output.Output.WriteLine("Enter your calculate formula >"); 
						String ebx = input.GetLine();
						if(ebx == "exit")break;
						NumberCalculating calc = new NumberCalculating();
						Output.Output.WriteLine("The result is:\t");
						Output.Output.WriteLine(calc.GetResult(ebx) + "\n");
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
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
