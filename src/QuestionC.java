import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuestionC {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int studentNumber = sc.nextInt();
        int cakeNumber = sc.nextInt();

        double[] radiusArray = new double[cakeNumber];
        double[] areaArray = new double[cakeNumber];

        for(int i =0; i<radiusArray.length;i++){
            radiusArray[i]= sc.nextInt();
        }

        for(int i =0; i<radiusArray.length;i++){
            areaArray[i]=((radiusArray[i])*(radiusArray[i])*Math.PI);
        }

        //Print all area array

//        System.out.println("areaArray: ");
//        for(double i: areaArray){
//            System.out.println(i);
//        }

        Arrays.sort(areaArray);
        double largestArea = areaArray[areaArray.length-1];


        //Print largest Number
        System.out.println(largestArea);

//        while(largestArea>0.00005){
//
//            double divider = studentNumber;
//            for(int i = areaArray.length-1;i>=0;i--){
//                double dividedNumber = Math.floor(areaArray[i]/divider);
//                divider=divider-dividedNumber;
//
//            }
//
//            if(divider>0){
//                largestArea=largestArea/2;
//            }else if(divider<0){
//
//            }else if(divider==0){
//                break;
//            }
//        }

        binarySearch(0, largestArea,studentNumber,areaArray);
    }

    static double binarySearch (double lowBounds, double highBounds, double studentNumber, double[]areaArray){

        double initialNumber = highBounds/2;
        System.out.println("lowBounds-> " + lowBounds + " highBounds->"+highBounds+ " initialNumber->"+initialNumber);

        double number = studentNumber;
        while(highBounds-lowBounds>0.00005){
            for(double area : areaArray){
                double dividedNumber = area/initialNumber;
                number = number -dividedNumber;
            }

        }
        if(number>0){
            return binarySearch(initialNumber, highBounds,studentNumber,areaArray);
        }else if(number==0) {
            return initialNumber;
        }else if(number<0){
            return binarySearch(lowBounds, initialNumber,studentNumber,areaArray);
        }
        return -1;
    }

}
