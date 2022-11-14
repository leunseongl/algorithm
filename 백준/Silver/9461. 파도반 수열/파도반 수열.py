t = int(input())
dy = [0] * 101
dy[1]=1
dy[2]=1
dy[3]=1

for _ in range(t):
    a = int(input())
    for i in range(4, a+1):
        dy[i] = dy[i-2]+dy[i-3]
    print(dy[a])