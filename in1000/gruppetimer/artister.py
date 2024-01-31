
artist = {"The Beatles":["Help!", "Revolver", "Abbey Road"],
            "Red Hot Chili Peppers":["By The Way", "Stadium Arcadium"],
            "Led Zeppelin":["Bipbop", "Zoomies"]}

x = artist.keys()
print(x)
inp = input("Skriv inn navnet på en artist: ").lower()
if inp in artist:
    print(artist[svar][0])
else:
    print("oh no")
