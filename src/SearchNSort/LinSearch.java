package SearchNSort;

import java.util.Scanner;

/**
 * Created by Katerina on 15.05.2018.
 */
public class LinSearch {
    public static class LinSearch1{
            LinSearch1(){
                Scanner scIn = new Scanner(System.in);
                int n = scIn.nextInt();
                int[] arr = new int[n];
                for(int i = 0; i < n; i++){
                    arr[i] = scIn.nextInt();
                }
                int m = scIn.nextInt();
                System.out.println(linSearch_1(n,arr,m));
            }
            public static int linSearch_1(int n, int[] arr, int m){
                int count = 0;
                for(int i = 0; i < n; i++){
                    if (arr[i] == m){
                        count ++;
                    }
                }
                return count;
            }
        }

    public static class LinSearch2{
        LinSearch2(){
            Scanner scIn = new Scanner(System.in);
            int n = scIn.nextInt();
            int[] arr = new int[n+1];
            for(int i = 0; i < n; i++){
                arr[i] = scIn.nextInt();
            }
            int m = scIn.nextInt();
            System.out.println(linSearch_2(n,arr,m));
        }
        public static String linSearch_2(int n, int[] arr, int m){
            arr[n] = m;
            int i;
            for( i = 0; arr[i] != arr[n]; i++){}
            return ((i < n)?"YES":"NO");
        }
    }

    public static class LinSearch3{
        LinSearch3(){
            Scanner scIn = new Scanner(System.in);
            int n = scIn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scIn.nextInt();
            }
            int m = scIn.nextInt();
            linSearch_3(n,arr,m);
        }
        public void linSearch_3(int n, int[] arr, int m){
            for(int i = 0; i < n; i++){
                if(arr[i] == m){
                    System.out.println(i+1);
                }
            }
        }
    }

    public static class ClosestNumber{
        ClosestNumber(){
            Scanner scIn = new Scanner(System.in);
            int n = scIn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scIn.nextInt();
            }
            int m = scIn.nextInt();
            System.out.println(closestNumberSearch(n,arr,m));
        }
        public int closestNumberSearch(int n, int[] arr, int m){
            int i_min = 0;
            int min = Math.abs(arr[0] - m);
            for (int i = 1; i < n; i++){
                int temp = Math.abs(arr[i] - m);
                if (temp < min){
                    min = temp;
                    i_min = i;
                }
            }
            return arr[i_min];
        }
    }

    public static class MaxElem{
        MaxElem(){
            Scanner scIn = new Scanner(System.in);
            int n = scIn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scIn.nextInt();
            }
            System.out.println(maxElemSearch(n,arr));
        }
        public int maxElemSearch(int n, int[] arr){
            int i_max = 0;
            for(int i = 1; i < n; i++){
                if (arr[i] > arr[i_max]){
                    i_max = i;
                }
            }
            return i_max+1;
        }
    }

    public static class Revision{
        Revision(){
            Scanner scIn = new Scanner(System.in);
            int n = scIn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scIn.nextInt();
            }
            revision(n, arr);
        }
        public void revision(int n, int[] arr){
            int i_min1= 1, i_min2 = 0;
            if (arr[0] < arr[1]){
                i_min1 = 0;
                i_min2 = 1;
            }
            for (int i = 2; i < n; i++){
                if (arr[i] < arr[i_min1]){
                    i_min2 = i_min1;
                    i_min1 = i;
                } else if (arr[i] < arr[i_min2]){
                    i_min2 = i;
                }
            }
            System.out.println(arr[i_min1] + " " + arr[i_min2]);
        }
    }

    public static class Column{
        Column(){
            Scanner scIn = new Scanner(System.in);
            int m = scIn.nextInt();
            int n = scIn.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j ++){
                    arr[i][j] = scIn.nextInt();
                }
            }
            checkColumn(n, arr, m);
        }
        public void checkColumn(int n, int[][] arr, int m){
            for(int j = 0; j < n; j++){
                boolean hasNum = false;
                for (int i = 0; i < n; i++){
                    if (arr[i][j] == m){
                        hasNum = true;
                        break;
                    }
                }
                if(hasNum){
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }

    public static class Matrix{
        Matrix(){
            Scanner scIn = new Scanner(System.in);
            int n = scIn.nextInt();
            int m = scIn.nextInt();
            int[][] arr = new int[n][m];
            for(int i = 0; i < n; i++){
                for (int j = 0; j < m; j ++){
                    arr[i][j] = scIn.nextInt();
                }
            }
            saddlePointsCount(n, m, arr);
        }
        public void saddlePointsCount(int n, int m, int[][] arr){
            int[] mins = new int[n];
            int[] maxs = new int[m];

            for(int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (arr[i][j] < arr[i][mins[i]]) {
                        mins[i] = j;
                    }
                    if (arr[i][j] > arr[maxs[j]][j]) {
                        maxs[j] = i;
                    }
                }
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (arr[i][j] == arr[maxs[j]][j] && arr[i][j] == arr[i][mins[i]]){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static class SilverMedal{
        SilverMedal(){
            Scanner scIn = new Scanner(System.in);
            int n = scIn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scIn.nextInt();
            }
            pointsSilver(n, arr);
        }
        public void pointsSilver(int n, int[] arr){
            int gold = 0, silver = 1;
            if (arr[gold] < arr[silver]){
                gold = 1;
                silver = 0;
            }

            for(int i = 2; i < n; i++){
                if (arr[i] > arr[gold]){
                    silver = gold;
                    gold = i;
                } else if (arr[i] == arr[gold]) {
                } else if (arr[i] > arr[silver]) {
                    silver = i;
                }
            }

            System.out.println(arr[silver]);
        }
    }

    public static class Controperation{
        Controperation(){
            Scanner scIn = new Scanner(System.in);
            int n = scIn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scIn.nextInt();
            }
            changeMarks(n, arr);
        }
        public void changeMarks(int n, int[] arr){
            int min_i = 0, max_i = 0;


            for(int i = 1; i < n; i++){
                if (arr[i] > arr[max_i]){
                    max_i = i;
                }
                if (arr[i] < arr[min_i]){
                    min_i = i;
                }
            }
            int max = arr[max_i];
            for(int i = 0; i < n; i++){
                if (arr[i] == max){
                    arr[i] = arr[min_i];
                }
            }
            for(int i = 0; i < n; i++){
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        new Controperation();
    }
}
