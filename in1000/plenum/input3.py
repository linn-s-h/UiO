voksen = input("Er du voksen? ")
gravid = input("Er du gravid? ")

if voksen == "ja":
    if gravid == "nei":
        print("Ta karusellen")
    else:
        print("Dessverre, det kan være farlig")
else:
    print("Kom tilbake naar du har blitt eldre!")
