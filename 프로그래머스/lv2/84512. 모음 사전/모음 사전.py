from itertools import product
def solution(word):
    answer = 0
    # A E I O U
    a = ["A","E","I","O","U"]
    # 길이 1,2,3,4,5개의 단어들
    # 조합 쓰면 안대남?
    alpha=[]
    ## A로 이루어짐
    for 모음 in a:
        alpha.append(모음)
    
    ## 길이 2
    two=list(product(a, repeat=2))
    sorted(two)
    for i in range(len(two)):
        alpha.append(two[i][0]+two[i][1])
    
    # 길이 3
    three = list(product(a,repeat=3))
    for i in range(len(three)):
        alpha.append(three[i][0]+three[i][1]+three[i][2])
    
    # 길이 4
    four=list(product(a,repeat=4))
    for i in range(len(four)):
        alpha.append(four[i][0]+four[i][1]+four[i][2]+four[i][3])
    
    # 길이 5
    five=list(product(a,repeat=5))
    for i in range(len(five)):
        alpha.append(five[i][0]+five[i][1]+five[i][2]+five[i][3]+five[i][4])
    
    alpha=sorted(alpha)
    answer=alpha.index(word)+1
    # print(alpha)
    return answer