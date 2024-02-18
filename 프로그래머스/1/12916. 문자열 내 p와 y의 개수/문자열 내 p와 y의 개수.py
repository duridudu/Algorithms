def solution(s):
    p = s.count('p')
    p += s.count('P')
    
    y = s.count('y')
    y += s.count('Y')
    
    if p == y :
        return True
    else :
        return False
    
    return True