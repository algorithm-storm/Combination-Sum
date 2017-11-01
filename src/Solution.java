import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */

    static public void main(String [] args){

        Solution s = new Solution();
        int target = 7;
        int [] candidates = {2,3,6,7};
        System.out.println(s.combinationSum(candidates,target));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if(candidates == null || candidates.length == 0){
            return result;
        }

        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0, combination,result);
        return result;

    }

    public void helper(int[] candidates,
                       int remaining,
                       int startIndex,
                       List<Integer> combination,
                       List<List<Integer>> result){

        if(remaining == 0 ){
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i = startIndex ; i < candidates.length; i++){

            if(remaining < 0 ){
                break;
            }
            if(i != 0 && candidates[i-1] == candidates[i]){
                continue;
            }
            combination.add(candidates[i]);
            helper(candidates,remaining - candidates[i], i , combination ,result);
            combination.remove(combination.size() - 1);
        }
    }
}