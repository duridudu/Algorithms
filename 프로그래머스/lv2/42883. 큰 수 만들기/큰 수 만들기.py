from itertools import permutations, combinations
def solution(number, k):
    # 1트 - 조합 쓰기
    # nums = list(map(int,number))
    # n=range(len(nums))
    # nCr=list(combinations(n,k))
    # now=0
    # temp=''
    # for c in nCr:
    #     for i in range(len(nums)):
    #         if i in list(c):
    #             continue
    #         temp+=str(nums[i])
    #     temp=int(temp)
    #     if temp>now:
    #         now=temp
    #     # print(int(now))
    #     temp=''
    
    # 2트 - 스택 쓰기
    stack=[]
    for n in number:
        while len(stack)!=0 and n>stack[-1] and k>0:
            stack.pop()
            k-=1
        stack.append(n)
        
    # k가 len(number)-1같은 경우
    # k가 남음
    if k > 0:
        stack = stack[:-k]

    # print()
    return ''.join(stack)