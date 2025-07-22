
import java.util.*;

public class ChatBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> responses = new HashMap<>();
        responses.put("hello", "Hi there! How can I help you today?");
        responses.put("bye", "Goodbye! Have a great day.");
        responses.put("name", "I'm CodeAlphaBot, your assistant.");
        responses.put("help", "You can ask me about this internship or tasks!");

        String input;
        System.out.println("Start chatting (type 'exit' to quit):");
        while (true) {
            input = sc.nextLine().toLowerCase();
            if (input.equals("exit")) break;
            boolean found = false;
            for (String key : responses.keySet()) {
                if (input.contains(key)) {
                    System.out.println(responses.get(key));
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("I'm not sure how to respond to that.");
        }
        sc.close();
    }
}