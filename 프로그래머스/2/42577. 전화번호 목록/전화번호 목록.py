def solution(phone_book):
    answer = True
    phone_book.sort()
    for i in range(len(phone_book)-1):
       # for j in range(1,len(phone_book[i+1:])+1):
            if phone_book[i+1].startswith(phone_book[i]) : 
                #print(phone_book[i], phone_book[j])
                answer = False
                break
        #if answer == False:
        #    break
    return answer