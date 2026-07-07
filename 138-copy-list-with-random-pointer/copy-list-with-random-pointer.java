class Solution {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Step 1: Insert copy nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // Step 3: Separate the two lists
        curr = head;
        Node dummy = new Node(0);
        Node copy = dummy;

        while (curr != null) {
            copy.next = curr.next;
            curr.next = curr.next.next;

            curr = curr.next;
            copy = copy.next;
        }

        return dummy.next;
    }
}