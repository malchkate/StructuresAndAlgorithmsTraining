package SearchNSort;

import java.util.Scanner;

/**
 * Created by Katerina on 27.05.2018.
 */
public class BinSearch {
    private int binSearchPrep(long[] arr, int l, int r, long x){
        int m;
        while (l < r - 1){
            m = (l + r) / 2;
            if (arr[m] < x){
                l = m;
            } else{
                r = m;
            }
        }
        return (arr[r] == x)?r:l;
    }
    public void approximateBinSearch(){
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        int K = scIn.nextInt();
        long[] arrN = new long[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = scIn.nextLong();
        }
        for (int i = 0; i < K; i++) {
            long x = scIn.nextLong();
            int l = 0;
            int r = N -1;

            int m;
            while (l < r - 1){
                m = (l + r) / 2;
                if (arrN[m] < x){
                    l = m;
                } else{
                    r = m;
                }
            }
            long result = arrN[l];
            long difference = Math.abs(result - x);
            if ( Math.abs(arrN[r] - x) < difference){
                result = arrN[r];
            }
            System.out.println(result);
        }
    }
    public void binSearchComplexity(){
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        double logN = (Math.log(N) / Math.log(2));
        double eps = 0.0000001;
        if (logN > Math.round(logN) + eps){
            logN++;
        }
        System.out.println(Math.round(logN));
    }
    public void binSearch(){
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        int K = scIn.nextInt();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scIn.nextLong();
        }
        for (int i = 0; i < K; i++) {
            long x = scIn.nextLong();
            int l = 0;
            int r = N-1;
            int resI = binSearchPrep(arr, l, r, x);
            //System.out.println(resI);
            if (x == arr[resI]){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
    public void leftRightBinSearch(){
        Scanner scIn = new Scanner(System.in);
        int N = scIn.nextInt();
        int K = scIn.nextInt();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scIn.nextLong();
        }
        for (int i = 0; i < K; i++) {
            long x = scIn.nextLong();
            int l = 0;
            int r = N-1;
            int leftBound, rightBound;

            int resI = binSearchPrep(arr, l, r, x);
            if (arr[resI] != x){
                System.out.println("0");
            } else{
                leftBound = resI;
                rightBound = resI;
                if (arr[0] == x){
                    leftBound = 0;
                } else{
                    while(arr[leftBound] != x || arr[leftBound-1] == x){
                        leftBound--;
                    }
                }
                if (arr[N-1] == x){
                    rightBound = N-1;
                } else{
                    while(arr[rightBound] != x || arr[rightBound+1] == x){
                        rightBound++;
                    }
                }
                leftBound++;
                rightBound++;
                System.out.println(leftBound + " " + rightBound);
            }
        }
    }

    public static void main(String[] args) {
        new BinSearch().leftRightBinSearch();
    }
}
