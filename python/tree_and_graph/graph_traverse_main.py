from node import Node


def main():
    root = Node('A')
    b = Node('B')
    c = Node('C')
    d = Node('D')
    e = Node('E')
    f = Node('F')
    
    root.append_adjacent(b)
    root.append_adjacent(c)
    
    b.append_adjacent(d)
    b.append_adjacent(e)

    d.append_adjacent(f)
    
    # print('dfs')
    # Node.dfs_traversal(root)

    print()
    print('bfs')
    Node.bfs_traversal(root)

if __name__ == "__main__":
    main()
