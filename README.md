# Sorted Linked List Library

This library provides a sorted linked list that maintains elements in ascending order. It includes common operations such as insertion, deletion, search, display, and utility methods.

## Methods

- `insert(T data)`: Inserts a new element into the sorted linked list while maintaining the order.

- `delete(T data)`: Deletes the first occurrence of the specified element from the sorted linked list.

- `display()`: Displays the elements of the sorted linked list in their current order.

- `search(T data)`: Searches for the specified element in the sorted linked list.

- `contains(T data)`: Checks if the specified element is present in the sorted linked list.

- `size()`: Returns the number of elements in the sorted linked list.

- `isEmpty()`: Checks if the sorted linked list is empty.

- `clear()`: Clears all elements from the sorted linked list, making it empty.

## Additional Methods

I added some methods from other collections I use pretty often such as `size()`, `contains()`, `isEmpty()`, `search(T data)`, and `clear()`.

## Optimization Considerations

- **Thread Safety**: For thread safety, I was thinking to make `insert` and `delete` synchronized. However, this might impact overall performance. Considering to make a separate concurrent version of the library.

- **Double LinkedList**: I considered making the linked list double to make deletions more efficient. However, this would consume more space due to the additional link.

- **Tail Reference**: I added tail reference maintaining. In case of inserting the new smallest or the biggest number, the operation will have only O(1) complexity.

## Example Usage

```java
 SortedLinkedList<Integer> sortedList = new SortedLinkedList<>();
        System.out.println("List is empty: " + sortedList.isEmpty());
        sortedList.insert(5);
        sortedList.insert(1);
        sortedList.insert(2);
        sortedList.insert(3);

        System.out.println("Sorted Linked List:");
        sortedList.display();
        System.out.println("List size " + sortedList.size());
        System.out.println("List contains 3 " + sortedList.contains(3));
        System.out.println("Result of searching 3: " + sortedList.search(3));

        sortedList.delete(3);

        System.out.println("After deleting 3: ");
        sortedList.display();
        System.out.println("List size: " + sortedList.size());
        System.out.println("List contains 3: " + sortedList.contains(3));
        System.out.println("Result of searching 3: " + sortedList.search(3));

        sortedList.clear();
        System.out.println("After clearing:");
        System.out.println("List is empty: " + sortedList.isEmpty());
        System.out.println("List size: " + sortedList.size());
        sortedList.display();