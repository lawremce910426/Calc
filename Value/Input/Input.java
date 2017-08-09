/**
 * 
 */
/**
 * @author lawrence910426
 *
 */
package Input;


public class Input
{
	GetMsg get;
	TranslateMsg translate;
	ChangeLineCode ChangeWay;
	public Input(ChangeLineCode ChangeWay)
	{
		this.ChangeWay = ChangeWay;
	}
	public String GetLine()
	{
		get = new GetMsg(1048576);	//1M size of text
		translate = new TranslateMsg(get.Get());
		translate.Translate(ChangeWay);
		return CharArrayToString.ToString(translate.GetMsg());
	}
	public enum ChangeLineCode
	{
		SlashN,
		SlashR,
		Slash0
	}
	
	
}





