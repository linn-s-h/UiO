
#Testprogram for Hund:
from hund import Hund

def main():
    pluto = Hund(92, 8) #alder: 92, vekt: 8
    pluto.spring() #får pluto til å springe sånn at han mister vekt
    print(pluto.hent_vekt()) #skriver ut vekten til pluto
    pluto.spring() #får pluto til å springe mer
    print(pluto.hent_vekt()) #skriver ut ny vekt til pluto
    pluto.spis(5) #sender argumentet 5 til mengde
    print(pluto.hent_vekt()) #sjekker om pluto har blitt tyngere etter måltid
    pluto.spis(2) #pluto spiser mer og endrer vekt
    print(pluto.hent_vekt())
    print()

    #et bitte-lite ekspirement
    for x in range(18): #får pluto til å springe 18 ganger
        pluto.spring()
        print(pluto.hent_vekt()) #skriver ut ny vekt for hver løpetur

main()
