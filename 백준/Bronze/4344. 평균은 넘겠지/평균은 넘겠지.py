a = int(input())  

for i in range(a):
  b = list(map(int, input().split()))
  avg = sum(b[1:])/b[0]
  cnt = 0
  for i in b[1:]:
    if i > avg:
      cnt += 1
  
  rate = (cnt/b[0])*100
  print(f'{rate:.3f}%')