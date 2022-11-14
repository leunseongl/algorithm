card = list(range(0, 21))

for _ in range(10):
    s, e = map(int, input().split())
    for i in range((e-s+1)//2):
        card[s+i], card[e-i] = card[e-i], card[s+i]

card.pop(0)
print(*card)