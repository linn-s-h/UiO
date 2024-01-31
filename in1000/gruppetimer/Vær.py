
vær = input("Hei! Er det sol eller regn i dag?\n").lower()
if vær != "regn" and vær != "sol":
    print("Feil vaer")

klær = input("Men har du på deg t-skjorte eller regnjakke da?\n").lower()
if klær != "t-skjorte" and klær != "regnjakke":
    print("Feil klaer")

if vær == "sol":
    if klær == "regnjakke":
        print("Du blir svett! Kanskje du burde ha på deg litt mindre.")
    elif klær == "t-skjorte":
        print("Perfekt for været!")


elif vær == "regn":
    if klær == "t-skjorte":
        print("Du blir våt! Ta med deg paraply i hvert fall...")
    elif klær == "regnjakke":
        print("Perfekt for været!")
