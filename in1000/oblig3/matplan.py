#programmet skal la bruker skrive inn nanvnet til en beboer
#og deretter vise liste over hva en beboer skal spise til hvert måltid

#ordbok som består av nøkkelverdi og liste med innholdsverdi (tilhørende nøkkelverdi)
#nøkkelverdi er navn på beboer mens innholdsverdi er mat
beboere = {"kari nordmann":["brød", "egg", "pølse"],
            "gunnard halvardsen":["knekkebrød", "grøt", "kjøttkaker"],
            "tone malmby":["nudler", "pannekaker, kylling"],
            "kathrine li":["banan", "musli", "peking duck"],
            "kjetil blekkmyr":["yoghurt", "lefse", "laks"]}

def matplan():
    #eller: x = beboere.keys()
    for x in beboere: #viser liste over alle nøkkelverdier i ordboken, en for en
        print(x) #skriver ut liste av beboer til terminalen
    n = input("Skriv inn navnet til en beboer: ").lower()
    if n in beboere:
        print(beboere.get(n)) #finner frem innholdsverdien i ordboka tilsvarende spesifisert nøkkelverdi
    else:
        print("Denne beboeren er ikke registrert hos oss.") #printes ut hvis beboer ikke er i ordboken

matplan()

#4.3:
"""
a)  mengde ekl. ekte navnet til studentene,
    fordi mengde er en uordnet samling av unike verdier.
    ingen in1000 student har samme brukernavn bokstav for bokstav.
    ordbok kan være lurt hvis brukernavn skal kunne bindes til
    studentenes ekte navn.
b)  ordbok, fordi det består av nøkkelverdier og variabelverdier
    liste er bare en samling av verdier og gir blaffen i alt annet,
    og kan ikke binde to verdier som ordbok gjør. brukernavn blir
    nøkkelverdi mens poeng på innlevering 3 blir variabelverdi.
c)  liste, fordi det kan være en lotto vinner flere ganger
d)  ordbok, for å oversikt over hvilke gjester som er allergisk mot hva
"""
