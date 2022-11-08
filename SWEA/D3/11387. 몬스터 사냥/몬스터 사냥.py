t = int(input())
for tc in range(1, t+1):
    d, l, n = map(int, input().split())
    attack = 0
    for i in range(n):
        attack += d*(1+i*l*1/100)
    print('#%d' %tc, int(attack))