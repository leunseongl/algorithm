def DFS(l, sum):
    global cnt
    if l>=n:
        return
    sum += num[l]
    if sum == s:
        cnt += 1
    DFS(l+1, sum-num[l])
    DFS(l+1, sum)

n, s = map(int, input().split())
num = list(map(int, input().split()))
cnt = 0
DFS(0,0)
print(cnt)