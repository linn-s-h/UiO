def minFunksjon():
    for x in range(2):
        c = 2
        print(c) #skriver ut 2
        c += 1 #øker verdi med 1 for hver gjennomkjøring, men vil ikke ha noe effekt
        b = 10                                              #ettersom variabel c er definert i det lokale skopet
        b += a #programmet kan ikke gå videre siden a ikke eksisterer
        print(b)
    return(b)

def hovedprogram():
    a = 42
    b = 0
    print(b) #skriver ut 0
    b = a #tilordnet samme verdi som a
    a = minFunksjon()
    print (b)
    print (a)

hovedprogram()

"""Funksjonen minFunksjon blir først definert, uten noen parametre.
    Så defineres funksjonen hovedprogram, igjen uten noen parametre.
    Deretter blir hovedprogram kalt på, og inne i funksjonen har variabelen
    a verdi 42 og variabelen b verdi 0. Så printes ut verdien 0 til terminalen.
    Variabel b får deretter tilordnet ny verdi 42 til varibel a. Inne i
    funksjonen blir minFunksjon kalt på og er definert i variabel a, deretter
    går ut funksjonen for å sjekke minFunksjon.

    Funksjonen består av en for-løkke med intensjon om å kjøre to ganger.
    I den løkken har variabelen c verdi 2, og verdien printes ut til terminalen.
    Verdien "skal" øke med 1 for hver gang løkken kjøres. Variabelen b har verdi 10,
    og verdien skal øke med verdien til variabel a for hver gang. Problemet her er
    at variabel a ikke eksisterer innenfor funksjonen. Det vil dermed komme en
    feilmelding om at a ikke er definert."""
