#include <iostream>

using namespace std;

int a[1001];
int d[1001];
int max(int a, int b){
	if(a>=b)
		return a;
	else
		return b;

}
int main(){

	int N;
	cin >> N;

	for(int i =0; i<N; i++){
		cin >> a[i];
		d[i] = 1;
	}

	for(int i =0; i<N; i++){
		for(int j =i; j>=0; j--){
			if(a[i] > a[j]){
				if(d[i] < d[j]+1)
					d[i] = d[j] + 1;
			}
		}
	}

	int maximum = d[0];
	for(int i =0; i<N; i++){
		if(maximum < d[i])
			maximum = d[i];
	}
	cout << maximum << "\n";

	return 0;
}