import lists.MyArrayList;
import lists.MyLinkedList;
import lists.MyList;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----------------------");
        System.out.println("Testing of MyArrayList");
        System.out.println("-----------------------");

        MyList<String> myList = new MyArrayList<>();

        myList.add("hello");
        myList.add("world");
        myList.add("!");

        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));

        myList.remove(1);
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));

        System.out.println(myList.size());

        myList.add("world", 1);
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));

        System.out.println(myList.remove("world"));
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.size());

        System.out.println(myList.indexOf("!"));
        System.out.println(myList.indexOf("hello"));
        System.out.println(myList.indexOf("world"));

        myList.add("hello");
        System.out.println(myList.lastIndexOf("hello"));
        System.out.println(myList.lastIndexOf("world"));

        myList.add("world");
        myList.sort();
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(3));
        System.out.println();
        System.out.println();

        System.out.println("-----------------------");
        System.out.println("Testing of MyLinkedList");
        System.out.println("-----------------------");

        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("car");
        list.add("dias");
        list.add("abcd");

        System.out.println("List after adding 3 elements: " + list);

        System.out.println("List size: " + list.size());

        System.out.println("Element at index 1: " + list.get(1));

        list.remove(0);
        System.out.println("List after removing element at index 0: " + list);

        System.out.println("List contains banana: " + list.contains("banana"));
        System.out.println("List contains apple: " + list.contains("apple"));

        list.clear();
        System.out.println("List after clear method: " + list);

        list.add("car");
        list.add("dias");
        list.add("abcd");
        System.out.println("List before sort method: " + list);

        list.sort();
        System.out.println("List after sort method: " + list);

    }
}
