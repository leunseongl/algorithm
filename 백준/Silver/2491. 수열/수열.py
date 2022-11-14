import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
increase = decrease = 1
res = 1
for i in range(1, n):
    if arr[i]>=arr[i-1]:
        increase += 1
    else:
        increase = 1
    if increase>res:
        res = increase

for i in range(1, n):
    if arr[i]<=arr[i-1]:
        decrease += 1
    else:
        decrease = 1
    if decrease>res:
        res = decrease
print(res)