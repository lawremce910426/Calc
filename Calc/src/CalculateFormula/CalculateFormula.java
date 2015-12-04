/**
 * 
 */
/**
 * @author lawrence910426
 *
 */
package CalculateFormula;

import Value.Value;

public class CalculateFormula
{
	public CalculateFormula()
	{
		
	}
	public Value CalculateValue(Formula.Formula data) throws Exception
	{
		if(data.GetChildFormula() != null)/*it must be leaf*/
		{
			CalcBracket calc = new CalcBracket();
			data = calc.CalculateBracket(data);
		}
		
		CalcMulDivFirst FirstCalcMgr = new CalcMulDivFirst();
		data = FirstCalcMgr.CalculateMulDiv(data);
		CalcAddSub AddMgr = new CalcAddSub();
		return AddMgr.CalculateAddSub(data); 
	}
	
	
	
}