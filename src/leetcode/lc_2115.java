package leetcode;

import java.util.*;

public class lc_2115 {
	
	public static void main(String[] args) {
//		input
		/*
		Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
Output: ["bread"]
		 */
		String[] recipes = {"bread", "sandwich"};
		List<List<String>> ingredients = List.of(List.of("yeast", "flour"), List.of("bread", "meat"));
		String[] supplies = {"yeast", "flour", "meat"};
		System.out.println(new lc_2115().findAllRecipes_Brute_Force(recipes, ingredients, supplies)); // Output: ["bread"]
	}
	
	
	public List<String> findAllRecipes_Brute_Force(String[] recipes, List<List<String>> ingredients,
	                                               String[] supplies) {
		List<String> ans = new ArrayList<>();
		Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
		int n = recipes.length;
		
		Queue<String[]> remainingRecipes = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			String recipe = recipes[i];
			List<String> ingredientsList = ingredients.get(i);
			boolean canBeMade = true;
			
			for (String ingredient : ingredientsList) {
				if (!suppliesSet.contains(ingredient)) {
					canBeMade = false;
					remainingRecipes.add(new String[]{String.valueOf(i), recipe});
					break;
				}
			}
			
			if (canBeMade) {
				ans.add(recipe);
				suppliesSet.add(recipe);
			}
		}
		
		// Process remaining recipes until no new recipe can be added
		boolean updated = true;
		while (updated) {
			updated = false;
			Iterator<String[]> iterator = remainingRecipes.iterator();
			
			while (iterator.hasNext()) {
				String[] recipe = iterator.next();
				List<String> ingredientsList = ingredients.get(Integer.parseInt(recipe[0]));
				boolean canBeMade = true;
				
				for (String ingredient : ingredientsList) {
					if (!suppliesSet.contains(ingredient)) {
						canBeMade = false;
						break;
					}
				}
				
				if (canBeMade) {
					ans.add(recipe[1]);
					suppliesSet.add(recipe[1]);
					iterator.remove();
					updated = true;
				}
			}
		}
		
		return ans;
	}
}
