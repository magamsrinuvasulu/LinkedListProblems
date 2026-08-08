import java.util.Scanner;
class DoubleNode{
    int data;
    DoubleNode next;
    DoubleNode prev;
    DoubleNode head=null;
    DoubleNode(int data){
        this.data=data;
        next=null;
        prev=null;
    }
    public void insert(int data){
        DoubleNode newNode=new DoubleNode(data);
        if(head==null){
            head=newNode;
            return;
        }
        DoubleNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.prev=newNode;
    }
    public void insertAtLast(int data){
        DoubleNode newNode=new DoubleNode(data);
        if(head==null){
            head=newNode;
            return;
        }
        DoubleNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.prev=newNode;
    }
    public void insertAtFisrt(int data){
        DoubleNode newNode=new DoubleNode(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void insertAtAnyPosition(int data, int position) {
    DoubleNode newNode = new DoubleNode(data);
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
    DoubleNode temp = head;

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
       DoubleNode temp=head;
        System.out.print("Null<-");
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("Null->");
    }
    public void displayReverse() {
    if (head == null) {
        System.out.println("List is Empty");
        return;
    }

    DoubleNode temp = head;

    // Move temp to the last node
    while (temp.next != null) {
        temp = temp.next;
    }

    // Display in reverse
    System.out.print("Null<-");

    while (temp != null) {
        System.out.print(temp.data + "<->");
        temp = temp.prev;
    }

    System.out.println("Null");
}
    public void deleteAtFirst(){
        if(head==null){
            System.out.println("List is Empty");
        }
        DoubleNode temp=head.next;
        System.out.print("\nDelete First Node:"+head.data);
        head=temp;
        temp.next=null;
        head.prev=null;
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
        DoubleNode temp=head;
        DoubleNode preNode=null;
        while(temp.next!=null){
            preNode=temp;
            temp=temp.next;
        }
        System.out.println("\nDelete Last Node:"+temp.data);
        preNode.next=null;
        temp.prev=null;
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
    DoubleNode temp = head;
    DoubleNode preNode = null;
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
  public void getSize(){
    if(head==null){
        return;
    }
    DoubleNode temp=head;
    int counter=0;
    while(temp!=null){
        counter++;
        temp=temp.next;
    }
    System.out.println("Counter:"+counter);
   }
   public void searchElement(int target){
    if(head==null){
        return;
    }
    DoubleNode temp=head;
    while(temp!=null){
        if(temp.data==target){
            System.out.println("Found:");
            break;
        }else{
            temp=temp.next;
        }
        System.out.println("Not Found:");
    }
  }
  public void updateValue(int target,int updateValue){
    if(head==null){
        return;
    }
    DoubleNode temp=head;
    while(temp!=null){
        if(temp.data==target){
            temp.data=updateValue;
        }
        temp=temp.next;
    }
    System.out.println("Null");
}
public static void main(String[] args){
        DoubleNode link=new DoubleNode(0);
        Scanner sc=new Scanner(System.in);
        int choice;
        int data;
        int pos;
        int target;
        int updateValue;
        do{
            System.out.println("\n===== Linked List Menu =====");
            System.out.println("1. Insert the Node");
            System.out.println("2. Insert At First");
            System.out.println("3. Insert At Last");
            System.out.println("4. Insert At Any Position");
            System.out.println("5. Delete At First");
            System.out.println("6. Delete At Last");
            System.out.println("7. Delete At Any Position");
            System.out.println("8. Display");
            System.out.println("9. Get Size");
            System.out.println("10.Serach Element");
            System.out.println("11.update Value");
            System.out.println("12.DisplayReverse");
            System.out.println("13.Exit");
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
                        link.insertAtFisrt(data);
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
                    System.out.println("Display DoubleLinkedList");
                        link.display();
                        System.out.println();
                        break;
                case 9:
                    System.out.println("Size of the DoubleLinkedList");
                    link.getSize();
                    break;
                case 10:
                        System.out.println("Enter the target Element:");
                        target=sc.nextInt();
                        link.searchElement(target);
                        break;
                case 11:
                    System.out.println("Entere the target Element:");
                    target=sc.nextInt();
                    System.out.println("Enter the update value:");
                    updateValue=sc.nextInt();
                    link.updateValue(target,updateValue);
                    break;
                case 12:
                    System.out.println("Display Reverse");
                    link.displayReverse();
                    break;
                case 13:
                    System.out.println("-------Thank You--------");
                    break;
                default:
                System.out.println("-----Invalid Choice-----");
            }
        }while(choice!=14);
    }
}