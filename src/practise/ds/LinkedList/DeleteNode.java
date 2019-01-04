package practise.ds.LinkedList;


public class DeleteNode {
	
    public static void main(String arg[]) {
        LinkedList list = new LinkedList();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(500);
        list.display(list.getHead());
        DeleteNode delete = new DeleteNode();
        delete.delete(400,list);
        System.out.println("After Deleting");
        list.display(list.getHead());
    }

    void delete(int key, LinkedList list) {

        Node temp = list.getHead(), prev=null;

        //head case
        if(temp!=null && temp.data==key){
            list.setHead(temp.next);
            return;
        }
        //search for key to be deleted
        while(temp!=null && temp.data!=key){
            prev = temp;
            temp=temp.next;
        }
        if(temp == null) return;

        //remove the node link
        prev.next=temp.next;

    } 

}
