package lab08;

public class TestingPractice {
	/**
	 * Computes the average of numbers within a given range in an array.
	 * If the range is invalid, 0.0 is returned.
	 * An invalid range has:
	 * a) at least one end point that is out of bounds for the array, or
	 * b) a beginning index that is greater than the end index.
	 * 
	 * @param numbers - array of numbers
	 * @param begin - index of the first number in the range
	 * @param end - index of the last number in the range(inclusive)
	 * @return average of the values between numbers[begin] and numbers[end] or 0.0 if the range is invalid
	 */
	public static double averageInRange(int[] numbers, int begin, int end) {
	    double average = 0.0;
	    if(begin >= 0 && begin <= end && end < numbers.length) {
	        for(int i = begin; i <= end; i++)
	            average += numbers[i];
	        average /= (end - begin + 1);
	    }
	    return average;
	}
}
