from verden import Verden

def hovedprogram():

    rader = int(input("Spillebrettets antall rader: "))
    kolonner = int(input("Spillebrettets antall kolonner: "))

    verden = Verden(rader, kolonner) #oppretter verden objekt med oppgitt dimensjoner
    verden.tegn() #tegner rutenett til verden, i tillegg antall levende og hvilken generasjon

    fortsett = True
    while (fortsett == True): #vil kjøre løkke så lenge det gir true
        meny = input("Press enter for å fortsette. Skriv inn q og trykk enter for å avslutte: ")
        if meny != "q":
            verden.oppdatering() #oppdaterer verden
            verden.tegn() #tegner oppdatert verden
        else:
            fortsett = False #hopper ut av løkken og avslutter program


# starte hovedprogrammet
hovedprogram()
