from sort import Sort


def main():
    a = [9, 8, 7, 6, 1, 5, 10, 3]
    b = [9, 8, 7, 6, 1, 5, 10, 3]

    print("Before sorting: %s" % a)
    Sort.bubble_sort(a)
    print("After sorting: %s" % a)

    print("------------------------")

    print("Before sorting: %s" % b)
    Sort.bubble_sort(b)
    print("After sorting: %s" % b)

if __name__ == '__main__':
    main()
