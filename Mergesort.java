 
import java.util.Arrays;

public class Mergesort {
	public static void main(String[] args) {
		int[] a = { 10, 2, 5, 2, 3, 9 };
		int l = 0, r = a.length - 1;
		divide(a, l, r);
		System.out.println(Arrays.toString(a));
	}

	public static void divide(int[] a, int l, int r) {
		if (l == r)
			return;
		int m = (l + r) / 2;
		divide(a, l, m);
		divide(a, m + 1, r);
		merge(a, l, m, r);
	}

	public static void merge(int[] a, int l, int m, int h) {
		int left = l, right = m + 1, x = 0;
		int[] res = new int[a.length];
		while (left <= m && right <= h) {
			if (a[right] > a[left])
				res[x++] = a[left++];
			else
				res[x++] = a[right++];

		}
		while (left <= m) {
			res[x++] = a[left++];
		}
		while (right <= h) {
			res[x++] = a[right++];
		}
		int k = 0;
		for (int i = l; i <= h; i++) {
			a[i] = res[k++];
		}
	}
}

