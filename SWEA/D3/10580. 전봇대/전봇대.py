t = int(input())
for tc in range(1, t+1):
    n = int(input())
    li = []
    cnt = 0
    for _ in range(n):
        a, b = map(int, input().split())
        for x, y in li:
            if x>a and b>y:
                cnt += 1
            elif a>x and y>b:
                cnt += 1
        li.append((a,b))
    print('#%d' %tc, cnt)
