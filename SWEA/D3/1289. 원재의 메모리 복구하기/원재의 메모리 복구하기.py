t = int(input())
for tc in range(1, t+1):
    m = list(input())
    co = ['0'] * len(m)
    cnt = 0

    for i in range(len(m)):
        if m[i] != co[i]:
            cnt += 1
            co[i:] = m[i] * len(co[i:])
    print('#%d' %tc, cnt)