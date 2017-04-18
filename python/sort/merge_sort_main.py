from sort import Sort


def main():
    a = [9, 8, 7, 6, 1, 5, 10, 3]
    print("Before sorting: %s" % a)
    Sort.merge_sort(a, 0, len(a) - 1)
    print("After sorting: %s" % a)

if __name__ == '__main__':
    main()
