import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Test3 {

    public static void main (String args[])
    {

        //if number is in array, use binaryDown for right side, binaryUp+1 for left side
        //if number is not in array, use binary down to the nearest left number
        int[] a={1,2,2,2,2,4,5,6,9};
        //   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
        //System.out.println(18+" "+binaryUp(a,0, a.length-1,18));
        for(int i =1; i<= 9;i++){
            System.out.println(i+" "+binarySearchLow(a,0, a.length-1,i));
            System.out.println(i+" "+binaryUp(a,0, a.length-1,i));
            System.out.println("");

        }


    }

    //Note these two binarySearch, one use recursion and one use iterative.

    static int binarySearchHigh(int arr[], int l, int r, int x)
    {

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

    public static void addElement(Map<Integer, Integer> map, int element) {
        int count =0;
        if (map.containsKey(element)) {
            count = count + 1;
            System.out.println("count: "+count);
            map.replace(element, count);
        } else {
            map.put(element, 1);
        }
    }

    static ArrayList<int[]> findDuplicates(
            ArrayList<int[]> arr)
    {
        System.out.println("Original array");
        for(int i=0; i< arr.size();i++){
            System.out.println(Arrays.toString(arr
                    .get(i)));
        }
        // initialize ifPresent as false
        boolean ifPresent = false;

        // ArrayList to store the output
        ArrayList<int[]> al = new ArrayList<>();

        al.add(arr.get(0));
        for(int[]array :arr){
            for(int[]i : al){
                if(Arrays.equals(i, array)){
                    al.add(array);
                }
            }
        }
        return al;
    }


    static int binarySearchLow(int arr[], int l, int r, int x){
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

}}
