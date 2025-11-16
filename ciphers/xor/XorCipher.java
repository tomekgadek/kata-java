import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XorCipher {

    private final int key;

    XorCipher(final int key) {
        this.key = key;
    }

    /*
     * M = message
     * K = key
     * C = code
     * 
     * Kodowanie odbywa się według wzoru: M xor K = C
     */
    String encode(final String input) {

        final char[] charArray = input.toCharArray();

        return IntStream.range(0, charArray.length)
                .mapToObj(idx -> Integer.toBinaryString(charArray[idx]))
                .map(binaryString -> String.valueOf(key ^ Integer.parseInt(binaryString)))
                .collect(Collectors.joining(" "));
    }

    // Dekodowanie odbywa się według wzoru: C xor K = M
    String decode(final String input) {

        final String[] stringArray = input.split(" ");

        return Arrays.stream(stringArray)
                .map(s -> String.valueOf(Integer.parseInt(s) ^ key))
                .map(number -> String.valueOf((char)Integer.parseInt(number, 2)))
                .collect(Collectors.joining());
    }
}
