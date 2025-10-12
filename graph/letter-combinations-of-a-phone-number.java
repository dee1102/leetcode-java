// Mine
// class Solution {
//    public List<String> letterCombinations(String digits) {
//
//        if (digits.length() == 0) {
//            return new ArrayList<String>();
//        }
//        HashMap<String, List<String>> map = new HashMap<>();
//        map.put("2", Arrays.asList("a", "b", "c"));
//        map.put("3", Arrays.asList("d", "e", "f"));
//        map.put("4", Arrays.asList("g", "h", "i"));
//        map.put("5", Arrays.asList("j", "k", "l"));
//        map.put("6", Arrays.asList("m", "n", "o"));
//        map.put("7", Arrays.asList("p", "q", "r", "s"));
//        map.put("8", Arrays.asList("t", "u", "v"));
//        map.put("9", Arrays.asList("w", "x", "y", "z"));
//
//
//        List<StringBuilder> combinations = subProblem(digits, map);
//
//        return combinations.stream().map(StringBuilder::toString).collect(Collectors.toList());
//    }
//
//    public List<StringBuilder> subProblem(String digits, HashMap<String, List<String>> map) {
//        System.out.println(map);
//        if (digits.length() == 1) {
//            return map.get(digits).stream().map(val -> new StringBuilder(val)).collect(Collectors.toList());
//        }
//        List<StringBuilder> sub = this.subProblem(digits.substring(0, digits.length() - 1), map);
//        List<StringBuilder> subNew = new ArrayList<>();
//        for (String s: map.get(digits.substring(digits.length() - 1, digits.length()))) {
//            for (StringBuilder x: sub) {
//                subNew.add((new StringBuilder(x)).append(s));
//            }
//        }
//        return subNew;
//    }
//}

// chat gpt
class Solution {
    private static final Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        dfs(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void dfs(String digits, int index, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            path.append(c);                 // choose
            dfs(digits, index + 1, path, result); // explore
            path.deleteCharAt(path.length() - 1); // un-choose (backtrack)
        }
    }
}
