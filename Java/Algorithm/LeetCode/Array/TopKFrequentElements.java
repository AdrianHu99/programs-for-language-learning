import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,3,3};
        int k = 2;
        int[] ans = new int[k];
        List<Integer> nas = topKFrequent(nums, k);
        for (int i = 0; i < k; i++) {
            ans[i] = nas.get(i);
        }

    }

    // Use hashmap and array of list
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] frequencyList = new List[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (frequencyList[frequency] == null) {
                frequencyList[frequency] = new ArrayList<>();
            }
            frequencyList[frequency].add(key);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = nums.length; i>=0 && k>1; i--) {
            if (frequencyList[i] != null) {
                ans.addAll(frequencyList[i]);
                k = k - frequencyList[i].size();
            }

        }

        return ans;
    }

    // Use treemap, because it can sort keys automatically
    public static List<Integer> topKFrequentByTreeMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if(treeMap.get(freq) == null) {
                treeMap.put(freq, new ArrayList<>());
            }
            treeMap.get(freq).add(key);
        }
        map = null;

        List<Integer> ans = new ArrayList<>();

        while (ans.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
            ans.addAll(entry.getValue());
        }
        treeMap = null;

        return ans;
    }
}
