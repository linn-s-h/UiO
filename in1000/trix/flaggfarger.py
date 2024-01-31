
def land_og_farger():

    flaggOrdbok = {"norge" : ["rødt", "hvitt", "blått"],
                "sverige" : ["blått", "gult"],
                "danmark" : ["rødt", "hvitt"],
                "finland" : ["hvitt", "blått"],
                "japan" : ["rødt", "hvitt"],
                "gabon" : ["grønt", "gult", "blått"],
                "storbritannia" : ["rødt", "blått", "hvitt"],
                "chile" : ["blått", "hvitt", "rødt"]}

    flaggOrdbok["thailand"] = "blått", "hvitt", "rødt"

    land = input("land: ")
    if land in flaggOrdbok:
        farge = input("farge: ")
        if land in flaggOrdbok:
            if farge in flaggOrdbok[land]:
                print(f"ja, fargen {farge} forekommer i {land}!")
            else:
                print(f"{farge} forkommmer ikke i flagget til {land}")
        else:
            print(f"{farge} forkommmer ikke i flagget til {land}")
    else:
        print(f"landet {land} er ikke registrert")


land_og_farger()
