package practice.exceptions;

import java.util.HashMap;

public class ConcurrentException {
    private static final HashMap<String, String> ages;
    static {
        ages = new HashMap<String, String>() {{
            put("usman", "25");
            put("Ali", "24");
            put("Naveed", "23");
        }};
    }

    public static void main(String[] args) {
        ConcurrentException concurrentException = new ConcurrentException();
        concurrentException.run();
    }

    private void run() {
        produceConcurrentExceptionInSingleThread();
    }

    private void produceConcurrentExceptionInSingleThread() {

        for (String key : ages.keySet()) {
            if (key.equals("usman")) {
                ages.remove(key);
            }
        }
    }
}
