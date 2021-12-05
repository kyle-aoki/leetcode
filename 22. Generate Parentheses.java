class Solution {
    Set<Input> seen;

    public List<String> generateParenthesis(int n) {
        seen = new HashSet<>();
        String variable = "()".repeat(Math.max(0, n));
        String fixed = "";
        return new ArrayList<>(permute(new Input(fixed, variable)));
    }
    
    public boolean valid(String parenString) {
        int balance = 0;
        for (int i = 0; i < parenString.length(); i++) {
            if (balance <= -1) return false;
            if (parenString.charAt(i) == '(') {
                balance += 1;
                continue;
            }
            balance -= 1;
        }
        return true;
    }
    
    public Set<String> permute(Input input) {
        if (seen.contains(input)) return new HashSet<>();
        if (input.variable.length() > 0) {
            Set<String> perms = new HashSet<>();
            for (int i = 0; i < input.variable.length(); i++) {
                String newFixed = input.fixed + input.variable.charAt(i);
                if (!valid(newFixed)) {
                    return new HashSet<>();
                }
                String newVariable = input.variable.substring(0, i) + input.variable.substring(i + 1);
                Set<String> newPerms = permute(new Input(newFixed, newVariable));
                perms.addAll(newPerms);
                seen.add(input);
            }
            return perms;
        } else {
            Set<String> fixedList = new HashSet<>();
            fixedList.add(input.fixed);
            return fixedList;
        }
    }
}

class Input {
    String fixed;
    String variable;

    public Input(String fixed, String variable) {
        this.fixed = fixed;
        this.variable = variable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Input input = (Input) o;
        return Objects.equals(fixed, input.fixed) && Objects.equals(variable, input.variable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fixed, variable);
    }
}
