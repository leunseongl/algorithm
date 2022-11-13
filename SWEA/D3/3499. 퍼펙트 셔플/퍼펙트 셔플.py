t = int(input())
for tc in range(1, t+1):
    n = int(input())
    card = list(input().split())
    half1 = half2 = []
    if n%2 == 0:
        half1 = card[:n//2]
        half2 = card[n//2:]
    else:
        half1 = card[:n//2+1]
        half2 = card[n//2+1:]
    shuffle = []
    tmp = 0
    while half1 or half2:
        if tmp%2 == 0:
            shuffle.append(half1.pop(0))
        else:
            shuffle.append(half2.pop(0))
        tmp += 1
    print('#%d' %tc, *shuffle)