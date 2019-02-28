package com.sam.utils.sort;

/**
 * @Author:ChenXinmin
 * @Date:2019/2/28 15:17
 * 插入排序
 * 从第一个元素开始，该元素可以认为已经被排序
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 将新元素插入到该位置中
 * 重复步骤2
 */
public class InsertSort {
    public static void insertSort(int[] numbers){
        if (numbers.length>0){
            int size = numbers.length;
            int temp;
            int j;
            for(int i=0;i<size;i++){
                temp=numbers[i];
                for (j=i;j>0&&temp<numbers[j-1];j--){
                    numbers[j] = numbers[j-1];
                }
                System.out.println(j);
                numbers[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,10,5,11,20,2};
        insertSort(numbers);
        for (int i:numbers){
            System.out.print(i+" ");
        }
    }
}
