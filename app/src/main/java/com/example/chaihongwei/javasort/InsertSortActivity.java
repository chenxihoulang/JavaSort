package com.example.chaihongwei.javasort;

/**
 * 直接插入排序
 */
public class InsertSortActivity extends BaseSortActivity {
    /**
     * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
     */
    @Override
    protected void sort() {
        for (int i = 0, count = datas.length; i < count - 1; i++) {
            int temp = datas[i + 1];

            //i之前的都是已经排好序的
            int j = i;

            //从i往前在已排好序的数组中,查找一个合适的位置存放temp,大于temp的元素向后移动
            while (j >= 0 && datas[j] > temp) {
                datas[j + 1] = datas[j];

                j--;
            }

            datas[j + 1] = temp;

            //每次遍历都打印一下
            printDatas("中间数据:");
        }
    }
}
