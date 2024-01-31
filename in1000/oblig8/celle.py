class Celle:
    # Konstruktør
    def __init__(self):
        self._status = "doed"
        self._naboer = []
        self._ant_levende_naboer = 0

    def sett_doed(self): #setter status av cellen til død
        self._status = "doed"

    def sett_levende(self): #setter status av cellen til levende
        self._status = "levende"

    def legg_til_nabo(self, nabo): #legger til nabocelle i liste av naboer
        return self._naboer.append(nabo)

    def er_levende(self): #returnerer cellens status om den er levende (True) eller ikke (False)
        return self._status == "levende"

    def hent_status(self):
        pass

    def hent_status_tegn(self): #metode som representerer celle status med tegn
        if self.er_levende():
            return "O" #levende celle representert med O
        return "." #død celle representert med .

    def tell_levende_naboer(self):
        antall_levende = [] #ny liste skal fylles med levende celler
        for celle in self._naboer: #itererer gjennom liste av naboer
            if celle.er_levende(): #hvis celle er levende
                antall_levende.append(celle) #legger til levende celle i liste

        self._ant_levende_naboer = len(antall_levende) #ant levende naboer er da lengden av listen

        #kunne gjort dette, men virker litt fy-fy:
        """
        self._ant_levende_naboer = 0
        for antall_levende in self._naboer:
            if antall_levende.er_levende() == True:
                self._ant_levende_naboer += 1

        return self._ant_levende_naboer
        """
    #metode består av nøstet if-setning som hopper til else hvis antall naboer
    #verken er mindre enn 2 eller større enn 3
    def oppdater_status(self):
        if self.er_levende():
            if self._ant_levende_naboer > 3:
                self.sett_doed()
            elif self._ant_levende_naboer < 2:
                self.sett_doed()
        else: #hvis cellen er dau i utgangspunket
            if self._ant_levende_naboer == 3: #cellen vil leve i neste generasjon
                self.sett_levende()             #hvis den har 3 naboceller
