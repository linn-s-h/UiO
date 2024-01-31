svar = input("Hva vil du laere?\n")
studentnavn = ""
if svar.lower() == "y":
    studentnavn = input("Hva er navnet ditt?\n")
print(f"Men, {studentnavn}. " + "Det er andre maater aa bruke konkatinering av strenger.")
