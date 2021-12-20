var customSortString = function(order, s) {
    const sMap = {};
    const orderMap = {};
    for (let i = 0; i < order.length; i++) {
        orderMap[order[i]] = true;
    }
    let postChars = "";
    for (let i = 0; i < s.length; i++) {
        if (orderMap[s[i]] == null) {
            postChars += s[i];
            continue;
        }
        if (sMap[s[i]] == null) {
            sMap[s[i]] = 1;
            continue;
        }
        sMap[s[i]] = sMap[s[i]] + 1;
    }
    let permutation = "";
    for (let i = 0; i < order.length; i++) {
        const ch = order[i];
        if (sMap[ch] == null) continue;
        const quantity = sMap[ch];
        const toAppend = ch.repeat(quantity);
        permutation += toAppend
    }
    return permutation + postChars;
};
