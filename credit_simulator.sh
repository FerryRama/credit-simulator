#!/bin/sh

# Navigate to the directory where your compiled Java classes are located
cd bin

# Check if an argument (input file) is provided
if [ "$#" -eq 1 ]; then
    # Run the Java application with the provided input file
    java com.simulator.Main "$1"
else
    # Run the Java application interactively
    java com.simulator.Main
fi