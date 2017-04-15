def kmp(string, pattern):
    s_len = len(string)
    p_len = len(pattern)
    pi = get_pi(pattern)
    matches = []
    j = 0
     
    for i in range(0, s_len):
        while j > 0 and string[i] != pattern[j]:
            j = pi[j-1]
         
        if string[i] == pattern[j]:
            if j == p_len - 1:
                matches.append(i - p_len + 1) # mistake!
                j = pi[j]
            else:
                j += 1

    return matches

def get_pi(pattern):
    p_len = len(pattern)
    pi = [0] * p_len
    j = 0
    
    for i in range(1, p_len):
        while j > 0 and pattern[i] != pattern[j]:
            j = pi[j-1]
        
        if pattern[i] == pattern[j]:
            # This is what I did wrong
            j += 1 
            pi[i] = j
    
    return pi
