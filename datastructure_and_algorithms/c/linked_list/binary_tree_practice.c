#include <stdio.h>
#include <stdlib.h>

#define FALSE 0
#define TRUE 1

#define LEFT 'L'
#define RIGHT 'R'

#define NOT_NULL_CHAR 'a'


typedef struct BinaryTreeNode {
    int data;
    struct BinaryTreeNode* left_child;
    struct BinaryTreeNode* right_child;
}BinaryTreeNode;


BinaryTreeNode* create_node(int data);
BinaryTreeNode* get_node(BinaryTreeNode *root, int data);
BinaryTreeNode* initialize_root_and_children(int root_data, int left_data, int right_data);
void append_child_to_parent(BinaryTreeNode *parent, int child_data, char sibling_direction);
void append_children_to_parent(BinaryTreeNode *root, int parent_data, int left_data, int right_data);
void preorder_traverse(BinaryTreeNode *root);
void search(BinaryTreeNode *root, char search_directions[]);


int main(){
	BinaryTreeNode *root = NULL;
	int parent_num, left_child_num, right_child_num;
	int num_of_nodes, node_index;
	int search_count, loop_count;
	char search_directions[100];

	scanf("%d", &num_of_nodes);
	for(node_index = 0; node_index < num_of_nodes; node_index++){
		scanf("%d %d %d", &parent_num, &left_child_num, &right_child_num);
		if(node_index != 0){
			append_children_to_parent(root, parent_num, left_child_num, right_child_num);
		}else{ // root is NULL
			root = initialize_root_and_children(parent_num, left_child_num, right_child_num);
		}
	}

	scanf("%d", &search_count);
	for(loop_count = 0; loop_count < search_count ; loop_count++){
		scanf("%s", search_directions);
		search(root, search_directions);
	}

	return 0;
}

BinaryTreeNode* create_node(int data){
	BinaryTreeNode *node = (BinaryTreeNode*)malloc(sizeof(BinaryTreeNode) * 1);
	node->data = data;
	node->left_child = NULL;
	node->right_child = NULL;

	return node;
}

BinaryTreeNode* get_node(BinaryTreeNode *root, int data){
	BinaryTreeNode *child = NULL;

	if(root == NULL){
		return NULL;
	}else if(root->data == data){
		return root;
	}else{
		if(root->left_child != NULL){
			child = get_node(root->left_child, data);
			if(child != NULL){
				return child;
			}
		}
		if(root->right_child != NULL){
			return get_node(root->right_child, data);
		}
	}

	return NULL;
}

BinaryTreeNode* initialize_root_and_children(int root_data, int left_data, int right_data){
	BinaryTreeNode *root = (BinaryTreeNode*)malloc(sizeof(BinaryTreeNode) * 1);
	root->data = root_data;
	append_child_to_parent(root, left_data, LEFT);
	append_child_to_parent(root, right_data, RIGHT);
	
	return root;
}

void append_child_to_parent(BinaryTreeNode *parent, int child_data, char sibling_direction){	
	BinaryTreeNode *child = NULL;

	if(child_data == 0){
		return;
	}

	child = create_node(child_data);
	
	if(sibling_direction == LEFT){
		parent->left_child = child;
	}else{
		parent->right_child = child;
	}
}

void append_children_to_parent(BinaryTreeNode *root, int parent_data, int left_data, int right_data){
	BinaryTreeNode *parent = get_node(root, parent_data);
	
	if(parent != NULL){
		append_child_to_parent(parent, left_data, LEFT);
		append_child_to_parent(parent, right_data, RIGHT);
	}
}

void preorder_traverse(BinaryTreeNode *root){
	if(root == NULL){
		return;
	}

	printf(" %d", root->data);

	preorder_traverse(root->left_child);
	preorder_traverse(root->right_child);
}

void search(BinaryTreeNode *root, char search_directions[]){
	BinaryTreeNode *node = root;
	char current_direction = NOT_NULL_CHAR;
	int index = 0;

	while(current_direction){
		printf(" %d", node->data);
		current_direction = search_directions[index++];
		if(current_direction == LEFT){
			node = node->left_child;
		}else{
			node = node->right_child;
		}
	}
	printf("\n");
}
