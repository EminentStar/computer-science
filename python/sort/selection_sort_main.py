from sort import Sort


def main():
    a = [9, 8, 7, 6, 1, 5, 10, 3]
    print("Before sorting: %s" % a)
    Sort.selection_sort(a)
    print("After sorting: %s" % a)

if __name__ == '__main__':
    main()
