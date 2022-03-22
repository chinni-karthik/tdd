package isbntools;

public class ValidateISBN {

    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int LONG_ISBN_LENGTH = 13;
    public static final int LONG_ISBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkISBN(String isbn) {
        if (isbn.length() == 13) {
            return isThisValid13DigitISBN(isbn);
        } else if(isbn.length() == 10){
            return isThisValid10DigitISBN(isbn);
        } else {
            throw new NumberFormatException("ISBN Numbers should be 10 or 13 digits long");
        }
    }

    private boolean isThisValid10DigitISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (isbn.charAt(i) == 'X') {
                total += 10;
            } else if (isbn.charAt(i) < '0' || isbn.charAt(i) > '9') {
                throw new NumberFormatException("ISBN Numbers should only be numeric");
            }
            total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
        }
        return (total % SHORT_ISBN_MULTIPLIER == 0);
    }

    private boolean isThisValid13DigitISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else if (i % 2 == 1) {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        return (total % LONG_ISBN_MULTIPLIER == 0);
    }
}
