package SearchNSort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuickSort {

    private void quickSort(Map<Long,Long> array, long l, long r){
        if(l >= r){
            return;
        }
        long m = partition(array, l, r);
        quickSort(array, l, m-1);
        quickSort(array, m+1, r);
    }
    private long partition(Map<Long,Long> array, long l, long r){
        long x = array.get(l);
        long j = l;
        for (long i = l+1; i <= r; i++) {
            if (array.get(i) <= x){
                j++;
                changeElements(array, i, j);
            }
        }
        changeElements(array, l, j);
        return j;
    }
    private void changeElements(Map<Long,Long> array, long i, long j){
        long temp = array.get(i);
        array.remove(i);
        array.put(i, array.get(j));
        array.remove(j);
        array.put(j, temp);
    }
    private void quickSortFun(){
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        Map<Long, Long> array = new HashMap<>();
        for (long i = 0; i < N; i++) {
            array.put(i,scIn.nextLong());
        }
        quickSort(array, 0, N-1);
        printArray(array, N);
    }
    private void printArray(Map<Long, Long> array, long N){
        StringBuffer stringBuffer = new StringBuffer();
        for (long i = 0; i < N; i++) {
            stringBuffer.append(array.get(i) + " ");
        }
        System.out.println(stringBuffer.toString());
    }
    public static void main(String[] args) {
        new QuickSort().quickSortFun();
    }
}
