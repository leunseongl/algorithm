def DFS(l, sum):
    global cnt
    visit = [0] * n
    visit[l] = 1
    sum += li[l]
    if sum == k:
        cnt += 1
    for i in range(l, n):
        if visit[i] == 0:
            DFS(i, sum)
            visit[i] = 0

t = int(input())
for tc in range(1, t+1):
    n, k = map(int, input().split())
    li = list(map(int, input().split()))
    cnt = 0
    for i in range(n):
        DFS(i, 0)
    print('#%d' %tc, cnt)