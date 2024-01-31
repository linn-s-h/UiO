#et program som sjekker om et tall er et partall eller et oddetall
tall = int(input("Skriv inn et heltall: "))
if tall % 2 == 0:
    print(str(tall), "er et partall")
else:
    print(str(tall), "er et oddetall")
