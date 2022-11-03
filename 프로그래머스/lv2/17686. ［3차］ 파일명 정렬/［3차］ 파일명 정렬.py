import re
def solution(files):
    infos=[]
    for i in range(len(files)):
        ## 헤드 뽑아서 저장
        answer = []
        regex_head=r'[a-zA-Z- .]*'
        head=re.findall(regex_head, files[i])[0]
        head=head.upper()
        
        ## 중간 번호 뽑아서 저장
        regex_num=r'[0-9]{1,5}'
        remove_head=files[i][len(head):]
        num=re.findall(regex_num, remove_head)[0]
        
        ## 새 리스트에 원본, 헤드, 번호 저장
        infos.append([files[i], head, int(num)])
    ## 기준1:헤드, 기준2:번호로 정렬
    infos = sorted(infos, key=lambda x: (x[1], x[2]))
    
    ## 정렬된 배열의 원본을 정답에 저장
    for info in infos:
        answer.append(info[0])
    
    return answer