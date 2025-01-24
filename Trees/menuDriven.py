print("1.Area of circle")
print("2.Circumference of circle")
print("3.Area of Rectangle")
print("4.Perimeter of Rectangle")
print("5.Area of Square")
print("6.Perimeter of Square")
ch=int(input("Enter your choice"))
if(ch==1):
    radius=int(input("Enter radius"))
    area=3.14*radius**2
    print("The area of circle is ",area)
elif(ch==2):
    radius=int(input("Enter radius"))
    circumference=2*3.14*radius
    print("The circumference of circle is ",circumference)
elif(ch==3):
    lenght=int(input("Enter length"))
    breadth=int(input("Enter breadth"))
    area=lenght*breadth
    print("Area of rectangle is ",area)
elif(ch==4):
    lenght=int(input("Enter length"))
    breadth=int(input("Enter breadth"))
    perimeter=2*(lenght+breadth)
    print("Perimeter of rectangle is ",perimeter)
elif(ch==5):
    side=int(input("Enter side"))
    area=side*side
    print("Area of square is ",area)
elif(ch==6):
    side=int(input("Enter side"))
    perimeter=4*side
    print("Perimeter of square is ",perimeter)
else:
    print("Entered number is invalid")