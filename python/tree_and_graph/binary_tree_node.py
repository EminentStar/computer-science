class Node():
    """ Graph Node """
    def __init__(self, value=None, left=None, right=None):
        self.__value = value
        self.__left_child = left
        self.__right_child = right

    @property
    def value(self):
        return self.__value

    @value.setter
    def value(self, value):
        self.__value = value

    @property
    def left_child(self):
        return self.__left_child

    @left_child.setter
    def left_child(self, left):
        self.__left_child = left

    @property
    def right_child(self):
        return self.__right_child

    @right_child.setter
    def right_child(self, right):
        self.__right_child = right

    @classmethod
    def is_balanced_tree(cls, root, cur_depth, leaf_depths):
        if root.left_child:
            cls.is_balanced_tree(root.left_child, cur_depth+1, leaf_depths)
        if root.right_child:
            cls.is_balanced_tree(root.right_child, cur_depth+1, leaf_depths)

        if root.left_child is None and root.right_child is None:
            leaf_depths.append(cur_depth)

        if cur_depth == 0:
            return (max(leaf_depths) - min(leaf_depths)) <= 1
        else:
            return None
