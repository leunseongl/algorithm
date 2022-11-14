n, l, k = map(int, input().split())
score = 0
cnt = 0
level = []
for _ in range(n):
    sub1, sub2 = map(int, input().split())
    level.append((sub1, sub2))
level.sort(key=lambda x: (x[1], x[0]))

for s1, s2 in level:
    if s2 <= l:
        score += 140
        cnt += 1
    elif s1 <= l:
        score += 100
        cnt += 1
    else:
        continue
    if cnt == k:
        break
print(score)