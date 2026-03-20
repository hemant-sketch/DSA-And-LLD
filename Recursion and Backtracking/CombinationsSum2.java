class Solution {
    public void getCombination(int[] candidates, int target, int start, List<List<Integer>> combinations, List<Integer> combination) {
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int idx = start; idx < candidates.length; idx++) {

            if (idx > start && candidates[idx] == candidates[idx - 1]) continue;

            if (candidates[idx] > target) break;

            combination.add(candidates[idx]);
            getCombination(candidates, target - candidates[idx], idx + 1, combinations, combination);
            combination.remove(combination.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        getCombination(candidates, target, 0, combinations, combination);
        return combinations;
    }
}
