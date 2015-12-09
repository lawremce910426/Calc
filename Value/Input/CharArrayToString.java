package Input;
class CharArrayToString
{
	static String ToString(char[] array)
	{
		String ret = "";
		for(int i = 0 ; i != array.length;)
		{
			ret += array[i++];
		}
		return ret;
	}
}