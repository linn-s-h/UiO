#from <filnavn> import (klasse)
from bygg import Bygg

def main():
    farge = input("skriv inn farger: ")
    etasjer = int(input("skriv inn antall etasjer: "))
    bygg1 = Bygg(farge, etasjer) #argumenter #("Hvitt", 50)
    print(bygg1.hentFarge())
    bygg1.skiftFarge("Rødt")
    print(bygg1.hentFarge())

    bygg2 = Bygg("Oransje", 25)
    print(bygg2.hentFarge())

main()
