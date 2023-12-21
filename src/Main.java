public class Main {
    public static void main(String[] args) {

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
    }
}
