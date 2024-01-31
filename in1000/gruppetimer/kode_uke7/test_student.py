from student import Student

def hovedprogram():
    # tester klassen Student
    stud = Student()
    assert stud.hent_poeng() == 0

    stud.registrer_poeng(5)
    assert stud.hent_poeng() == 5

hovedprogram()