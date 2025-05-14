package org.svarog.lexer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum TokenType {
    START("^начало\b"),
    ELSE("^инако\b"),
    END("^конец\b"),
    IF("^коль\b"),
    NUMBER_TYPE("^число\b"),
    FLOAT_TYPE("^дробь\b"),
    STRING_TYPE("^речь\b"),
    BOOL_TYPE("^истинник\b"),
    VOID_TYPE("^пустец\b"),
    PRINT("^явить\b"),
    OPERATOR("^(==|\\+|\\-|\\*|=|<|>|или\b|и\b|не\b)"),
    NUMBER("^[0-9]+"),
    STRING("^\"[^\"]*\""),
    LPAREN("^\\("),
    RPAREN("^\\)"),
    LSQBRACKET("^\\["),
    RSQBRACKET("^\\]"),
    COMMA("^,"),
    VARIABLE("^[а-яА-Я_][а-яА-Я0-9_]*"),
    SEMICOLON("^;");

    private final Pattern pattern;

    TokenType(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public String matchPrefix(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find() && matcher.start() == 0) {
            return matcher.group();
        }
        return null;
    }
}
