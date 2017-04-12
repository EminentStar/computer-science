package com.company;

/**
 * Created by junkyu on 2017. 4. 1..
 */
public class Sort {
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

