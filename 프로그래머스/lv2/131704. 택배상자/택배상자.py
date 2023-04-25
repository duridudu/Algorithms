from collections import deque
def solution(order):
    answer = 0
    ## 기존 컨베이어 벨트 
    main=deque(list(range(1, len(order)+1)))
    ## 보조 컨베이어 벨트
    bojo=deque([])
    i=0
    ## 메인 컨베이어 확인 
    for m in main:
        # print("메인상자는 {}, 기사님 위시는 {} ".format(m, order[i]))
        ## 일치하지 않으면 보조 컨베이어에 넣어줘야함
        if m != order[i]:
            # print("너는 일치하지 않으니까 보조컨테이너로 가라")
            bojo.append(m)
            
        ## 일치하면 바로 트럭에 넣어야함
        else:
            # print("너는 일치하니까 바로 트럭에 넣어주겠다")
            answer+=1
            i+=1
            
        ## 보조 컨테이너가 비어있지 않고, 지금 순서의 상자가 보조 컨테이너 맨 위랑 같으면
        while(len(bojo)!=0 and order[i]==bojo[-1]):
            # print("기사님 위시가 보조 컨테이너 맨 끝 것과 일치한다.")
            ## 보조 컨테이너에서 빼고 다음 메인상자로 넘어가고 트럭에 하나 추가해준다
            bojo.pop()
            i+=1
            answer+=1
        
        
        # print(main)
        # print(bojo)
            
    return answer