/*
    XorCipher.java

    Temat:
    Szyfry klasyczne (Szyfr XOR).

    Opis:
    Wieloalfabetowy szyfr podstawieniowy. Pomimo niedużej siły zapewnianego
    bezpieczeństwa, proste szyfrowanie XOR było wykorzystywane w wielu
    komercyjnych aplikacjach ze względu na dużą szybkość działania i
    prostotę zaimplementowania.

    Prosty szyfr XOR jest odmianą szyfru Vigenère'a. Różni się od niej tym, że
    zamiast manipulować na literach i znakach, zmienia bity i bajty
    elektronicznej wiadomości przechowywanej w pamięci komputera.

    Źródło:
    http://www.crypto-it.net/pl/proste/prosty-xor.html
 */
public class Main {
    public static void main(String[] args) {

        int key = 0b10110101111;
        final String input = "KRYPTOGRAFIA";

        final XorCipher xor = new XorCipher(key);
        final String outputEncode = xor.encode(input);
        final String outputDecode = xor.decode(outputEncode);

        System.out.printf("message: %s \n", input);
        System.out.printf("encode : %s \n", outputEncode);
        System.out.printf("decode : %s \n", outputDecode);
    }
}
