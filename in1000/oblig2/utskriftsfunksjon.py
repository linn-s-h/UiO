#programmet skal lese inn informasjon til bruker; navn og bosted, og skrive ut hilsen
#og gjør dette tre ganger

def gjentaDialog():
    inpNavn = input("Skriv inn navn: ")
    inpSted = input("Hvor kommer du fra? ")
    print(f"Hei, {inpNavn}! Du er fra {inpSted}.")
#kaller prosedyren 3 ganger for å hente info om hver person
gjentaDialog()
print()
gjentaDialog()
print()
gjentaDialog()
