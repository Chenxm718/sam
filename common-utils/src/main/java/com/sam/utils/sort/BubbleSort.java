package com.sam.utils.sort;


/**
 * @Author:ChenXinmin
 * @Date:2019/2/26 17:50
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param integerList
     */
    public static void bubbleSort(Integer[] integerList){
        Integer temp;
        int size = integerList.length;
        for (int i=0;i<size;i++){
            for (int j=0;j<size-1-i;j++){
                if (integerList[j] > integerList[j+1]){
                    temp = integerList[j];
                    integerList[j] = integerList[j+1];
                    integerList[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] test = {1,10,7,15,3};
        bubbleSort(test);
        for (Integer t: test) {
            System.out.println(t);
        }
    }
}
