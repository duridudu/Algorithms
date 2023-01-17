tc = int(input())
for t in range(tc):
    animals = list(input().split())
    # print(animals)
    arr=[]
    while(True):
        temp=list(input().split())
        # print(temp)
        temp1=temp[0]
        temp2=temp[-1]
        if temp1=='what':
            break
        arr.append(temp2)

    # print(arr)
    for i in range(len(animals)):
        if animals[i] in arr:
            animals[i]=0
    while 0 in animals:
        animals.remove(0)
    for a in animals:
        print(a, end=" ")