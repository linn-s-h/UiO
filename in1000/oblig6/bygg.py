#klasse - et oppskrift på hvordan et objekt skal være, samling med egenskaper
#objekt - et eksemplar (instans av en klasse)
#klassedefinisjon - hva klassen inneholder (hele filen med Class)
#konkstruktør - setter parametere til å være lik argumentene og kalles automatsik med opprettelse av et objekt
#instansmetoder - metoder som kun objekter / klassen får lov til å bruke, metoder som fungerer på objektet
#instansvariabeler - variabler som blir husket på (for alltid), kun objekter i samme klasse får lov til å bruke
#grensesnitt - et sett med metoder objekter kan bruke
#innkapsling - gjemme bort implementasjonen

class Bygg:
    #konstruktøren starter opp et objekt, metoden blir kalt automatisk og kjører hver gang
    #konstruktør setter parametere til å være argumentene
    def __init__(self, farge, antall_etasjer): #konkstruktør / initialize
    #self -> bare klassen kan bruke denne metoden

        """Her sier vi hva et bygg skal inneholde:"""
        #instansvariabel som blir oppdatert og husket for alltid
        self._etasjer = antall_etasjer #varibeler som skal huske på verdi / vilkårlig variabel #_etasjer er instansvariabel
        self._farge = farge #i hele denne klassen her må jeg huske på farge og etasjer

        self._avdeling = []

    def skiftFarge(self, fargeskift): #grensesnitt skriftFarge
        self._farge = fargeskift

    def hentFarge(self): #instansmetode
        return self._farge
