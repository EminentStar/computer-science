from queue import Queue


class Node():
    """ Graph Node """
    def __init__(self, value=None, visited=False):
        self.__value = value
        self.__visited = visited
        self.__adjacent = []

    @property
    def value(self):
        return self.__value

    @value.setter
    def value(self, value):
        self.__value = value

    @property
    def visited(self):
        return self.__visited

    @visited.setter
    def visited(self, visited):
        self.__visited = visited

    @property
    def adjacent(self):
        return self.__adjacent

    @adjacent.setter
    def adjacent(self, adjacent):
        self.__adjacent = adjacent
    
    def append_adjacent(self, node):
        self.__adjacent.append(node)
    
    @classmethod
    def dfs_traversal(cls, root):
        print(root.value, end=', ')
        root.visited = True
        
        if root.adjacent is None:
            return

        for node in root.adjacent:
            if node.visited is False:
                cls.dfs_traversal(node)
                node.visited = True

    @classmethod
    def bfs_traversal(cls, root):
        q = Queue()
        
        root.visited = True
        print(root.value, end=', ')
        q.put(root)

        while q.empty() is False:
            node = q.get()
            
            for ad in node.adjacent:
                if ad.visited is False:
                    print(ad.value, end=', ')
                    ad.visited = True
                    q.put(ad)
