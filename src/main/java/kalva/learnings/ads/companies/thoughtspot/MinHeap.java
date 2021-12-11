package kalva.learnings.ads.companies.thoughtspot;

public class MinHeap {

    private int[] Heap;
    private int size;
    private int maxSize;
    private static final int FRONT = 1;

    public MinHeap(int maxsize) {
        this.maxSize = maxsize;
        this.size = 0;
        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }


    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        Heap[++size] = element;
        int current = size;
        while (Heap[parent(current)] > Heap[current]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    private void minHeapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }
        if (Heap[leftChild(pos)] >= Heap[pos] &&
                Heap[rightChild(pos)] >= Heap[pos]) {
            return;
        }
        if (Heap[rightChild(pos)] > Heap[leftChild(pos)]) {
            swap(pos, leftChild(pos));
            minHeapify(leftChild(pos));
        } else {
            swap(pos, rightChild(pos));
            minHeapify(rightChild(pos));
        }
    }

    // Function to print the contents of the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " Left [" + Heap[2 * i] + "]"
                    + " Right [" + Heap[2 * i + 1] + "]");
            System.out.println();
        }
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("Removing Min Element : " + minHeap.remove());
        minHeap.print();

        minHeap.print();
    }
}

