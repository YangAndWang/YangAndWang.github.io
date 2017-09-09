#!/bin/bash

name=$1
name=${name%.tex}
echo $name

latex $name && xdvipdfmx $name

