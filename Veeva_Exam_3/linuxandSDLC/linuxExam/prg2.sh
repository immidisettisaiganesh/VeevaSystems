#!/bin/bash

echo "Enter file name:"
read filename

result=$(find / -type f -name "$filename" 2>/dev/null)

if [ -n "$result" ]; then
    echo "File exists at:"
    echo "$result"
else
    echo "File not found in system."
fi
