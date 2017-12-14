package com.example.chaihongwei.javasort;

/**
 * 希尔排序--基于插入排序
 */
public class ShellSortActivity extends BaseSortActivity {

    /**
     * 希尔排序的原理:根据需求，如果你想要结果从小到大排列，它会首先将数组进行分组，然后将较小值移到前面，较大值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强版的插入排序
     * 拿数组64, 8, 7, 89, 6, 24, 2来说，数组长度为7，当increment为3时，数组分为两个序列
     * 64,8,7和89, 6, 24, 2,第一次排序，64和89比较，8和6比较，7和24比较，2和比其下标值小increment的数组值相比较
     * 此例子是按照从小到大排列，所以小的会排在前面，第一次排序后数组为64,6,7,89,8,24,2
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序， 实现数组从小到大排
     */
    @Override
    protected void sort() {
        // 每次将步长缩短为原来的一半
        for (int increment = datas.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < datas.length; i++) {
                int temp = datas[i];

                int j = 0;
                //根据分组大小,循环将较小值交换到前面,比如例子中的最后一个2,交换两次到了最前面
                for (j = i; j >= increment; j -= increment) {
                    //从小到大排序
                    if (temp < datas[j - increment]) {
                        datas[j] = datas[j - increment];
                    } else {
                        break;
                    }
                }
                datas[j] = temp;

                //每次遍历都打印一下
                printDatas("组内数据:");
            }

            //每次遍历都打印一下
            printDatas("中间数据:");
        }
    }
}
