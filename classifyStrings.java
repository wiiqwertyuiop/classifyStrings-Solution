String solution(String s) {
    
    if (s.length() < 3) return "good";
    
    // Count
    int vowel = 0, consont = 0;
    // Potential vowel, potenial consonant
    int pv = 0, pc = 0;
    // Keep track of WHO is mixed
    boolean vmix = false, cmix = false;
    
    for (char cur_char : s.toCharArray()) {

        if (cur_char == '?') {
            // Potential =
            // (What we have + what could be)
            pv = vowel + pv+1;
            pc = consont + pc+1;
            // We do this because we dont want to effect what is happening NOW
            // but we do want to keep any momentum going we do have
            // Hence potential outcome
            vowel = 0; consont = 0;
        } else if (cur_char == 'a' ||
        cur_char == 'e' ||
        cur_char == 'i' ||
        cur_char == 'o' ||
        cur_char == 'u') {
            if (++vowel > 2) return "bad";
            consont = 0; pc = 0;
        } else {
            if (++consont > 4) return "bad";
            vowel = 0; pv = 0;
        }
        
        // Check if we have a potential mix
        if (vowel + pv > 2) vmix = true;
        if (consont + pc > 4) cmix = true;
        
        // If both are mixed, we may have a problem of test case:
        // aa?bbbb
        if ((vmix && cmix) && (pv == 1 || pc == 1)) {
            return "bad";
        }
    }    
    
    return (vmix || cmix) ? "mixed" : "good";
}