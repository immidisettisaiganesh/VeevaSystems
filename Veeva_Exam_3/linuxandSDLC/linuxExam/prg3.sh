#!/bin/bash

# Script to find files modified within last 3 days
# in the current directory

echo "Files modified in the last 3 days:"

find . -type f -mtime -3
