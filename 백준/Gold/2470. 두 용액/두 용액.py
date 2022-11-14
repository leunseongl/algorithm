import sys
input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))
li.sort()
lt = 0
rt = n-1
res = abs(li[lt]+li[rt])
final = [li[lt], li[rt]]

while lt<rt:
    tmp = li[lt] + li[rt]
    if abs(tmp)<res:
        res = abs(tmp)
        final = [li[lt],li[rt]]
        if tmp == 0:
            break
    if tmp < 0:
        lt += 1
    else:
        rt -= 1

print(final[0], final[1])
