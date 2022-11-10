import sys
input = sys.stdin.readline
n = int(input())
li = list(map(int, input().split()))
li.sort()
x = int(input())
cnt = 0
p1 = 0
p2 = n-1
while p1<p2:
    if li[p1] + li[p2] == x:
       cnt += 1
       p1 += 1
       p2 -= 1
    elif li[p1] + li[p2] > x:
        p2 -= 1
    else:
        p1 +=1
print(cnt)