package com.example.chaihongwei.javasort;

/**
 * 堆排序
 */
public class HeapSortActivity extends BaseSortActivity {

    /**
     * 堆排序在 top K 问题中使用比较频繁。堆排序是采用二叉堆的数据结构来实现的，虽然实质上还是一维数组。二叉堆是一个近似完全二叉树 。
     * 二叉堆具有以下性质：
     * <p>
     * 父节点的键值总是大于或等于（小于或等于）任何一个子节点的键值。
     * 每个节点的左右子树都是一个二叉堆（都是最大堆或最小堆）。
     * <p>
     * 步骤：
     * 构造最大堆（Build_Max_Heap）：若数组下标范围为0~n，考虑到单独一个元素是大根堆，则从下标n/2开始的元素均为大根堆。
     * 于是只要从n/2-1开始，向前依次构造大根堆，这样就能保证，构造到某个节点时，它的左右子树都已经是大根堆。
     * <p>
     * 堆排序（HeapSort）：由于堆是用数组模拟的。得到一个大根堆后，数组内部并不是有序的。因此需要将堆化数组有序化。
     * 思想是移除根节点，并做最大堆调整的递归运算。第一次将heap[0]与heap[n-1]交换，再对heap[0...n-2]做最大堆调整。
     * 第二次将heap[0]与heap[n-2]交换，再对heap[0...n-3]做最大堆调整。重复该操作直至heap[0]和heap[1]交换。
     * 由于每次都是将最大的数并入到后面的有序区间，故操作完后整个数组就是有序的了。
     * 最大堆调整（Max_Heapify）：该方法是提供给上述两个过程调用的。目的是将堆的末端子节点作调整，使得子节点永远小于父节点 。
     */
    @Override
    protected void sort() {
        // 将待排序的序列构建成一个大顶堆,叶子节点已经是最大堆,所以从倒数第一个非叶子节点开始一个节点一个节点进行堆调整
        for (int i = datas.length / 2; i >= 0; i--) {
            heapAdjust(datas, i, datas.length);
        }

        printDatas("最大堆:");

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = datas.length - 1; i > 0; i--) {
            // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            swap(datas, 0, i);

            printDatas("中间数据:");

            // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
            //i为要调整的数组的长度,最大根节点和最后一个节点交换后,只需要调整到i即可,这样相当于将根节点有序后,移除了根节点
            heapAdjust(datas, 0, i);

            printDatas("中间调整:");
        }
    }

    /**
     * 构建堆的过程
     *
     * @param datas            需要排序的数组
     * @param adjustIndex      需要构建堆的根节点的序号(要调整的节点序号)
     * @param maxAdjustToIndex 最大需要调整到元素索引,不包含最大索引
     */
    private void heapAdjust(int[] datas, int adjustIndex, int maxAdjustToIndex) {
        int leftChildIndex = getLeftChildIndexByParentIndex(adjustIndex);
        int father;
        //从要调整的节点开始,和左右子节点进行比较,调整后有可能破坏已经存在的最大堆结构,所以需要一级一级的调整
        for (father = datas[adjustIndex]; leftChildIndex < maxAdjustToIndex; adjustIndex = leftChildIndex) {
            leftChildIndex = getLeftChildIndexByParentIndex(adjustIndex);

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (leftChildIndex != maxAdjustToIndex - 1 && datas[leftChildIndex] < datas[leftChildIndex + 1]) {
                // 序号增1，指向右子树
                leftChildIndex++;
            }

            // 如果父节点小于孩子结点，则需要交换
            if (father < datas[leftChildIndex]) {
                datas[adjustIndex] = datas[leftChildIndex];
            } else {
                // 大顶堆结构未被破坏，不需要调整
                break;
            }
        }

        //最终把父节点调整到正确的位置
        datas[adjustIndex] = father;
    }

    /**
     * 根据父节点索引获取到左孩子结点索引(注意存储结构是数组)
     */
    private int getLeftChildIndexByParentIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * 交换元素位置
     */
    private void swap(int[] datas, int index1, int index2) {
        int tmp = datas[index1];
        datas[index1] = datas[index2];
        datas[index2] = tmp;
    }
}
