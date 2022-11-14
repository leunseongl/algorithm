a, b = input().split()

small = int(a.replace('6', '5')) + int(b.replace('6', '5'))
large = int(a.replace('5', '6')) + int(b.replace('5', '6'))

print(small, large)