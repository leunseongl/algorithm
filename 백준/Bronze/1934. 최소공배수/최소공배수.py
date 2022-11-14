import sys

def gcd(x, y):
    while y:
        x, y = y, x%y
    return x

def lcm(x, y):
    return x*y//(gcd(x, y))

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    print(lcm(a, b))