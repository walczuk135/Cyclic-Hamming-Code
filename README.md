# Cyclic-Hamming-Code
> Program generate hamming code for the given binary data. And also check and correct error in received hamming cyclic code.

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info
The program encodes and decodes messages with a case of Hamming codes (7.4) with two generating functions:
* x ^ 3 + x + 1
* x ^ 3 + x ^ 2 + 1

The program supports error control, you can only encode a message that has no more and no less 3-bits. You can only decode a message that has no more than 7 bits.
## Screenshots
![Example screenshot](https://github.com/walczuk135/Cyclic-Hamming-Code/blob/master/Example%20cyclic%20code.PNG)

## Technologies
* Java - version 8++
* Swing
* Maven

## Setup
You must have jdk or jre 8 ++ installed to run this project

## Status
Project is:  _finished_

## Inspiration
The program was created as an application to be credited to universities.

## Contact
Created by [@walczuk135](walczuk135@gmail.com) - feel free to contact me!
