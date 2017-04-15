from sort import Sort


def main():
    a = [9, 8, 7, 6, 1, 5, 10, 3]
    print("Before sorting: %s" % a)
    # Sort.quick_sort(a, 0, len(a) - 1)
    Sort.quick_sort_with_hoare_partition(a, 0, len(a) - 1)
    print("After sorting: %s" % a)

if __name__ == '__main__':
    main()
