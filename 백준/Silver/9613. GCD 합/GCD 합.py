import sys

def gcd(x, y):
    while y>0:
        x,y = y, x%y
    return x

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    tot = 0
    li = list(map(int, sys.stdin.readline().rstrip().split()))
    n = li.pop(0)
    for i in range(n):
        for j in range(i+1, n):
            tot += gcd(li[i], li[j])
    print(tot)