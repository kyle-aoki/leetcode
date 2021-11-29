class Solution {
    
    public List<Integer> partitionLabels(String str) {
        List<Integer> partitionLengths = new ArrayList<>();
        Set<Character> seen = new HashSet<>();
        List<Range> ranges = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (seen.contains(str.charAt(i))) continue;
            int end = 0;
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    end = j;
                }
            }
            ranges.add(new Range(str.charAt(i), i, end));
            seen.add(str.charAt(i));
        }

        Range currentRange = ranges.get(0);
        for (Range range : ranges) {
            if (Range.isOverlapping(currentRange, range)) {
                if (range.end > currentRange.end) currentRange.setEnd(range.end);
                continue;
            }

            partitionLengths.add(currentRange.size);
            currentRange = range;
        }
        partitionLengths.add(currentRange.size);

        return partitionLengths;
    }
}

class Range {
    
    char ch;
    int start;
    int end;
    int size;
    
    Range(char ch, int start, int end) {
        this.ch = ch;
        this.start = start;
        this.end = end;
        updateSize();
    }

    private void updateSize() {
        this.size = this.end - this.start + 1;
    }
    
    void setEnd(int newEnd) {
        this.end = newEnd;
        updateSize();
    }

    static boolean isOverlapping(Range r1, Range r2) {
        return !(r1.end < r2.start || r2.end < r1.start);
    }

    @Override
    public String toString() {
        return ch + "(" + start + "-" + end + ")";
    }
}
