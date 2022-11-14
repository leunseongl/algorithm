import sys
input = sys.stdin.readline

n, k = map(int, input().split())
pascal = [1] * n
for i in range(1, n):
    pascal[i] = pascal[i-1]*(n-i)//i

print(pascal[k-1])