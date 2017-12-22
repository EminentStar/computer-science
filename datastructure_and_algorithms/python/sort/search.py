def binary_search(a, value, left, right):
    """
    오름차순으로 정렬된 리스트에서 특정한 값의 위치를 찾는 알고리즘
    
    단점: 정렬된 리스트에만 사용할 수 있음
    장점: 검색이 반복될 때마다 목표값을 찾을 확률은 두 배가 되므로 속도가 빠름. 
    """

    if left > right: # Failed to find the value in the list
        return -1

    mid = (left + right) // 2

    if a[mid] is value:
        """My Fault: mid라는 index를 값과 비교해버림.."""
        return mid
    elif value > a[mid]:
        """
            My Fault: recursive call할때 return을 안붙여줌..
        """
        return binary_search(a, value, mid + 1, right)
    else:
        return binary_search(a, value, left, mid - 1)
