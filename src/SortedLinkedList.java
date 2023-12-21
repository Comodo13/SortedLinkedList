/**
 * I added some methods from other collections I use pretty often such as: size(), contains(), isEmpty(), search(T data), clear().
 *
 *
 *
 * Optimization considerations:
 * For tread safety I would use locks by making insert and delete synchronized. But it will lower overall performance, so I would make separate concurrent version of my library.
 * I was thinking to make LInkedList double, to make deletions more efficient, but it would take much more space to store because of additional link.
 * I just added tail reference maintaining. So in case of inserting the new smallest or the biggest number, operation will have only O(1) complexity.
 *
 */
public class SortedLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;

    public SortedLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts a new element into the sorted linked list while maintaining the order.
     *
     * @param data the data to be inserted
     */
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (data.compareTo(head.data) < 0) {
            newNode.next = head;
            head = newNode;
        } else if (data.compareTo(tail.data) >= 0) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && data.compareTo(current.next.data) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /**
     * Deletes the first occurrence of the specified element from the sorted linked list.
     * If the element is found and deleted, the list is adjusted accordingly.
     *
     * @param data the data to be deleted
     */
    public void delete(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) {
                tail = null;    //list is empty after deletion
            }
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;

            if (prev.next == null) {
                //last node deleted
                tail = prev;
            }
        }
    }

    /**
     * Displays the elements of the sorted linked list in their current order.
     */
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Searches for the specified element in the sorted linked list.
     *
     * @param data the data to be searched for
     * @return the found data if present, otherwise null
     */
    public T search(T data) {
        if (head == null || data.compareTo(head.data) < 0 || data.compareTo(tail.data) > 0) {
            return null;
        }

        // O(1) complexity - best case scenario
        if (data.equals(head.data)) {
            return head.data;
        } else if (data.equals(tail.data)) {
            return tail.data;
        }

        if (data.compareTo(tail.data) > 0) {
            return null;
        }

        // Start searching from the head or tail, whichever is closer
        Node<T> current = (data.compareTo(tail.data) > data.compareTo(head.data)) ? tail : head;

        while (current != null) {
            if (current.data.equals(data)) {
                return current.data;
            }
            current = current.next;
           // System.out.println("+O 1");
        }

        return null;
    }

    /**
     * Checks if the specified element is present in the sorted linked list.
     *
     * @param data the data to be checked for existence
     * @return true if the data is present, false otherwise
     */
    public boolean contains(T data) {
        return search(data) != null;
    }

    /**
     * Returns the number of elements in the sorted linked list.
     *
     * @return the size of the linked list
     */
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Checks if the sorted linked list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Clears all elements from the sorted linked list, making it empty.
     */
    public void clear() {
        head = null;
        tail = null;
    }
}

