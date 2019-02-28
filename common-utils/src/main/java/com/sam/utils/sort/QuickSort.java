package com.sam.utils.sort;

/**
 * @Author:ChenXinmin
 * @Date:2019/2/27 17:58
 */
public class QuickSort {

    public static void quickSort(int[] numbers,int low,int high){
        if (numbers.length>0){
            System.out.println(low+"============"+high);
            if (low<high){
                int midLength = getMiddleNumber(numbers,low,high);
                quickSort(numbers,low,midLength-1);
                quickSort(numbers,midLength+1,high);
                System.out.println(low+"+++"+high);
                System.out.println(midLength);
            }
        }

    }

    public static int getMiddleNumber(int[] numbers,int start,int end){
        int temp = numbers[start];//第一个数开始作为中轴
        while (start<end){
            while (start<end && numbers[end]>temp){
                end--;
            }
            numbers[start] = numbers[end];//小的数移到低端
            while (start<end && numbers[start]<temp){
                start++;
            }
            numbers[end] = numbers[start];//比中轴数大的，移到高端
        }
        numbers[start] = temp;
        return start;
    }

    public static void quick(int[] numbers){
        if (numbers.length>0){
            quickSort(numbers,0,numbers.length-1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {-2,5,11,10,3,-9};
        quick(numbers);
        for (int i:numbers){
            System.out.print(i+" ");
        }
    }
}
