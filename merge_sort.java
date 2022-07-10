package MergeSort_HeapSort;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * merge_sort
 */
public class merge_sort {

    public static void main(String[] args) {
        
        PrintArr(ArrCreate(10));
    }

    public static int[] ArrCreate(int a) {
        int[] myArray = new int[a];
        for (int i = 0; i < a; i++) {
            myArray[i] = new Random().nextInt(0,100);
        }
        return myArray;
    }

    public static void PrintArr(int[] array) {
        
        for (int i = 0; i < array.length; i++ ) {
            System.out.println(array[i]);
        }
    }

    public static int[] sortArr(int[] originArray) {
        if (originArray == null) {
            return null;
        }

        if (originArray.length < 2) {
            return originArray;
        }

        int[] leftArray = new int[originArray.length/2];
        System.arraycopy(originArray, 0, leftArray, 0, originArray.length/2);

        int[] rightArray = new int[originArray.length/2];
        System.arraycopy(originArray, originArray.length/2, rightArray, 0, originArray.length - originArray.length/2);
        
        leftArray = sortArr(leftArray);
        rightArray = sortArr(rightArray);

        return mergeArr(leftArray, rightArray);
    }

    public static int[] mergeArr(int[] leftArr, int[] rightArr) {
        int[] mergedArr = new int[leftArr.length + rightArr.length];
        int leftPos = 0;
        int rightPos = 0;

        for (int i = 0; i < mergedArr.length; i++) {
            if (leftPos == leftArr.length){
                mergedArr[i] = rightArr[i - rightPos];
                rightPos++;
                } else if (rightPos == rightArr.length) {
                mergedArr[i] = leftArr[i - leftPos];
                leftPos++;
                } else if (leftArr[i - leftPos] < rightArr[i - rightPos]) {
                mergedArr[i] = leftArr[i - leftPos];
                rightPos++;
                } else {
                mergedArr[i] = rightArr[i - rightPos];
                leftPos++;
                }
        }
        return mergedArr;
    }
}