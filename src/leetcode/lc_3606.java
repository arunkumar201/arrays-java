package leetcode;

import java.util.*;

public class lc_3606 {

	public static void main(String[] args) {
		// Input: code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine =
		// ["restaurant","grocery","pharmacy","restaurant"], isActive =
		// [true,true,true,true]

		String[] code = { "SAVE20", "", "PHARMA5", "SAVE@20" };
		String[] businessLine = { "restaurant", "grocery", "pharmacy", "restaurant" };
		boolean[] isActive = { true, true, true, true };
		lc_3606 solutionLc_3606 = new lc_3606();
		System.out.println(solutionLc_3606.validateCoupons(code, businessLine, isActive));
	}

	static boolean isValidCouponString(String couponCode) {

		if (couponCode.length() == 0) {
			return false;
		}
		for (int i = 0; i < couponCode.length(); i++) {
			char ch = couponCode.charAt(i);

			// only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (_).
			if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9') && ch != '_') {
				return false;
			}
		}
		return true;

	}

	static class MyCoupon {
		String code;
		String businessLine;
		boolean isActive;
		int index;
		
	public MyCoupon(String c, String b, boolean isActive, int index) {
            code = c;
            businessLine = b;
			this.isActive = isActive;
			this.index=index;
        }
		
	}

	public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
		int n=code.length;
		
		Map<String, Integer> businessOrder = new HashMap<>();
		businessOrder.put("electronics", 0);
		businessOrder.put("grocery", 1);
		businessOrder.put("pharmacy", 2);
		businessOrder.put("restaurant", 3);
		
		
		List<MyCoupon> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (isValidCouponString(code[i]) && isActive[i] && (businessOrder.containsKey(businessLine[i]))) {
				list.add(new MyCoupon(code[i], businessLine[i], isActive[i], i));
			}
		}
		// sorted first by their businessLine in the order: "electronics", "grocery",
		// "pharmacy", "restaurant", and then by code in lexicographical (ascending)
		// order within each category
		list.sort((a, b) -> {
			int cmp = Integer.compare(
					businessOrder.get(a.businessLine),
					businessOrder.get(b.businessLine));
			if (cmp != 0) {
				return cmp;
			}
			return a.code.compareTo(b.code);
		});

		List<String> result = new ArrayList<>();
		for (MyCoupon coupon : list) {
			result.add(coupon.code);
		}
		return result;
	}
}
