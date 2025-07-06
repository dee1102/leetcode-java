class Solution {
    public boolean isValid(String s) {
        int i = 0;
        ArrayList<Character> stack = new ArrayList<>();

        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            } else {
                if (!stack.isEmpty() && ((s.charAt(i) == ')' && stack.getLast() == '(' ) || (s.charAt(i) == '}' && stack.getLast() == '{' ) || (s.charAt(i) == ']' && stack.getLast() == '[' ))) {
                    stack.remove(stack.size() - 1);
                } else {
                    stack.add(s.charAt(i));
                }
            }
            i++;
        }

        return stack.isEmpty();

    }
}