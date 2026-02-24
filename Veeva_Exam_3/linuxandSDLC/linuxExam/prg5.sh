#!/bin/bash

echo "Files larger than 1KB with details:"

find . -maxdepth 1 -type f -size +1k -exec ls -lh {} \;
