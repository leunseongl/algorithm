t = int(input())
dy = [0] * 12
dy[1] = 1
dy[2] = 2
dy[3] = 4

for _ in range(t):
    n = int(input())
    for i in range(4, n+1):
        dy[i] = dy[i-1]+dy[i-2]+dy[i-3]
    print(dy[n])