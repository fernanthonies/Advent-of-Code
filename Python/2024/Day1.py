from aocd import get_data

data = list(map(int, get_data(day=1, year=2024).split()))
first, second = sorted(data[0::2]), sorted(data[1::2])
result = sum(abs(a-b) for a, b in zip(first, second))
print(result)
result2 = sum(a * second.count(a) for a in first)
print(result2)


