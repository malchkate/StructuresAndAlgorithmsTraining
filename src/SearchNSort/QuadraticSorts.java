package SearchNSort;

import java.util.Scanner;

public class QuadraticSorts {

    private void maxFirst(){
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        int maxI = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scIn.nextInt();
            if(arr[i]> arr[maxI]){
                maxI = i;
            }
        }
        int temp = arr[0];
        arr[0] = arr[maxI];
        arr[maxI] = temp;
        printArray(arr, N);
    }
    private void maxSelectionSort(){
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scIn.nextInt();
        }
        for (int j = N-1; j > 0; j--) {
            int maxI = 0;
            for (int i = 0; i <= j; i++) {
                if (arr[i] > arr[maxI]){
                    maxI = i;
                }
            }
            int temp = arr[j];
            arr[j] = arr[maxI];
            arr[maxI] = temp;
        }
        printArray(arr, N);
    }
    private void numberInsertionFunc(){
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        int[] initArray = new int[N];
        for (int i = 0; i < N; i++) {
            initArray[i] = scIn.nextInt();
        }
        int numberToInsert = scIn.nextInt();
        int numberToInsertIndex = scIn.nextInt()-1;
        int[] resultArray = new int[N+1];
        resultArray[numberToInsertIndex] = numberToInsert;
        for (int i = 0; i < N+1; i++) {
            if (i < numberToInsertIndex){
                resultArray[i] = initArray[i];
            } else if (i > numberToInsertIndex){
                resultArray[i] = initArray[i-1];
            }
        }
        printArray(resultArray, N+1);
    }
    private void insertionSort(){
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        int[] array = new int[N];
        if (N > 0){
            array[0] = scIn.nextInt();
        }
        for (int i = 1; i < N; i++) {
            array = numberInsertion(array, i, scIn.nextInt());
        }
        printArray(array, N);
    }
    private int[] numberInsertion(int[] arr, int N, int number){
        int[] resultArray = new int[N+1];
        boolean addedNumber = false;
        if (number < arr[0]){
            resultArray[0] = number;
            addedNumber = true;
        } else{
            resultArray[0] = arr[0];
        }
        for (int i = 1; i < N+1; i++) {
            if (addedNumber){
                resultArray[i] = arr[i-1];
            } else{
                if (i == N || number < arr[i]){
                    resultArray[i] = number;
                    addedNumber = true;
                } else {
                    resultArray[i] = arr[i];
                }
            }
        }
        return resultArray;
    }
    private void bubbleSort(){
        int changesCount = 0;
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scIn.nextInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-i-1; j++) {
                if (array[j] > array[j+1]){
                    array = changeArrayElems(array, j, j+1);
                    changesCount++;
                }
            }
        }
        //printArray(array, N);
        System.out.println(changesCount); // how many changes were made during the sort
    }
    private int[] changeArrayElems(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }
    private void printArray(int[] arr, int N){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < N; i++) {
            stringBuffer.append(arr[i] + " ");
        }
        System.out.println(stringBuffer.toString());
    }

    public static void main(String[] args) {
        new QuadraticSorts().bubbleSort();
    }
}
