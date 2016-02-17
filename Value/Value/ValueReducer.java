
package Value;

public class ValueReducer extends Thread
{
	public static boolean KillThread = false;
	Value ReduceTarget;
	public ValueReducer(Value Target)
	{
		ReduceTarget = Target;
	}
	@Override
	 public void run()
	 {
		  while(!KillThread)
		  {
			  if(!ReduceTarget.Reduced)
		  	  {
				  ReduceTarget.Reducing = true;
				  Value eax = ReduceTarget.reducer.Reduce(ReduceTarget);
				  while(ReduceTarget.Running){}
				  ReduceTarget.Denominator = new LargeNumber(eax.Denominator);
				  ReduceTarget.Molecule = new LargeNumber(eax.Molecule);
				  ReduceTarget.Reduced = true;
				  ReduceTarget.Reducing = false;
		  	  }
			  else
			  {
				  System.gc();
				  Thread.yield();
			  }
		  }
		  System.gc();
	 }
	
	
}