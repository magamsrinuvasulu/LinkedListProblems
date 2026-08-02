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
    public static void main(String[] args){
        Node link=new Node(0);
        link.insert(23);
        link.insert(20);
        link.insert(57);
        link.insertAtAnyPosition(10,57);
        link.insert(56);
        link.display();
        link.insertAtFirst(90);
        link.display();
        link.insertAtFirst(7346);
        link.display();
    }
}