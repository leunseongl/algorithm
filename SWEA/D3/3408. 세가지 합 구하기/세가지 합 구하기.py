t = int(input())
for tc in range(1, t+1):
    n = int(input())
    sum1 = n*(n+1)//2
    sum2 = n**2
    sum3 = n*(n+1)
    print('#%d' %tc, sum1, sum2, sum3)