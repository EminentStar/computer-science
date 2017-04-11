public class Main {
    public static void main(String[] args) {
        int[] a = {0, 10, 7, 9, 4, 14, 3, 8, 1, 2, 98};

        System.out.println("Before building heap");
        System.out.print("[");
        for(int e: a){
            System.out.print(e + ", ");
        }

        System.out.print("]");
        System.out.println("");

        buildMaxHeap(a, a.length);

        System.out.println("After building heap");
        System.out.print("[");
        for(int e: a){
            System.out.print(e + ", ");
        }

        System.out.print("]");
        System.out.println("");
        heapSort(a);

        System.out.println("After heapsort");
        System.out.print("[");
        for(int e: a){
            System.out.print(e + ", ");
        }
        System.out.print("]");
        System.out.println("");

    }


    public static void heapSort(int[] a){
        int size = a.length;
        buildMaxHeap(a, size);
        for(int i = size - 1; i > 1 ; i--){
            swap(a, 1, i);
            size--;
            maxHeapify(a, 1, i);
        }
    }

    public static void buildMaxHeap(int[] a, int size){
        for(int i = size / 2; i > 0; i--){
            maxHeapify(a, i, size);
        }
    }

    public static void maxHeapify(int[] a, int i, int size){
        int l = left(i);
        int r = right(i);
        int largest = 0;

        if(l < size && (a[l] > a[i])){
            largest = l;
        }else{
            largest = i;
        }

        if(r < size && (a[r] > a[largest])){
            largest = r;
        }

        if(largest != i){
            int tmp = a[i];
            a[i] = a[largest];
            a[largest] = tmp;
            maxHeapify(a, largest, size);
        }
    }

    public static int left(int i){
        return 2*i;
    }


    public static int right(int i){ return 2*i + 1; }

    public static void swap(int[] a, int idx1, int idx2){
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
}

