package leetcode;

public class lc_2337 {
	public static void main(String[] args) {
//		Input: start = "_L__R__R_", target = "L______RR"
		String start = "_L__R__R_";
		String target = "L______RR";
		boolean res = new lc_2337().canChange(start, target);
		System.out.println(res);
	}
	
	public boolean canChange(String start, String target) {
		int startLength = start.length();
		int targetLength = target.length();
		
		int startIndex = 0;
		int targetIndex = 0;
		
		while (startIndex < startLength || targetIndex < targetLength) {
			
			//skip the underscore in the start string
			while (startIndex < startLength && start.charAt(startIndex) == '_') {
				startIndex++;
			}
			//skip the "_" or underscore in target string
			while (targetIndex < targetLength && target.charAt(targetIndex) == '_') {
				targetIndex++;
			}
			//if one of the string is completely explored
			if (startIndex == startLength || targetIndex == targetLength) {
				return startIndex == startLength && targetIndex == targetLength;
			}
			//check if the matches or moving rules is applicable or not so far
			if (start.charAt(startIndex) != target.charAt(targetIndex) || (start.charAt(startIndex) == 'L' && startIndex < targetIndex) || (start.charAt(startIndex) == 'R' && startIndex > targetIndex)) {
				return false;
			}
			startIndex++;
			targetIndex++;
		}
		return true;
	}
}
