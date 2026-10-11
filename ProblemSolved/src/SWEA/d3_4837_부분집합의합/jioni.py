def dfs(hubo,choice,total):
    global ans
    #제한조건
    # 정상종료
    if choice ==N :
        if total ==K:
            ans+=1
        return
    # 편식쟁이(가지치기)
    if hubo > 12:
        return

    # 재귀
    # 선택 하기
    dfs(hubo+1,choice+1,total+hubo)
    #선택 안하기
    dfs(hubo+1,choice,total)


T=int(input())
for tc in range(1,T+1):
    N,K=map(int,input().split())
    ans=0
    # 후보 1 , 선택한 숫자, 합
    dfs(1,0,0)
    print(f'#{tc} {ans}')