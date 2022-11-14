import sys
input = sys.stdin.readline

n, m = map(int, input().split())
n_li = list(map(int, input().split()))
m_li = list(map(int, input().split()))
p1 = p2 = 0
li = []

while p1<n and p2<m:
    if n_li[p1]<=m_li[p2]:
        li.append(n_li[p1])
        p1 += 1
    else:
        li.append(m_li[p2])
        p2 += 1

if p1 == n:
    li = li+m_li[p2:]
if p2 == m:
    li = li+n_li[p1:]

print(*li)