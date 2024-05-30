public class AllocatedBook {
    public static int allocatedBooks(int arr[], int n, int m) {
        if (n < m) {
            return -1;
        }
        int l = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > l) {
                l = arr[i];
            }
        }
        int h = 0;
        for (int j = 0; j < n; j++) {
            h += arr[j];
        }
        int res = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isFeasible(mid, arr, m)) {
                res = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static boolean isFeasible(int n, int arr[], int m) {
        int stu = 1, pages = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > n) {
                return false;
            }
            if (pages + arr[i] > n) {
                stu++;
                pages = arr[i];
            } else {
                pages += arr[i];
            }
        }
        if (stu > m) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 34, 67, 90 };
        int n = 4;
        int m = 2;
        System.out.println(allocatedBooks(arr, n, m));
    }
}