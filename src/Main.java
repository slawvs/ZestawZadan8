
public class Main {

	public static void main(String[] args) throws NoSuchElementInTable, NoElementsInTable  {
		TableManager tablica = new TableManager();
		for(int i = 0 ; i < 3 ; i++)
		{
			tablica.PushBack(i);
		}
			tablica.PrintTable();
			System.out.println(tablica.getLastAndRemove());
			System.out.println(tablica.getLastAndRemove());
			System.out.println(tablica.getLastAndRemove());
			System.out.println(tablica.getLastAndRemove());
			System.out.println(tablica.getElementFromPosition(5));
			tablica.PushBack(33);
			tablica.PushBack(33);
			System.out.println(tablica.getLast());

	}
}
