
public class TableManager {
	private int [] uchwyt;
	private int ileJestObecnieElementowWTablicy;
	TableManager()
	{
		uchwyt = new int[10];
	}
	
	void PushBack(int number)
	{
		if(ileJestObecnieElementowWTablicy >= uchwyt.length)
		{
			int [] refTemp = new int[ileJestObecnieElementowWTablicy  + 10];
			for(int i = 0; i < ileJestObecnieElementowWTablicy ; i++)
			{
				refTemp[i] = uchwyt[i];
			}
			uchwyt = refTemp;
		}
		uchwyt[ileJestObecnieElementowWTablicy++] = number;
	}
	
	void PrintTable() throws NoElementsInTable
	{
		if(ileJestObecnieElementowWTablicy>0)
		{
			for(int i = 0; i < ileJestObecnieElementowWTablicy; i++)
			{
				System.out.println("element nr " + i + " = " + uchwyt[i]);
			}
		}else
		{
			throw new NoElementsInTable();
		}

	}
	
	int getLast() throws NoElementsInTable
	{
		if(ileJestObecnieElementowWTablicy > 0)
		{
			return uchwyt[ileJestObecnieElementowWTablicy-1];
		}
		else
		{
			throw new NoElementsInTable();
		}
		
	}
	
	int getLastAndRemove() throws NoElementsInTable
	{
		if(ileJestObecnieElementowWTablicy > 0)
		{
			return uchwyt[ileJestObecnieElementowWTablicy---1];
		}
		else
		{
			throw new NoElementsInTable();
		}
	}
	
	int getElementFromPosition(int position) throws NoSuchElementInTable
	{
		if(position < 0 || position >= ileJestObecnieElementowWTablicy)
		{
			throw new NoSuchElementInTable(position);
		}
		else return uchwyt[position];
		
	}
}
