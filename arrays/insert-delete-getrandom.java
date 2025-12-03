import java.util.Random;

class RandomizedSet {
    List<Integer> obj;

    public RandomizedSet() {
        this.obj = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (this.obj.contains(Integer.valueOf(val))) {
            return false;
        }
        this.obj.add(Integer.valueOf(val));
        return true;
    }

    public boolean remove(int val) {
        if (this.obj.contains(Integer.valueOf(val))) {
            this.obj.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(this.obj.size() - 0);
        return this.obj.get(randomNumber);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */