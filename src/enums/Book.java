package enums;

public class Book {
	public enum BookGenre {
		BIOGRAPHY(12), HORROR(15);
		private int minAge;

		private BookGenre(int minAge) {
			this.minAge = minAge;
		}

		public int minAgetoRead() {
			return minAge;
		}
	}
	public static void main(String[] args) {
		for (BookGenre bookGenre : BookGenre.values()) {
			System.out.print("\nName: " + bookGenre); // toString
			System.out.print(", name(): " + bookGenre.name());
			System.out.print(", Ordinal: " + bookGenre.ordinal());
			System.out.print(", Declaring Class: "
					+ bookGenre.getDeclaringClass());
			System.out.print(", compareTo(HORROR): "
					+ bookGenre.compareTo(BookGenre.HORROR));
			System.out.print(", equals(HORROR): "
					+ bookGenre.equals(BookGenre.HORROR));
			System.out.println(", MinAge: " + bookGenre.minAge);
		}
	}
}
