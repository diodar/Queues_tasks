package app_task_1_2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger counter = new AtomicInteger(0);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String title;
        Queue<String> queue = getData(sc);
        title = "Your queue:";
        getOutput(title, queue);
        title = "Some product was added to the queue:";
        getOutput(title, addToTheQueue(queue));
        title = "Updated queue:";
        getOutput(title, firstOut(queue));

        sc.close();
    }

    private static Queue<String> getData(Scanner sc) {

        System.out.println("\nHow many products do you want to add to the queue ?: ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.println("\nMaking queue with " + num + " products . . .");

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            counter.incrementAndGet();
            System.out.print(counter + ")" + " product: ");
            String product = sc.nextLine().toLowerCase();
            queue.add(product);
        }
        return queue;
    }

    private static void getOutput(String title, Queue<String> queue) {
        counter.set(0);
        System.out.println("\n" + title);
        for (String list : queue) {
            counter.incrementAndGet();
            System.out.println(counter + ") " + list);
        }
    }

    private static Queue<String> addToTheQueue(Queue<String> queue) {

        System.out.println("\nThere are " + queue.size() + " products already in the queue.");

        System.out.println("\nHow many products do you want to add to the queue?: ");
        counter.set(queue.size());
        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            counter.incrementAndGet();
            System.out.print(counter + ")" + " product: ");
            String product = sc.nextLine().toLowerCase();
            queue.add(product);
        }
        return queue;
    }

    private static Queue<String> firstOut(Queue<String> queue) {

        String productOut = queue.poll();
        System.out.println('\n' + productOut + " - has left the queue.");

        return queue;
    }
}