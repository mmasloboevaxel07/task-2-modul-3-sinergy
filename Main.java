package third_modul.second;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(1);
        }
        list.print();

        list.add(0, 5);
        list.add(3, 3);
        list.print();

        list.remove(list.getSize() - 1);
        list.print();

        Integer i = 1;
        list.remove(i);
        list.print();

        System.out.println(list.indexOf(i));
    }
}
