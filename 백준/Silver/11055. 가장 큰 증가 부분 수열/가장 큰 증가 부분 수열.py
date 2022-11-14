n = int(input())
li = list(map(int, input().split()))
li.insert(0,0)
dy = [0]*(n+1)
dy[1] = li[1]

for i in range(1, n+1):
    big = 0
    for j in range(i, 0, -1):
        if li[i]>li[j] and dy[j]>big:
            big = dy[j]
    dy[i] = big + li[i]

print(max(dy))