class Solution {
    public String[] reorderLogFiles(String[] logs) {

        Queue<Log> logPriorityQueue = new PriorityQueue<>(new LogComparator());
        Queue<Log> digitLogList = new LinkedBlockingQueue<>();

        for (String s : logs) {
            Log log = new Log(s);
            if (log.logType == LogType.DIGIT) {
                digitLogList.add(log);
                continue;
            }
            logPriorityQueue.add(log);
        }

        String[] sortedLogs = new String[logs.length];

        for (int i = 0; i < sortedLogs.length; i++) {
            if (!logPriorityQueue.isEmpty()) {
                sortedLogs[i] = logPriorityQueue.poll().toRawLog();
                continue;
            }
            sortedLogs[i] = digitLogList.poll().toRawLog();
        }

        return sortedLogs;
    }
}

enum LogType {
    DIGIT,
    LETTER
}

class LogTypeParser {
    static LogType parse(String firstLog) {
        int firstChar = (int) firstLog.charAt(0);
        if (97 <= firstChar && firstChar <= 122) return LogType.LETTER;
        return LogType.DIGIT;
    }
}

class LogComparator implements Comparator<Log> {

    @Override
    public int compare(Log o1, Log o2) {
        boolean sameLogContent = o1.logContent.equals(o2.logContent);
        if (!sameLogContent) {
            return o1.logContent.compareTo(o2.logContent);
        }
        return o1.logId.compareTo(o2.logId);
    }
}

class Log {
    LogType logType;
    String logId;
    String logContent;
    Log(String rawLog) {
        StringBuilder id = new StringBuilder();
        StringBuilder logContent = new StringBuilder();
        boolean appendingId = true;

        for (int i = 0; i < rawLog.length(); i++) {
            char ch = rawLog.charAt(i);
            if (appendingId && ch == ' ') {
                appendingId = false;
                continue;
            }
            if (appendingId) id.append(ch);
            else logContent.append(ch);
        }
        this.logId = id.toString();
        this.logType = LogTypeParser.parse(logContent.toString());
        this.logContent = logContent.toString();
    }

    public String toRawLog() {
        return logId + " " + logContent;
    }

    @Override
    public String toString() {
        return logType + ": " + logId + " " + logContent;
    }
}
