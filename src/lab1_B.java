
import java.util.*;

public class lab1_B {

    public static int removeDuplicate(int a[], int n){
        if (n == 0 || n == 1) {
            return n;
        }

        // creating another array for only storing
        // the unique elements
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                temp[j++] = a[i];
            }
        }

        temp[j++] = a[n - 1];

        // Changing the original array
        for (int i = 0; i < j; i++) {
            a[i] = temp[i];
        }

        return j;
    }


    public static long triplet(int[] a, int S) {
        long count = 0;

        Map<Integer, Integer> map = new TreeMap<>();
        for (int value : a) {
            addElement(map, value);
        }

        map.forEach((key, value) -> System.out.println(key + ":" + value));

        for (int i = 0; i < a.length - 2; i++) {
            int left = i + 1;
            int right = a.length - 1;

            while ((left <= right)) {
                if (a[left] + a[right] == S - a[i]) {
                    System.out.println("i-> "+i + " a[i]-> "+a[i] );
                    if (a[i] == a[left] && a[i] == a[right]) {
                        int temp = map.get(a[i]) - 2;
                        count += ((long) temp * (temp + 1) * (temp + 2)) / 6;
                        i += temp;
                        break;
                    }
                    else if (a[left] == a[right]) {
//                        System.out.println("a[left] "+a[left]);
//                        System.out.println("map.get(a[left]) "+map.get(a[left]));

                        int temp = map.get(a[left]) - 1;
                        count += ((long) temp * (temp + 1)) / 2;
                    }
                    else if (a[left] == a[i]) {
//                        System.out.println("a[right] "+a[right]);
//                        System.out.println("map.get(a[right]) "+map.get(a[right]));

                        int temp = map.get(a[right]);
                        count += temp;
                    }
                    left++;
                    right--;
                }
                else if (a[left] + a[right] < S - a[i]) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return count;
    }

    /*public static long triplet(int[] a, int S){
        int count = 0;

        Map<Integer, Integer> map = new TreeMap<>();
        for (int value : a) {
            addElement(map, value);
        }

        for(int i = 0; i < a.length - 2; i++){
            for (int j = i + 1; j < a.length - 1; j++){
                int left = j + 1;
                int right = a.length - 1;
                int ak = S - (a[i] + a[j]);

                while(left <= right){
                    int mid = (right + left + 1)/2;

                    if(a[mid] == ak){
                        if(a[mid] == a[i] && a[mid] == a[j]){
                            int temp = map.get(a[mid]) - 2;
                            count += (temp * (temp + 1) * (temp + 2))/6;
                            i += temp;
                            break;
                        }
                        else if(a[mid] == a[j]){
                            int temp = map.get(a[mid]) - 1;
                            count += (temp * (temp + 1))/2;
                            j += temp;
                            break;
                        }
                        else{
                            count += map.get(a[mid]);
                            break;
                        }
                    }
                    else if(a[mid] < ak){
                        left = mid + 1;
                    }
                    else{
                        right = mid - 1;
                    }
                }
            }
        }
        return count;
    }*/



    public static void addElement(Map<Integer, Integer> map, int element) {
        if (map.containsKey(element)) {
            int count = map.get(element) + 1;
            map.put(element, count);
        } else {
            map.put(element, 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int S = input.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        int length = a.length;
        length = removeDuplicate(a, length);
//        for(int i : a){
//            System.out.print(i + " ");
//        }

        System.out.println(triplet(a, S));

    }




}