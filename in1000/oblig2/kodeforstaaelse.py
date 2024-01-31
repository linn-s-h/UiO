
a = input("Tast inn et heltall! ")
b = int(a)
if b < 10:
    print(b+"Hei!")

"""
Programmet vil bare kjøre første programsetning ettersom den bare er
avhengig av brukerens input alene, men etter brukers input
vil det komme en feilmelding. Det er fordi programmet har
behandlet variabelen b som et heltall, og konkatinering av streng og integer
i samme uttrykk er ikke akseptert. Programmet vil heller ikke kjøre videre hvis
input tallet er større enn 10, siden det ikke er en if-setning på det.
#vil kjøres
#syntax feil
#kjører hvis b >= 10
#kjører ikke hvis b ikke er et heltall
"""

#retning
a = input("Tast inn et heltall! ")
b = int(a)
if b < 10:
    print(str(b)+"Hei!") #må behandle integer som en streng igjen
#else:
    #print(str(b)+"Hade!")
