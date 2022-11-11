T = int(input())

for tc in range(1,T+1):
    s = str(input())
    lens = len(s)
    res = 0
    sum = 0
    for i in range(lens):
        if sum < i:
            res+=1
            sum+=1
        sum+=int(s[i])

    print('#%d %d' % (tc,res))

