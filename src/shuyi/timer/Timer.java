package shuyi.timer;

import shuyi.product.ShuyiTealiciousTeas;

import java.util.ArrayList;

public class Timer {
    ShuyiTealiciousTeas parent;
    ArrayList<Integer> counts;

    public Timer(ShuyiTealiciousTeas teas) {
        parent = teas;
        counts = new ArrayList<>();
    }

    public void addToTimer(int count) {
        counts.add(count);
    }

    public int getBest() {
        int best = 0;
        for (Integer integer : counts) {
            if (integer > best) {
                best = integer;
            }
        }
        return best;
    }

    public float getAverage() {
        int all = 0;
        for (Integer integer : counts) {
            all += integer;
        }
        return all / counts.size();
    }

    public ArrayList<Integer> getCounts() {
        return counts;
    }

    public float getMedium() {
        ArrayList<Integer> sortedList = new ArrayList<>(counts);
        sortedList.sort(null);
        if (sortedList.size() % 2 == 0) {
            return (sortedList.get(sortedList.size()/2-1) + sortedList.get(sortedList.size()/2)) / 2;
        } else {
            return sortedList.get(sortedList.size()/2);
        }
    }
}
