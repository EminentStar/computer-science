'''
x값을 갖는 노드를 기준으로 연결 리스트를 나누는 코드를 작성하라. x보다 작은 값을 갖는 노드가 x와
같거나 더 큰 값을 갖는 노드들보다 앞쪽에 오도록 하면 된다.
'''
from node import Node


def divide_list_by_specific_value(head, x):
    """
    My Solution
    """
    if head.next is None:
        return False
    
    node = head
    bigger_list = Node(-1)

    while node.next is not None:
        if node.next.value >= x:
            next = node.next
            node.next = next.next
            next.next = None
            bigger_list.append_to_tail(next)
        else:
            node = node.next
    
    head.append_to_tail(bigger_list.next)
    
    return True

def main():
    head = Node(-1)
    a = Node(1)
    b = Node(3)
    c = Node(4)
    d = Node(9)
    e = Node(5)
    f = Node(4)
    g = Node(2)
    
    head.append_to_tail(a)
    head.append_to_tail(b)
    head.append_to_tail(c)
    head.append_to_tail(d)
    head.append_to_tail(e)
    head.append_to_tail(f)
    head.append_to_tail(g)
    
    head.next.track_list()

    divide_list_by_specific_value(head, 4)

    head.next.track_list()



if __name__ == '__main__':
    main()
