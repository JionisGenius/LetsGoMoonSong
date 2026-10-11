def dfs(idx,score,total):
    global arr
    global ans
    # 제약조건
    # 가지치기
    if total > L:
        return
    # 정상종료
    if idx == N:
        if ans < score:
            ans= score
        return
    
    # 재귀
    # 선택
    dfs(idx+1,score+arr[idx][0],total+arr[idx][1])
    # 선택안함
    dfs(idx+1,score,total)
    


T=int(input())
for tc in range(1,T+1):
    N,L = map(int,input().split())
    arr= [list(map(int,input().split()))for _ in range(N)]
    ans=0
    # idx,score, 총칼로리
    dfs(0,0,0)
    print(f'#{tc} {ans}')