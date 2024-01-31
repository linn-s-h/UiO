from student_med_navn import StudentMedNavn

def hovedprogram():
    # tester klassen Student_med_navn
    stud = StudentMedNavn("Einstein")

    stud.skriv_ut()                 # Er innholdet som forventet og fungerer skriv_ut?
    assert stud.hent_poeng() == 0   # Ble objektet opprettet med forventet poengsum?

    stud.registrer_poeng(5)
    assert stud.hent_poeng() == 5   # Ble antall poeng oppdatert som forventet?
    stud.skriv_ut()                 # Er innholdet fortsatt som forventet i skriv_ut?

hovedprogram()