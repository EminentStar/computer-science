'''
단방향 연결 리스트의 중간에 있는 노드 하나를 삭제하는 알고리즘을 구현하라. 삭제할 노드에 대한
접근만 가능하다는 것에 유의하라.

- 예
입력: a->b->c->d->e 의 노드 c
결과: 아무것도 반환 할 필요 없고, 결과로 연결리스트가 a->b->d->e가 되어 있으면 OK
'''
from node import Node

def remove_node_my_solution(node):
    node.value = node.next.value
    removed_node = node.next
    node.next = node.next.next
    del removed_node


def remove_node_solution(node):
    """
    The problem of my solution above is that I haven't dealed with the case if the node wouldn't
    existed or the node is the last node of the list.
    """
    if node is None or node.next is None:
        return False
    
    next = node.next

    node.value = next.value
    node.next = next.next

    return True



def main():
    head = Node('a')
    b = Node('b')
    c = Node('c')
    d = Node('d')
    e = Node('e')
    
    head.append_to_tail(b)
    head.append_to_tail(c)
    head.append_to_tail(d)
    head.append_to_tail(e)
    
    head.track_list()

    remove_node_my_solution(c)

    head.track_list()



if __name__ == '__main__':
    main()
