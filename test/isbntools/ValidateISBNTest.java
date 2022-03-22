package isbntools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateISBNTest {
    @Test
    public void checkValid10DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        Assertions.assertTrue(result,"First Value");
        result = validator.checkISBN("0140177396");//Another valid number form Amazon
        Assertions.assertTrue(result,"Second Value");
    }
    @Test
    public void checkInValid10DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        Assertions.assertFalse(result);
    }

    @Test
    public void nineDigitISBNAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        Assertions.assertThrows(NumberFormatException.class,
                () -> {
                    validator.checkISBN("140449116");
                });
    }

    @Test
    public void nonNumericISBNsAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        Assertions.assertThrows(NumberFormatException.class,
                () -> {
                    validator.checkISBN("HelloWorld");
                });
    }

    @Test
    public void isbnEndingWithXAreValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        Assertions.assertTrue(result);
    }

    @Test
    public void checkValid13DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780141198248");
        Assertions.assertTrue(result,"First Value");
        result = validator.checkISBN("9780571364886");
        Assertions.assertTrue(result,"Second Value");
    }

    @Test
    public void checkInValid13DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780141198247");
        Assertions.assertFalse(result);
    }
}
