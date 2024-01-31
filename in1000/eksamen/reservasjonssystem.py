
class Gruppe:
    def __init__(self, kravliste):
        self._krav = kravliste
        self._gruppe = [] #self._gruppe = Gruppe() vil ikke funke fordi senere metoder
        #krever å registrere om et rom er opptatt av gjester eller ikke

    def legg_til_personer(self, personer):
        for person in personer:
            self._gruppe.append(person)
        #ikke 'self._gruppe.append(personer)', fordi parameter er en liste med strenger

    def hent_personer(self):
        return self._gruppe

    def hent_krav(self):
        return self._krav

class Rom:

    def __init__(self, romNummer, antSenger, fasiliteter):
        self._rom = romNummer
        self._senger = antSenger
        self._fasiliteter = fasiliteter
        self._gjester = [] #tom liste betyr ledig

    def reserver(self, gjester):
        self._gjester = gjester #liste med gjester
        print(f"Rommet er opptatt av {self.hent_personer()}")

    def hent_ant_senger(self):
        return self._senger

    def passer(self, kravliste):
        #while rommet ikke allerede er occupied av en annen gruppe
        if len(self._gjester) > 0: #if ledig rom eller ikke
            return False
        for krav in kravliste:
            if krav.lower() not in self._fasiliteter:
                return False #på denne måten vil for løkken stoppe iterasjonen ved
                                #ved første if sjekk som evaluerer til False
        return True

    def __str__(self):
        str = f"Rom {self._rom} har {self._senger} senger.\n "
        str += f"Fasiliteter: {self._fasiliteter}"
        return str

class Hotell:

    def __init__(self, hotellnavn):
        self._hotellnavn = hotellnavn
        self._hotellRom = {}
        self._romFraHotellFil()

    def _romFraHotellFil(self, hotellnavn):
        fil = open(hotellnavn, "r")
        for linje in fil:
            data = linje.strip().split(" ")
            romNummer = data[0]
            antSenger = data[1]
            fasiliteter = data[2:] #automatisk gjort om til en liste
            self._hotellRom[romNummer] = Rom(romNummer, antSenger, fasiliteter)

        fil.close()

    def hent_hotellRom(self):
        return self._hotellRom

    def reserver_rom(self, romNummer, gjester):
        self._hotellRom[romNummer].reserver(gjester)

    def finn_passende_rom(self, kravliste):
        passendeRom = []
        for rom in self._hotellRom.values(): #self._hotellRom[rom]
            if rom.passer(kravliste):
                passendeRom.append(rom)

        return passendeRom

class Reservasjonssytem:

    def __init__(self, hotellnavn):
        self._hoteller = {}
        for hotell in hotellnavn:
            self._hoteller[hotell] = Hotell(hotell) #klassen Hotell har bare en egenskap/referanse
        #{hotellnavn:self._hotellRom}

    def reserver_rom_i_hotell(self, hotellnavn, romNummer, gjester):
        self._hoteller[hotellnavn].reserver_rom(romNummer, gjester)

    #non public
    def finn_alle_passende_rom(self, kravliste):
        allePassendeRom = {}
        for hotellnavn in self._hoteller:
            #hotellObjekt = self._hoteller[hotellnavn]
            romListe = self._hoteller[hotellnavn].finn_passende_rom(kravliste)
            if len(romListe) > 0:
                allePassendeRom[hotellnavn] = romListe

        return allePassendeRom #returnerer dict med hoteller og alle rom som passer

    def gruppe_reservasjon(self, gruppe):

        personer = gruppe.hent_personer()
        kravliste = gruppe.hent_krav()
        alleRom = self.finn_alle_passende_rom(kravliste) #returnerer dict med alle passende rom i hotellet
        if len(alleRom) == 0:
            return ["Fant ingen passende rom for gruppen"]
        else:
            beskreftelse = ["Bekrefter gruppebestilling!\n> Hoteller med reserverte rom:\n\n"]

        neste_i_liste_av_gjester = 0

        for hotellnavn in alleRom:
            for rom in alleRom[hotellnavn]: #vi vil finne rommene og for hvert rom reservere
                                            #til så mange gjester det er plass til

                gjester = []
                while neste_i_liste_av_gjester < len(personer) and len(gjester) < rom.hent_ant_senger():
                    gjester.append(personer[neste_i_liste_av_gjester])
                    neste_i_liste_av_gjester += 1
                rom.reserver(gjester)
                bekreftelse.append(f"{hotellnavn}: {str(rom)}")
                if neste_i_liste_av_gjester == len(personer):
                    return bekreftelse

        manglerSeng = len(personer) - neste_i_liste_av_gjester
        if manglerSeng > 0: #hvis det er flere gjester igjen
            advarsel = f"\n\nAdvarsel! {manglerSeng} gjester vil mangle rom."
            bekreftelse.append(advarsel)

        return bekreftelse
