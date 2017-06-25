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
    print(Node.is_balanced_tree(root, 0, leaf_depths)) # True

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
    print(Node.is_balanced_tree(root, 0, leaf_depths)) # False

if __name__ == "__main__":
    main()
