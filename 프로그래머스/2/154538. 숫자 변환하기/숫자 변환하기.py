def solution(x, y, n):    
    answer = 0    # DP 테이블 : 최소 횟수 저장    
    DP = [0 for _ in range(y + 1)]    
    for i in range(x + 1, y + 1):        
        # 초기값        
        a, b, c = 1e9, 1e9, 1e9        
        # 1. X3 확인        
        # 3의 배수가 아닌 경우 + x 범위 이전에 온 경우 불가        
        if i % 3 == 0 and i / 3 >= x:            
            a = DP[i//3]        
        # 2. X2 확인        
        # 2의 배수가 아닌 경우 + x 범위 이전에 온 경우 불가        
        if i % 2 == 0 and i / 2 >= x:           
            b = DP[i//2]        
        # 3. +N 확인        
        # x 범위 이전에 온 경우 불가        
        if i - n >= x:            
            c = DP[i - n]        
        
        # a, b, c 값이 모두 업데이트 되지 않음 : 접근 불가능        
        if a == b == c == 1e9:            
            DP[i] = 1e9        
        # a, b, c 값 중 최소 값을 결정할 수 있는 경우        
        else:               
            DP[i] = min(a, b, c) + 1    
    return DP[y] if DP[y] != 1e9 else -1