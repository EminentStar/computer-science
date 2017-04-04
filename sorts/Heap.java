public class Main {
    static int count = 0;
    public static void main(String[] args) {
        int[] a = {0, 10, 7, 9, 4, 14, 3, 8, 1, 2};

        for(int e: a){
            System.out.print(e + ", ");
        }

        System.out.println("");

        buildMaxHeap(a);

        for(int e: a){
            System.out.print(e + ", ");
        }

    }

    public static void buildMaxHeap(int[] a){
        for(int i = (a.length / 2); i > 0; i--){
            maxHeapify(a, i, a.length - 1);
        }
    }

    public static void maxHeapify(int[] a, int i, int len){
        count++;
        System.out.println(count);
        int l = left(i);
        int r = right(i);
        int largest = 0;

        if(l <= len && (a[l] > a[i])){
            largest = l;
        }else{
            largest = i;
        }

        if(r <= len && (a[r] > a[largest])){
            largest = r;
        }

        if(largest != i){
            int tmp = a[i];
            a[i] = a[largest];
            a[largest] = tmp;
            maxHeapify(a, largest, len);
        }
    }

    public static int left(int i){
        return 2*i;
    }


    public static int right(int i){
        return 2*i + 1;
    }
}

