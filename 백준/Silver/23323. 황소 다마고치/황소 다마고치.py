input = __import__('sys').stdin.readline
mis = lambda: map(int, input().split())
ii = lambda: int(input())

for t in range(ii()) :
	n, m = mis()
	while n > 0 :
	    m += 1
	    n //= 2
	print(m)
