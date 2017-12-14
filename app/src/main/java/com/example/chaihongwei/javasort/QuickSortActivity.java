package com.example.chaihongwei.javasort;

/**
 * 快速排序
 */
public class QuickSortActivity extends BaseSortActivity {
    /**
     * 通过一趟排序将待排序记录分割成独立的两部分，一部分全小于选取的参考值，另一部分全大于选取的参考值。
     * 每次都能把某个元素确定在最终结果的某个位置上,这样分别对两部分排序之后顺序就可以排好了。
     */
    @Override
    protected void sort() {
        // 查看数组是否为空
        if (datas.length > 0) {
            quick(datas, 0, datas.length - 1);
        }
    }

    /**
     * @param datas 带排序数组
     * @param low   开始位置
     * @param high  结束位置
     */
    public void quick(int[] datas, int low, int high) {
        if (low < high) {
            // 将datas数组进行一分为二,中轴元素最终的位置已经确定了
            int middle = getMiddle(datas, low, high);

            printTempData("中轴索引=" + middle);

            // 对低端进行递归排序
            quick(datas, low, middle - 1);
            // 对高端进行递归排序
            quick(datas, middle + 1, high);
        }

        printDatas("中间数据:");
    }

    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param datas 带查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return 中轴所在位置, 方法返回后中轴位置就确定在那里了
     */
    public int getMiddle(int[] datas, int low, int high) {
        // 数组的第一个作为中轴,先记录下来,下面找到正确的位置再将该元素放置到最终正确的位置上
        int temp = datas[low];

        //一直判断,直到比中轴大的元素全在高端,比中轴小的元素全在低端
        while (low < high) {
            //从后向前寻找比中轴小的数,找到后交换到low位置
            while (low < high && datas[high] > temp) {
                high--;
            }
            // 比中轴小的记录移到低端
            datas[low] = datas[high];

            printDatas("中间数据:");

            //从前往后寻找比中轴大的数,找到后交换到high位置
            while (low < high && datas[low] < temp) {
                low++;
            }
            // 比中轴大的记录移到高端
            datas[high] = datas[low];

            printDatas("中间数据:");
        }

        // 中轴记录到位
        datas[low] = temp;

        // 返回中轴的位置
        return low;
    }
}
