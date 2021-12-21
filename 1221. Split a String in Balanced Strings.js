function balancedStringSplit(s) {
    let left = 0;
    let right = 0;
    let output = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] === "L") left++;
        if (s[i] === "R") right++;
        if (left === right) {
            output++;
        }
    }
    return output;
};
