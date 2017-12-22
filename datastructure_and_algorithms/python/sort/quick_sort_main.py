from sort import Sort


def main():
    a01 = [9, 8, 7, 6, 1, 5, 10, 3]
    a02 = [1, 2, 3, 4, 5, 6, 7, 8]
    a03 = [10, 23, 643, 12, 34, 1, 60]
    a04 = [-1, 5, 1, 654, 12, 4, 1]
    a05 = [1, 1, 1, 1, 2, 2, 1, 2, 4, 6]

    print("Before sorting: %s" % a01)
    Sort.quick_sort(a01, 0, len(a01) - 1)
    # Sort.quick_sort_with_hoare_partition(a, 0, len(a) - 1)
    print("After sorting: %s" % a01)
    print('--------------------------')

    print("Before sorting: %s" % a02)
    Sort.quick_sort(a02, 0, len(a02) - 1)
    print("After sorting: %s" % a02)
    print('--------------------------')

    print("Before sorting: %s" % a03)
    Sort.quick_sort(a03, 0, len(a03) - 1)
    print("After sorting: %s" % a03)
    print('--------------------------')

    print("Before sorting: %s" % a04)
    Sort.quick_sort(a04, 0, len(a04) - 1)
    print("After sorting: %s" % a04)
    print('--------------------------')

    print("Before sorting: %s" % a05)
    Sort.quick_sort(a05, 0, len(a05) - 1)
    print("After sorting: %s" % a05)
    print('--------------------------')


if __name__ == '__main__':
    main()
