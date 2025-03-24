package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_1233 {
	
	public static void main(String[] args) {
		//Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
		//Output: ["/a","/c/d","/c/f"]
		
		String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
		System.out.println(new lc_1233().removeSubfolders(folder)); // Output: ["/a", "/c/d", "/c/f"]
		
	}
	
	public List<String> removeSubfolders(String[] folder) {
		List<String> result = new ArrayList<>();
		Arrays.sort(folder);
		int n = folder.length;
		
		result.add(folder[0]);
		
		for (int i = 1; i < n; i++) {
			String currentFolder = folder[i];
			
			String lastFolder = result.getLast() + "/";
			
			if (!currentFolder.startsWith(lastFolder)) {
				result.add(currentFolder);
			}
		}
		
		return result;
		
	}
}
