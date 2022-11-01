grade = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
t = int(input())
for tc in range(1, t+1):
    n, k = map(int, input().split())
    score = []
    k_score = 0
    for i in range(n):
        a, b, c = map(int, input().split())
        tmp = (a*0.35) + (b*0.45) + (c*0.2)
        score.append(tmp)
        if i+1 == k:
            k_score = tmp
    score.sort(reverse=True)
    div = n//10
    res = score.index(k_score)//div
    print('#%d' %tc, grade[res])