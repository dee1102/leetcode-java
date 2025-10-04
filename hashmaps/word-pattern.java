// BIJECTIONAL
// O(n) O(n)

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] splitS = s.split(" ");
        char[] splitPattern = pattern.toCharArray();

        if (splitS.length != splitPattern.length) {
            return false;
        }

        int i = 0, j = 0;
        HashMap<Character, String> tracker = new HashMap<>();

        while (j < splitS.length) {
            if (tracker.get(splitPattern[i]) == null) {
                if (tracker.containsValue(splitS[j])) {
                    return false;
                } else {
                    tracker.put(splitPattern[i], splitS[j]);
                }
            } else {
                if (!tracker.get(splitPattern[i]).equals(splitS[j])) {
                    return false;
                }
            }
            j++;
            i++;
        }
        return true;
    }
}
/* NON-BIJECTIONAL
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> tracker = new HashMap<>();
        String[] splitS = s.split(" ");
        char[] splitPattern = pattern.toCharArray();
        int i = 0, j = 0;

        while (j < splitS.length) {
            System.out.println("----");
            // System.out.println(splitPattern[i]);
            // System.out.println(splitS[i]);
            System.out.println(tracker);
            // System.out.println(tracker.get(splitPattern[i]));
            System.out.println(splitS[j]);
            System.out.println(tracker.containsValue(splitS[j]));

            if (i < splitPattern.length && tracker.get(splitPattern[i]) == null) {
                if (tracker.containsValue(splitS[j])) {
                    return false;
                } else {
                    tracker.put(splitPattern[i], splitS[j]);
                }
            } else {
                // System.out.println((tracker.get(splitPattern[i]).equals(splitS[j])));
                // System.out.println(tracker.get(splitPattern[i]) + " " +  splitS[j]);
                if ((i < splitPattern.length && !tracker.get(splitPattern[i]).equals(splitS[j])) || (i == splitPattern.length-1 && !tracker.containsValue(splitS[j]))) {
                    return false;
                }
            }
            j++;
            if (i < splitPattern.length) {
                i++;
            }
        }
        return true;
    }
}
 */