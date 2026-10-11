def dfs(cnt,hubo,total):
    global ans
    # 제한조건
    # 정상종료
    if cnt == N :
        if total == K:
            ans+=1
            return
        return
    # 편식쟁이
    if hubo > 12:
        return
    
    # 재귀
    # 선택함
    dfs(cnt+1,hubo+1,total+hubo)
    # 선택안함
    dfs(cnt,hubo+1,total)


T=int(input())
for tc in range(1,T+1):
    N,K=map(int,input().split())
    ans=0
    # 선택된 숫자 개수, 후보, 총합   
    dfs(0,1,0)
    print(f'#{tc} {ans}')
    