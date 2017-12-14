package com.example.chaihongwei.javasort;

/**
 * 冒泡排序
 */
public class BubbleSortActivity extends BaseSortActivity {
    /**
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
     * 在这一点，最后的元素应该会是最大的数。针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    @Override
    protected void sort() {
        int count = datas.length;
        //从头到尾,相邻元素比较,i只需要截止为倒数第2个即可
        for (int i = 0; i < count - 1; i++) {
            //每次都从头到尾将最大的数交换到最后,所以每次需要比较的元素个数都会减少
            for (int j = 0; j < count - i - 1; j++) {
                if (datas[j] > datas[j + 1]) {
                    int temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;
                }
            }

            printDatas("中间数据:");
        }
    }
}
