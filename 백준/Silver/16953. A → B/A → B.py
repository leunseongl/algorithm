a, b = map(int, input().split())
cnt = 1

while a != b:
    if (a>b) or (b%2 != 0 and b%10 != 1):
        cnt = -1
        break
    else:
        if b%2 == 0:
            b = b//2
            cnt += 1
        elif b%10 == 1:
            b = b//10
            cnt += 1
print(cnt)