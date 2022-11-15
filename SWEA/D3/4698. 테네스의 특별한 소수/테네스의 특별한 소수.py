def isPrime():
    for i in range(2, N+1):
        if li[i] == 1:
            for j in range(i*2, N+1, i):
                li[j] = 0

N = 10**6
li = [1] * (N+1)
li[0], li[1] = 0,0
isPrime()

t = int(input())
for tc in range(1, t+1):
    d, a, b = map(int, input().split())
    res = []
    for i in range(a, b+1):
        if str(d) in str(i) and li[i]:
                res.append(i)
    print('#%d' %tc, len(res))