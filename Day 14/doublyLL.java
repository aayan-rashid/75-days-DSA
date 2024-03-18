package Linkedlist;

public class doublyLL 
{
    static class Node
    {
        int val;
        Node next;
        Node back;

        Node (int val)
        {
            this.val = val;
            this.next = null;
            this.back = null;
        }

        Node (int val, Node next, Node back)
        {
            this.val = val;
            this.next = next;
            this.back = back;
        }

        Node (Node next, Node back)
        {
            this.val = 0;
            this.next = next;
            this.back = back;
        }

    }


    // traverse Doubly LL and print
    private static Node traverseAndPrint(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.println("value is : " + temp.val);
            temp = temp.next;
        }
        return head;
    }
    


    // convert Array to Doubly LL
    private static Node arrToList(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i< arr.length; i++)
        {
            Node temp = new Node(arr[i], null, prev);
            //temp.back = prev;
            prev.next = temp;
            prev = prev.next;
        }

        return head;
    }






    // delete head/first node of Doubly LL
    private static Node deleteHead(Node head)
    {
        if (head == null || head.next == null)
        {
            return null;
        }

        Node prev = head;

        head = head.next;
        head.back = null;
        prev.next = null;

        return head;
    }



    // delete last/tail node of Doubly LL
    private static Node deleteLast(Node head)
    {
        if (head == null || head.next == null)
        {
            return null;
        }


        // using back.next with only 1 Node 
        Node last = head;

        while (last.next != null)
        {
            last = last.next;
        }

        last.back.next = null;
        last.back = null;

        // using prev node to track back of last node
        // Node last = head;
        // Node prev = head;

        // last = last.next;
        // while (last.next != null)
        // {
        //     last = last.next;
        //     prev = prev.next;
        // }

        // last.back = null;
        // prev.next = null;

        return head;
    }



    // delete Node at Kth position
    private static Node deleteAtKthpos(Node head, int k)
    {
        if (head == null || head.next == null)
        {
            return null;
        }

        if (k == 1)
        {
            if (head.next == null)
            {
                return null;
            }
            else
            {
                head = head.next;
                head.back.next = null;
                head.back = null;
            }

            return head;
        }

        Node temp = head;
        int cnt = 0;
        while (temp != null)
        {
            cnt++;
            if (cnt == k && temp.next != null)
            {
                temp.back.next = temp.next;
                temp.next.back = temp.back;
                temp.next = null;
                temp.back = null;

                break;
            }
            else if (cnt == k && temp.next == null) 
            {
                temp.back.next = null;
                temp.back = null;
                    
                break;
            }
                
            temp = temp.next;
        }
        return head;
    }



    // delete node from Doubly LL (except head)
    private static Node deleteNode(Node del)
    {
       if (del.next == null)
       {
            del.back.next = null;
       }
       else
       {
            del.back.next = del.next;
            del.next.back = del.back;
       }   

       return del;
    }







    // insert before head of Doubly LL
    private static Node insertBeforeHead(Node head, Node beforeHead)
    {
        if (head == null)
        {
            return beforeHead;
        }
        
        beforeHead.next = head;
        beforeHead.back = null;
        head.back = beforeHead;
        head = beforeHead;

        return head;
    }

    // insert after head of DoublyLL
    private static Node insertAfterHead(Node head, Node afterHead)
    {
        if (head == null)
        {
            return afterHead;
        }
        if (head.next == null)
        {
            head.next = afterHead;
            afterHead.back = head;
            return head;
        }
        
        Node temp = head;
        Node front = temp.next;

        temp.next = afterHead;
        afterHead.next = front;
        afterHead.back = temp;
        front.back = afterHead;

        return head;
    }




    // insert before tail of Doubly LL
    private static Node insertBeforeTail(Node head, Node beforeTail)
    {
        if (head == null)
        {
            return beforeTail;
        }

        if (head.next == null)
        {
            beforeTail.next = head;
            head.back = beforeTail;
            head = beforeTail;

            return head;
        }

        Node temp = head;
        Node b4last = null;
        while (temp.next != null)
        {
            b4last = temp;
            temp = temp.next;
        }

        b4last.next = beforeTail;
        beforeTail.back = b4last;
        beforeTail.next = temp;
        temp.back = beforeTail;

        return head;
    }

    // insert after tail of DoublyLL    
    private static Node insertAfterTail(Node head, Node aftTail)
    {
        if (head == null)
        {
            return aftTail;
        }

        if (head.next == null)
        {
            head.next = aftTail;
            aftTail.back = head;
            aftTail.next = null;

            return head;
        }

        Node temp = head;

        while (temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = aftTail;
        aftTail.back = temp;
        aftTail.next = null;

        return head;
    }

    



    // insert before Kth Node of Doubly LL
    private static Node insertBeforeKthNode(Node head, Node KthNode, int k)
    {
        if (head == null && k < 1)
        {
            return head;
        }

        if (head == null && k == 1)
        {
            return KthNode;
        }

        if (head.next == null && k == 1)
        {
            KthNode.next = head;
            head.back = KthNode;
            KthNode.back = null;

            return KthNode;
        }

        if (head.next == null && k == 2)
        {
            head.next = KthNode;
            KthNode.back = head;
            KthNode.next = null;

            return head;
        }

        Node temp = head;
        int cnt = 0;

        while (temp != null)
        {
            cnt++;
            if (cnt == k)
            {
                break;
            }
            temp = temp.next;
        }

        Node prev = temp.back;

        prev.next = KthNode;
        KthNode.back = prev;
        KthNode.next = temp;
        temp.back = KthNode;

        return head;
    }

    // insert after Kth Node of Doubly LL
    private static Node insertAfterKthNode(Node head, int k, int val)
    {
        Node node = new Node(val);

        if (head == null && k == 1)
        {
            return node;
        }

        if (head.next == null && k == 1)
        {
            node.next = head;
            head.back = node;

            return node;
        }

        if (head.next == null && k == 2)
        {
            node.back = head;
            head.next = node;

            return head;
        }

        Node temp = head;
        int cnt = 0;

        while (temp != null)
        {
            cnt++;
            if (cnt == k)
            {
                break;
            }

            temp = temp.next;
        }

        if (temp.next == null)
        {
            node.back = temp;
            temp.next = node;

            return head;
        }

        Node front = temp.next;
        node.next = front;
        node.back = temp;
        front.back = node;
        temp.next = node;

        return head;
    }





    // insert before given Node of Doubly LL
    private static Node insertbeforeNode(Node givenNode, Node insertNode)
    {
        Node prev = givenNode.back;
        prev.next = insertNode;
        insertNode.next = givenNode;
        insertNode.back = prev;
        givenNode.back = insertNode;

        return givenNode;
    }

    private static Node insertbeforeNode(Node givenNode, int val)
    {
        Node prev = givenNode.back;
        Node insertNode = new Node(val, givenNode, prev);
        prev.next = insertNode;
        givenNode.back = insertNode;

        return givenNode;
    }



    // insert after given Node in Doubly LL
    private static Node insertafterNode(Node givenNode, int val)
    {
        Node front = givenNode.next;
        Node insertNode = new Node(val, front, givenNode);
        givenNode.next = insertNode;
        front.back = insertNode;

        return givenNode;
    }



    
    public static void main(String[] args) 
    {

    }    
}
