package com.example.chaihongwei.javasort;

/**
 * 归并排序
 */
public class MergeSortActivity extends BaseSortActivity {

    /**
     * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
     * 即把待排序序列分为若干个子序列，每个子序列是有序的。
     * 然后再把有序子序列合并为整体有序序列 时间复杂度为O(nlogn) 稳定排序方式
     */
    @Override
    protected void sort() {
        mergeSort(datas, 0, datas.length - 1);
    }

    /**
     * 归并排序
     *
     * @param datas 待排序数组
     * @return 输出有序数组
     */
    public int[] mergeSort(int[] datas, int low, int high) {
        int mid = (low + high) / 2;

        if (low < high) {
            // 左边
            mergeSort(datas, low, mid);
            // 右边
            mergeSort(datas, mid + 1, high);

            // 左右归并
            merge(datas, low, mid, high);
        }

        printDatas("中间数据:");

        return datas;
    }

    /**
     * 将数组中low到high位置的数进行排序
     * <p>
     * 归并排序是采用分治法的一个非常典型的应用。归并排序的思想就是先递归分解数组，再合并数组。
     * 先考虑合并两个有序数组，基本思路是比较两个数组的最前面的数，谁小就先取谁，取了后相应的指针就往后移一位。
     * 然后再比较，直至一个数组为空，最后把另一个数组的剩余部分复制过来即可。
     * <p>
     * 再考虑递归分解，基本思路是将数组分解成left和right，如果这两个数组内部数据是有序的，
     * 那么就可以用上面合并数组的方法将这两个数组合并排序。
     * 如何让这两个数组内部是有序的？可以再二分，直至分解出的小组只含有一个元素时为止，此时认为该小组内部已有序。
     * 然后合并排序相邻二个小组即可。
     *
     * @param datas 待排序数组
     * @param low   待排的开始位置
     * @param mid   待排中间位置
     * @param high  待排结束位置
     */
    public void merge(int[] datas, int low, int mid, int high) {
        //归并排序需要额外的存储空间
        int[] temp = new int[high - low + 1];
        // 左指针
        int i = low;
        // 右指针
        int j = mid + 1;
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (datas[i] < datas[j]) {
                temp[k++] = datas[i++];
            } else {
                temp[k++] = datas[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = datas[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = datas[j++];
        }

        // 把新数组中的数覆盖datas数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            datas[k2 + low] = temp[k2];
        }
    }
}
