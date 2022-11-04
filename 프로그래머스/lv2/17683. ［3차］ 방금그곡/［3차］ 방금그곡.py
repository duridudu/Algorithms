from collections import deque
def solution(m, musicinfos):
    answer = ''
    res=[]
    m=m.replace('E#','T')
    m=m.replace('B#','O')
    m=m.replace('C#','H')
    m=m.replace('D#','I')
    m=m.replace('F#','J')
    m=m.replace('G#','K')
    m=m.replace('A#','L')
    for i in range(len(musicinfos)):
        temp=musicinfos[i].split(',')
        start=temp[0]
        fin=temp[1]
        title=temp[2]
        music=temp[3]
        music=music.replace('E#','T')
        music=music.replace('B#','O')
        music=music.replace('C#','H')
        music=music.replace('D#','I')
        music=music.replace('F#','J')
        music=music.replace('G#','K')
        music=music.replace('A#','L')
        
        dur=(int(fin[0:2])*60+int(fin[3:]))-(int(start[0:2])*60+int(start[3:]))
        if dur>len(music):
            music*=(dur//len(music))
            music+=music[:dur%len(music)]
        elif dur<len(music):
            music=music[:dur]
            
        if m in music:
            res.append([dur,i,title])

        # print(dur,m,music)    
        # dq = deque(music)
        # for j in range(len(music)):
        #     t = dq.popleft()
        #     dq.append(t)
        #     # print(m,list(dq))
        #     if m in ''.join(list(dq)):
        #         res.append([dur,i,title])
        #         break
        if len(res)==0:
            answer='(None)'
        else:
            res=sorted(res, key=lambda x: (x[0],-x[1]))
            answer=res[-1][2]
        # print(answer)
    return answer