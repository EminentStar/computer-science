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

    @classmethod
    def get_height(cls, root):
        if root is None: return 0
        
        return max(cls.get_height(root.left_child), cls.get_height(root.right_child)) + 1

    @classmethod
    def is_balanced(cls, root):
        if root is None: return True

        left_height = cls.get_height(root.left_child)
        right_height = cls.get_height(root.right_child)

        diff_height = abs(left_height - right_height)

        if diff_height > 1:
            return False
        else:
            return cls.is_balanced(root.left_child) and cls.is_balanced(root.right_child)

     
    @classmethod
    def check_height(cls, root):
        if root is None: return 0

        left_height = cls.check_height(root.left_child)
        if left_height == -1:
            return -1

        right_height = cls.check_height(root.right_child)
        if right_height == -1:
            return -1
     
        diff_height = abs(left_height - right_height)

        if diff_height > 1:
            return -1
        else:
            return max(left_height, right_height) + 1

    @classmethod
    def is_balanced_improved(cls, root):
        if cls.check_height(root) == -1:
            return False
        else:
            return True
