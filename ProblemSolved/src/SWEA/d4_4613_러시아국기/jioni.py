# 새로칠하는 개수 최소화
# 최소 한줄 하양, 파랑, 빨강
# 첫줄 , 마지막 줄 무조건 하양, 빨강
# 칠한 개수 카운트
# 2번째 줄부터 마지막-1 줄까지 검사
# 

T=int(input())
for tc in range(1,T+1):
    N,M=map(int,input().split())
    arr=[list(map(int,input().split())) for _ in range(N)]
    

