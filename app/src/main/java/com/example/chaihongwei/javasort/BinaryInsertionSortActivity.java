package com.example.chaihongwei.javasort;

/**
 * 二分插入排序
 */
public class BinaryInsertionSortActivity extends BaseSortActivity {

    /**
     * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置
     * 由于前面的元素已经排好序,所以在查找插入位置的时候采用二分查找算法，直到全部插入排序完为止。
     */
    @Override
    protected void sort() {
        for (int i = 1, count = datas.length; i < count; i++) {
            int temp = datas[i];

            int left = 0;
            int right = i;

            //二分算法寻找合适的插入位置
            while (left <= right) {
                int mid = (left + right) / 2;

                if (datas[mid] < temp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            //只需要将left到i之间的元素后移,即可给待插入的元素让出空间
            for (int j = i - 1; j >= left; j--) {
                datas[j + 1] = datas[j];
            }

            datas[left] = temp;

            //每次遍历都打印一下
            printDatas("中间数据:");
        }
    }
}
