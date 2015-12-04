/**
 * 
 */
/**
 * @author lawrence910426
 *
 */
package Formula;

import Value.Value;

public class Formula
{
	OperatorNumber[] Data;//對於括弧運算式並沒有保留空間
	Formula[] BracketsFormulas;
	int ThisItemIndex = -1;//這個物件在父物件中的項數(開始為0)
	Operator.OperatorCode BracketFrontOperator;
	public Formula(char[] Operators,Value[] Numbers)throws Exception
		//Operators[0] and Numbers[0] create a OperatorNumber.So do the data after.
	{
		InitData(Operators ,Numbers);
	}
	public Formula(char[] Operators,Value[] Numbers ,Operator.OperatorCode Operator)throws Exception
	//Please look description for overload(char ,int).
	{
		InitData(Operators ,Numbers);
		BracketFrontOperator = Operator;
	}	
	public Formula(char[] Operators,Value[] Numbers ,Formula[] ChildFormulas)throws Exception
	//Please look description for overload(char ,int).
	{
		InitData(Operators ,Numbers);
		InitBrackets(ChildFormulas);
	}	
	public Formula(char[] Operators,Value[] Numbers ,int ThisItemIndex ,Operator.OperatorCode Operator)throws Exception
		//Please look description for overload(char ,int).
	{
		InitData(Operators ,Numbers);
		this.ThisItemIndex = ThisItemIndex;
		BracketFrontOperator = Operator;
	}	
	public Formula(char[] Operators,Value[] Numbers,Formula[] ChildFormulas ,Operator.OperatorCode Operator)throws Exception
		//Please look description for overload(char ,int).
	{
		InitData(Operators ,Numbers);
		InitBrackets(ChildFormulas);
		BracketFrontOperator = Operator;
	}
	public Formula(char[] Operators,Value[] Numbers,Formula[] ChildFormulas ,int ThisItemIndex ,Operator.OperatorCode Operator)throws Exception
		//Please look description for overload(char ,int).
	{
		InitData(Operators ,Numbers);
		InitBrackets(ChildFormulas);
		this.ThisItemIndex = ThisItemIndex;
		BracketFrontOperator = Operator;
	}
	
	
	
	void InitBrackets(Formula[] ChildFormulas)
	{
		BracketsFormulas = new Formula[ChildFormulas.length];
		for(int i = 0;i != ChildFormulas.length;i++)BracketsFormulas[i] = ChildFormulas[i];
	}
	void InitData(char[] Operators,Value Numbers[]) throws Exception
	{
		if(Operators.length != Numbers.length)throw new Exception("Operators length and Numbers lenght do not match");
		OperatorNumber[] operatorNumber = new OperatorNumber[Operators.length];
		for(int i = 0;i != Operators.length;)
		{
			operatorNumber[i] = new OperatorNumber(Operators[i] ,Numbers[i++]);
		}
		Data = operatorNumber;
	}
	
	public OperatorNumber[] GetData()
	{
		return Data;
	}
	public Formula[] GetChildFormula()
	{
		return BracketsFormulas;
	}
	public int GetItemIndex() throws Exception
	{
		if(ThisItemIndex == -1)
			throw new Exception("This is root. Unable to get ItemIndex.");
		else
			return ThisItemIndex;
	}
	public Operator.OperatorCode GetOperatorCode() throws Exception
	{
		return BracketFrontOperator;
	}
}

