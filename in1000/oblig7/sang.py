
class Sang:

    #konstruktør med artist og tittel som paramter, og oppretter instansvariabler
    #som skal holde styr på det som blir sendt inn
    def __init__(self, artist, tittel):
        self._artist = artist
        self._tittel = tittel

    #metode som spiller av sang i strengformat
    def spill(self):
        print(f"Spiller {self._tittel} av {self._artist}")

    def sjekk_artist(self, navn):
        for navn in navn.split(): #splitter navn "Jahn Teigen" i liste "Jahn" "Teigen"
            if navn in self._artist.split(): #sjekker om navn sendt inn som argument finnes i _artist
                return True

        return False

    #metode som sjekker om tittel sendt inn som argument er det samme som i _tittel
    def sjekk_tittel(self, tittel):
        if self._tittel.lower() == tittel.lower():
            return True
        return False

        #kunne også gjort:
        """return self._tittel.lower() == tittel.lower()"""

    #denne metoden kaller på de tidligere to metodene med artist og tittel som parameter
    #og returnerer om det stemmer
    def sjekk_artist_og_tittel(self, artist, tittel):
        return self.sjekk_artist(artist) and self.sjekk_tittel(tittel)
