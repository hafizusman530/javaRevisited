package practice.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ConcurrentException {
    private static final HashMap<String, String> ages;
    private static final List<String> agesList;

    static {
        ages = new HashMap<String, String>() {{
            put("usman", "25");
            put("Ali", "24");
            put("Naveed", "23");
        }};
        agesList = new ArrayList<String>() {{
            add("23");
            add("24");
            add("26");
            add("25");
        }};
    }

    public static void main(String[] args) {
        ConcurrentException concurrentException = new ConcurrentException();
        concurrentException.run();
    }

    private void run() {
        produceConcurrentExceptionInSingleThread(agesList);
        fixConcurrentExceptionInSingleThread(agesList);
    }

    private void fixConcurrentExceptionInSingleThread(List<String> ages) {
        System.out.println("Ages Before Delete 25");
        printList(ages);
        System.out.println("Ages After Delete 25");
        printList(ages.stream().filter(age -> !age.equals("25")).collect(Collectors.toList()));
    }

    private void printList(List<String> ages) {
        ages.forEach(System.out::println);
    }

    private void produceConcurrentExceptionInSingleThread(List<String> ages) {

        for (String age : ages) {
            if (age.equals("25")) {
                ages.remove(age);
            }
        }
    }

}
