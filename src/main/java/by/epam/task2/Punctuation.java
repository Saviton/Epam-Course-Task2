package by.epam.task2;

public enum Punctuation implements Component {
    EXCLAMATION("!"),
    DOT("."),
    QUESTION("?"),
    NEWLINE("\n"),
    CARRET("\r"),
    TWO_DOT("‥"),
    HORIZONTAL_ELLIPSIS("…"),
    INTERROBANG("⁈"),
    DISAMBIGUATION("⁇"),
    NUMBERSIGN("#"),
    DOLLAR("$"),
    PERCENT("%"),
    AMPERSAND("&"),
    LBRACKETS("("),
    RBRACKETS(")"),
    ASTERISK("*"),
    PLUS("+"),
    COMMA(","),
    SPACE(" "),
    MINUS("-"),
    SLASH("/"),
    COLON(":"),
    SEMICOLON(";"),
    LESSTHAN("<"),
    EQUAL("="),
    GREATERTHAN(">"),
    LSQUAREBRACKETS("["),
    RSQUAREBRACKETS("]"),
    CARET("^"),
    UNDERSCORE("_"),
    GRAVIS("`"),
    LCURLYBRACKETS("{"),
    VERTICALBAR("|"),
    RCURLYBRACKETS("}"),
    TILDE("~"),
    DASH("‒"),
    GDASH("—"),
    GIANTDASH("―"),
    MULTIPLICATION("×"),
    PER_MILLE("‰"),
    PER_TEN_THOUSAND("‱"),
    QUOTATION("\""),
    LEFT_POINTING_DOUBLE_ANGLE_QUOTATION("«"),
    RIGHT_POINTING_DOUBLE_ANGLE_QUOTATION("»"),
    LEFT_SINGLE_QUOTATION("‘"),
    RIGHT_SINGLE_QUOTATION("’"),
    SINGLE_LOW_9_QUOTATION_MARK("‚"),
    SINGLE_HIGH_REVERSED_9_QUOTATION("‛"),
    LEFT_DOUBLE_QUOTATION("“"),
    RIGHT_DOUBLE_QUOTATION("”"),
    DOUBLE_LOW_9_QUOTATION("„"),
    DOUBLE_HIGH_REVERSED_9_QUOTATION("‟"),
    SINGLE_LEFT_POINTING_ANGLE_QUOTATION("‹"),
    SINGLE_RIGHT_POINTING_ANGLE_QUOTATION("›"),
    BACKSLASH("\\");

    private String value;

    Punctuation() {
    }

    private Punctuation(String value) {
        this.value = value;
    }


    public String getValue() {
        return this.value;
    }

    @Override
    public String print() {
        return this.value;
    }
}
