from sang import Sang

class Spilleliste:
    def __init__(self, listenavn):
        self._sanger = []
        self._navn = listenavn

    def les_fil(self, filnavn):

        musikk_fil = open(filnavn) #argument i Testprogram er musikk.txt

        for linje in musikk_fil:
            alle_data = linje.strip().split(";") #gjør om tekststreng til liste med elementer
            ny_sang = Sang(alle_data[1], alle_data[0]) #oppretter ny Sang-objekt
            self._sanger.append(ny_sang) #legger til i _sanger

    #metode som legger til nytt sang objekt til _sanger
    def legg_til_sang(self, ny_sang):
        self._sanger.append(ny_sang)

    #metode som fjerner et sang objekt
    def fjern_sang(self, sang):
        self._sanger.remove(sang)

    #metode som spiller sang i testprogram ved å kalle på metode fra Sang-klassen
    def spill_sang(self, sang):
        return sang.spill()

    #metode som spiller av alle sanger oppdatert i _sanger ved å kalle på spill_sang metode
    def spill_alle(self):
        for sanger in self._sanger:
            self.spill_sang(sanger)

    #metode som iterer gjennom alle elementer i _sanger
    #sjekker om oppgitt tittel dukker opp ved å kalle på sjekk_tittel metode
    #og returnerer første den finner
    def finn_sang(self, tittel): #parameter er oppgitt tittel
        for sanger in self._sanger:
            if sanger.sjekk_tittel(tittel):
                return sanger
        return None

    #metode som går gjennom alle sanger i spillelisten og returnerer
    #en liste med sanger til bare oppgitt artist
    def hent_artist_utvalg(self, artistnavn):
        artist_utvalg = [] #oppretter en ny liste med alle sangene til artisten
        for sanger in self._sanger: #iterer gjennom _sanger
            if sanger.sjekk_artist(artistnavn): #finner artist
                artist_utvalg.append(sanger) #legger til sang i liste
        return artist_utvalg
