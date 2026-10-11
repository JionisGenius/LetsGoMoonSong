import sys; sys.stdin=open('testcase.txt')

def my_abs(num):
    if num < 0:
        return -num
    return num

T=int(input())
for tc in range(1,T+1):
    N=int(input())
    arr=list(map(int,input().split()))
    max_int=0
    min_int=11
    min_loca=0
    max_loca=0
    
    
    for i in range(len(arr)):
        if arr[i] < min_int:
            min_int=arr[i]
            min_loca=i
        elif arr[i] >= max_int:
            max_int=arr[i]
            max_loca=i

    ans=my_abs(max_loca - min_loca)
    print(f'#{tc} {ans}')