import queue as Q




dict_hn={'A':336,'B':0,'D':160,'F':242,'C':161,'E':176,'G':77}


dict_gn=dict(
    A=dict(F=31,B=72),
    B=dict(E=16,F=25,D=35,A=72),
    D=dict(E=10,G=12,B=35),
    F=dict(C=13,B=25,A=31),
    C=dict(F=13,E=15),
    E=dict(D=10,C=15,B=16,G=20),
    G=dict(D=12,E=20)
    )
    








start =input("Enter the Start point")
print(start)
goal= input("Enter Your Goal Here")
print(goal)


result=""

def get_fn(citystr):
    cities=citystr.split(" , ")
    hn=gn=0
    for ctr in range(0, len(cities)-1):
        gn=gn+dict_gn[cities[ctr]][cities[ctr+1]]
    hn=dict_hn[cities[len(cities)-1]]
    return(hn+gn)

def expand(cityq):
    global result
    tot, citystr, thiscity=cityq.get()
    if thiscity==goal:
        result=citystr+" : : "+str(tot)
        return
    for cty in dict_gn[thiscity]:
        cityq.put((get_fn(citystr+" , "+cty), citystr+" , "+cty, cty))
    expand(cityq)

def main():
    cityq=Q.PriorityQueue()
    thiscity=start
    cityq.put((get_fn(start),start,thiscity))
    expand(cityq)
    print("The A* path with the total is: ")
    print(result)

main()
