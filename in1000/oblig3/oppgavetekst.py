
#oppgavetekst:
"""
1.  Lag en liste med spørsmål du velger selv. Lag deretter en til liste med flere
    svaralternativer til hvert spørsmål som deltageren kan velge mellom.
2.  Lag enda en til liste, men denne skal bestå av riktig svar til hvert spørsmål.
    Pass på at riktig svar har samme index som spørsmålet og svaralternativet den tilhører.
3.  Bruk while-løkke for å lese inn svar fra bruker helt til alle spørsmål
    har blitt svart. Husk at spørsmål og svaralternativer skal printes ut.
    Skriv ut melding til deltager om svaret er korrekt eller ukorrekt.
"""

spoersmaal = ["Hvilken farge er vannmelon på innsiden?",
            "Hvilken farge er agurk på utsiden?",
            "Hvilken form har kloden vår?"]

alternativer = ["(a) Rosa\n(b) Blå\n(c) Rød",
                "(a) Fiolett\n(b) Grønn\n(c) Hvit",
                "(a) Sylinder\n(b) Kube\n(c) Kule"]

riktig_svar = ["c","b","c"]

i = 0 #gir den tallverdien 0 sånn at spoersmaal[0] kjøres først
while i < len(spoersmaal): #utfører løkken så lenge i er mindre enn lengden av lista, som er 3
    print(spoersmaal[i])
    print(alternativer[i])
    inp = input().lower()
    if inp == riktig_svar[i]:
        print("Riktig!")
    else:
        print("Feil!")
    i = i + 1 #gir i ny verdi sånn at programmet kan utføre neste spørsmål
                # --> spoersmaal[1] --> spoersmaal[2]
