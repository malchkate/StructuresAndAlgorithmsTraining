//package SearchNSort;

import java.util.Scanner;

public class CountingSort {

    private void countingSort(){
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        int[] array = new int[20001];
        for (int i = 0; i < N; i++) {
            array[scIn.nextInt() + 10000]++;
        }
        printArray(array);
    }
    private void printArray(int[] array){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i] ; j++) {
                int x = i - 10000;
                stringBuffer.append( x + "  ");
            }
        }
        System.out.println(stringBuffer.toString());
    }

    public static void main(String[] args) {
        new CountingSort().countingSort();
    }
}
