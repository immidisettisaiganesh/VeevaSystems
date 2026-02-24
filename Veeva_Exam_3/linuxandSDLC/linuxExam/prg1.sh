#!/bin/bash

echo "Enter file name:"
read filename

if [ -f "$filename" ]; then
    echo "File exists in current directory."
else
    echo "File does not exist in current directory."
fi
