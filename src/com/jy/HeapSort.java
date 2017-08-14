package com.jy;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		DataWrap[] dataWraps = new DataWrap[] { new DataWrap(9, ""), new DataWrap(79, ""), new DataWrap(46, ""),
				new DataWrap(30, ""), new DataWrap(58, ""), new DataWrap(49, "") };

		System.out.println("排序前：" + Arrays.toString(dataWraps));

		heapSort(dataWraps);
		System.out.println("*********************排序结束*********************");

		System.out.println("排序后（从小到大）：" + Arrays.toString(dataWraps));
	}

	/**
	 * 堆排序 从小到大排序，就建立大顶堆；从大小排列，就建立小顶堆
	 * 
	 * @param dataWraps
	 *            待排序的数组
	 */
	public static void heapSort(DataWrap[] dataWraps) {
		System.out.println("*********************开始排序*********************");
		int arrayLength = dataWraps.length;
		for (int i = 0; i < arrayLength - 1; i++) {
			// 循环建堆
			buildMaxHeap(dataWraps, arrayLength - 1 - i);
			// 交换出堆顶元素，然后继续建堆得到最值
			swap(dataWraps, 0, arrayLength - 1 - i);
			// 每一趟后都打印出当前的排序结果
			System.out.println(Arrays.toString(dataWraps));
		}
	}

	/**
	 * 将给定的数组建堆
	 * 
	 * @param dataWraps
	 *            待建堆的数组
	 * @param lastIndex
	 *            用来建堆的最后一个数组元素的索引
	 */
	public static void buildMaxHeap(DataWrap[] dataWraps, int lastIndex) {
		// 从lastIndex的父节点(lastIndex - 1) / 2开始，逐步递减直到根节点
		for (int i = lastIndex - 1 >> 1; i >= 0; i--) {
			// 当前将用来判断的节点
			int currentNode = i;
			// 左子节点
			int leftNode = (currentNode << 1) + 1;
			// 当前节点存在子节点，即至少存在左子节点
			while (leftNode <= lastIndex) {
				// 保存当前节点的两个子节点中较大的节点的索引
				int biggerNode = leftNode;
				// 右子节点
				int rightNode = (currentNode << 1) + 2;
				// 当前节点存在右子节点，并且右子节点大于左子节点
				if (rightNode <= lastIndex && dataWraps[leftNode].compareTo(dataWraps[rightNode]) < 0)
					biggerNode = rightNode;
				// 将当前节点和它的较大的节点比较，并根据大小情况选择交换
				if (dataWraps[currentNode].compareTo(dataWraps[biggerNode]) >= 0) // 如果当前节点不小于较大子节点，直接结束本次while循环
					break;
				swap(dataWraps, currentNode, biggerNode);
				// 将biggerNode的值赋给currentNode继续while循环，保证当前节点的值始终大于左右子节点的值
				currentNode = biggerNode;
				leftNode = (currentNode << 1) + 1;

			}
		}
	}

	/**
	 * 交换数组中两个元素的值
	 * 
	 * @param dataWraps
	 *            待操作的数组
	 * @param i
	 *            其中一个待交换元素的索引
	 * @param j
	 *            另一个待交换元素的索引
	 */
	public static void swap(DataWrap[] dataWraps, int i, int j) {
		DataWrap temp = dataWraps[i];
		dataWraps[i] = dataWraps[j];
		dataWraps[j] = temp;
	}

}
