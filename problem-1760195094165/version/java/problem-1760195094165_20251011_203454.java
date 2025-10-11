// Last updated: 11/10/2025, 20:34:54
class ExamTracker {
    private TreeMap<Integer, Integer> scores;
    private TreeMap<Integer, Long> prefixSum;
    public ExamTracker() {
         scores = new TreeMap<>();
        prefixSum = new TreeMap<>();
    }
    
    public void record(int time, int score) {
         scores.put(time, score);

        // Get prefix sum up to the previous time
        Map.Entry<Integer, Long> prev = prefixSum.floorEntry(time - 1);
        long prevSum = (prev == null) ? 0 : prev.getValue();

        // Current prefix sum
        prefixSum.put(time, prevSum + score);
    }
    
    public long totalScore(int startTime, int endTime) {
         Map.Entry<Integer, Long> endEntry = prefixSum.floorEntry(endTime);
        if (endEntry == null) return 0;

        long endSum = endEntry.getValue();

        // Get prefix sum just before startTime
        Map.Entry<Integer, Long> startEntry = prefixSum.lowerEntry(startTime);
        long startSum = (startEntry == null) ? 0 : startEntry.getValue();

        return endSum - startSum;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */