package sem5;

import java.util.ArrayDeque;

public class Volny2 {
    public static int[][] gamefield(int a, int b) {/*Массив ноликов */
        int[][] arr = new int[a][b];
        for (int i= 0; i < a; i++) {
            for (int j= 0; j < b; j++){
                arr[i][j] = 0;
            }
        }
        return arr;
    }

    public static int[][] fieldstones(int arr[][]) {/*Хаотично раскидываем препятствия*/
        for (int i= 0; i < (2*(arr.length + arr[0].length))/3; i++) {/*количество камней */
            arr[(int)(Math.random()*arr.length)][(int)(Math.random()*arr[0].length)] = -1;
        }
        for (int i = 0; i < arr.length; i++){/*стеночки */
            arr[i][0] = -1;
            arr[i][arr[0].length-1] = -1;
        }
        for (int j = 1; j < arr[0].length-1; j++){
            arr[0][j] = -1;
            arr[arr.length-1][j] = -1;
        }
        return arr;
    }
    
    static void printArray(int arr[][]){
        for (int i=0; i<arr.length; ++i){
            for (int j=0; j<arr[0].length; ++j){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(); 
        }
    }    
    
    public static int[][] waveLee(int arr[][], int startA, int startB){
        ArrayDeque<Integer> point = new ArrayDeque<>();
        // ArrayDeque<Integer> pointJ = new ArrayDeque<>();
        point.add(startA);
        point.add(startB); /*можно наверное и в одну... */

        while (point.size() > 0) {
            int i = point.pop();
            int j = point.pop();
            if (arr[i+1][j]==0) {
                arr[i+1][j] = arr[i][j]+1;
                point.addLast(i+1);
                point.addLast(j);
            }
            if (arr[i][j+1]==0) {
                arr[i][j+1] = arr[i][j]+1;
                point.addLast(i);
                point.addLast(j+1);
            }
            if (arr[i-1][j]==0) {
                arr[i-1][j] = arr[i][j]+1;
                point.addLast(i-1);
                point.addLast(j);
            }
            if (arr[i][j-1]==0) {
                arr[i][j-1] = arr[i][j]+1;
                point.addLast(i);
                point.addLast(j-1);
            }
        } 
        arr[startA][startB] = -2;
        return arr;
    }

    public static void main(String args[])
    {
        int[][] arr = fieldstones(gamefield(10,20));
        // int[][] arr = gamefield(6,8);        
        printArray(arr);
        System.out.println(" ");
        int[][] arr2 = waveLee(arr, 2, 4);
        printArray(arr2);
        // int endpoint = arr2[9][15];
        // System.out.printf("Требуется %d шагов", endpoint);
    }
    
}
