person = input("konge: ")
etterkommere = {"oscar":"haakon", "haakon":"olav", "olav":"harald"}

barn = etterkommere[person]
barnebarn = etterkommere[barn] #eller barnebarn = etterkommere[etterkommere[barn]]

print("barnebarn: ", barnebarn)
