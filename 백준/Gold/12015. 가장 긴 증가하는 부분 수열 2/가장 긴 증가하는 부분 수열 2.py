n=int(input())
arr = list(map(int, input().split()))

bnr = [0]
bnr[0] = arr[0]

for i in range(1,n):
   #print(bnr)
   if bnr[-1] < arr[i]:
        bnr.append(arr[i])
   else:
       start=0
       fin=len(bnr)
       target = arr[i]

       while(start<fin):
           mid = (start+fin)//2
           if bnr[mid] < target :
               start = mid + 1
           else  : 
               fin = mid
        
       bnr[fin] = arr[i]

print(len(bnr))