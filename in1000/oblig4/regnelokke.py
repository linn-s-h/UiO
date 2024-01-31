"""programmet skal la bruker taste inn så mange tall de vil og printe ut summen
    når de taster inn 0, deretter skal programmet skrive ut til bruker
    hvilket av tallene som er minst og størst"""

liste = []
inp = liste.append(int(input("Tast inn et tall: ")))
while inp != 0: # så lenge input ikke er null så vil bruker kunne taste inn tall
    inp = int(input("Tast inn et tall: "))
    liste.append(inp) #legger inn tall i den tomme listen for hver input
liste.remove(0) #fjerner 0 sånn at det ser ryddig ut

for i in range(0, len(liste)): #sjekker hvert element fra indeks 0 helt til det ikke er mer å sjekke
    print(liste[i]) #printer ut elementene

#legger til hvert verdi fra liste i minSum
#og printer ut summen av alle tallene
minSum = 0
for tall in liste:
    minSum += tall
print("Sum:", minSum)

min = liste[0] #setter minste tall til første element i lista

for elem in liste: #sjekker om hvert element i liste er mindre enn det som er lagret
    if elem <= min: #hvis element er større enn det forrige
        min = elem #oppdaterer hva som er det laveste tallet

storste = liste[0] #setter største tall til første element i lista

for elem in liste: #sjekker om hvert element i liste er større enn det som er lagret
    if elem >= storste: #hvis element er større enn den forrige
        storste = elem #oppdaterer hva som er det høyeste tallet

print("Minste tallet i listen er", min)
print("Største tallet i listen er", storste)
