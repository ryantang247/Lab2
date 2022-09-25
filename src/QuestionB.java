import java.util.*;

public class QuestionB {
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);

        int arrayNum = sc.nextInt();
        int sum = sc.nextInt();

        int[] numberArray = new int [arrayNum];

        if(arrayNum<=3000 & arrayNum>0){
            for(int i=0; i<arrayNum;i++){
                numberArray[i]= sc.nextInt();
            }
        }

        System.out.println((testCalculate(numberArray, sum)));
    }

    static int testCalculate(int[]array,int sum){

        Map<Integer, Integer> map = new TreeMap<>();

        for (int value : array) {
            if (map.containsKey(value)) {
                map.merge(value, 1, Integer::sum);
            } else {
                map.put(value, 1);
            }
        }
        map.forEach((key, value) -> System.out.println(key + ":" + value));

        ArrayList<int[]>resultArray = new ArrayList<>();

        int counter =0;
        for(int i=0;i< array.length;i++){
            for(int j = i + 1; j < array.length; j++){
//                System.out.println("Indexes before filter i-> "+i+" j-> "+j);
//                System.out.println(sum-array[i]-array[j]);
                if((Arrays.binarySearch(array,sum-array[i]-array[j])>=0)){
                    int k = Arrays.binarySearch(array,sum-array[i]-array[j]);

                    if((j>i) && k>j) {
                        System.out.println("i-> "+i +" j-> "+ j+" k->" +k);

                        if(array[i]==array[j] && array[j]==array[k]){
                            //System.out.println("A+A+A");
                            long value = map.get(array[k]);
                            int result = (int) (( value *(value+1)*(value+2))/6);
                            counter=counter+result;
                            //System.out.println(result);
                            addArray(array[i],array[j],array[k],resultArray);

                            //k = binaryUp(array,0, array.length-1, array[k]);

                        }else if( array[j]==array[k]){
                            //System.out.println("A+B+B");
                            long value = map.get(array[k]);
                            long iValue = map.get(array[i]);
                            int result = (int) (( value * (value + 1)) / 2);
                            counter=counter+result;
                            addArray(array[i],array[j],array[k],resultArray);

                            //k = binaryUp(array,0, array.length-1, array[k]);
                            //System.out.println("i-> "+i +" j-> "+ j+" k->" +k);
                           //System.out.println(result);

                        } else if(array[i]==array[j]){
                            //A+A+B
                            //System.out.println("A+A+B");
                            long value = map.get(array[i]);
                            long kValue = map.get(array[k]);

                            int result = (int) ((value * (value + 1)) / 2);
                            counter= (int) (counter+result+kValue);
                            addArray(array[i],array[j],array[k],resultArray);


                            //j = binaryUp(array,0, array.length-1, array[j]);
                            //System.out.println("i-> "+i +" j-> "+ j+" k->" +k);
                            //System.out.println(result);

                        }else {
                            //A+B+C
                            long iValue = map.get(array[i]);
                            long jValue = map.get(array[j]);
                            long kValue = map.get(array[k]);


                            counter= (int) (counter+iValue+jValue+kValue);
                            //System.out.println("A+B+C");
                            addArray(array[i],array[j],array[k],resultArray);
                            //System.out.println(counter);
//                            i = binaryUp(array,0, array.length-1, array[i]);
//                            j = binaryUp(array,0, array.length-1, array[j]);
//                            k = binaryUp(array,0, array.length-1, array[k]);
                            System.out.println("i-> "+i +" j-> "+ j+" k->" +k);
                        }

                    }
                }
            }
        };

        for(int i[]: resultArray){
            System.out.println(Arrays.toString(i));
        }
        return counter;
    }

    static void addArray (int i , int j , int k,ArrayList<int[]>arrayList){
        int [] array= new int[3];
        array[0]= i;
        array[1]= j;
        array[2]= k;

        arrayList.add(array);
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

    }
}
