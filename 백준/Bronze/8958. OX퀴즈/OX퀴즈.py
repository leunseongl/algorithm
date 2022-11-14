a = int(input())
for i in range(a):
  count = 0
  sum = 0
  b = list(input())
  for i in b:
    if i == 'O':
      count += 1
      sum += count
    else:
      count = 0
  print(sum)