t = int(input())
for tc in range(1, t+1):
    n, k = map(int, input().split())
    score = list(map(int, input().split()))
    score.sort(reverse=True)
    res = 0
    for _ in range(k):
        res += score[0]
        score.pop(0)
    print('#%d'%tc, res)