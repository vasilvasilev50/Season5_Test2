package salesVignettes;

public class SortVignettes {

	static void quickSort(Vignette[] array, int begin, int end) {
		if (begin >= end) {
			return;
		}

		int position = partition(array, begin, end);
		quickSort(array, begin, position - 1);
		quickSort(array, position + 1, end);
	}

	static int partition(Vignette[] a, int l, int r) {
		// get random index of element
		int randomIndex = ((int) (Math.random() * (r - l + 1))) + l;

		// swap with the last
		Vignette temp = a[r];
		a[r] = a[randomIndex];
		a[randomIndex] = temp;

		float x = a[r].getPrice();
		int lastIndexOfSmallerElement = l - 1;

		for (int index = l; index <= r; index++) {
			if (a[index].getPrice() <= x) {
				lastIndexOfSmallerElement++;

				temp = a[index];
				a[index] = a[lastIndexOfSmallerElement];
				a[lastIndexOfSmallerElement] = temp;
			}
		}
		return lastIndexOfSmallerElement;
	}

	static Vignette[] bubbleSort(Vignette[] array) {
		Vignette temp = null;

		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < (array.length - i); j++) {
				if (array[j - 1].getPrice() > array[j].getPrice()) {
					// swap the elements!
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

}
