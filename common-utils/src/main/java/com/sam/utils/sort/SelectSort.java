package com.sam.utils.sort;

/**
 * @Author:ChenXinmin
 * @Date:2019/2/28 14:06
 * 选择排序
 * 在未排序序列中找到最小元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
 * 以此类推，直到所有元素均排序完毕。
 */
public class SelectSort {
    /**
     * 选择排序
     * @param numbers
     */
    public static void selectSort(int[] numbers){
        if (numbers.length>0){
            int size = numbers.length;
            int temp;
            for (int i=0;i<size;i++){
                int k=i;
                for (int j=size-1;j>i;j--){
                    if (numbers[j]<numbers[k]){
                        k=j;
                    }
                }
                temp = numbers[i];
                numbers[i] = numbers[k];
                numbers[k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {12,9,6,16,20,2};
        selectSort(numbers);
        for (int i:numbers){
            System.out.print(i+" ");
        }
    }
}
