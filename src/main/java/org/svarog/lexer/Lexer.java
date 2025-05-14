package org.svarog.lexer;

import java.util.ArrayList;
import java.util.regex.Matcher;


public class Lexer {
    private final String input;
    private int pos;

    public Lexer(String input) {
        this.input = input;
        pos = 0;
    }

    public ArrayList<Token> parse() {
        ArrayList<Token> tokenList = new ArrayList<>();

        Token currentToken;
        while ((currentToken = nextToken()) != null) {
            tokenList.add(currentToken);
        }

        return tokenList;
    }

    private Token nextToken() {
        while (pos < input.length() && Character.isWhitespace(input.charAt(pos))) {
            pos++;
        }

        if (pos >= input.length()) {
            return null;
        }

        String remaining = input.substring(pos);

        for (TokenType type : TokenType.values()) {
            String match = type.matchPrefix(remaining);
            if (match != null) {
                Token token = new Token(type, match);
                pos += match.length();
                return token;
            }
        }

        throw new RuntimeException("Неизвестный символ на позиции " + pos + ": " + input.charAt(pos));
    }

}
