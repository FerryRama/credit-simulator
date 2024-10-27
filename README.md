# Vehicle Loan Calculator
This is a Java console application that calculates monthly installments for vehicle loans. The application can handle different types of vehicles and loan conditions, and it can be run interactively or using an input file.

## Features
- Supports calculations for both new and used vehicles.
- Calculates monthly installments based on user inputs.
- Interest rates vary based on vehicle type and condition.
- Supports reading input from a file or interactively.
- Interest Year On Year increase 0,5% every 2 year. 
- Interest Year On Year increase 0,1% every 1 year.
- Tenor Cannot more than 6 years.
- Jumlah DP Mobil/Motor Baru >= 35% Jumlah Pinjaman
- Based Interest Rate : Mobil = 8% | Motor = 9%
~~~
RUN :
Compile File Using this command:
- javac -d bin src/**/*.java
Running Manual Command
- cd bin
- java com.simulator.Main /  java com.simulator.Main file_input.txt
~~~
~~~
Other Otional Application should be run use syntax like
*Must Compile First for running this command*
$ ./credit_simulator.sh
$ ./credit_simulator.sh file_inputs.txt
~~~
~~~
Example file_input.txt format :
VehicleType,Vehicle Condition,Vehicle Years,Jumlah Pinjaman,Tenor,DP
Mobil,Baru,2023,50000000,5,20000000
Motor,Bekas,2021,30000000,3,7500000
~~~
~~~
Running On Docker Tutorial
Build Image
- docker build -t credit-simulator . 
Running Container Docker
- docker run -it credit-simulator  

Other For Using file_input.txt
Running Container
- docker run -it -v $(pwd):/app credit-simulator /bin/sh
Put Command this for running using file_input.txt
- java com.simulator.Main file_input.txt