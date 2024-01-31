"""
dette programmet viser eksempel på if-setninger - valg av brus
og printer ut respons utifra svar ja eller nei
"""

#splitter handlingen i tre alternativer avhengig av input fra bruker
brus = input("Vil du ha en brus?\n") #spør bruker om input
if brus.lower() == "ja":
    print("Her har du en brus!") #printer denne beskjeden hvis bruker svarer ja
elif brus.lower() == "nei": #skriver elif sånn at else knyttes til begge linjer
    print("Den er grei.") #printer annen beskjed hvis bruker svarer nei
else:
    print("Det forstod jeg ikke helt...") #printer beskjed om at programmet ikke kjenner igjen input
