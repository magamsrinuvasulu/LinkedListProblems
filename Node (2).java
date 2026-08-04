import java.util.*;
class Node{
    int data;
    Node next;
    Node head=null;
    Node temp=null;
    Node(int data){
        this.data=data;
        next=null;
    }
    public void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            temp=newNode;
        }else{
            temp.next=newNode;
            temp=newNode;
        }
    }
    public void insertAtFirst(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
        System.out.println();
    }
    public void insertAtLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        temp=newNode;
    }
    public void insertAtAnyPosition(int data, int position) {
    Node newNode = new Node(data);
    if (position <= 0) {
        System.out.println("Invalid Position");
        return;
    }
    if (position == 1) {
        newNode.next = head;
        head = newNode;
        return;
    }
    int counter = 1;
    Node temp = head;

    while (counter < position - 1 && temp != null) {
        temp = temp.next;
        counter++;
    }
    if (temp == null) {
        System.out.println("Invalid Position");
        return;
    }
    newNode.next = temp.next;
    temp.next = newNode;
}
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.print("null");
    }
    public void deleteAtFirst(){
        if(head==null){
            return;
        }
        Node temp=head.next;
        System.out.print("\nDelete First Node:"+head.data);
        head.next=null;
        head=temp;
    }
    public void deleteAtLast(){
        if(head==null){
            return;
        }
        if(head.next==null){
            System.out.println("\nDelete Last Node"+head.data);
            head=null;
            return;
        }
        Node temp=head;
        Node preNode=null;
        while(temp.next!=null){
            preNode=temp;
            temp=temp.next;
        }
        System.out.println("\nDelete Last Node:"+temp.data);
        preNode.next=null;
    }
    public void deleteAnyPosition(int pos) {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }
    if (pos <= 1) {
        deleteAtFirst();
        return;
    }
    Node temp = head;
    Node preNode = null;
    int counter = 1;
    while (counter < pos && temp != null) {
        preNode = temp;
        temp = temp.next;
        counter++;
    }
    if(temp==null){
        return;
    }
    System.out.println("\nDelete Position Node: " + temp.data);
    preNode.next = temp.next;
}
    public static void main(String[] args){
        Node link=new Node(0);
        Scanner sc=new Scanner(System.in);
        int choice;
        int data;
        int pos;
        do{
            System.out.println("\n===== Linked List Menu =====");
            System.out.println("1. Insert the Node");
            System.out.println("2. Insert At First");
            System.out.println("3. Insert At Last");
            System.out.println("4. Insert At Any Position");
            System.out.println("5. Delete At First");
            System.out.println("6. Delete At Last");
            System.out.println("7. Delete At Any Position");
            System.out.println("8. Exit");
            System.out.println("9. Display");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();
            switch(choice){
                case 1: {
                          System.out.println("Enter the insert Node:");
                          data = sc.nextInt();
                          link.insert(data);
                         break;
                        }

                case 2: {
                        System.out.println("Insert At First Node:");
                        data = sc.nextInt();
                        link.insertAtFirst(data);
                        break;
                        }
                case 3:
                    System.out.println("Insert At Last Node:");
                    data=sc.nextInt();
                    link.insertAtLast(data);
                    break;
                case 4:
                    System.out.println("Insert Any Postion:");
                    data=sc.nextInt();
                    pos=sc.nextInt();
                    link.insertAtAnyPosition(data,pos);
                    break;
                case 5:
                    System.out.println("Delete at First Node:");
                    link.deleteAtFirst();
                    break;
                case 6:
                    System.out.println("Delete at Last Node:");
                    link.deleteAtLast();
                    break;
                case 7:
                    System.out.println("Delete at Any Position:");
                    pos=sc.nextInt();
                    link.deleteAnyPosition(pos);
                    break;
                case 8:
                        System.out.println("Thank You...");
                        break;
                case 9:
                        link.display();
                        System.out.println();
                        break;
                default:
                System.out.println("-----Invalid Choice-----");
            }
        }while(choice!=10);
    }
}