
public class NoSuchElementInTable extends Exception {

	private static String message = "Nie ma takiego indeksu w tablicy: ";
	public NoSuchElementInTable(int index) {
		super(message+index);
		// TODO Auto-generated constructor stub
	}

}
