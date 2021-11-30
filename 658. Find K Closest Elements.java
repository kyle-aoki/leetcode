class Diff implements Comparable<Diff> {
    Integer n;
    Integer diff;

    public Diff(Integer n, Integer x) {
        this.n = n;
        this.diff = Math.abs(n - x);
    }

    @Override
    public int compareTo(Diff d) {
        if (Objects.equals(diff, d.diff)) {
            return this.n.compareTo(d.n);
        }
        return this.diff.compareTo(d.diff);
    }

    @Override
    public String toString() {
        return "n=" + n + " diff=" + diff;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Diff> diffs = new PriorityQueue<>();

        for (int i : arr) diffs.add(new Diff(i, x));

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Diff nextDiff = diffs.poll();
            if (nextDiff == null) break;
            ans.add(nextDiff.n);
        }
        
        Collections.sort(ans);
        return ans;
    }
}
