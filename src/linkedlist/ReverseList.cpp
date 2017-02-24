#include<iostream>
#include<cstdlib>
/**
 * Created by code on 8/2/17.
 * reverse a linked list
 */
using namespace std;
class Node {
    public:
         int data;
         Node* next;
         Node(int data) {
             this->data = data;
             this->next = NULL;
         }
         static void printLL(Node* head){
             while(head != NULL){
                 cout<<head->data<<"->";
                 head = head->next;
             }
             cout<<"NULL"<<endl;
         }
         void reverse(Node** head){
             Node* newhead = NULL;
             Node* curr = *head;
             while(curr != NULL){
                 Node* next = curr->next;
                 curr->next = newhead;
                 newhead = curr;
                 curr = next;
             }
             *head = newhead;
         }
         static void addToHead(Node* node, Node** head);
};

void Node :: addToHead(Node* node, Node** head){
    node->next = (*head);
    (*head) = node;
}
//compile and run
// g++ -o reve ReverseList.cpp && ./reve
int main(){
    Node* head = new Node(1);
    Node::addToHead(new Node(2),&head);
    Node::addToHead(new Node(3),&head);
    Node::addToHead(new Node(4),&head);
    Node::printLL(head);
    head->reverse(&head);
    Node::printLL(head);
}
