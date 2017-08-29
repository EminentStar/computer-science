#include <stdio.h>
#include <stdlib.h>

#define FALSE 0
#define TRUE 1


typedef struct Node {
    char elem;
    struct Node* prev;
    struct Node* next;
}Node;

Node* initialize_linked_list(){
	Node *pHeader = (Node*)malloc(sizeof(Node) * 1);
	Node *pTrailer = (Node*)malloc(sizeof(Node) * 1);

	(*pHeader).next = pTrailer;
	(*pHeader).prev = NULL;

	(*pTrailer).prev = pHeader;
	(*pTrailer).next = NULL;

	return pHeader;
}

Node* add_node(Node *list, int position, char item){
	int indexCount = 0;
       	Node* node = list;
       	Node* pAdded = (Node*)malloc(sizeof(Node) * 1);

	if(position < 1){
		return NULL;
	}

	(*pAdded).elem = item;

	while((*node).next != NULL){
	       	if(indexCount == position - 1){
		       	(*pAdded).next = (*node).next;
		       	(*pAdded).prev = node;
		       	(*(*node).next).prev = pAdded;
		       	(*node).next = pAdded;
		       	return pAdded;
	       	}else{
		       	indexCount++;
		       	node = (*node).next;
	       	}
       	}
       	return NULL;
}

char delete_node(Node *list, int position){
	int indexCount = 1;
	char returnValue;
	Node* node = (*list).next;
	
	if(position < 1){
		return NULL;
	}

	while((*node).next != NULL){
		if(indexCount == position){
			returnValue = (*node).elem;
		       	(*(*node).prev).next = (*node).next;
		       	(*(*node).next).prev = (*node).prev;
		       	return returnValue;
		}else{
		       	indexCount++;
		       	node = (*node).next;
		}
	}
	return NULL;
}

char get_entry(Node *list, int position){
	int indexCount = 1;
	char returnValue;
	Node* node = (*list).next;

	if(position < 1){
		return NULL;
	}

	while((*node).next != NULL){
		if(indexCount == position){
			return (*node).elem;
		}else{
			indexCount++;
			node = (*node).next;
		}
	}
	return NULL;
}

void print(Node* list){
	Node* node = (*list).next;

	while((*node).next != NULL){
		printf("%c", (*node).elem);
		node = (*node).next;
	}
	printf("\n");
}

int main(){
	Node *pHead = initialize_linked_list();
	int operation_count;
	int loop_count;
	char operation_abbr, elem_chr;
	int position;
	char returnedChar;
	int invalid_position;
   	 
	scanf("%d", &operation_count);

	for(loop_count = 0; loop_count < operation_count ; loop_count++){
		invalid_position = FALSE;
		scanf(" %c", &operation_abbr);

		if(operation_abbr == 'A'){
			scanf(" %d %c", &position, &elem_chr);
			if(add_node(pHead, position, elem_chr) == NULL){
				invalid_position = TRUE;
			}
		}else if(operation_abbr == 'D'){
			scanf("%d", &position);
			if(delete_node(pHead, position) == NULL){
				invalid_position = TRUE;
			}
		}else if(operation_abbr == 'G'){
			scanf("%d", &position);
			returnedChar = get_entry(pHead, position);
			if(returnedChar != NULL){
				printf("%c\n", returnedChar);
			}else{
				invalid_position = TRUE;
			}
		}else if(operation_abbr == 'P'){
			print(pHead);
		}
		
		if(invalid_position){
			printf("invalid position\n");
		}
	}

	return 0;
}
