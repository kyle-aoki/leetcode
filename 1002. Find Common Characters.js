function commonChars(words) {
    let letters = getLetterMap(words[0]);
    for (let i = 1; i < words.length; i++) {
        let ls = getLetterMap(words[i]);
        for (const key in letters) {
           letters[key] = Math.min(letters[key], ls[key]);
        }
    }
    const sharedLetters = [];
    for (const key in letters) {
        if (letters[key] > 0) {
            const quantity = letters[key];
            sharedLetters.push(...key.repeat(quantity).split(''))
        }
    }
    return sharedLetters;
};


const alpha = "abcdefghijklmnopqrstuvwxyz";

function getLetterMap(word) {
    let letters = {};
    for (const letter of alpha) {
        letters[letter] = 0;
    }
    for (const letter of word) {
        letters[letter] = letters[letter] + 1;
    }
    return letters;
}
