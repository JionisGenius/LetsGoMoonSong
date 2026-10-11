# top > B -> 이 중 가장 낮은 top 찾기 
def dfs(idx,total):
    global ans
    global S
    #제약조건
    # 정상 종료
    if idx == N:
        if total >= B:
            if ans > total:
                ans=total
                return
        return
    
    # 편식쟁이
    if total > ans:
        return

    # 재귀
    # 선택하기
    dfs(idx+1,total+S[idx])
    # 선택 안하기
    dfs(idx+1,total)

T=int(input())
for tc in range(1,T+1):
    N,B=map(int,input().split())
    S=list(map(int,input().split()))
    ans=float('inf')
    
    # 선택된 직원수 , 직원키, 탑 총높이
    dfs(0,0)
    print(f'#{tc} {abs(B-ans)}')