from turtle import *

shape('turtle')
shapesize(2)
bgcolor('darkblue')
color('yellow')

def polylines(sides, length, angle):
    for i in range(sides):
        forward(length)
        right(angle)

def spiral(sides, length, angle):
    for i in range(sides):
        forward(length)
        right(angle)
        length = length + 5

spiral(100, 5, 125)
