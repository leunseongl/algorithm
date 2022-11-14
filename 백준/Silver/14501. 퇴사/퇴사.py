n = int(input())
t_li = []
p_li = []
dy = [0] * (n+1)

for _ in range(n):
    t, p = map(int, input().split())
    t_li.append(t)
    p_li.append(p)

for i in range(n-1, -1, -1):
    if t_li[i]+i > n:
        dy[i] = dy[i+1]
    else:
        dy[i] = max(dy[i+1], p_li[i]+dy[i+t_li[i]])

print(dy[0])