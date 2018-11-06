import java.util.Scanner;
import java.io.*; 

public class AL_22_04_2048 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		//Scanner input = new Scanner(System.in);
		long mainScore = 0;
		int sizeOfboard = BufferToInt(bufferRead);
		int numberOfStartValues = BufferToInt(bufferRead);
		long [][] TableOfValues = new long[sizeOfboard][sizeOfboard];
		//wypelnianie tablicy gry zerami
		for(int i=0;i<sizeOfboard;i++)
		{
			for(int j=0;j<sizeOfboard;j++)
			{
				TableOfValues[i][j] = 0;
			}
		}
		//WYpelnianie tablicy wartosciami poczatkowymi
		for(int i =0; i < numberOfStartValues; i++ )
		{
			int temp = BufferToInt(bufferRead);
			TableOfValues[BufferToInt(bufferRead)][BufferToInt(bufferRead)] = temp; 		
		}
		//Pobieranie kolejnych ruchów i ich wykonanie.
		int numberOfMoves = BufferToInt(bufferRead);
		for(int i = 0; i < numberOfMoves ; i++)
		{
			//w zadaniu wyslanym na Spoja , linijke ponizej nalezalo usunac , gdyz powodowala ze zamiast literek Ruchu zczytywal spacje i wynik = 0
			//Problem jest zwi¹zany z systemem operacyjnym. Eclipse dzia³a pod Windows gdzie koniec linijki to dwa znaki \r\n . Ideone uruchamia programy pod Linuxem gdzie koniec linii to po prostu \n.
			
			bufferRead.read();
			switch ((char)bufferRead.read()) 
			{
			case 'G' :
				mainScore += gMove(TableOfValues , sizeOfboard );
				break;
			case 'D' :
				mainScore += dMove(TableOfValues , sizeOfboard );
				break;
			case 'L':
				mainScore += lMove(TableOfValues , sizeOfboard );
				break;
			case 'P':
				mainScore += pMove(TableOfValues , sizeOfboard );
				break;
				
			}
			int temp = BufferToInt(bufferRead);
			TableOfValues[BufferToInt(bufferRead)][BufferToInt(bufferRead)] = temp;
		}
		System.out.print(mainScore);
	}

	public static long gMove(long [][] TableOfValues, int sizeOfboard )
	{
		long score = 0; 
		for(int i=0;i<sizeOfboard;i++)
		{
			int placeForValue = 0;
			for(int j=0;j<sizeOfboard;j++)
			{
				boolean doWeChangePlaceOfValue = false;
				if(TableOfValues[j][i]!=0)
				{
					while(j!=placeForValue && doWeChangePlaceOfValue!=true)
					{
						if(TableOfValues[placeForValue][i] == TableOfValues[j][i] || TableOfValues[placeForValue][i]==0 )
						{
							long valueOfPlaceForValue = TableOfValues[placeForValue][i];
							TableOfValues[placeForValue][i]+=TableOfValues[j][i];
							TableOfValues[j][i]-=TableOfValues[j][i];
							if(valueOfPlaceForValue!=0) 
							{
								placeForValue++;
								score+=2*valueOfPlaceForValue;
							}
							doWeChangePlaceOfValue=true;
						}else
						{
							placeForValue++;
						}	
					}
				}
			}
		}
		return score;
	}
	
	public static long dMove(long [][] TableOfValues, int sizeOfboard )
	{
		long score = 0; 
		for(int i=0;i<sizeOfboard;i++)
		{
			int placeForValue = sizeOfboard-1;
			for(int j=sizeOfboard-1; j >= 0 ;j--)
			{
				boolean doWeChangePlaceOfValue = false;
				if(TableOfValues[j][i]!=0)
				{
					while(j!=placeForValue && doWeChangePlaceOfValue!=true)
					{
						if(TableOfValues[placeForValue][i] == TableOfValues[j][i] || TableOfValues[placeForValue][i]==0 )
						{
							long valueOfPlaceForValue = TableOfValues[placeForValue][i];
							TableOfValues[placeForValue][i]+=TableOfValues[j][i];
							TableOfValues[j][i]-=TableOfValues[j][i];
							if(valueOfPlaceForValue!=0) 
							{
								placeForValue--;
								score+=2*valueOfPlaceForValue;
							}
							doWeChangePlaceOfValue=true;
						}else
						{
							placeForValue--;
						}	
					}
				}
			}
		}
		return score;
	}
	
	public static long pMove(long [][] TableOfValues, int sizeOfboard )
	{
		long score = 0; 
		for(int i=0;i<sizeOfboard;i++)
		{
			int placeForValue = sizeOfboard-1;
			for(int j=sizeOfboard-1; j >= 0 ;j--)
			{
				boolean doWeChangePlaceOfValue = false;
				if(TableOfValues[i][j]!=0)
				{
					while(j!=placeForValue && doWeChangePlaceOfValue!=true)
					{
						if(TableOfValues[i][placeForValue] == TableOfValues[i][j] || TableOfValues[i][placeForValue]==0 )
						{
							long valueOfPlaceForValue = TableOfValues[i][placeForValue];
							TableOfValues[i][placeForValue]+=TableOfValues[i][j];
							TableOfValues[i][j]-=TableOfValues[i][j];
							if(valueOfPlaceForValue!=0) 
							{
								placeForValue--;
								score+=2*valueOfPlaceForValue;
							}
							doWeChangePlaceOfValue=true;
						}else
						{
							placeForValue--;
						}	
					}
				}
			}
		}
		return score;
	}
	
	public static long lMove(long [][] TableOfValues, int sizeOfboard )
	{
		long score = 0; 
		for(int i=0;i<sizeOfboard;i++)
		{
			int placeForValue = 0;
			for(int j=0; j < sizeOfboard ;j++)
			{
				boolean doWeChangePlaceOfValue = false;
				if(TableOfValues[i][j]!=0)
				{
					while(j!=placeForValue && doWeChangePlaceOfValue!=true)
					{
						if(TableOfValues[i][placeForValue] == TableOfValues[i][j] || TableOfValues[i][placeForValue]==0 )
						{
							long valueOfPlaceForValue = TableOfValues[i][placeForValue];
							TableOfValues[i][placeForValue]+=TableOfValues[i][j];
							TableOfValues[i][j]-=TableOfValues[i][j];;
							if(valueOfPlaceForValue!=0) 
							{
								placeForValue++;
								score+=2*valueOfPlaceForValue;
							}
							doWeChangePlaceOfValue=true;
						}else
						{
							placeForValue++;
						}	
					}
				}
			}
		}
		return score;
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
