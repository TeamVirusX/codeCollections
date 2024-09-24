#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <iomanip>
#include <time.h>
#include <windows.h>
#include <cstring>
#include <cstdio>
using namespace std;
/*
	[Coded by Raven for CC-103 Project]
	checkLength | Checks the character length of the subject and the prompt and adds 1 for punctuation.
	setPalette | uses Windows.h to change the text color within the console.
				Color values reference: https://cplusplus.com/forum/beginner/54360/
	clearScreen | Uses the Windows DOS command "cls" to clear the console screen.
	createDlgBox | Refer to the about section of the paper for complete explanation.
*/
int checkLength(char *subject, char *prompt) {
    int i = 0, j = 0;
    while (subject[i])
        i++;
    while(prompt[j])
        j++;
    return (i + j) + 1; // Added 1 for punctuation.
}

void setPalette(string colorName) 
{
    HANDLE color = GetStdHandle(STD_OUTPUT_HANDLE);
    int converted;
	if (colorName == "BLUE") {
        converted = 1;
    } else if (colorName == "GREEN") {
        converted = 2;
    } else if (colorName == "RED") {
        converted = 4;
    } else if (colorName == "LIGHTGRAY") {
        converted = 7;
    } else if (colorName == "LIGHTGREEN") {
        converted = 10;
    } else if (colorName == "LIGHTRED") {
        converted = 12;
    } else if (colorName == "YELLOW") {
        converted = 14;
    }
	else
	{
		converted = 15;
	}

    SetConsoleTextAttribute(color, converted);
}

void clearScreen()
{
	// Might as well use "cls" DOS Command to clear the screen
	system("CLS");
}


void createDlgBox(char *subject, char *prompt = "", char *punctuation = ".", char *arrangement = "sp") {
   	
    int totalCharLength = checkLength(subject, prompt) + 5; // Checks the total length of subject and prompt plus allowance characters.
    for (int column = 0; column < 5; column++) {
        int row = 0;
		// It will print a dash character in the first and last column
        if (column == 0 || column == 4) {
            while (row < totalCharLength) {
                cout << "-";
                row++;
            }
            cout << endl;
        } 
        // In the middle columns, it will print a vertical line in the beginning and end, snd whitespace for the rest.
		else if (column == 1 || column == 3) {
            while (row < totalCharLength) {
                if (row == 0 || row == totalCharLength - 1) {
                    cout << "|";
                } else {
                    cout << " ";
                }
                row++;
            }
            cout << endl;
        } else {
        	// sp parameter means "Subject to Prompt" otherwise "Prompt to Subject" by default
            if (arrangement == "sp") {
                cout << "| " << subject << " " << prompt << punctuation << " |"  << endl;               
            } else {
                cout << "| " << prompt << " " << subject << punctuation << " |"  << endl;
            }
        }
    }
}
