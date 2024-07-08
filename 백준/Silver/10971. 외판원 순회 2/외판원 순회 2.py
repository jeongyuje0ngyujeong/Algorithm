import sys

cities = int(sys.stdin.readline())
is_visited = [False] * cities
costs = []
final_costs = 10000000
for i in range(cities):
    row = list(map(int, sys.stdin.readline().split()))
    costs.append(row)


def route(first: int, cur: int, depth: int, check_costs: int):
    global cities
    global final_costs

    if depth == cities and costs[cur][first] > 0:
        final_costs = min(check_costs + costs[cur][first], final_costs)
        return

    for i in range(cities):
        if not is_visited[i] and costs[cur][i] > 0:
            is_visited[i] = True
            route(first, i, depth + 1, check_costs + costs[cur][i])
            is_visited[i] = False


for i in range(cities):
    is_visited[i] = True
    route(i, i, 1, 0)
    is_visited[i] = False

sys.stdout.write(str(final_costs))
