import sys
input = sys.stdin.readline

n = int(input())
milk = [int(input()) for _ in range(n)]
milk.sort(reverse=True)
pay = sum(milk)

for i in range(2, n, 3):
    pay -= milk[i]

print(pay)