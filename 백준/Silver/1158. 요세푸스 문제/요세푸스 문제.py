import sys
from collections import deque

n, k = map(int, sys.stdin.readline().rstrip().split())
person = list(range(1, n+1))
person = deque(person)
res = []

while person:
    for _ in range(k-1):
        tmp1 = person.popleft()
        person.append(tmp1)
    tmp2 = person.popleft()
    res.append(tmp2)
    if len(person) == 1:
        res.append(person.popleft())

print('<', end='')
print(', '.join([str(i) for i in res]), end='')
print('>', end='')