def solution(genres, plays):
    answer = []
    ## 노래별 재생횟수 각각 저장할 사전
    songs=dict()
    ## 장르별 재생 횟수 저장할 사전
    check=dict()
    for i in range(len(genres)):
        ## 이미 저장되어있는 장르면 
        if genres[i] in songs:
            ## 재생횟수 추가
            songs[genres[i]].append(((i,(int(plays[i])))))
            ## 재생횟수 누적
            check[genres[i]]+=int(plays[i])
        ## 저장 안되어있는 장르면 추가해줌
        else:
            songs[genres[i]]=[(i,int(plays[i]))]
            check[genres[i]]=int(plays[i])
            
    ## 장르별 노래들 내림차순 정렬해줌
    for s in songs:
        songs[s]=sorted(songs[s], key=lambda x : (-x[1],x[0]))
    ## 장르 전체 누적합 내림차순 정렬해줌
    check=dict(sorted(check.items(), key=lambda x:x[1],reverse=True))
    
    ## 재생횟수 많은 장르부터 상위 2곡 뽑아서 저장
    for c in check:
        ## 해당 장르 c에 곡이 2 개 이상일 때만 두 번 반복문 돌며 저장
        if (len(songs[c])>=2):
            for j in range(2):
                answer.append(songs[c][j][0])
        ## 장르에 속한 곡이 하나라면, 하나의 곡만 선택
        else:
             answer.append(songs[c][0][0])   
        
    return answer