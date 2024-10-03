def solution(enroll, referral, seller, amount):
    answer = [0]*len(enroll)
     # enroll의 이름과 인덱스를 매핑
    index_map = {name: i for i, name in enumerate(enroll)}
    
    for s,aa in zip(seller,amount):
        now = s
        a = aa*100
        while(now!="-"):
            index_e = index_map[now] 
                
            if referral[index_e] == "-":
                if a//10 > 0:
                    answer[index_e] += (a-a//10)
                else:
                    answer[index_e] += a
                break
            
            e = enroll[index_e]
            r = referral[index_e]
            
            ## 추천인의 인덱스 
            index_r = index_map[referral[index_e]]
            
            total_a = a
            referrals_a = total_a//10
            nows_a = total_a - referrals_a
            #print(e,r,total_a, nows_a, referrals_a)
            ## answer 갱신
            answer[index_e] += nows_a
            #answer[index_r] += referrals_a
            
            now = r
            a = int(referrals_a)
            if a < 1 :
                break
            
    return answer