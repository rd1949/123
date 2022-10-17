import queue as Q

dict_gn=dict(
    A=dict(F=31,B=72),
    B=dict(E=16,F=25,D=35,A=72),
    D=dict(E=10,G=12,B=35),
    F=dict(C=13,B=25,A=31),
    C=dict(F=13,E=15),
    E=dict(D=10,C=15,B=16,G=20),
    G=dict(D=12,E=20)
    )


start =input(" Enter the Start point: ")
print(start)
goal= input(" Enter Your Goal Here: ")
print(goal)


result=" "

def DLS(city, visitedstack, startlimit, endlimit):
    global result
    found=0
    result=result+city+' '
    visitedstack.append(city)
    if city==goal:
        return 1
    if startlimit==endlimit:
        return 0
    for eachcity in dict_gn[city].keys():
        if eachcity not in visitedstack:
            found=DLS(eachcity, visitedstack, startlimit+1, endlimit)
            if found:
                return found

def IDDFS(city, visitedstack, endlimit):
    global result
    for i in range(0, endlimit):
        print("Searching at Limit: ",i)
        found=DLS(city, visitedstack, 0, i)
        if found:
            print("Found")
            break
        else:
            print("Not Found! ")
            print(result)
            print("-----")
            result=' '
            visitedstack=[]

def main():
    visitedstack=[]
    IDDFS(start, visitedstack, 9)
    print("IDDFS Traversal from ",start," to ", goal," is: ")
    print(result)


main()
