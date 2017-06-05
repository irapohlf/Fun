package com.sucho.fun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sucho
 * @since 6/4/17.
 */
public class Heap {
    private static final boolean MAX_HEAP = true;
    private List<Integer> heap;
    private boolean isMaxHeap;

    public Heap(final boolean isMaxHeap) {
        this.heap = new ArrayList<>();
        this.isMaxHeap = isMaxHeap;
    }

    public Integer peek() throws Exception {
        if (heap.size() == 0) {
            throw new Exception("heap is empty");
        }

        return heap.get(0);
    }

    private int right(final int index) {
        return 2 * (index + 1);
    }

    private int left(final int index) {
        return 2 * index + 1;
    }

    private int parent(final int index) {
        return (index + 1)/2 - 1;
    }

    private boolean isOrdered(final int parent, final int child) {
        int ret = heap.get(parent) - heap.get(child);

        return isMaxHeap == MAX_HEAP? ret >= 0 : ret < 0;
    }

    private boolean isEmpty() {
        return heap.size() == 0;
    }

    private void swap(final int i1, final int i2) {
        Integer temp = heap.get(i1);
        heap.set(i1, heap.get(i2));
        heap.set(i2, temp);
    }

    private int maxIndex(final int i1, final int i2) {
        if (i2 >= heap.size()) {
            return i1;
        }

        return heap.get(i1) >= heap.get(i2)? this.isMaxHeap? i1 : i2 : this.isMaxHeap? i2 : i1;
    }

    private void heapifyDown() {
        int index = 0;

        while (left(index) < heap.size()) {
            int compIndex = maxIndex(left(index), right(index));

            if (isOrdered(index, compIndex)) {
                break;
            }

            swap(index, compIndex);
            index = compIndex;

        }
    }

    private void heapifyUp() {
        int index = heap.size() - 1;

        while (parent(index) >= 0) {
            if (isOrdered(parent(index), index)) {
                break;
            }

            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void remove() {
        if (heap.size() == 1) {
            heap.remove(0);
            return;
        }
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        heapifyDown();
    }

    public void add(final Integer val) {
        heap.add(val);

        heapifyUp();
    }

    public static void main(String[] argx) throws Exception {
        int[] inputs = {4, 7, 12, 3, 1, 19, 22, 32, 5, 2, 2};

        Heap heap = new Heap(MAX_HEAP);

        for (int i : inputs) {
            heap.add(i);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.peek());
            heap.remove();
        }
    }
}
