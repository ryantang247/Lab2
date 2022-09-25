import java.util.Scanner;

public class Test {
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        int[] numberArray = {1,2,3,4,5,6,7,8,9};
        //int number =testFunction(numberArray,10,0,1);
        System.out.println(testCalculate(numberArray,10));
    }

    //Note: Remember BinarySearch gives only -1 and index of located number
    static int testFunction(int[]array,int sum, int a, int b){
        int counter = 0;

        for(int i=0;i<array.length;i++){
            int i1 = array[i];
            int i2 = array[b];

            System.out.println("");
            System.out.println("x: "+ sum);
            System.out.println("a1: "+ a + " b1: "+ b);
            System.out.println("i1: "+i1+" i2: "+i2);

            ///finds given array location number for both i and j


            if(i1+i2==sum){
                System.out.println("Added");
                counter+=1;

            } else{
                int k =binarySearch(array,0, array.length-1,i2);
                if(k==-1){
                    testFunction(array, sum,  a,  b+1);
                }else {

                }
            }

            //counter still zero because recurse keeps making new counter in each recursion
        }
        return counter;

    }

    static int testCalculate(int[]array,int sum){
        int counter =0;
        for(int i=0;i< array.length;i++){

            for(int j=0;j< array.length;j++){
                int x= binarySearch(array,0,array.length-1,sum-array[j]-array[i]);
                int a = array[i];
                int b = array[j];
                if(x!=-1 && a+b+array[x]==sum){
                    System.out.println("a: "+a+"b: "+b+"x: "+x);
                    counter+=1;
                }

            }

        }

        return counter;
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
    static int binaryUpperSearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x || arr[mid]<x)
                return mid+1;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binaryUpperSearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binaryUpperSearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    static int binaryLowerSearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x ||arr[mid]<x)
                return mid-1;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binaryLowerSearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binaryLowerSearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    public static int search(int[] a,int l, int r,int value) {

        //handles if value is out of array
        if(value < a[0]) {
            return a[0];
        }
        if(value > a[a.length-1]) {
            return a[a.length-1];
        }

        //recurse until finding value's location
        while (l <= r) {
            int mid = (r + l) / 2;

            if (value < a[mid]) {
                r = mid - 1;
            } else if (value > a[mid]) {
                l = mid + 1;
            } else {
                return a[mid];
            }
        }
        // determines whether the value should take left or right
        return (a[l] - value) < (value - a[r]) ? a[l] : a[r];
    }
}
