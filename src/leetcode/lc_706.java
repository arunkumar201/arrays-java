package leetcode;

import java.util.Arrays;

public class lc_706 {

    int[] map;

    public void MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        if (map[key] == -1) {
            return -1;
        }
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}
