import sys

house_nums, router_nums = map(int, sys.stdin.readline().split())
house_location = []

for _ in range(house_nums):
    house_location.append(int(sys.stdin.readline()))

house_location.sort()
min_dist = 1
max_dist = house_location[-1] - house_location[0]
check_dist = (min_dist + max_dist) // 2

while min_dist <= max_dist:
    check_router = 1
    installation_house = house_location[0]

    for house in house_location[1:]:
        if (house - installation_house) >= check_dist:
            installation_house = house
            check_router += 1

    if check_router < router_nums:
        max_dist = check_dist - 1

    else:
        min_dist = check_dist + 1

    check_dist = (min_dist + max_dist) // 2
    
sys.stdout.write(str(check_dist))
