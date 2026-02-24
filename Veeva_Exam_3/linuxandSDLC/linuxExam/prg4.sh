#!/bin/bash

# Script to check files with specific extension
# in current directory

echo "Enter file extension (example: txt, sh, java):"
read extension

echo "Files with .$extension extension in current directory:"

files=$(ls *.$extension 2>/dev/null)

if [ -z "$files" ]; then
    echo "No files found with .$extension extension."
else
    echo "$files"
fi
