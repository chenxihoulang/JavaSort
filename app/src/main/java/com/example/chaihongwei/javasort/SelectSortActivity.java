package com.example.chaihongwei.javasort;

/**
 * 选择排序
 */
public class SelectSortActivity extends BaseSortActivity {
    /**
     * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    @Override
    protected void sort() {
        int count = datas.length;
        for (int i = 0; i < count; i++) {
            //假设当前位置的元素已经是最小的
            int minPos = i;
            //从当前位置往后的元素中寻找一个比较当前位置更新小的元素
            for (int j = i + 1; j < count; j++) {
                if (datas[j] < datas[minPos]) {
                    minPos = j;
                }
            }

            int temp = datas[i];
            datas[i] = datas[minPos];
            datas[minPos] = temp;

            printDatas("中间结果:");
        }
    }
}
