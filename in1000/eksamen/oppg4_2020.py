
class Emne:

    #a)
    def __init__(self, emnekode, studenter, rettere):
        self._emnekode = emnekode
        self._registrerte_studenter = studenter
        self._rettere = rettere

    #b)
    def meny(self):
        print(f"Emnet: {self._emndekode}. Følgende kommandoer:")
        print("O: Ny oblig")
        print("F: Frist ute, start retting")
        print("L: Lag eksamsnliste")
        print("A: Avslutt\n")

    def adminstrer(self):
        self._meny()
        kommando = input(" ").strip().upper()
        if kommando == "O":
            _opprettOblig()
        elif kommando == "F":
            _startRetting()
        elif kommando == "L":
            _skrivEksamensListe()
        elif:
            exit()
        else:
            print("Ukjent kommando. Prøv igjen.")
            self._meny()
            kommando = input(" ").strip().upper()

class Student:

    #c)
    def __init__(self, brukernavn, fullt_navn):
        self._brukernavn = brukernavn
        self._fullt_navn = fullt_navn
        self._obliger = {} #verdi i ordboken er obligens resultat godkjent(1) eller underkjent(0)

    def registrer(self, oblig, resultat):
        self._obliger[oblig] = resultat #setter verdi til resultat

    def altGodkjent(self, antObliger):
        if antObliger > len(self._obliger): #student har ikke levert alle obliger
            return False
        for oblig in self._obliger:
            if not self._obliger[oblig] == 1:
                return False
        return True

class Retter:

    #d)
    def __init__(self, brukernavn):
        self._retters_brukernavn = brukernavn

    def vurder(self, filnavn):
        return 1

class Oblig:

    #e)
    def __init__(self, id, frist):
        self._oblig_id = id
        self._leverings_frist = frist
        self._rette_status = False

    def klarForRetting(self, dagens_dato):
        if dagens_dato > self._leverings_frist:
            if not self._rette_status:
                return True
        return False

        #student1 obl1student1.txt
    def hentBesvarelser(self):
        fil = self._oblig_id + ".txt" #student1 obl1student1 -> student1 obl1student1.txt
        alleBesvarelser = open(fil, "r") #åpner fil
        besvarelser = {}
        for linje in alleBesvarelser:
            data = linje.split() #separerer student1 og obl1student1.txt fra hverandre
            if len(data) > 1: #kan hende at besvarelse mangler
                brukernavn = data[0]
                besvarelse = data[1]
                besvarelser[brukernavn] = besvarelse
        alleBesvarelser.close()
        return besvarelser

    def fordelRetting(self):
        pass
