package leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

class lc_2353 {

	public static void main(String[] args) {
		/**
		 * Your FoodRatings object will be instantiated and called as such:
		 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
		 * obj.changeRating(food,newRating);
		 * String param_2 = obj.highestRated(cuisine);
		 */

		String[] foods = { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" };
		String[] cuisines = { "korean", "japanese", "japanese", "greek", "japanese", "korean" };
		int[] ratings = { 9, 12, 8, 15, 14, 7 };
		lc_2353 obj = new lc_2353();
		obj.FoodRatings(foods, cuisines, ratings);
		String param_2 = obj.highestRated("korean");
		String param_3 = obj.highestRated("japanese");
		obj.changeRating("sushi", 16);
		String param_4 = obj.highestRated("japanese");
		obj.changeRating("ramen", 16);
		String param_5 = obj.highestRated("japanese");
		System.out.println("param_2 " + param_2);
		System.out.println("param_3 " + param_3);
		System.out.println("param_4 " + param_4);
		System.out.println("param_5 " + param_5);

	}
	
	private HashMap<String, Integer> foodToRatingMap;
	private HashMap<String, String> foodToCuisineMap;
	private HashMap<String, TreeSet<String>> cuisineToFoodsMap;

	
	

	public void FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRatingMap = new HashMap<>();
        foodToCuisineMap = new HashMap<>();
        cuisineToFoodsMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToRatingMap.put(foods[i], ratings[i]);
            foodToCuisineMap.put(foods[i], cuisines[i]);

            cuisineToFoodsMap.putIfAbsent(cuisines[i],
                new TreeSet<>((a, b) -> {
                    int ra = foodToRatingMap.get(a);
                    int rb = foodToRatingMap.get(b);
                    if (ra != rb) return rb - ra;  //ensures highest rating first
                    return a.compareTo(b); //ensures lexicographically smaller food first
                })
            );

            cuisineToFoodsMap.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisineMap.get(food);
        TreeSet<String> foodsSet = cuisineToFoodsMap.get(cuisine);

        foodsSet.remove(food);

        foodToRatingMap.put(food, newRating);

        foodsSet.add(food);
    }

	public String highestRated(String cuisine) {
		return cuisineToFoodsMap.get(cuisine).first();
	}
	
	//using priority queue

	static class Food {
		String name;
		String cuisine;
		int rating;

		Food(String name, String cuisine, int rating) {
			this.name = name;
			this.cuisine = cuisine;
			this.rating = rating;
		}
	}

	Map<String, Food> foodToFoodMap;
	Map<String, PriorityQueue<Food>> cuisineToPriorityQueueFoodMap;

	public void FoodRatings_priorityQueue(String[] foods, String[] cuisines, int[] ratings) {
		foodToFoodMap = new HashMap<>();
		cuisineToPriorityQueueFoodMap = new HashMap<>();

		for (int i = 0; i < foods.length; i++) {
			Food food = new Food(foods[i], cuisines[i], ratings[i]);
			foodToFoodMap.put(foods[i], food);

			cuisineToPriorityQueueFoodMap.computeIfAbsent(cuisines[i], c -> new PriorityQueue<>((a, b) -> {
				int ra = foodToRatingMap.get(a.name);
				int rb = foodToRatingMap.get(b.name);
				if (ra != rb)
					return rb - ra; //ensures highest rating first
				return a.name.compareTo(b.name); //ensures lexicographically smaller food first
			})).add(food);
		}

	}
	public String highestRated_priorityQueue(String cuisine) {
		return cuisineToPriorityQueueFoodMap.get(cuisine).peek().name;
	}

	public void changeRating_priorityQueue(String food, int newRating) {
		Food foodObj = foodToFoodMap.get(food);
		Food updatedFood = new Food(food, foodObj.cuisine, newRating);


		foodToFoodMap.put(food, updatedFood);

		cuisineToPriorityQueueFoodMap.get(foodObj.cuisine).remove(foodObj);
		cuisineToPriorityQueueFoodMap.get(foodObj.cuisine).add(updatedFood);


	}
}
