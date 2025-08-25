public class split {
    public static void main(String[] args) {
        String text = "This is a sample text to split into words";
        System.out.println("original text:" +text);
        System.out.println("Manual split:");
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                System.out.println(text.substring(start, i));
                start = i + 1;
            }
        }
        System.out.println(text.substring(start));
        System.out.println("\nUsing split() method:");
        String[] words = text.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }
}

