from random import randrange


class Sort():
    __MAX__ = 2100000000

    @classmethod
    def merge_sort(cls, a, p, r):
        """ 
            if p < r: 이 조건은 퀵 소트나 머지 소트가 같다. 기억해두자.
            재귀된 구간의 길이가 2개 미만이라는 의미
            
            또한 머지소트는 소트를 분할정복를 하다가 마지막에 병합한다
            퀵 소트는 partition을 먼저하고 그후에 퀵 소트를 분할정복한다.
        """
        if p < r: 
            q = int((p + r)/2)
            cls.merge_sort(a, p, q)
            cls.merge_sort(a, q+1, r)
            cls.merge(a, p, q, r)

    @classmethod
    def merge(cls, a, p, q, r):
        # q를 기준으로 left, right 리스트를 만든다.
        left_len = q - p + 1
        right_len = r - q

        left = [0] * (left_len + 1)
        right = [0] * (right_len + 1)
        
        # 각 리스트의 마지막 인덱스에 경계값을 넣어준다.
        left[left_len] = right[right_len] = cls.__MAX__


        # left와 right 리스트에 리스트의 부분값을 초기화한다.
        for i in range(left_len):
            left[i] = a[p+i]
        
        for i in range(right_len):
            right[i] = a[q + i + 1]
        
        """
            기존 리스트 a를 p 부터 r까지 돌면서 
            left, right중 작은 것을 채워나가는 식으로 한다.
        """
        i = 0 # for left list
        j = 0 # for right list
        for k in range(p, r + 1):
            if left[i] <= right[j]:
                a[k] = left[i]
                i += 1
            else:
                a[k] = right[j]
                j += 1

    @classmethod
    def quick_sort(cls, a, p, r):
        if p < r:
            q = cls.partition(a, p, r)
            cls.quick_sort(a, p, q-1)
            cls.quick_sort(a, q+1, r)

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
    def partition(cls, a, p, r):
        rand_idx = randrange(r - p + 1) + p
        cls.swap(a, r, rand_idx)
        a_len = r - p + 1

        x = a[r]
        left = p - 1
        right = p

        while j < r:
            if a[j] <= x:
                i += 1
                cls.swap(a, i, j)

            j += 1

        cls.swap(a, i+1, r)
        
        return i+1
    
    @classmethod
    def swap(cls, a, idx_1, idx_2):
        a[idx_1], a[idx_2] = a[idx_2], a[idx_1]
