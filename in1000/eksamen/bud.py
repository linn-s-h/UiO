
#prøveeksamen 2017

class Bud:

    def __init__(self, navn, budstørrelse):
        self._budiver = navn
        self._budStr = max(1, budstørrelse)
        #ELLER if _budStr < 1:
            #self._budStr = 1

    def hentBudgiver(self):
        return self._budgiver

    def hentBudStr(self):
        return self._budStr

class Annonse:

    def __init__(self, annTekst):
        self._annTekst = annTekst
        self._bud = [] #liste over bud, ble opprettet sammen med def giBud()

    def hentTekst(self):
        return self._annTekst

    def giBud(self, hvem, belop):
        nytt_bud = Bud(hvem, belop) #oppretter nytt bud
        self._bud.append(nytt_bud) #legger til nytt bud i liste

    def antBud(self):
        return len(self._bud)

    def hoyesteBud(self):
        hoyeste = self._bud[0] #hoyeste begynner på null
        for i in range(1, len(self._bud)): #sjekker ikke første bud opp mot første bud
            if self._bud[i].hentBudStr() > hoyeste.hentBudStr(): #hvis to bud er like høye, vil det første komme først (> ekte større)
                hoyeste = self._bud[i]

        return hoyeste

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
        self._ordbok = {}

    def nyKategori(self, katNavn):
        ny_kategori = Kategori(katNavn)
        if katNavn in self._ordbok:
            return None
        self._ordbok[katNavn] = ny_kategori
        return ny_kategori

    def finnKategori(self, katNavn):
        if katNavn not in self._ordbok:
            return None
        return self._ordbok[katNavn] #katNavn er nøkkel i ordbok, som henter verdi i kategorien

    #oppg. 4g
    def tellLaveBud(self):
        laveBud = 0
        for katNavn in self._ordbok:
            laveBud += self._ordbok[katNavn].tellLaveBud()

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
