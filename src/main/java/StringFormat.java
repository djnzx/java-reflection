public class StringFormat {
    public static void main(String[] args) {
        System.out.printf("Hello word %s %s %s\n", "ONE", "TWO", "THREE");
        System.out.printf("Hello word %2$s %1$s %3$s\n", "ONE", "TWO", "THREE");
    }

}
