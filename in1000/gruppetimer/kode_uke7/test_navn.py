from navn import Navn

def hovedprogram():
	navn1 = Navn("Siri", "Moe", "Jensen")
	navn2 = Navn("Geir", "Kjetil", "Sandve")

	print (navn1.sortert())
	print (navn2.sortert())
	print (navn2.naturlig())
	
	navn3 = Navn("Siri", "Moe", "Jensen")
	
	assert(navn1.sortert() != navn2.sortert())
	assert(navn1.sortert() == navn3.sortert())

hovedprogram()
