import java.util.Deque;
import java.util.LinkedList;

// Deque - When You Need a Double-Ended Queue!

/* Use Deque when you need:
1. Add/remove from both ends
2. Stack functionality (LIFO - Last In First Out)
3. Queue functionality (FIFO - First In First Out)
*/

/* 
 * Deque (pronounced "deck") lets us:
 * addFirst/offerFirst - Add to front
 * addLast/offerLast - Add to back
 * removeFirst/pollFirst - Remove from front
 * removeLast/pollLast - Remove from back
 */

public class DequeUsage {
    public static void main(String[] args) {
        // Deque is an interface, so we can't just say new Deque
        // LinkedList is commonly used as it implements Deque
        Deque<String> browserHistory = new LinkedList<>();
        
        // Let's simulate browser history
        System.out.println("=== Browsing the web ===");
        System.out.println("Browsing history added in the following order: google.com, youtube.com, ithsdistans.se");
        browserHistory.offerLast("google.com");
        browserHistory.offerLast("youtube.com");
        browserHistory.offerLast("ithsdistans.se");
        
        // Current page (Remember that we used offerLast,  now we use peekLast)
        System.out.println("Current page: " + browserHistory.peekLast());
        
        // Go back one page (we remove from the end)
        browserHistory.pollLast();
        System.out.println("Going back one step in the browser history");
        System.out.println("Went back to: " + browserHistory.peekLast());

        // Let's go forward to a new page
        System.out.println("Opps, we \"accidentally\" ended up on Twitter.");
        browserHistory.offerLast("twitter.com");
        System.out.println("Current page: " + browserHistory.peekLast());
        
        // Let's also try using it as a stack
        System.out.println("\n=== Using as a stack ===");

        Deque<String> stack = new LinkedList<>();
        
        // Push some plates onto our stack
        stack.offerFirst("Blue plate");
        stack.offerFirst("Red plate");
        stack.offerFirst("Green plate");

        System.out.println("--------------");
        System.out.println("Stack at start:");
        for(String s : stack){
            System.out.println(s);
        }
        System.out.println("--------------");
        
        // Let's look at the difference between peek and poll 
        System.out.println("Top plate is: " + stack.peekFirst()); // Shows us the top plate, but doesn't remove the plate
        System.out.println("Taking plate: " + stack.pollFirst()); // Shows us AND removes plate from stack.
        System.out.println("Top plate is: " + stack.pollFirst() + " let's grab that too!");
        System.out.println("Top plate is: " + stack.pollFirst() + " and I need that one too!");

        // Our deque is now empty! 
        System.out.println(stack);
        System.out.println("Empty deque peek: " + stack.peekFirst());
        System.out.println("Empty deque poll: " + stack.pollFirst());

        // Below is just a bonus visualisation of a stack of pancakes used as a stack
        System.out.println("\n\n  ~~~ Welcome to the Pancake Stack ~~~\n");
        System.out.println("The following is just a little bonus for running the code and to ");
        System.out.println("really drive home the stack of pancake visualisation of a stack!\n");
        System.out.println("------------------------------------------------------------\n");

        int numPancakes = 5;
        String topPancake = " =====*====";
        String regularPancake = " ==========";
        String plate = "\\__________/\n";

        for (int s = numPancakes; s > 0; s--) {
            System.out.println(s == numPancakes ? topPancake : regularPancake);
            
            for (int i = 0; i < s - 1; i++) {
                System.out.println(regularPancake);
            }
            
            System.out.println(plate);
            
            if (s > 1) {
                System.out.println("Now, we use pollFirst() on our stack of pancakes\n");
                System.out.println("------------------------------------------------------------\n");
            }
        }
    }
}
