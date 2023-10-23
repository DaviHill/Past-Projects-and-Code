import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortLibrary {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[1000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10000);

        }
        System.out.println("Before (Quicksort): ");
        printArray(numbers);

        final long QSstartTime = System.currentTimeMillis();
        Quicksort(numbers, 0, numbers.length - 1);
        final long QSDuration = System.currentTimeMillis();

        System.out.println("\nAfter (Quicksort): ");
        printArray(numbers);
        NumberFormat QSformatter = new DecimalFormat("#0.00000");
        System.out.print("\n"+"And this took "+ QSformatter.format((QSDuration - QSstartTime)/1000d) +" seconds"+"\n\n\n");
//----------------------------------------------------------------------------------
        Random rand2 = new Random();
        int[] numbers2 = new int[1000];

        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = rand2.nextInt(10000);

        }

        System.out.println("Before (Mergesort): ");
        printArray(numbers2);

        final long MSstartTime = System.currentTimeMillis();
        Mergesort(numbers2);
        final long MSDuration = System.currentTimeMillis();

        System.out.println("\nAfter (Mergesort): ");
        printArray(numbers2);

        NumberFormat MSformatter = new DecimalFormat("#0.00000");
        System.out.print("\n"+"And this took "+ MSformatter.format((MSDuration - MSstartTime)/1000d) +" seconds"+"\n\n\n");
//----------------------------------------------------------------------------------
        Random rand3 = new Random();
        int[] numbers3 = new int[1000];

        for (int i = 0; i < numbers3.length; i++) {
            numbers3[i] = rand3.nextInt(1000000);

        }

        System.out.println("Before (Bubblesort): ");
        printArray(numbers3);

        final long BSstartTime = System.currentTimeMillis();
        Bubblesort(numbers3);
        final long BSDuration = System.currentTimeMillis();

        System.out.println("\nAfter (Bubblesort): ");
        printArray(numbers3);

        NumberFormat BSformatter = new DecimalFormat("#0.00000");
        System.out.print("\n"+"And this took "+ BSformatter.format((BSDuration - BSstartTime)/1000d) +" seconds"+"\n\n\n");
//----------------------------------------------------------------------------------


        System.out.println("Done (BOGOsort): ");


        final long BOGOstartTime = System.currentTimeMillis();
        BOGOsort();
        final long BOGODuration = System.currentTimeMillis();



        NumberFormat BOGOformatter = new DecimalFormat("#0.00000");
        System.out.print("\n"+"And this took "+ BOGOformatter.format((BOGODuration - BOGOstartTime)/1000d) +" seconds"+"\n\n\n");
//----------------------------------------------------------------------------------
    }

    private static void Quicksort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivot = array[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            QSswap(array, leftPointer, rightPointer);
        }
        QSswap(array, leftPointer, highIndex);
        Quicksort(array, lowIndex, leftPointer - 1);
        Quicksort(array, leftPointer + 1, highIndex);
    }

    private static void QSswap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    //-----------------------------------------------------------------------------------------------------------------
    private static void Mergesort(int[] inputArray) {
        int inputLength = inputArray.length;
        if (inputLength < 2) {
            return;
        }
        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }
        Mergesort(leftHalf);
        Mergesort(rightHalf);
        merge(inputArray, leftHalf, rightHalf);

    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int LH = 0, RH = 0, MA = 0;
        while(LH < leftSize && RH < rightSize){
            if(leftHalf[LH] <= rightHalf[RH]){
                inputArray[MA] = leftHalf[LH];
                LH++;
            }
            else {
                inputArray[MA] = rightHalf[RH];
                RH++;
            }
            MA++;
        }
        while(LH < leftSize){
            inputArray[MA] = leftHalf[LH];
            LH++;
            MA++;
        }
        while(RH < rightSize){
            inputArray[MA] = rightHalf[RH];
            RH++;
            MA++;
        }
    }

    //-----------------------------------------------------------------------------------------------------------------
    private static void Bubblesort(int[] numbers){
        Boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i = 0; i < numbers.length-1; i++){
                if (numbers[i] > numbers[i+1]){
                    swapped = true;
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                }
            }
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
    private static void BOGOsort(){
        Random rand = new Random();
        List<Integer> numberList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            numberList.add(rand.nextInt(10000));

        }
        while(!isListSorted(numberList)){
            Collections.shuffle(numberList);
        }
        numberList.forEach(i -> System.out.println(i));
    }

    private static boolean isListSorted(List<Integer> numberList){
        if(numberList == null){
            return true;
        }
        int length = numberList.size();
        if(length <= 1){
            return true;
        }
        for (int i = 0; i < length - 1; i++){
            if (numberList.get(i) > numberList.get(i + 1)){
                return false;
            }
        }
        return true;
    }




















    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

}