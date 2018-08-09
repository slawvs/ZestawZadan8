import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.Collections;

public class AL_22_01 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		int numberOfTests = BufferToInt(bufferRead);
		for( int i = 0 ; i < numberOfTests; i++ )
		{
			long result=0;
			int numberOfClothes = BufferToInt(bufferRead);
			int limitOfClothes = BufferToInt(bufferRead);
			Vector<Integer> tableOfValue = new Vector<Integer>();
			for(int  j = 0 ; j < numberOfClothes ; j++)
			{
				tableOfValue.add(BufferToInt(bufferRead));
			}
			Collections.sort(tableOfValue);
			int actuallIndex = numberOfClothes-1;
			while( actuallIndex-(limitOfClothes-1) >= 0 )
			{
				actuallIndex-=(limitOfClothes-1);
				result += tableOfValue.get(actuallIndex);
				actuallIndex--;
			}
			System.out.println(result);
		}	
	}

	public static int BufferToInt(BufferedReader bufferRead) throws IOException
	{
		int character;
		int result=0;
		do 
		{
			character=bufferRead.read();
		} while (character < '0' || character > '9');
		while ( (character >= '0' && character <= '9'))
		{
			result = result * 10 + character - '0';
			character = bufferRead.read();
		}
		return result;
	}
}
