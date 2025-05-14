package org.svarog;

import org.svarog.lexer.Lexer;

public class Main {
    public static void main(String[] args) {
        String input = "число база() начало\n" +
                "    число х = 10;\n" +
                "    число у = х + 5;\n" +
                "    явить(у);\n" +
                "    коль (х == \"жопа\" или у == \"тест\") начало\n" +
                "        явить(\"Здравствуй миръ!\");\n" +
                "    конец\n" +
                "    воротить 1;\n" +
                "конец";

        Lexer lexer = new Lexer(input);
        System.out.println(input);
        lexer.parse().forEach(token -> {
            System.out.print("Token Type: " + token.getTokenType());
            System.out.println(", Token Value: " + token.getValue());
        });
    }
}
