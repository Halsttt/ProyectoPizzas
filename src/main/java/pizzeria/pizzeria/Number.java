package pizzeria.pizzeria;

public class Number {
	
	public static int id = 1;
	private int number;

	public Number() {
		super();
		this.number = Number.id++;
	}

	@Override
	public String toString() {
		return "" + number + "";
	}
	
	
}
