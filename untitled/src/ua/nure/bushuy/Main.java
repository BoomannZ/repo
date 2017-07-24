package ua.nure.bushuy;

public class Main {

    int[] array = {21, 23, 32, 11, 8, -2, 4, 19, 19, 99, 2};
    public static void print(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }
   public static void swapSort(int[] ar) {
        int tmp = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length ; j++) {
                if (ar[i] > ar[j]) {
                    tmp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = tmp;
                }
            }
        }
    }

    public static void bubbleSort(int[] ar) {
        int tmp = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 1; j < ar.length - i; j++) {
                if(ar[j - 1] > ar[j]) {
                    tmp = ar[j - 1];
                    ar[j - 1] = ar[j];
                    ar[j] = tmp;
                }

            }
        }

    }
    public static void main(String[] args) {
        int[] array = {21, 23, 32, 11, 8, -2, 4, 19, 19, 99, 2};
        bubbleSort(array);
        print(array);
    }


}
