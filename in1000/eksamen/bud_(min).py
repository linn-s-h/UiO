
class Bud:

    def __init__(self, budgiver, budStr):
        self._budgiver = budgiver
        self._budStr = budStr
        if budStr < 1:
            self._budStr = 1
        #ELLER self._budStr = max(1, budstørrelse)

    def hentBudgiver(self):
        return self._budgiver

    def hentBudStr(self):
        return self._budStr

class Annonse:

    def __init__(self, annTekst):
        self._annonseTekst = annTekst
        self._bud = []

    def hentTekst(self):
        return self._annonseTekst

    def giBud(self, hvem, belop):
        bud = Bud(hvem, belop) #self._bugdiver, self._budStr
        self._bud.append(bud) #self._bud.append(Bud(hvem, belop))

    def antBud(self):
        return len(self._bud)

    def hoyesteBud(self):
        maxBud = self._bud[0] #starter med første bud i listen
        for i in range(1, len(self._bud)): #range(1) fordi den første allerede er størst
            if self._bud[i].hentBudStr() > maxBud.hentBudStr(): #gjør nytte av metoder (> ekte større)
                maxBud = self._bud[i] #Bud-Objekt

        return maxBud

    #utvid-metode
    def kraftBud(self, hvem, belop, max):
        bud_str = belop #beløpet på annet bud
        hoyeste = self.hoyesteBud() #lyst til å gi høyeste bud
        if hoyeste > bud_str:
            bud_str = hoyeste + 1

        if bud_str > max:
            bud_str = max

        self.giBud(hvem, belop)

    #oppg. 4g) lavere bud som kommer på et senere tidspunkt
    def hentHoyesteBudIndeks(self): #henter indeksen
        hoyeste = 0
        for i in range(1, len(self._bud)):
            if self._bud[i].hentBudStr() > self._bud[hoyeste].hentBudStr():
                hoyeste = i

        return hoyeste #høyeste indeks

    def tellLaveBud(self, indeks):
        teller = 0
        for i in range(indeks + 1, self._bud):
            if self._bud[i] < self._bud[indeks]: #ekte lavere
                teller += 1
        return teller


class Kategori:

    def __init__(self, katNavn):
        self._katNavn = katNavn
        self._annonser = []

    def nyAnnonse(self, annTekst):
        ny_annonse = Annonse(annTekst) #oppretter ny annonse som skal legges til i liste
        self._annonser.append(ny_annonse)
        return ny_annonse #returnerer referanse til den nye annonsen

    def hentAnnonser(self):
        return self._annonser #henter hele annonse-listen i katergoerier

    def tellLaveBud(self): #for hver annonse
        sum = 0
        for annonse in self._annonser:
            indeks = annonse.hentHoyesteBudIndeks()
            sum += annonse.tellLaveBud(indeks)

        return sum

class Bruktmarked:

    def __init__(self):
        self._bruktmarked = {}

    def nyKategori(self, katNavn):
        ny_kategori = Kategori(katNavn)
        if katNavn in self._bruktmarked:
            return None
        self._bruktmarked[katNavn] = ny_kategori #self._bruktmarked[katnavn] = Kategori(katNavn)

        return ny_kategori

    def finnKategori(self, katNavn):
        if katNavn not in self._bruktmarked:
            return None

        return self._bruktmarked[katNavn] #katNavn er nøkkel i ordbok, som henter verdi i kategorien

#oppg. 4g
def tellLaveBud(self):
    laveBud = 0
    for katNavn in self._bruktmarked:
        laveBud += self._bruktmarked[katNavn].tellLaveBud()

    return laveBud

#Hovedprogram

def main():

    marked = Bruktmarked()
    kat = marked.nyKategori("Sykkellykt")
    ann = kat.nyAnnonse("New Yorker sykkellykt")

    ann.giBud("Peter", 42)
    ann.giBud("Ann", 0)
    ann.kraftBud("Mary", 40, 50)

    hoyeste = ann.hoyesteBud()
    assert hoyeste.hentBudStr() == 43
    assert hoyeste.hentBudgiver() == "Mary"


main()
