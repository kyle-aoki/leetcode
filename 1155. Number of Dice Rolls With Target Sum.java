class Solution {
    static class DTarget {
        int d;
        int target;
        DTarget(int d, int target) {
            this.d = d;
            this.target = target;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DTarget dTarget = (DTarget) o;

            if (d != dTarget.d) return false;
            return target == dTarget.target;
        }

        @Override
        public int hashCode() {
            int result = d;
            result = 31 * result + target;
            return result;
        }
    }
    int faces;
    HashMap<DTarget, Long> memo;
    final int MOD = 1000000007;

    public int numRollsToTarget(int d, int f, int target) {
        memo = new HashMap<>();
        faces = f;

        return (int) (search(new DTarget(d, target)) % MOD);
    }
    Long search(DTarget dTarget) {
        if (dTarget.target < 0) return 0L;
        if (dTarget.d == 0) return dTarget.target == 0 ? 1L : 0L;
        if (memo.containsKey(dTarget)) return memo.get(dTarget);

        long numWays = 0L;
        for (int face = 1; face <= faces; face++) {
            DTarget newDTarget = new DTarget(dTarget.d - 1, dTarget.target - face);
            long result = search(newDTarget) % MOD;
            memo.put(newDTarget, result);
            numWays += result;

        }
        return numWays;
    }
}
