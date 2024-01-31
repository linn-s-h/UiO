from student_med_navn import StudentMedNavn

studenter_liste = []
studenter_liste.append(StudentMedNavn("Ole"))
studenter_liste.append(StudentMedNavn("Dole"))
studenter_liste.append(StudentMedNavn("Doffen"))

studenter_liste[0].registrer_poeng(3)
studenter_liste[0].registrer_poeng(5)
studenter_liste[0].registrer_poeng(5)
studenter_liste[0].registrer_poeng(6)

print("Studenter med nok poeng (fra liste):")
for student in studenter_liste:
    if student.hent_poeng() >= 19:
        student.skriv_ut()
