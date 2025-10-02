// Okay-ish complexities - -people did it in a better way
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> sourceMap = new HashMap<Character, Integer>();
        for (char a: magazine.toCharArray()) {
            if (sourceMap.get(a) != null) {
                sourceMap.put(a, sourceMap.get(a)+1);
            } else {
                sourceMap.put(a, 1);
            }
        }
        for (char a: ransomNote.toCharArray()) {
            if (sourceMap.get(a) != null){
                if (sourceMap.get(a) > 0) {
                    sourceMap.put(a, sourceMap.get(a) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
