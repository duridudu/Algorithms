from collections import Counter
def solution(want, number, discount):
    answer = 0
    temp=dict()
    for w,n in zip(want, number):
        temp[w]=n
        
    for i in range(len(discount)-9):
        mart = Counter(discount[i:i+10])
        if mart==temp:
            answer+=1
        # print(discount[i:i+10])
        # print(mart)
        #test=0
        #for m in mart:
            # print("=============",m)
            # print(m)
            #if (m not in want) or (mart[m]!=temp[m]):
               # test=1
               # break
            # test=0
            
        #if test==0:
            # print("프프ㅡ프ㅡㅡ리릴리ㅣㅣㅣ더더더더ㅓㅓ덤",i)
           # answer+=1
        
            
    return answer