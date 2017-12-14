package com.example.chaihongwei.javasort;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * 基数排序
 */
public class RadixSortActivity extends BaseSortActivity {
    /**
     * 1.首先根据元素的个位数，在遍历元素时将它们分配至编号0到9的桶子中。
     * 2.将第1步中的各个桶子中的元素按先进先出的顺序取出(队列),接着再进行一次分配，这次是根据十位数来分配.
     * 3.重复以上步骤直到数组中最大数字的最高位,最后将所有元素按第2步的方式取出,排序完成
     */
    @Override
    protected void sort() {
        //10进制数的基数排序
        radixSort(datas);
    }

    private void radixSort(int[] datas) {
        //首先确定排序的趟数
        int max = getMaxData(datas);
        int digits = getDigits(max);

        //建立10个队列
        ArrayDeque<Integer>[] queue = new ArrayDeque[10];
        for (int i = 0; i < 10; i++) {
            queue[i] = new ArrayDeque<>();
        }

        //进行digits次分配和收集
        for (int i = 0; i < digits; i++) {
            //分配数组元素,将数组元素根据第i位的值放置到对应的桶中
            for (int j = 0; j < datas.length; j++) {
                //得到数字的第i+1位数
                int k = datas[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);

                queue[k].addLast(datas[j]);
            }

            //打印每个桶中的数据
            printDatas(queue);

            //元素计数器
            int count = 0;
            //收集桶中队列元素,根据桶索引依次将桶中的数据取出来放置到数组中
            for (int k = 0; k < 10; k++) {
                while (queue[k].size() > 0) {
                    datas[count] = queue[k].removeFirst();

                    count++;
                }
            }

            printDatas("中间数据:");
        }

    }

    /**
     * 获取数组中最大的数
     */
    private int getMaxData(int[] datas) {
        int max = datas[0];

        for (int i = 1; i < datas.length; i++) {
            if (datas[i] > max) {
                max = datas[i];
            }
        }

        return max;
    }

    /**
     * 获取数字的位数
     */
    private int getDigits(int data) {
        int digits = 0;
        while (data > 0) {
            data /= 10;
            digits++;
        }

        return digits;
    }

    private void printDatas(ArrayDeque<Integer>[] queues) {
        StringBuilder sbPartSortData = new StringBuilder("桶中数据:\n");

        for (int i = 0, count = queues.length; i < count; i++) {
            sbPartSortData.append("桶" + i + ":");
            Iterator<Integer> datas = queues[i].iterator();

            while (datas.hasNext()) {
                sbPartSortData.append(datas.next() + ",");
            }
            sbPartSortData.append("\n");
        }

        tvTip.append(sbPartSortData);
    }
}
