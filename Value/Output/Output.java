/**
 * 
 */
/**
 * @author lawrence910426
 *
 */
package Output;

import Value.Value;

public class Output
{
	static String WaitForPrintData = "";
	public static void WriteLine(String s)
	{
		System.out.print(s);
	}
	public static void WriteLine(int s)
	{
		System.out.print(s);
	}
	public static void WriteLine(Value s)
	{
		while(!s.Reduced){}
		System.out.print(s.Denominator.toString() + " / " + s.Molecule.toString());
	}
	public static void Write(String s)
	{
		WaitForPrintData += s;
		if(s.contains("\n")){
			System.out.print(WaitForPrintData);
			WaitForPrintData = "";
		}
	}
	
}