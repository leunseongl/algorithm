import sys

input = sys.stdin.readline
N, M = map(int, input().rstrip().split())
moneys = [int(input().rstrip()) for _ in range(N)]
mx_moneys = max(moneys)

left = mx_moneys
right = 10000 * 100000

answer = 0
while left <= right:
    mid = (left + right) // 2
    days = 1
    p = mid
    for money in moneys:
        if p - money < 0:
            p = mid
            days += 1
        p = p - money

    if days <= M:
        answer = mid
        right = mid-1
    else:
        left = mid+1

print(answer)