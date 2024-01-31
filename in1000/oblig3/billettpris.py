#dette programmet skal beregne billettpris utifra kjøperens alder
#deretter skal jeg teste om programmet utføres riktig med 15, 31 og 63 som input
def prosedyre():
    alder = int(input("Hva er alderen din? "))
    billettpris = 0

    if alder <= 17:
        billettpris = 30
    elif alder > 17: #oppgaven spør kun om "over 17" for denne setningen
        billettpris = 50
    elif alder >= 63:
        billettpris = 35
    print("Billettprisen er", billettpris, "kroner")

prosedyre()

"""
Den første elif setiningen sjekker bare om input alder
er større enn 17. Siden 63 er større enn 17, gir dette true
og programmet vil ikke sjekke neste elif setning, men vil istedenfor
stoppe her. Dette betyr at feil billettpris blir skrevet ut til kjøper.
"""
