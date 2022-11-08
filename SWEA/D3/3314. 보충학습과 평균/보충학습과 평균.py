t = int(input())
for tc in range(1, t+1):
    score = list(map(int, input().split()))
    tot = 0
    for i in score:
        if i<40:
            tot += 40
        else:
            tot += i
    avg = tot//len(score)
    print('#%d' %tc, avg)