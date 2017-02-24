#include<iostream>
#include<bits/stdc++.h>
/**
 * Created by code on 8/2/17.
 * clean code
 */
using namespace std;
int main(){
    int T=1;
    int N=5;

    while(T--){
        vector<int> arr(N);
        vector<int> dp(N);

        for(int i=0;i<N;i++){
            arr[i]=rand()%10;
        }

        dp[0] = arr[0];
        if(N>1){
            dp[1] = max(arr[1],dp[0]);
        }

        for(int i=2;i<N;i++){
            //consider element dp[i-2]+arr[i]
            //skip element dp[i-1]
            dp[i] = max(dp[i-2]+arr[i],dp[i-1]);
        }

        cout<<dp[N-1]<<endl;
    }
}

