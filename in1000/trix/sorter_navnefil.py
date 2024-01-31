personer = []
hunder = []

min_fil = open("navn.txt")
for linje in min_fil:
    if linje[0] == "H":
        hunder.append(linje[2:-1]) #tallet 2 indikerer startposisjon i strengen og
    elif linje[0] == "P":
        personer.append(linje[2:-1]) #-1 indikerer den neste siste posisjonen, indeks 9
    else:
        print("Feil i linjeformat:\n", linje)

min_fil.close()

print("Personer")
print(personer)
print("\n\nHunder")
print(hunder)
