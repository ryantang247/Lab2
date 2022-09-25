import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int count_Triplets(int[] A, int sum){
        int count=0;

        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                for(int k = j + 1; k < A.length; k++){
                    if(A[i] + A[j]+ A[k]==sum){
                        System.out.println(A[i]+" "+A[j]+" "+A[k]+" ");
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int arrayNum = sc.nextInt();
        int sum = sc.nextInt();

        int[] numberArray = new int [arrayNum];

        if(arrayNum<=3000 & arrayNum>0){
            for(int i=0; i<arrayNum;i++){
                numberArray[i]= sc.nextInt();
            }
        }

        System.out.println(count_Triplets(numberArray,sum));
    }

    static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
