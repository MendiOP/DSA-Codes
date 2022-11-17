package DataStructures.Heap;

public class MinHeap {
    private int[] arr;
    private int size;
    private int capacity;

    MinHeap(int capacity)
    {
        arr = new int[capacity];
        size=0;
        this.capacity = capacity;
    }

    void insert(int data)
    {
        if(size == capacity){
            System.out.println("Size if full.");
            return;
        }

        size++;
        arr[size-1] = data;

        for (int i=size-1; i!=0 && arr[parent(i)]>arr[i]; )
        {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void heapify(int i)
    {
        int l = left(i);
        int r = right(i);

        int min = i;

        if(l < size && arr[l] < arr[min])
            min = l;
        if(r < size && arr[r] < arr[min])
            min = r;

        if(i != min)
        {
            int t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;

            heapify(min);
        }
    }

    int extractMin()
    {

        if(size <= 0)
            return Integer.MAX_VALUE;

        if(size == 1){
            size--;
            return arr[size];
        }

        int t = arr[0];
        arr[0] = arr[size-1];
        arr[size-1] = t;

        size--;

        heapify(0);

        return arr[size];
    }

    void decreaseKey(int i, int data)
    {
        arr[i] = data;

        while(i!=0 && arr[i]<arr[parent(i)])
        {
            int t = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = t;

            i = parent(i);
        }
    }

    void delete(int i)
    {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    void buildHeap()
    {
        for(int i= (size-2)/2; i>=0; i--)
            heapify(i);
    }

    int left(int i)
    {
        return 2*i+1;
    }

    int right(int i)
    {
        return 2*i+2;
    }

    int parent(int i)
    {
        return (i-1)/2;
    }
}

class HeapMainClass{
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);


        //              20
        //            /    \
        //           25     30
        //          /  \   /  \
        //         35  40 80  32
        //        /  \ /
        //      100 70 60

        heap.insert(20);
        heap.insert(25);
        heap.insert(30);
        heap.insert(35);
        heap.insert(40);
        heap.insert(80);
        heap.insert(32);
        heap.insert(100);
        heap.insert(70);
        heap.insert(60);

        System.out.println(heap.extractMin());



    }
}
