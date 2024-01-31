#program som henter input og gir output med bruk av variabler

print("Hei Student!") #printer en string for å starte dialog med bruker
tall = 10 #lager to tallvariabler
tall2 = 5
navn = input("Hva er navnet ditt? ") #spør bruker om input
print("Hei", navn) #skriver ut respons til bruker
print(tall) #printer tallvariabler
print(tall2)
differanse = tall - tall2 #finner differansen utifra mellomverdi
print("Differanse:", differanse) #skriver ut resultatet av kalkulasjonen

navn2 = input("Vennligst oppgi nytt navn: ") #ber bruker om ny input

sammen = navn + navn2
sammen = navn + " og " + navn2 #gir variabel ny verdi
print(sammen) #printer ut verdi
