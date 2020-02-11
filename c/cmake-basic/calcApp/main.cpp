/*
 * main.cpp
 *
 *  Created on: 10 Feb 2020
 *      Author: Andy Gibson
 */


#include <iostream>
#include "calc/Calc.h"


int main() {
	Calc calc;
	std::cout << "Hello World 12+1 = " << calc.add(12,1) << "\n";
}
