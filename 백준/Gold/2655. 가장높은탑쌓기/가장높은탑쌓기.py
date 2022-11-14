import sys
input = sys.stdin.readline

n = int(input())
bricks = []
bricks.append((0,0,0,0))

for i in range(1, n+1):
    a, b, c = map(int, input().split())
    bricks.append((i,a,b,c))

bricks.sort(key=lambda x: x[3])
dy = [0] * (n+1)

for i in range(1, n+1):
    for j in range(0, i):
        if bricks[i][1]>bricks[j][1]:
            dy[i] = max(dy[i], dy[j] + bricks[i][2])

largest = max(dy)
index = n
res = []

while index != 0:
    if largest == dy[index]:
        res.append(bricks[index][0])
        largest -= bricks[index][2]
    index -= 1

res.reverse()
print(len(res))

for i in res:
    print(i)
