import sys
from collections import Counter

n = int(sys.stdin.readline().rstrip())
num = []

for _ in range(n):
    num.append(int(sys.stdin.readline().rstrip()))

avg = round(sum(num)/n) #산술평균
num.sort() #중앙값 구하기위해
print(avg)
print(num[n//2])

cnt = Counter(num).most_common(2)

if len(num) > 1:
    if cnt[0][1] == cnt[1][1]:
        print(cnt[1][0])
    else:
        print(cnt[0][0])
else:
    print(cnt[0][0])

print(max(num)-min(num))

