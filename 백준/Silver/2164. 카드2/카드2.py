from collections import deque

n = int(input())
card = list(range(1, n+1))
card = deque(card)

while len(card) > 1:
    for _ in range(1):
        card.popleft()
    tmp = card.popleft()
    card.append(tmp)
print(card[0])