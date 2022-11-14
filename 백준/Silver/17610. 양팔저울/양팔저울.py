def DFS(l, sum):
    global res
    if l == k:
        if 0<sum<=tot:
            res.add(sum)
    else:
        DFS(l+1, sum+kg[l])
        DFS(l+1, sum-kg[l])
        DFS(l+1, sum)


k = int(input())
kg = list(map(int, input().split()))
res = set()
tot = sum(kg)
DFS(0,0)

print(sum(kg)-len(res))