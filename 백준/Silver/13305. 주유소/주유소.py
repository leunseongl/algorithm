n = int(input())
road = list(map(int, input().split()))
pay = list(map(int, input().split()))
tot = 0
small = pay[0]
for i in range(n-1):
    if pay[i] < small:
        small = pay[i]
    tot += small * road[i]
print(tot)