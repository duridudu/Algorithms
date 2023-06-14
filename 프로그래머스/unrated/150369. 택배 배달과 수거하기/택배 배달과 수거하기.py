from collections import Counter
# Counter 안써도 됨, .. 
def solution(cap, n, deliveries, pickups):
    answer = 0
    
    ## 맨 뒷 집부터 시작 
    deli=n-1
    pick=n-1
    
    ## 배달 or 수거할게 모두 0이면 종료
    # while (a!=n or b!=n):
    
    ## 0이 없을 때까지 순환 
    while(deliveries[deli]!=0 or pickups[pick]!=0):
        length=[]
        
        ## 택배 수 세기 
        sums=0
        
        ## 배달하기
        ## 배달할게 남아있는 가장 먼 집부터 왼쪽으로 이동해가며 배달
        for i in range(deli,-1,-1):
            ## i번째 집 배달할거랑 현재 개수 더한게 cap보다 작거나 같으면 고
            if cap>=sums+deliveries[i]:
                ## 개수 합에 더해줌
                sums+=deliveries[i]
                ## 택배 완.이니까 i번째 집의 택배수는 0으로 바꿔줌
                deliveries[i]=0
                ## 배달 클리어한 인덱스 하나 왼쪽으로 보냄
                deli-=1
                ## 길이 계산
                length.append(i)
            else:
                ## 배달할거+현재합이 cap보다 크면 deliveries는 cap에서 현재합 뺀것만큼 빼줌
                deliveries[i]-=(cap-sums)
                ## 다 끝났다! 브레이크
                sums=cap
                ## 길이 계산
                length.append(i)
                break
                
        ## sums 초기화해서 수거 로직 한번 더
        sums=0
        ## 수거하기
        for i in range(pick, -1, -1):
            if cap>=sums+pickups[i]:
                sums+=pickups[i]
                pickups[i]=0
                pick=i-1
                length.append(i)
            else:
                pickups[i]-=(cap-sums)
                sums=cap
                length.append(i)
                break
                    
        ## 가장 긴 길이가 이번 턴의 길이
        if length:
            answer+=(max(length)+1)*2
    return answer