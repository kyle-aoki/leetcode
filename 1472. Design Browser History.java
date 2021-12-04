class BrowserHistory {

    int index;
    int size;
    List<String> path;
    
    public BrowserHistory(String homepage) {
        index = 0;
        size = 0;
        path = new ArrayList<>();
        path.add(homepage);
    }
    
    public void visit(String url) {
        if (size == index) {
            index++;
            size++;
            path.add(url);
            return;
        }
        path = path.subList(0, index + 1);
        index++;
        size = path.size();
        path.add(url);
    }
    
    public String back(int steps) {
        int trueSteps = index - steps < 0 ? index : steps;
        index -= trueSteps;
        return path.get(index);
    }
    
    public String forward(int steps) {
        index = index + steps > size ? size : index + steps;
        return path.get(index);
    }
}
