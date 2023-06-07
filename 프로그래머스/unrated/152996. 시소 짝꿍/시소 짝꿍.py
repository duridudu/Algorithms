def solution(weights):
    weight_dict = dict()
    answer = 0
    ## 개수를 저장해준다. 카운터로 하면 더 쉬울듯?
    for w in weights:
        ## 와 파이썬 dictionary get함수 처음 봄. 
        weight_dict[w] = weight_dict.get(w, 0) + 1
    

    for w in weights:
        ## 2로 나눴을때 정수 나오는 값만 해보기 위해
        if w % 2 == 0: 
            ## 균형 이루는 무게인 사람 있는지 확인
            answer += weight_dict.get(w * 3 // 2, 0)
        ## 3으로 나눴을 때 정수 나오는 값만 해보기 위해
        if w % 3 == 0: 
            ## 균형 이루는 무게인 사람 있는지 확인
            answer += weight_dict.get(w * 4 // 3, 0)
        ## 그냥 나보다 두 배인 사람 있는지 확인 
        answer += weight_dict.get(w * 2, 0)
        
    for w in weights:
        ## 나 자신은 빼주기
        weight_dict[w] -= 1
        ## 가능한 개수만 답에 저장
        answer += weight_dict[w]
    return answer