def solution(book_time):
    answer = 0
    times = []
    for b in book_time:
        s = b[0].replace(":","")
        f = b[1].replace(":","")
        endtime = str(int(f)+10)
        length = len(endtime)
        if int(endtime[-2:]) > 59 :
            back = int(endtime[-2:])-60
            if length>3:
                front = int(endtime[:2])+1
            elif length>2:
                front = int(endtime[:1])+1
            else:
                front = 1
               # print(front, back)
            endtime = int(str(front)+"0"+str(back))
       #print(int(s), endtime)
        times.append([int(s), int(endtime)])
    times.sort(key = lambda x:(x[0],x[1]))
    #print(times)
    check = [times[0][1]]
    for t in range(1,len(times)):
        flag = True
        for c in range(len(check)):
            if times[t][0] >= check[c]:
                check[c] = times[t][1]
                flag = False
                break
        if flag:
            check.append(times[t][1])
        
        #print(check)
    return len(check)