package LargeNumber;

import Value.Number_10;

class LargeNumber_DivManager {
	public LargeNumber Divide(LargeNumber BeDiv_origin,LargeNumber Diver)	
	{
		LargeNumber BeDiv = BeDiv_origin.Mul(new LargeNumber(1));	//Some kind of "clone".
		
		
		if(BeDiv.Smaller(Diver)) return new LargeNumber(0);
		if(BeDiv.Equals(Diver))return new LargeNumber(1);
		
		Number_10[] result = new Number_10[BeDiv_origin.data.length - Diver.data.length + 1];
		
		for(int i = BeDiv.data.length - Diver.data.length - 1 + 1;i != -1;i--)
		{
			try {
				result[i] = SingleDigitResult(BeDiv ,Diver ,i);
			} catch (Exception e) {
				e.printStackTrace();	//impossible code
			}
		}
		
		LargeNumber ret = new LargeNumber(result);
		ret.CleanUpJunk();
		return ret;
	}
	
	Number_10 SingleDigitResult(LargeNumber BeDiv,LargeNumber Diver, int AddDigit) throws Exception	//Digit: the diver's digit.
	{
		LargeNumber Diver_LargeNum = Diver.AddZeros(Diver, AddDigit);
		
		LargeNumber _1 = Diver_LargeNum;
		LargeNumber _3 = Diver_LargeNum.Mul(new LargeNumber(3));
		LargeNumber _5 = Diver_LargeNum.Mul(new LargeNumber(5));
		
		int counter = 0;
		if(_5.Smaller(BeDiv) || _5.Equals(BeDiv))
		{
			BeDiv.Sub(_5);
			counter += 5;
		}
		if(_3.Smaller(BeDiv) || _3.Equals(BeDiv))
		{
			BeDiv.Sub(_3);
			counter += 3;
		}
		
		//only 1 might repeat.
		if(_1.Smaller(BeDiv) || _1.Equals(BeDiv))
		{
			BeDiv.Sub(_1);
			counter += 1;
		}
		if(_1.Smaller(BeDiv) || _1.Equals(BeDiv))
		{
			BeDiv.Sub(_1);
			counter += 1;
		}
		
		return new Number_10(counter);
	}
	
	
}
