package com.company;

import java.util.Random;

/**
 * Created by junkyu on 2017. 4. 7..
 */
public class Sort {
    private static final int MAX = 2100000000;
    public static void mergeSort(int[] a, int p, int r){
        if(p < r){
            int q = (p + r)/2;
            mergeSort(a, p, q);
            mergeSort(a, q+1, r);
            merge(a, p, q, r);

        }
    }

    public static void merge(int[] a, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] a1 = new int[n1+1];
        int[] a2 = new int[n2+1];
        a1[n1] = a2[n2] = MAX;

        for(int i = 0; i < n1; i++){
            a1[i] = a[p+i];
        }

        for(int i = 0; i < n2; i++){
            a2[i] = a[q + i + 1];
        }

        int i = 0, j = 0;

        // k< r+ 1을 i < r+1로 오타..
        // 또 k는 0부터가 아님. 본 배열의 인덱스이므로 p부터 시작해야함
        for(int k = p; k < r + 1 ; k++){
            if(a1[i] <= a2[j]){
                a[k] = a1[i++];
            }else{
                a[k] = a2[j++];
            }
        }
    }

    public static void quickSort(int[] a,int p,int r){
        // Unoptimized quick sort
        if(p < r){
            int q = partition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
    }

    public static void randomizedQuickSort(int[] a, int p, int r){
        // Randomized quick sort
        if(p < r){
            int q = randomizedPartition(a, p, r);
            randomizedQuickSort(a, p, q-1);
            randomizedQuickSort(a, q+1, r);
        }

    }

    public static void hoarePartitionQuickSort(int[] a, int p, int r){
        if(p < r){
            int q = hoarePartition(a, p, r);
            hoarePartitionQuickSort(a, p, q);
            hoarePartitionQuickSort(a, q+1, r);
        }
    }

    public static int partition(int[] a, int p, int r){
        int x = a[r]; // x = r로 잘못 입력
        int i = p - 1;
        for(int j = p; j < r; j++){ // r-1이 아니라 r전까지 가야하는거지
            if(a[j] <= x){
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i+1, r);

        return i+1;
    }

    public static int randomizedPartition(int[] a, int p, int r){
        //Wrong! 범위구간을 잡았어야했는데, 0부터 마지막 제한까지로 해버렸네
        //int i = new Random().nextInt(r + 1);
        int i = new Random().nextInt(r + 1 - p) + p;
        swap(a, i, r);
        return partition(a, p, r);
    }

    public static int hoarePartition(int[] a, int p, int r){
        int x = a[p];
        int i = p;
        int j = r;
        while(true){
            while(a[j] > x){
                System.out.println(j);
                j--;
            }
            while(a[i] < x){
                i++;
            }

            if(i < j){
                swap(a, i, j);
            }else{
                return j;
            }
        }
    }

    public static void bubbleSort(int[] arr){
        /*
        * 첫 원소부터 순차적으로 진행하며 현재 원소가 그 다음 원소의 값보다 크면
        * 그 두 원소를 바꾸는 작업을 반복한다
        * 평균 실행 시간: O(n^2)
        * 최악 실행 시간: O(n^2)
        * 메모리 O(1)
        * */
        /*
        * 두번째 루프에서 제일 마지막에는 가장 큰 수가 저장되기에
        * 루프 제한을 1씩 줄여나가야 한다는 것을 생각하지 못하였음
        * */
        int loop = arr.length - 1;

        for(int i = 0; i < loop ; i++){
            for(int j = i ; j < loop - i ; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j, j+1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        /*
        * 배열을 linear scan하며 최솟값 원소를 찾은 다음 그 원소를 배열 맨 앞으로 보낸다.
        * 평균 실행 시간: O(n^2)
        * 최악 실행 시간: O(n^2)
        * 메모리 O(1): 제자리 정렬(in-place sort)
        * Basically, Unstable, but depending on how to implement, it could be changed
        * */
        /*
        * min과 minIdx를 매번 큰 루프때마다 값 할당을 해줘야한다는 것을 놓침
        * */
        int len = arr.length;
        int min = 0;
        int minIdx = 0;

        for(int i = 0; i < len ; i++){
            min = arr[i];
            minIdx = i;
            for(int j = i ; j < len ; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    public static void insertionSort(int[] arr){
        /*
        * 삽입 정렬(揷入整列, insertion sort)은 자료 배열의 모든 요소를
        * 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여,
        * 자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘이다.
        * 최선 실행 시간: O(n^2)
        * 평균 실행 시간: O(n^2)
        * 최악 실행 시간: O(n^2)
        * 메모리 O(1): 제자리 정렬(in-place sort)
        * 입력자료가 정렬되어 있을 수록 빠르다
        * Stable:
        * */
        int len = arr.length;
        int tmp = 0;

        for(int i = 1 ; i < len ; i++){
            tmp = arr[i];
            for(int j = i ; j > 0 ; j--){
                if(tmp < arr[j-1]){
                    arr[j] = arr[j-1];
                    if(j == 1){
                        arr[j-1] = tmp;
                        break;
                    }
                }else{
                    arr[j] = tmp;
                    break; // 이걸 놓쳐버렸다
                }
            }
        }

    }

    private static void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

}

