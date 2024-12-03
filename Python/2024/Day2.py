from aocd import get_data
from itertools import pairwise


def safe(diffs):
    diff_set = set(map(lambda pair: pair[1] - pair[0], pairwise(diffs)))
    return diff_set <= {1, 2, 3} or diff_set <= {-1, -2, -3}


def drop_nth(a, i):
    return a[0:i] + a[i+1:]


data = get_data(day=2, year=2024).split('\n')
print(sum(1 if safe(a) else 0 for a in map(lambda a: list(map(int, a.split(' '))), data)))  # part one
print(sum(1 if any(safe(drop_nth(line, i)) for i in range(len(line))) else 0 for line in map(lambda a: list(map(int, a.split(' '))), data)))  # part two
