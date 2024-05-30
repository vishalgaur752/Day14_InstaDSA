public class PaintersPartiton {
    public static int maxTime(int arr[], int a, int b) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < arr.length; i++) {
            high = high + arr[i];
        }
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossibleSol(arr, a, mid) == true) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static boolean isPossibleSol(int arr[], int a, int m) {
        int painter = 1;
        int pbc = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > m) {
                return false;
            }
            if (pbc + arr[i] <= m) {
                pbc = pbc + arr[i];
            } else {
                painter++;
                if (painter > a) {
                    return false;
                }
                pbc = arr[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40 };
        int a = 2;
        int b = 2;
        System.out.println(maxTime(arr, a, b));
    }
}
