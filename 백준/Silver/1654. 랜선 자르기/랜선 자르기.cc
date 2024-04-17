#include <iostream>
#include <cstring>
#include <cstdio>
#include <algorithm>

using namespace std;

long long N, M, a;
long long map[10001] = { 0, };
long long m_ax = 0;

int main()
{
	scanf("%d %d", &N, &M);
	for (long long i = 0; i < N; i++)
	{
		scanf("%d", &map[i]);
		if (m_ax < map[i])
		{
			m_ax = map[i];
		}
	}
	long long left = 1;
	long long right = m_ax;
	long long mid, ans;
	long long cnt;
	bool flag;
	while (left <= right)
	{
		cnt = 0;
		mid = (left + right) / 2;
		flag = 0;
		for (long long i = 0; i < N; i++)
		{
			cnt += (map[i] / mid);
			if (cnt >= M)
			{
				ans = mid;
				left = mid + 1;
				flag = 1;
				break;
			}
		}
		if(flag ==0)
			right = mid - 1;
		
	}
	printf("%d\n", ans);
	return 0;
}