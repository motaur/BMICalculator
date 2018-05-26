# BMI Calculator
Assignment 2 Android - BMI Calculator


## Goal: 
Study basics of android development. Writing an Android mobile application that will be able to calculate BMI and ideal weight of person when his weight, height, age, body frame are known.
By doing so we learn how to build mobile application using Android Studio.

## Formulas:
BMI = weight in kilos / height in metres^2

BMI                     Weight Status 
Below 15	        Anorexic
15 - 18.5               Underweight 
18.5 – 24.9             Normal 			     
25.0 – 29.9 	        Overweight 
30.0 - 35               Obese
Above 35	        Extreme Obese

body-frame	      slimness:
small:  		0.9
medium: 		  1
large:  		1.1
    
   ideal weight in kilos = (height - 100 + (age / 10)) * 0.9 * slimness - for men
   ideal weight in kilos = (height - 110 + (age / 10)) * 0.85 * slimness - for women

## Classes:
MainActivity.java - this class starts up the GUI with all components placed into it.
DisplayData.java - the second activity for dispalayig results

## How to Use:
Chose gender by using Radio button, choose height, weight and age using seek bars, choose body frame by using spinner. Push 'SUBMIT' button. Press back arrow to go back to main activity.
Do this as many times as you wish for various calculations.

## Prerequisites:
Android 4.0.03 (Ice Cream Sandwich) is required for running the application.

## How to run:
Install 'BMI Calculator.apk' on your mobile Android device, click on the icon.



