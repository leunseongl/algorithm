def DFS(l, sum):
    global cnt
    if sum < w:
        return
    if l == n:
        if sum >= w:
            cnt += 1
    else:
        for i in range(n):
            if visit[i] == 0:
                visit[i] = 1
                DFS(l+1, sum+kit[i]-k)
                visit[i] = 0

n, k = map(int, input().split())
kit = list(map(int, input().split()))
w = 500
visit = [0]*n
cnt = 0
DFS(0, w)
print(cnt)