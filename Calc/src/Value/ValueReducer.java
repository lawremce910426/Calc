package Value;

class ValueReducer extends Thread
{
	Value ReduceTarget;
	public ValueReducer(Value Target)
	{
		ReduceTarget = Target;
	}
	@Override
	 public void run()
	 {
		  while(true)
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