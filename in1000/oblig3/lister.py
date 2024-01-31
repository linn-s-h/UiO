
tall = [20, 25, 30]
tall.append(35) #legger til ny element i lista som får index [3]
print(tall[0]) #printer ut 20
print(tall[2]) #printer ut 30

navn = []
#spør bruker om input og legger til input bakerst i lista navn = []
inp = input('Si et navn: ')
navn.append(inp)
inp = input('- og et til: ')
navn.append(inp)
inp = input('- og enda et: ')
navn.append(inp)
inp = input('- og et siste: ')
navn.append(inp)
print(navn) #printer ut liste


if navn.count("linn") >= 1: #teller hvor mange ganger navnet mitt dukker opp i listen
    print("Du husket meg!") #dukker det opp en gang eller fler så printes dette ut
else:
    print("Glemte du meg?") #og hvis ikke

sum = tall[0] + tall[1] + tall[2] + tall[3] #summerer elementene som ligger i indexene
produkt = tall[0] * tall[1] * tall[2] * tall[3] #multipliserer elementene som ligger i index
liste1 = [sum, produkt] #bruker komma for å ikke summere verdiene sammen
liste2 = tall + liste1 #legger sammen to lister (ikke verdier), kan dermed bruke +
print(liste2)

del liste2[-1] #fjerner siste element i lista
del liste2[-1] #fjerner siste element i lista igjen
print(liste2) #printer ut ny liste
