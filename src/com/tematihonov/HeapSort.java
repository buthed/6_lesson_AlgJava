package com.tematihonov;

public class HeapSort {
    private int heapSize;

    public HeapSort() {
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    public static void swap(int[] sourceArray, int i, int j) {
        int temp = sourceArray[i];
        sourceArray[i] = sourceArray[j];
        sourceArray[j] = temp;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public void buildHeap(int[] sourceArray) {
        this.heapSize = sourceArray.length;
        for (int i = sourceArray.length / 2; i >= 0; i--) {
            heapify(sourceArray, i);
        }
    }

    public void heapify(int[] sourceArray, int i) {
        int leftChild = left(i);
        int rightChild = right(i);
        int largestChild = i;

        if (leftChild < this.heapSize && sourceArray[i] < sourceArray[leftChild]) {
            largestChild = leftChild;
        }

        if (rightChild < this.heapSize && sourceArray[largestChild] < sourceArray[rightChild]) {
            largestChild = rightChild;
        }

        if (i != largestChild) {
            swap(sourceArray, i, largestChild);
            heapify(sourceArray, largestChild);
        }
    }

    public void heapSort(int[] sourceArray) {
        buildHeap(sourceArray);
        while (this.heapSize > 1) {
            swap(sourceArray, 0, this.heapSize - 1);
            this.heapSize--;
            heapify(sourceArray, 0);
        }
    }
}
