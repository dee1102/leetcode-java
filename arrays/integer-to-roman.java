class Solution {
    public String intToRoman(int num) {

        HashMap<Integer, Character> mapper = new HashMap<>();
        mapper.put(1000, 'M');
        mapper.put(500, 'D');
        mapper.put(100, 'C');
        mapper.put(50, 'L');
        mapper.put(10, 'X');
        mapper.put(5, 'V');
        mapper.put(1, 'I');

        int i = 1000;
        int val = 0;
        StringBuilder romanNumber = new StringBuilder();
        while (i > 0) {
            val = num / i; // 3994 / 1000 = 3; 994 / 100 = 9; 94 / 10 = 9; 4 / 1 = 4
            if (val == 9) {
                romanNumber.append(mapper.get(1 * i));
                romanNumber.append(mapper.get(10 * i));
            } else if (val == 5) {
                romanNumber.append(mapper.get(5 * i));
            } else if (val == 4) {
                romanNumber.append(mapper.get(1 * i));
                romanNumber.append(mapper.get(5 * i));
            } else {
                int j = val;
                if (val > 5) {
                    romanNumber.append(mapper.get(5 * i));
                    j = val - 5;
                }
                for (; j > 0; j--) {
                    romanNumber.append(mapper.get(1 * i));
                }
            }
            num = num - val * i;
            // 3994 - 3 * 1000 = 994; 994 - 9 * 100 = 94; 94 - 9 * 10 = 4
            // 3749 - 3 * 1000 = 749; 749 - 7 * 100 = 49;
            i = i / 10;
            // 1000 / 10 = 100; 100 / 10 = 10 ; 10 / 10 = 1
        }
        return romanNumber.toString();
    }
}