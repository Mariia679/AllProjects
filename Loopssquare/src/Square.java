public class Square {
	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.printf("%4d", (j + 1) * (i + 1));
			}
			System.out.println();
		}
	}
}
