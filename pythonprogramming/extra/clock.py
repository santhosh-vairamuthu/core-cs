hour=float(input("Enter the Time in hours : "))
mi=float(input("Enter the Time in minutes : "))
hour=float(30*hour);
temp=mi
mi=float(6*mi);
temp=temp/60.0
hour+=temp*30.0
angle = abs(hour - mi)
print("The angle between hands of a cock is "+str(angle)+" degrees")