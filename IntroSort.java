
// original Copyright Ralph Unden, 
// http://ralphunden.net/content/tutorials/a-guide-to-introsort/?q=a-guide-to-introsort
// Modifications: Bernhard Pfahringer 
//  changes include: local insertion sort, no global array


/**
 * O(n log n)
 *
 */
public class IntroSort {
	/*
	 * Class Variables
	 */
	private static int size_threshold = 16;


	/**
	 * @param a tableau à trier
	 */
	public static void sort(Occurrence[] a) {
		introsort_loop(a, 0, a.length, 2 * floor_lg(a.length));
	}

	/**
	 * Quicksort algorithm modified for Introsort
	 * @param a tableau à tier
	 * @param lo index minimal du tableau
	 * @param hi index maximal du tableau
	 * @param depth_limit profondeur limite
	 */
	private static void introsort_loop(Occurrence[] a, int lo, int hi, int depth_limit) {
		while (hi - lo > size_threshold) {
			depth_limit = depth_limit - 1;
			int p = partition(a, lo, hi,
					medianof3(a, lo, lo + ((hi - lo) / 2) + 1, hi - 1));
			introsort_loop(a, p, hi, depth_limit);
			hi = p;
		}
		insertionsort(a, lo, hi);
	}

	/**
	 * @param a tableau à trier
	 * @param lo index minimal du tableau
	 * @param hi index maximal du tableau
	 * @param x tableau découpé
	 * @return
	 */
	private static int partition(Occurrence[] a, int lo, int hi, int x) {
		int i = lo, j = hi;
		while (true) {
			while (a[i].getOcu() < x)
				i++;
			j = j - 1;
			while (x < a[j].getOcu())
				j = j - 1;
			if (!(i < j))
				return i;
			exchange(a, i, j);
			i++;
		}
	}

	private static int medianof3(Occurrence[] a, int lo, int mid, int hi) {
		if (a[mid].getOcu() < a[lo].getOcu()) {
			if (a[hi].getOcu() < a[mid].getOcu())
				return a[mid].getOcu();
			else {
				if (a[hi].getOcu() < a[lo].getOcu())
					return a[hi].getOcu();
				else
					return a[lo].getOcu();
			}
		} else {
			if (a[hi].getOcu() < a[mid].getOcu()) {
				if (a[hi].getOcu() < a[lo].getOcu())
					return a[lo].getOcu();
				else
					return a[hi].getOcu();
			} else
				return a[mid].getOcu();
		}
	}

	/*
	 * Insertion sort algorithm
	 */
	private static void insertionsort(Occurrence[] a, int lo, int hi) {
		int i, j;
		Occurrence t;
		for (i = lo; i < hi; i++) {
			j = i;
			t = a[i];
			while (j != lo && t.getOcu() < a[j - 1].getOcu()) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = t;
		}
		
	}

	/*
	 * Common methods for all algorithms
	 */
	private static void exchange(Occurrence[] a, int i, int j) {
		Occurrence t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * @param a
	 * @return 8 (pour un tableau dont la taille fait 256)
	 */
	private static int floor_lg(int a) {
		return (int) (Math.floor(Math.log(a) / Math.log(2)));
	}

}
