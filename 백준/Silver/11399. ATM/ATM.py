n = int(input())
a = list(map(int, input().split()))
a.sort()
sum = 0
answer = 0
for i in a:
    sum += i
    answer += sum
print(answer)