package isbntools.tautology;

public class NumberValidator {
	public boolean isItPrime(int number) {
		int maxDivisor = (int)Math.sqrt(number);
		for(int i=2;i<=maxDivisor;i++) {//Logic changed from < to <=
			if(number % i==0)
				return false;
		}
		return true;
	}
}
