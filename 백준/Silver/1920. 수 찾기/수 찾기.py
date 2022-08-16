n = int(input())
n_lst = list(map(int, input().split()))
m = int(input())
m_lst = list(map(int, input().split()))

def binary(lst,target):
    start = 0
    end = n-1
    while start <= end:
        mid = (start+end) // 2
        if lst[mid] == target :
            return '1'
        elif lst[mid] > target:
            end = mid - 1
        else :
            start = mid +1
    return None
        
N = sorted(n_lst)

for target in m_lst:
    res = binary(N, target)
    if res == None :
        print('0')
    else : print('1')