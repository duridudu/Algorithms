N=int(input())
arr=list(map(int, input().split()))
answer=[-1]*len(arr)
stack=[]

for i in range(len(arr)):
    ## 내 오른쪽에 있는 수 중 나보다 작은 발견
    while stack and arr[stack[-1]]<arr[i]:
        ## 나랑 가장 붙어있는 애들부터 봄. 꼬붕은 걔의 가장 왼쪽에 있는 애를 섬기므로
        temp=stack.pop()
        ## 내 꼬붕의 정답을 나로 업데이트해줌
        answer[temp]=arr[i]
    ## 나도 나보다 더 큰 애의 꼬붕이 될 수 있으니 일단 스택에 넣어줌
    stack.append(i)

for a in answer:
    print(a, end=" ")