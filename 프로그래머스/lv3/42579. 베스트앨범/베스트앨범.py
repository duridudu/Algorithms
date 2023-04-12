def solution(genres, plays):
    answer = []
    songs=dict()
    check=dict()
    for i in range(len(genres)):
        ## 이미 저장되어있는 장르면 재생횟수 추가
        if genres[i] in songs:
            songs[genres[i]].append(((i,(int(plays[i])))))
            check[genres[i]]+=int(plays[i])
        else:
            songs[genres[i]]=[(i,int(plays[i]))]
            check[genres[i]]=int(plays[i])
            
    for s in songs:
        songs[s]=sorted(songs[s], key=lambda x : (-x[1],x[0]))
        
    check=dict(sorted(check.items(), key=lambda x:x[1],reverse=True))
    # sorted(check, reverse=False)
    # print(check)
    # print(songs)
    for c in check:
        # print(songs[c][:2])
        # answer.append(sum(songs[c][:2]))
        if (len(songs[c])>=2):
            for j in range(2):
                # print(songs[c][j])
                answer.append(songs[c][j][0])
        else:
             answer.append(songs[c][0][0])   
    # for g in genres:
        
    return answer