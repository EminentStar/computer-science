from random import randint


class Sort():
    __MAX__ = 2100000000
   
    """
        * heapsort
        * buildmaxheap
        * max_heapify
    """

    @classmethod
    def build_maxheap(cls, a, len):
        while i <= len/2:
            cls.max_heapify(a, len)

    @classmethod
    def max_heapify(cls, a, len):
        i = 1
        while i < len:
            biggest = i

            if a[i] < a[2*i]:
                biggest = 2*i
            if a[biggest] < a[2*i + 1]:
                biggest = 2*i + 1
            # swap
            a[i], a[biggest] = a[biggest], a[i]

            i = biggest

    @classmethod
    def merge_sort(cls, a, left, right):
        """ 
        정렬되지 않는 리스트를 반으로 두개의 서브 리스트로 분할하고 
        각 서브 리스트의 크기가 1이 될 때까지 재귀로 분할 정렬을 한 다음
        분리된 서브 리스트를 병합하여 원래 리스트로 복원시킨다.
        if p < r: 이 조건은 퀵 소트나 머지 소트가 같다. 기억해두자.
        재귀된 구간의 길이가 2개 미만이라는 의미
        
        또한 머지소트는 소트를 분할정복를 하다가 마지막에 병합한다
        퀵 소트는 partition을 먼저하고 그후에 퀵 소트를 분할정복한다.
        * Time Complexity
          - O(nlogn)
        * Space Complexity
          - O(n)
          - In place sort
        * Stable
        """
        if left < right:
            mid = (left + right) // 2
            cls.merge_sort(a, left, mid)
            cls.merge_sort(a, mid + 1, right)
            cls.merge(a, left, mid, right)


    @classmethod
    def merge(cls, a, left, mid, right):
        # mid를 기준으로 left, right 리스트를 만든다.
        left_size = mid - left + 1
        right_size = right - mid

        left_part = [0] * (left_size + 1)
        right_part = [0] * (right_size + 1)
        
        # 각 리스트의 마지막 인덱스에 경계값을 넣어준다.
        left_part[left_size] = cls.__MAX__
        right_part[right_size] = cls.__MAX__

        
        # left_part와 right_part에 리스트의 부분값을 초기화한다.
        for a_idx, left_idx in zip(range(left, mid+1), range(len(left_part))):
            left_part[left_idx] = a[a_idx]
        for a_idx, right_idx in zip(range(mid+1, right + 1), range(len(right_part))):
            right_part[right_idx] = a[a_idx]

        left_idx = right_idx = 0

        """
            기존 리스트 a를 left 부터 right까지 돌면서 
            left_part, right_part중 작은 것을 채워나가는 식으로 한다.
        """
        for i in range(left, right+1):
            if left_part[left_idx] > right_part[right_idx]:
                a[i] = right_part[right_idx]
                right_idx += 1
            else:
                a[i] = left_part[left_idx]
                left_idx += 1

    @classmethod
    def quick_sort(cls, a, left, right):
        """
        리스트에서 피벗을 고르고 피벗의 왼쪽엔 그보다 작은 원소가,
        오른쪽에는 큰 원소가 오도록 한 후에 피벗을 제외하고 두 부분 리스트로 분할한다.
        그리고 그 분할된 두 리스트에 대해 재귀적으로 위의 과정l을 반복한다. 
        재귀는 크기가 0이나 1이 될때까지 반복
        * Time Complexity
          - average: O(nlogn)
          - worst: O(n^2)
            - 이미 모든 데이터가 정렬되어 있는 경우 맨앞의 데이터를 기준으로 선택햇을 때 데이터가
              분할되지 못하기에 한번의 비교 연산이 n번 이루어 진다고 하면 모든 데이터에 대해서는
              O(n^2)의 시간이 걸릴 것임.
        * Space Complexity
          - O(nlogn) for sorting
        * Unstable
        """
        if left < right:
            pivot = cls.partition(a, left, right)
            cls.quick_sort(a, left, pivot-1)
            cls.quick_sort(a, pivot+1, right)

    @classmethod
    def quick_sort_with_hoare_partition(cls, a, p, r):
        if p < r:
            q = cls.hoare_partition(a, p, r)
            cls.quick_sort_with_hoare_partition(a, p, q)
            cls.quick_sort_with_hoare_partition(a, q+1, r)

    @classmethod
    def hoare_partition(cls, a, p, r):
        i = p
        j = r
        x = a[p]

        while True: # i와 j가 경게 밖을 나가지 않을까에 대해 고민해보자
            while a[j] > x:
                j -= 1
            while a[i] < x:
                i += 1

            if i < j:
                cls.swap(a, i, j)
            else:
                return j # 왜 i가 아니라 j를 반환하지?

    @classmethod
    def partition(cls, a, left, right):
        rand_idx = randint(left, right)
        cls.swap(a, rand_idx, right)
        
        pivot_value = a[right]
        partition_idx = left - 1
        
        for j in range(left, right):
            if pivot_value > a[j]:
                partition_idx += 1
                cls.swap(a, partition_idx, j)
        
        partition_idx += 1
        cls.swap(a, partition_idx, right)
        
        return partition_idx

    @classmethod
    def bubble_sort(cls, a):
        """
        첫 원소부터 순차적으로 진행하며 
        현재 원소가 그 다음 원소값보다 크면 
        그 두 원소를 바꾸는 작업을 반복해나가는 정렬
        * Time Complexity
          - best: O(n^2)
          - average: O(n^2)
          - worst: O(n^2)
        * Space Complexity
          - O(1)
          - In place sort
        * Stable
        """
        l = len(a)

        for i in range(l-1):
            # loop를 돌리면서 0부터 갈수록 끝에서 하나씩 줄어듬
            for j in range(l-1-i):
                if a[j] > a[j+1]:
                    cls.swap(a, j, j+1)
    
    @classmethod
    def bubble_sort_recursive(cls, a, start_idx):
        length = len(a)
        if start_idx >= length-1:
            return

        for i in range(start_idx+1, length):
            if a[i] > a[i-1]:
                cls.swap(a, i, i-1)
        
        cls.bubble_sort_recursive(a, start_idx+1)

    @classmethod
    def selection_sort(cls, a):
        """
        리스트를 linear scan하면서 최솟값 원소를 찾은 다음
        그 원소를 리스트의 맨 앞으로 보내는 정렬
        * Time Complexity
          - best: O(n^2)
          - average: O(n^2)
          - worst: O(n^2)
        * Space Complexity
          - O(1)
          - In place sort
        * Basically unstable, but depending on how to implement, it could be changed
        """
        l = len(a)

        for i in range(l):
            # 매 loop마다 min을 설정해야 됨
            min = a[i]
            min_idx = i
            for j in range(i, l):
                if min > a[j]:
                    min = a[j]
                    min_idx = j
           
            cls.swap(a, i, min_idx)

    @classmethod
    def selection_sort_recursive(cls, a, start_idx):
        if start_idx >= len(a) - 1:
            return
        
        min_idx = start_idx

        for i in range(start_idx + 1, len(a)):
            if a[i] < a[min_idx]:
                min_idx = i
        
        cls.swap(a, start_idx, min_idx)
        cls.selection_sort_recursive(a, start_idx+1)

    @classmethod
    def insertion_sort(cls, a):
        """
        리스트의 모든 요소를 앞에서부터 차례대로 이미 정렬된
        리스트 부분과 비교하여 자신의 위치를 찾아 삽입함으로써
        정렬을 완성
        * Time Complexity
          - best: O(n^2)
          - average: O(n^2)
          - worst: O(n^2)
        * Space Complexity
          - O(1)
          - In place sort
        * Stable
        """
        l = len(a)
        
        for i in range(1, l):
            tmp = a[i]
            for j in range(i, 0, -1):
                """
                이미 정렬된 부분 a[j-1i]이 
                기준이 되는 tmp보다 크면
                a[j]를 한칸 뒤로 민다.

                그리고 a[j]의 index가 1이면 
                index 0에 tmp를 삽입
                """
                if tmp < a[j-1]:
                    a[j] = a[j-1]
                    if j == 1:
                        a[j-1] = tmp
                        break
                
                # a[j-1]이 tmp보다 작으면 
                # a[j]에 tmp를 삽입 
                else:
                    a[j] = tmp 
                    break

    @classmethod
    def swap(cls, a, idx_1, idx_2):
        a[idx_1], a[idx_2] = a[idx_2], a[idx_1]
