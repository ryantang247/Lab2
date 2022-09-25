import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question_A {
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        int arrayNumber = scanner.nextInt();
        int queryNumber = scanner.nextInt();

        if(arrayNumber>0 && queryNumber>0){
            int [] array = new int[arrayNumber];

            for(int i =0; i<arrayNumber;i++){
                int number = scanner.nextInt();
                array[i]=number;
            }

            int[][] resultArray = new int[queryNumber][2];
            int[][] rangeArray = new int[queryNumber][2];

            for(int i =0; i<queryNumber;i++){

                int range = scanner.nextInt();
                int range2 = scanner.nextInt();

                rangeArray[i][0]= range;
                rangeArray[i][1]= range2;

                if(binarySearch(array,0,array.length-1,range)==-1){
                    int index = binarySearchLow(array, 0, array.length-1,range);
                    resultArray[i][0]=index;

                }else {
                    int index = binaryUp(array, 0, array.length-1,range);
                    resultArray[i][0]=index+1;

                }

                int index2 = binarySearchLow(array, 0, array.length-1,range2);
                resultArray[i][1]=index2;

            }

            for(int i =0;i<queryNumber;i++){

                int index = resultArray[i][0];
                int index2 = resultArray[i][1];
                //System.out.println("new index "+index+" new index2 "+index2);

                if((index2-index)>0){

                    int result = index2-Math.abs(index);

                    System.out.println("YES "+ (result));

                }else {
                    System.out.println("NO");
                }
            }

        }

    }

    static int binaryUp(int arr[], int l, int r, int x)
    {
        int mid;
        while(l<r){
            mid=(l+r+1)/2;
            if(arr[mid]>x){
                r=mid-1;
            }
            else l=mid;
            //mid keeps getting divided until r diminishes, mid keeps getting divided due to l
        }

        return l;

    }

    static int binarySearchLow(int arr[], int l, int r, int x)
    {
        //System.out.println("Binary Search Low");
        if (r >= l) {
            int mid = l + (r - l) / 2;
            //System.out.println("l-> "+l + " r-> "+r + " mid-> "+mid);

            if (arr[mid] == x){
                return binarySearchLow(arr, l, mid - 1, x);
            }

            //limits the range to mid-1
            if (arr[mid] > x){
                return binarySearchLow(arr, l, mid - 1, x);

            }
            //for l , mid+1 is used to replace it and is divided
            return binarySearchLow(arr, mid + 1, r, x);
        }
        return l;
    }

    static int binarySearchHigh(int arr[], int l, int r, int x)
    {
        //System.out.println("Binary Search High");
        if (r >= l) {
            int mid = l + (r - l) / 2;
            //System.out.println("l-> "+l + " r-> "+r + " mid-> "+mid);

            if (arr[mid] == x){
                return binarySearchHigh(arr, mid+1, r , x);

            }

            //limits the range to mid-1
            if (arr[mid] > x){
                return binarySearchHigh(arr, l, mid - 1, x);

            }

            //for l , mid+1 is used to replace it and is divided
            return binarySearchHigh(arr, mid + 1, r, x);
        }
        return l-1;
    }

    static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
    }

}
