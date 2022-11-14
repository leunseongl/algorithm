from collections import deque
n, k = map(int, input().split())
li = list(range(1, n+1))
li = deque(li)
cnt = 0
res = []
while li:
    cnt += 1
    if cnt == k:
        a = li.popleft()
        res.append(a)
        cnt = 0
    else:
        a = li.popleft()
        li.append(a)
print('<', end='')
for i in range(len(res)):
    if i==len(res)-1:
        print('%d>' %res[i])
    else:
        print(res[i], end=', ')
