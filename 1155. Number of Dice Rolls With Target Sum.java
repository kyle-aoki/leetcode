class Solution {
    static class DiceTarget {
        int d;
        int target;
        
        DiceTarget(int d, int target) {
            this.d = d;
            this.target = target;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DiceTarget diceTarget = (DiceTarget) o;

            if (d != diceTarget.d) return false;
            return target == diceTarget.target;
        }

        @Override
        public int hashCode() {
            int result = d;
            result = 31 * result + target;
            return result;
        }
    }
    
    int faces;
    HashMap<DiceTarget, Long> memo;
    final int MOD = 1000000007;

    public int numRollsToTarget(int d, int f, int target) {
        memo = new HashMap<>();
        faces = f;

        return (int) (search(new DiceTarget(d, target)) % MOD);
    }
    Long search(DiceTarget diceTarget) {
        if (diceTarget.target < 0) return 0L;
        if (diceTarget.d == 0) return diceTarget.target == 0 ? 1L : 0L;
        if (memo.containsKey(diceTarget)) return memo.get(diceTarget);

        long numWays = 0L;
        for (int face = 1; face <= faces; face++) {
            DiceTarget newDiceTarget = new DiceTarget(diceTarget.d - 1, diceTarget.target - face);
            long result = search(newDiceTarget) % MOD;
            memo.put(newDiceTarget, result);
            numWays += result;
        }
        return numWays;
    }
}
