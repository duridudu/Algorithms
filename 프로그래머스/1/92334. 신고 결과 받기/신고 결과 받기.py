def solution(id_list, report, k):
    answer = [0]*len(id_list) 
    users = {}
    check = {}
    
    ## 유저 목록 저장 
    for i in id_list :
        users[i] = [set(),0]
        check[i] = set()
    ## 신고 목록 저장 및 신고 당한 횟수 갱신    
    for r in report : 
        reports = r.split(" ")
        singo = reports[0]
        singoed = reports[1]
        users[singo][0].add(singoed)
        
        if singoed not in list(check[singo]):
            #print(singo, singoed)
            check[singo].add(singoed)
            users[singoed][1]+=1

    ## 이메일 보낼 횟수 인덱스 초기화
    i = 0
    ## 정지 횟수 k 이상인 애들에게 이메일 발송
    for u in users: 
        for uu in users[u][0]:
            if users[uu][1] >= k :
                answer[i]+=1
        i+=1
        
    return answer