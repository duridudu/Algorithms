def solution(routes):
    ## answer는 1로 시작
    answer = 1
    ## 젤 이른 지점부터 정렬을 해보쟈
    ## 진입 지점이 같다면 진출 지점으로 정렬
    routes.sort(key=lambda x:(x[0],x[1]))
    
    ## i번째 진출 지점이 i+1번째 진입 지점보다 작거나 같으면 routes[i][1]이 커버 가눙.
    temp=routes[0][1]
    for i in range(1,len(routes)):
        ## temp가 진입 지점보다 크거나 같으면 
        ## i번째 고속도로는 아직 answer번째 단속 카메라로 커버 가능한 것
        if temp>=routes[i][0]:
            ## i번째 고속도로 진입 지점 확인해서 temp보다 작으면 
            ## i번째 고속도로의 진출 지점으로temp 변경
            temp=min(temp, routes[i][1])
        else:
            ## temp가 교체될 때 단속카메라 하나 추가되는 것
            temp=routes[i][1]
            answer+=1
    return answer