package challenge;

import java.util.Arrays;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        if (!texto.equals("")) {
            int x, y;
            String l2 = "";

            for (char c : texto.toCharArray()) {
                if (c != ' ' && c != '.' && Character.isLetter(c)) {
                    x = ((int) c);
                    if ((int) c <= 90) {
                        x += 32;
                    }
                    x += 3;
                    if (x > 122) {
                        x -= 26;
                    }
                    l2 += (char) x;
                } else {
                    l2 += c;
                }
            }
            return l2;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String descriptografar(String texto) {
        if (!texto.equals("")) {
            int x, y;
            String l2 = "";
            for (char c : texto.toCharArray()) {
                if (c != ' ' && c != '.' && Character.isLetter(c)) {
                    x = ((int) c);
                    if ((int) c <= 90) {
                        x += 32;
                    }
                    x -= 3;
                    if (x < 97) {
                        x += 26;
                    }
                    l2 += (char) x;
                } else {
                    l2 += c;
                }
            }
            return l2;
        }
        throw new IllegalArgumentException();
    }
}
