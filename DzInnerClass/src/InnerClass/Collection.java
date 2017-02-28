package InnerClass;

public class Collection {

	private static int valueLenght;

	private static Object[] value = new Object[valueLenght];

	public Collection(int valueLenght, Object[] value) {
		Collection.valueLenght = valueLenght;
		Collection.value = value;
	}

	public Collection() {
	}

	public int getVaueLenght() {
		return valueLenght;
	}

	public void setVaueLenght(int vaueLenght) {
		Collection.valueLenght = vaueLenght;
	}

	public Object[] getValue() {
		return value;
	}

	public void setValue(Object[] value) {
		Collection.value = value;
	}

	public class FirstInner implements Iterator {

		@Override
		public void hasNext() {
			for (int i = 0; i < value.length; i++) {
				System.out.print((Integer) value[i] + " ");
			}
			System.out.println();
		}

		@Override
		public void next() {
			for (int i = 0; i < value.length; i++) {
				if ((Integer) value[i] % 2 != 0) {
					value[i] = 0;
				}
			}
		}
	}

	public class SecondInner implements Iterator {

		@Override
		public void hasNext() {
			for (int i = value.length - 1; i >= 0; i -= 2) {
				System.out.print((Integer) value[i] + " ");
			}
			System.out.println();
		}

		Iterator second = new Iterator() {
			@Override
			public void hasNext() {
				for (int i = value.length - 1; i >= 0; i -= 3) {
					if ((Integer) value[i] % 2 != 0) {
						System.out.print((Integer) value[i] + " ");
					}
				}
			}

			@Override
			public void next() {
			}
		};

		@Override
		public void next() {
		}
	}

	public void odd() {
		class Even {
			public void even() {
				for (int i = 0; i < value.length; i += 5) {
					if ((Integer) value[i] % 2 == 0) {
						value[i] = (Integer) value[i] - 100;
						System.out.print(value[i] + " ");
					}
				}
			}
		}
		Even even1 = new Even();
		even1.even();
	}

	public static class EvenToOdd {
		public void even() {
			for (int i = 0; i < value.length; i += 2) {
				if ((Integer) value[i] % 2 == 0) {
					value[i] = (Integer) value[i] + 1;
					System.out.print(value[i] + " ");
				}
			}
		}
	}
}
