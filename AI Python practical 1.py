import queue as Q                  

##dict_gn=dict(
##Arad=dict(Zerind=75,Timisoara=118,Sibiu=140),
##Bucharest=dict(Urziceni=85,Giurgiu=90,Pitesti=101,Fagaras=211),
##Craiova=dict(Drobeta=120,Pitesti=138,Rimnicu=146),
##Drobeta=dict(Mehadia=75,Craiova=120),
##Eforie=dict(Hirsova=86),
##Fagaras=dict(Sibiu=99,Bucharest=211),
##Giurgiu=dict(Bucharest=90),
##Hirsova=dict(Eforie=86,Urziceni=98),
##Iasi=dict(Neamt=87,Vaslui=92),
##Lugoj=dict(Mehadia=70,Timisoara=111),
##Mehadia=dict(Lugoj=70,Drobeta=75),
##Neamt=dict(Iasi=87),
##Oradea=dict(Zerind=71,Sibiu=151),
##Pitesti=dict(Rimnicu=97,Bucharest=101,Craiova=138),
##Rimnicu=dict(Sibiu=80,Pitesti=97,Craiova=146),
##Sibiu=dict(Rimnicu=80,Fagaras=99,Arad=140,Oradea=151),
##Timisoara=dict(Lugoj=111,Arad=118),
##Urziceni=dict(Bucharest=85,Hirsova=98,Vaslui=142),
##Vaslui=dict(Iasi=92,Urziceni=142),
##Zerind=dict(Oradea=71,Arad=75)
##)

dict_gn=dict(
    A=dict(F=31,B=72),
    B=dict(E=16,F=25,D=35,A=72),
    D=dict(E=10,G=12,B=35),
    F=dict(C=13,B=25,A=31),
    C=dict(F=13,E=15),
    E=dict(D=10,C=15,B=16,G=20),
    G=dict(D=12,E=20)
    )
    



##start=''goal=''result=''

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
