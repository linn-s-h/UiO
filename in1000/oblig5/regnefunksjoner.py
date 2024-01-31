"""dette programmet spør bruker om to tall, som programmet deretter skal gjøre utregninger
    med addisjon, subtraksjon og divisjon. utregningene skal skrives ut. til sist ber
    programmet om et tall i tommer som skal konverteres til cm og skriver ut resultatet."""

def addisjon(tall1, tall2):
    sum = tall1+tall2
    return sum #sender parametre tilbake (returnerer resultat)

def subtraksjon(tall1, tall2):
    sub = tall1 - tall2
    return sub #sender parametre tilbake

#sjekker at kall på funksjon får riktig subtraksjon verdi
assert subtraksjon(5, 8) == -3
assert subtraksjon(-4, -3) == -1
assert subtraksjon(8, -2) == 10

def divisjon(tall1, tall2):
    div = tall1 / tall2
    return div #sender parametre tilbake

#sjekker at kall på funksjon får riktig divisjon verdi
assert divisjon(5, 8) == 0.625
assert divisjon(-12, -3) == 4
assert divisjon(8, -2) == -4

def tommerTilCm(antallTommer):
    assert antallTommer > 0
    return antallTommer*2.54 #returverdi som gjør om tommer til cm

def skrivBeregninger():
    print("Utregninger:")
    t1 = float(input("Skriv inn tall 1: ")) #input som senere blir brukt som argumenter
    t2 = float(input("Skriv inn tall 2: "))

    print() #kaller på funksjoner med begge input som argument, og printer ut resultat
    print(f"Resultat av summering {float(addisjon(t1, t2))}")
    print(f"Resultat av subtraksjon {float(subtraksjon(t1, t2))}")
    print(f"Resultat av divisjon {float(divisjon(t1, t2))}")

    print()
    print("Konvertering fra tommer til cm:")
    cm = float(input("Skriv inn et tall: ")) #antallTommer = cm, cm blir senere et argument
    resultat = tommerTilCm(cm) #funksjonskallet evaluerer til returverdien, som gjør om tommer til cm
    print(f"Resultat: {resultat}") #skriver ut konverteringen

skrivBeregninger()
