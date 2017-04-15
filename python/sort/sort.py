from random import randrange


class Sort():
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
