class Stasjon:

    def __init__(self, navn):
        self._navn = navn
        self._nabo = None

    def sett_nabo(self, nabo):
        self._nabo = nabo

    def hent_nabo(self):
        return self._navn #"self sitt navn"


def main(filnavn):
    trikkestall = Stasjon("staller")
    forrige_stasjon = trikkestall
    for stasjonsnavn in open(filnavn): #["Rikshospitaler", "Forkningsparken", "Universitetsplassen"]
        denne = Stasjon(stasjonsnavn.strip()) #fjerner usynlig /n fra tekstfil
        forrige_stasjon.sett_nabo(denne) #noen_stasjon.sett_nabo(en_annen_stasjon)
        forrige_stasjon = denne #oppdaterer stasjon

    maal = input("Hvor vil du reise til?" )
    her = trikkestall
    while her.hent_navn() != maal:
        print("Du er her:", her.hent_navn)
        her = her.hent_nabo()

main("trase.txt")
