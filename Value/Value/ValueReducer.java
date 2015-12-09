
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
				  ReduceTarget.Reduce();
				  ReduceTarget.Reduced = true;
				  ReduceTarget.Reducing = false;
		  	  }
			  
			  Thread.yield();
		  }
	 }
	
	
}