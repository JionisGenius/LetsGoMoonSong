def dfs(idx,total):
    global ans
    global A
    # 제약조건
    # 정상종료
    if idx == N:
        if total == K:
            ans +=1
            return
        return
    # 편식쟁이
    if total > K:
        return

    # 재귀
    # 선택하기
    dfs(idx+1,total+A[idx])
    # 선택안함
    dfs(idx+1,total)
    
T=int(input())
for tc in range(1,T+1):
    N,K=map(int,input().split())
    A=list(map(int,input().split()))
    ans=0
    # idx , total
    dfs(0,0)
    print(f'#{tc} {ans}')