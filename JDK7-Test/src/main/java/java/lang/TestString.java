package java.lang;

/**
 * Hello world!
 */
public class TestString {
    public static void main(String[] args) {
        // 这可是会编译报错的哟
        String s = new String("hello world");
        for (int i = 0; i < 1; i++) {
        }
    }
}
