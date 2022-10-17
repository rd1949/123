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
    

start =input("Enter the Start point: ")
print(start)
goal= input("Enter Your Goal Here: ")
print(goal)


result=""



def BFS(city, cityq, visitedq):
    global result
    if city==start:
        result=result+' '+city
    for eachcity in dict_gn[city].keys():
        if eachcity==goal:
            result=result+' '+eachcity
            return
        if eachcity not in cityq.queue and eachcity not in visitedq.queue:
            cityq.put(eachcity)
            result=result+' '+eachcity
    visitedq.put(city)
    BFS(cityq.get(),cityq,visitedq)

def main():
    cityq=Q.Queue()
    visitedq=Q.Queue()
    BFS(start, cityq, visitedq)
    print("BFS Traversal from ",start," to ",goal," is: ")
    print(result)
    
main()
