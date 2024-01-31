from random import randint
from celle import Celle

class Rutenett:
    def __init__(self, rader, kolonner):
        self._ant_rader = rader
        self._ant_kolonner = kolonner
        self._rutenett = self._lag_tomt_rutenett() #lager rutenett ved å kalle på metode

    #disse to metodene utgjør instansen _rutenett og er i samarbeid
    def _lag_tomt_rutenett(self):
        noested_liste = [] #lager en liste som skal bli fylt med lister
        for rad in range(self._ant_rader):
            noested_liste.append(self._lag_tom_rad()) #lager rad for hver rad rutenettet trenger
        return noested_liste #liste inneholder lister

    def _lag_tom_rad(self):
        ytre_liste = []
        for kol in range(self._ant_kolonner):
            ytre_liste.append(None) #fyller rad med None for hver kolonne rutenettet trenger
        return ytre_liste

    #metode som fyller rutenettet med tilfeldige celler ved å iterere gjennom plass
    #i rutenettet og kalle på lag_celle for å fylle inn plassen med en celle
    def fyll_med_tilfeldige_celler(self):
        for rad in range(self._ant_rader):
            for kol in range(self._ant_kolonner):
                self._rutenett[rad][kol] = self.lag_celle(rad, kol) #kan fjerne argumenter


    def lag_celle(self, rad, kol): #kan fjerne parametere
        celle = Celle()
        if randint(0, 2) == 0: #returnerer tall 0, 1, 2 tilfeldig
            celle.sett_levende()
        return celle

    #en metode som henter en celle hvis den er innenfor rutenettet og returnerer
    #None hvis cellen er utenfor
    def hent_celle(self, rad, kol):
        if rad in range(self._ant_rader):
            if kol in range(self._ant_kolonner):
                return self._rutenett[rad][kol] #returnerer kordinatene til cellen i rutenettet
        else:
            return None

    #metode som bestemmer hvordan rutenettet skal se ut i terminalen
    #og henter status tegn til cellen for hver plass i rutenettet
    def tegn_rutenett(self):
        for rad in range(self._ant_rader):
            for kol in range(self._ant_kolonner):
                    print(self._rutenett[rad][kol].hent_status_tegn(), end="  ")
            print("") #printer hver kolonne før neste rad
                        #sånn at rad og kolonne ikke er på en og samme linje i terminal

    #metode som finner naboceller
    def _sett_naboer(self, rad, kol):
        main_celle = self.hent_celle(rad, kol) #henter celle
        for y in range(-1, 2): #-1, 0, 1 nedover #[i-y], [i], [i+y]
            for x in range(-1, 2): #-1, 0, 1 bortover #[j-1], [j], [j+1]
                if self.hent_celle(rad + y, kol + x) != main_celle: #nabocelle kan ikke være selve valgt celle
                    if self.hent_celle(rad + y, kol + x) != None: #None -> "utenfor brettet", passer på at cellene ikke havner utenfor rutenettet
                        main_celle.legg_til_nabo(self.hent_celle(rad + y, kol + x)) #innenfor rutenettet, henter celle og legger til i naboliste

    #metode som oppdaterer nabo til hver celle
    def koble_celler(self):
        for rad in range(self._ant_rader):
            for kol in range(self._ant_kolonner):
                self._sett_naboer(rad, kol)

    #metode som henter hver celle, legger de til i en liste og returnerer listen
    def hent_alle_celler(self):
        alle_celler = []
        for rad in range(self._ant_rader):
            for kol in range(self._ant_kolonner):
                alle_celler.append(self.hent_celle(rad, kol))

        return alle_celler

    #metode som iteterer gjennom rutenettet og teller antall levende celler
    def antall_levende(self):
        antall_levende = 0
        for rad in range(self._ant_rader):
            for kol in range(self._ant_kolonner):
                if self.hent_celle(rad, kol).er_levende():
                    antall_levende += 1

        return antall_levende
