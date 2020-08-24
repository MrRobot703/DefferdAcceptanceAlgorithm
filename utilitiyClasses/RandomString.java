package utilitiyClasses;

import java.util.Random;

public class RandomString {

    public static String generate(int length) {
        int leftLimit = 'a';
        int rightLimit = 'z';
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
