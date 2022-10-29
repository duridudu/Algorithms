N = int(input())
inpt = []
sum=0 
words=dict()
for _ in range(N):
    word = input()
    inpt.append(word)
    for w in word:
        if w not in words:
            words[w]=0

    for i in range(len(word)):
        if word[i] in words:
            words[word[i]]+=(10**((len(word)-i)-1))    
        else :
            # print(word[i])
            words[word[i]]=0
words2=sorted(words.items(), key=lambda x:x[1], reverse=True)
minus=9
for w in words2:
    k=w[0]
    words[k]=minus
    minus-=1
# print(words)

bigSum=0
for i in range(N):
    littleSum=0
    for j in range(len(inpt[i])):
        nowW = inpt[i][j]
        littleSum+=words[nowW]*(10**((len(inpt[i])-j)-1))  
    bigSum+=littleSum
print(bigSum)