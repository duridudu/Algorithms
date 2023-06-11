from collections import Counter, defaultdict
def solution(gems):
    answer=[]
    kind=len(set(gems))
    check={gems[0]:1}
    
    length=len(gems)+1
    left=0
    right=0
    
    while(True):
        # print(check,left, right, right-left+1)
        ## 모든 보석 다 산거면 비교 및 갱신 후 넘어가기
        ## right가 끝까지 간 상태라면 체크 딕셔너리에 왠만한 보석은 다 들어가 있을것
        ## 이 때 중요한 것이 left~right 구간의 길이!
        if len(check)==kind :
            if right-left+1<length:
                length=right-left+1
                answer=[left+1, right+1]
            ## check 사전 수정!!! 
            ## 이제 left를 왼쪽으로 하나 옮길건데, 그러면 인덱스=left인 원소가 하나 줄면 된다
            ## 누적합에서 구간합 구할 때 sums[5]-sums[3]하는거랑 같은 원리
            ## 맨 앞 한개만 빼주면 나머지는 세어져있는 것 활용할 수 있음
            if check[gems[left]]==1:
                del check[gems[left]]
            else:
                check[gems[left]]-=1
            left+=1
            
        ## 아직 보석 다 못 삼
        else:
            ## 그러면 오른쪽으로 한 칸 더 이동
            right+=1
            if right>=len(gems):
                break
            ## 체크 딕셔너리에 보석 추가해줌
            check[gems[right]]=check.get(gems[right],0)+1
            
            
        if left>right :
            break
            # or left>=len(gems) or right>=len(gems)
# 시도 2          
#        while(True):
#             check[gems[right]]+=1
#             # print(left, right, check, length)
#             if 0 not in check.values() and right-left+1<length:
#                 length=right-left+1
#                 answer=[left+1, right+1]
#                 break
#             right+=1
            
#             if left>right:
#                 break
#             elif right>=len(gems):
#                 break

        
        
# 시도2 - 투포인터 썼지만 슬라이싱으로 구간 확인해서 시간초과
#     while(True):
#         temp=len(set(gems[left:right+1]))
#         if temp == cnt and right-left+1<length:
#             length=right-left+1
#             answer=[left+1, right+1]
#             left+=1
#         else:
#             right+=1
            
#         if left>right or left>=len(gems) or right>=len(gems):
#             break
    # print(answer)
# 시도1    
#     answer = []
#     cnts=dict(Counter(gems))
#     cnt=len(cnts)
#     # memo=[0]*len(gems)
#     idx=0
#     m=100000
    
#     st=0
#     fn=0
#     t=100000
#     for i in range(len(gems)-cnt):
#         temp=0
#         temps=[]
#         # if flag==True:
#         #     break
#         for j in range(i,len(gems)):
#             if gems[j] not in temps:
#                 temps.append(gems[j])
#                 if j==len(gems)-1:
#                     # print("하하하")
#                     if len(temps)==cnt:
#                         if j-i<t:
#                             st=i
#                             fn=j+1
#                             t=fn-st
#             elif len(temps)==cnt:
#                 # print("보석 종류와 개수 같아질 때의 i와 j는 ",i,", ",j)
#                 if j-i<t:
#                     st=i
#                     fn=j
#                     t=fn-st
            
#                 # flag=True
#                 break
#             temp+=1
            
#             # elif j==len(gems) and len(temps)<cnt:
#         # memo[i]=temp
#         # print("i가 {}일 때 temp는 {}".format(i, temp))
# #         if m>temp:
# #             m=temp
# #             idx=i
            
#     # print(memo)
#     # print(idx+1,m)
#     # print(st+1,fn+1)
#     answer.append(st+1)
#     answer.append(fn)
    
    return answer