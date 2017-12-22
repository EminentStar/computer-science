class Node():
    """ Single Linked List Node """
    def __init__(self, value=None, next=None):
        self.__value = value
        self.__next = next

    @property
    def value(self):
        return self.__value

    @value.setter
    def value(self, value):
        self.__value = value

    @property
    def next(self):
        return self.__next

    @next.setter
    def next(self, next):
        self.__next = next
    
    def append_to_tail(self, node):
        curr_node = self

        while curr_node.next != None:
            curr_node = curr_node.next
        
        curr_node.next = node
    
    @classmethod
    def delete_node(self, head, value):
        if head.value == value:
            head = head.next
            return

        curr = head

        while curr.next != None:
            if curr.next.value == value:
                curr.next = curr.next.next
                return
            
            curr = curr.next
    
    def track_list(self):
        curr = self

        print("HEAD", end=' -> ')
        while curr != None:
            print("%r" % curr.value, end=' -> ')
            curr = curr.next

        print("None")
