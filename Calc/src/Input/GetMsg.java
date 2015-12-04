package Input;

import java.io.IOException;

class GetMsg
{
	static char[] buffer;
	java.io.InputStreamReader Reader;
	public GetMsg(int BufferLength)
	{	
		buffer = new char[BufferLength];
		Reader = new java.io.InputStreamReader(System.in);
	}
	public char[] Get()
	{
		try {
			Reader.read(buffer, 0, buffer.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buffer;
	}
	public void Get(char[] msg) 
	{
		try {
			Reader.read(buffer, 0, buffer.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg = buffer;
	}
}
