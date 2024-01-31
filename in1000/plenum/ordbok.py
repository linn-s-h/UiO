
land = input("Skriv et land i nordre skandinavia ")
if land == "Norge":
    print("Oslo")
    print("Byen ved fjorden")
if land != "Norge":
    print("Kunne ikke bryd meg mindre")


land = input("Skriv et land i nordre skandinavia! ").lower()
ordbok = {"norge":"oslo", "sverige":"stockholm"}
by = ordbok[land]
print(by)
