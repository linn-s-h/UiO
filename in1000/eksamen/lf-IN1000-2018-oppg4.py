                                                                                # Løsningsforslaget bruker konstruksjoner brukt i forelesninger og obliger.
# Andre objektorienterte løsninger aksepteres om de fungerer.

# 4a) class Rett 10 p
class Rett :
	def __init__(self, navn, pris, innhold):
		self._navn = navn
		self._pris = pris
		self._innhold = innhold
		
	def sjekkInnholdOk (self, unngaa):
		for innh in self._innhold :
			if innh in unngaa :
				return False
		return True
		
	def __str__ (self):
		s = ("Rett: " + self._navn + ". Pris: " 
            + str(self._pris) + ". Innhold:")
		for i in self._innhold :
			s +=  " " + i
		return s


#4b) class Kategori 5 p
class Kategori :
	def __init__(self, katNavn, retter):
		self._kNavn = katNavn
		self._retter = retter
		
	def hentOkRetter (self, unngaa):
		okRetter = []
		for r in self._retter :
			if r.sjekkInnholdOk(unngaa):
				okRetter.append(r)
		return okRetter
		
	def skrivKategori(self):
		print(self._kNavn + ":")
		for rett in self._retter :
			print(rett)

#4c) class Meny 10 p
class Meny :
	def __init__(self, katNavnListe):
		self._kategorier = {}
		for knavn in katNavnListe :
			nyKat = self._lesKategoriFil (knavn+".txt")
			self._kategorier[knavn] = nyKat
		
	def hentRedusertMeny(self, unngaa):
		okKategorier = {}
		for knavn in self._kategorier :
			retter = self._kategorier[knavn].hentOkRetter(unngaa)
			if retter  :
				nyKat = Kategori(knavn, retter)
				okKategorier[knavn] = nyKat
		return okKategorier
		
# Denne metoden skulle ikke skrives på eksamen. Leser én kategori:
	def _lesKategoriFil(self, kNavn):
		katfil = open(kNavn)
		retter = []
		for linje in katfil:
			linje = linje.split()
			retter.append(Rett(linje[0], linje[1], linje[2:]))
		nyKat = Kategori(kNavn, retter)
		katfil.close()
		return nyKat
	
#4d) class Kunde 8 poeng
class Kunde :
	def __init__(self, tlf, unngaa):
		self._tlf = tlf
		self._unngaa = unngaa
		
	def velgRetter(self, meny):
		kategorier = meny.hentRedusertMeny(self._unngaa)
		bestilling = []
		for k in kategorier.values():
			k.skrivKategori()
			valg = input("Skriv inn ønsket rett med kommentarer, eller tom linje: ")
			if valg != "" :
				bestilling.append(valg)
		return bestilling
		
#4e)	 class TakeAway 7 poeng
class TakeAway :
	def __init__(self, kategorier, kundefilnavn):
		self._meny = Meny(kategorier)
		self._kundekatalog = self._lesKundefil(kundefilnavn)
	
	def betjenKunde (self, kundeTlf):
		kunde = self._kundekatalog[kundeTlf]
		bestilling = kunde.velgRetter(self._meny)
		self._lagOgLeverMat(bestilling)
		
	def _lagOgLeverMat(self, bestilling):
		print("Følgende er bestilt: ")
		for bestillingstekst in bestilling :
			print(bestillingstekst)
			
# Denne metoden skulle ikke skrives på eksamen:
	def _lesKundefil(self, kundefilnavn):
		kunder = {}
		kundefil = open(kundefilnavn, "r")
		for linje in kundefil:
			data = linje.strip().split()
			kunder[data[0]] = Kunde(data[0], data[1:])
		kundefil.close()
		return kunder

#4f)	 Hovedprogram: 5 poeng
def hovedprogram():
	mineKategorier = ["Forretter", "Hovedretter", "Desserter"]
	minTakeAway = TakeAway(mineKategorier, "kunder.txt")
	kundeId = input("Oppgi telefonnr: ")
	while kundeId != "" :
		minTakeAway.betjenKunde(kundeId)
		kundeId = input("Oppgi telefonnr: ")
		
hovedprogram()
