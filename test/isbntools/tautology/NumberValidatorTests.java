package isbntools.tautology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberValidatorTests {
    NumberValidator validator;

    @BeforeEach
    public void setUp(){
        validator = new NumberValidator();
    }

    @Test
    public void checkPrimeNumbers() {
        Integer numbers[] = {1, 23, 61, 79};

        for (int i = 0; i < numbers.length; i++) {
            assertEquals(true, validator.isItPrime(numbers[i]));
        }
    }

    @Test
    public void checkNonPrimeNumbers() {
        Integer numbers[] = {15, 25, 60, 63, 207};

        for (int i = 0; i < numbers.length; i++) {
            assertEquals(false, validator.isItPrime(numbers[i]));
        }
    }
}