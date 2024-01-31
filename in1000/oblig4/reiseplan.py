""" programmet skal la bruker planlegge en reise
og deretter hente ut et spesifikk element fra en liste """

steder = []
klesplagg = []
avreisedatoer = []

#returnerer spesifisert lister av tall og stopper før gitt nummer 5
#liste vil få indeks 0-4
for x in range(5):
    steder.append(input("Reisemål: "))
    klesplagg.append(input("Klesplagg: "))
    avreisedatoer.append(input("Avreisedatoer: "))

#for-løkke som kjøres en gang med hver verdi i en samling
reiseplan = [steder, klesplagg, avreisedatoer] #lager nøstet liste
for innhold in reiseplan: #sjekker alle elementene i samlingen av lister
    print(innhold) #og printer de ut i lister (med hvert sitt innhold)

liste_indeks1 = int(input("Velg liste hvor 0 er steder, 1 er klesplagg og 2 er avreisedatoer: "))
liste_indeks2 = int(input("Velg et element hvor 0 er først og 4 er sist i listen: "))

#if-sjekker om bruker har tastet inn indeks til et eksisterende element
fortsettProgram = True
while (fortsettProgram == True):
    if liste_indeks1 >= 0 and liste_indeks1 <= 2 and liste_indeks2 >= 0 and liste_indeks2 <= 4:
            print(reiseplan[liste_indeks1][liste_indeks2]) #printer ut element fra en liste gitt indeks
            break #hopper ut av loopen
    else:
        print("Ugyldig input!") #feilmelding hvis bruker har skrevet inn indeks til et ikke-eksisterende element
        fortsettProgram = False
