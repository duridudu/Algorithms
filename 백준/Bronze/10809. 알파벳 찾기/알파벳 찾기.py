# original try
alp = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
       "t", "u", "v", "w", "x", "y", "z"]
word = input()
ans = [-1]*26

for i in range(len(word)):
    idx = alp.index(word[i])
    if ans[idx] == -1:
        ans[idx] = i

for j in ans:
    print(j, end= " ")