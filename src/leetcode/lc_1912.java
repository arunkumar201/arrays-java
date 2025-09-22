package leetcode;

import java.util.*;

public class lc_1912 {

	public static void main(String[] args) {

		/**
		 * Your MovieRentingSystem object will be instantiated and called as such:
		 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
		 * List<Integer> param_1 = obj.search(movie);
		 * obj.rent(shop,movie);
		 * obj.drop(shop,movie);
		 * List<List<Integer>> param_4 = obj.report();
		 */
		// ["MovieRentingSystem", "search", "rent", "rent", "report", "drop", "search"]
		// [[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]],
		// [1], [0, 1], [1, 2], [], [1, 2], [2]]
		int n = 3;
		int[][] entries = { { 0, 1, 5 }, { 0, 2, 6 }, { 0, 3, 7 }, { 1, 1, 4 }, { 1, 2, 7 }, { 2, 1, 5 } };
		MovieRentingSystem movieRentingSystem = new MovieRentingSystem(n, entries);

		List<Integer> param_1 = movieRentingSystem.search(1);
		System.err.println(param_1);
		movieRentingSystem.rent(0, 1);
		movieRentingSystem.rent(1, 2);
		List<List<Integer>> param_4 = movieRentingSystem.report();
		System.out.println(param_4);
		movieRentingSystem.drop(1, 2);
		List<Integer> param_5 = movieRentingSystem.search(2);
		System.out.println(param_5);
	}

}

class MovieRentingSystem extends lc_1912 {

	class Movie {
		int shop;
		int movie;
		int price;
		boolean isRented;

		public Movie(int shop, int movie, int price) {
			this.shop = shop;
			this.movie = movie;
			this.price = price;
			this.isRented = false;
		}
	}

	Comparator<Movie> movieRentingComparator = (a, b) -> {
		if (a.price != b.price)
			return a.price - b.price; // first we target the movie price
		if (a.shop != b.shop)
			return a.shop - b.shop; // movie price are same or tie - sort by shop
		return a.movie - b.movie; // else sort by movie
	};

	TreeSet<Movie> rentedMoviesList; // maintain the rented movies list
	Map<Integer, TreeSet<Movie>> movieMap; // keep track of movie -> shop mapping
	Map<String, Movie> shopMovieMap; // keep track of shop_movie -> movie mapping

	public MovieRentingSystem(int n, int[][] entries) {
		rentedMoviesList = new TreeSet<>(movieRentingComparator);
		movieMap = new HashMap<>();
		shopMovieMap = new HashMap<>();

		for (int[] entry : entries) {
			int shop = entry[0];
			int movie = entry[1];
			int price = entry[2];
			Movie movieObj = new Movie(shop, movie, price);
			String key = shop + "_" + movie;
			shopMovieMap.put(key, movieObj);
			movieMap.computeIfAbsent(movie, k -> new TreeSet<>(movieRentingComparator)).add(movieObj);
		}
	}

	public List<Integer> search(int movie) {
		TreeSet<Movie> movies = movieMap.get(movie);

		List<Integer> result = new ArrayList<>();
		if (movies == null || movies.isEmpty()) {
			return result;
		}

		int count = 0;
		for (Movie m : movies) {
			if (m.isRented) {
				continue;
			} else {
				result.add(m.shop);
				count++;
			}
			if (count == 5)
				break;
		}

		return result;
	}

	public void rent(int shop, int movie) {
		Movie movieObj = shopMovieMap.get(shop + "_" + movie);
		movieMap.get(movie).remove(movieObj); // remove from available list
		rentedMoviesList.add(movieObj); // add to rented list
		movieObj.isRented = true;
	}

	public void drop(int shop, int movie) {
		Movie movieObj = shopMovieMap.get(shop + "_" + movie);
		rentedMoviesList.remove(movieObj); // remove from rented list
		movieMap.get(movie).add(movieObj); // add to available list
		movieObj.isRented = false;
	}

	public List<List<Integer>> report() {
		List<List<Integer>> result = new ArrayList<>();
		int count = 0;
		for (Movie m : rentedMoviesList) {
			result.add(Arrays.asList(m.shop, m.movie));
			count++;
			if (count == 5)
				break;
		}
		return result;
	}
}
