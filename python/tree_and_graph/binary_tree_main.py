from binary_tree_node import Node

def main():
    root = Node('A') 
    b = Node('B')
    c = Node('C')
    d = Node('D')
    e = Node('E')
    f = Node('F')
    
    root.left_child = b
    root.right_child = c
    
    b.left_child = d
    b.right_child = e
    
    c.left_child = f

    """
            A          ---- root
        B       C
      D   E   F
    """
    leaf_depths = []
    print("Balanced: %r" % Node.is_balanced_tree(root, 0, leaf_depths)) # True
    print("Height: %r" % Node.get_height(root)) # 3
    print("Balanced(improved 1st): %r" % Node.is_balanced(root)) # True
    print("Balanced(improved 2nd): %r" % Node.is_balanced_improved(root)) # True

    root = Node('A') 
    b = Node('B')
    c = Node('C')
    d = Node('D')
    e = Node('E')
    f = Node('F')
    
    root.left_child = b
    root.right_child = c
    
    b.left_child = d
    b.right_child = e
    
    d.left_child = f

    """
            A          ---- root
        B       C
      D   E
    F
    """
    leaf_depths = []
    print("Balanced: %r" % Node.is_balanced_tree(root, 0, leaf_depths)) # False
    print("Height: %r" % Node.get_height(root)) # 4
    print("Balanced(improved 1st): %r" % Node.is_balanced(root)) # False
    print("Balanced(improved 2nd): %r" % Node.is_balanced_improved(root)) # False

if __name__ == "__main__":
    main()
