#include "./projUI.h"
struct examStruct
{
	char examQuestion[255];
	char examChoices[4][255];
	char examAnswer;
};

struct studentStruct
{
	char studentNum[15];
	char firstName[50];
	char lastName[50];
	char course[15];
};

// These functions below are based on Sir Carranza's lecture video.
void initialize(int *tempAr, int n, int val = 0) 
{ 
	for( int i = 0; i<n; i++)
	{
		tempAr[i] = val;
	}
	return;	
}

bool checkDuplicate(int value, int *tempArray, int size)
{
    for(int i = 0; i < size; i++)
    {
        if(value == tempArray[i])
        {
            return true;
        }
    }
    return false;    
}

int* generateRandomArray(int size, int limit)
{
    static int *array = NULL;
    int i = 0;
    array = new int[size];
    initialize(array, size, -1);
    srand(time(0));
    limit = size;
    while(i < size)
    {
        int randomNumber;
        randomNumber = rand() % limit;
        if(!checkDuplicate(randomNumber, array, size))
        {
            array[i] = randomNumber;
            i++;
        }
    }
    return array;
}

char toUpper(char ch){
    if(ch>= 97 && ch<= 97+26)
	{
    	ch = ch - 32;	
	}
    return ch;
}

int main(int argc, char *argv[])
{
	// Directly using fopen() instead of initializing NULL on *fp
	FILE *fp = fopen(argv[1], "rb"), *scoreFp = NULL;
	examStruct *mExam = NULL;
	studentStruct mStudent;
	int *arx = NULL, N, i, score = 0, limit;
	char correctAns, asciiVal = 65;
	
	if (argc != 2)
	{
		setPalette("RED");
		createDlgBox("", "Invalid usage. Syntax: doExam <filename>.<extension>", ".", "ps");
		setPalette("WHITE");
	}
	
	if (!fp)
	{
		setPalette("RED");
		createDlgBox(argv[1], "doesn't exist'", ".", "ps");
		setPalette("WHITE");
	}
	setPalette("BLUE");
	cout << "[Student Number (2x-xx-xxxx)] ";
	setPalette("WHITE");
	cin >> mStudent.studentNum;
	setPalette("BLUE");
	cout << "[Course Program] ";
	setPalette("WHITE");
	cin >> mStudent.course;
	setPalette("BLUE");
	cout << "[First Name] ";
	setPalette("WHITE");
	cin.ignore();
	cin.getline(mStudent.firstName, 50);
	setPalette("BLUE");
	cout << "[Last Name] ";
	setPalette("WHITE");
	cin.getline(mStudent.lastName, 50);
	// Recheck this line when an error arises.
	fread(&N, sizeof(int), 1, fp);
	mExam = (examStruct*) malloc (sizeof(examStruct) * N);
	
	if (!mExam)
	{
		setPalette("RED");
		createDlgBox("", "There was an error allocating mExam structure", ".", "ps");
		setPalette("WHITE");
		return 1;
	}
	
	fread(mExam, sizeof(examStruct), N, fp);
	arx = (int*) malloc(sizeof(int) * N);
	limit = N; // Gets the number of iterations to know the limit.
	arx = generateRandomArray(N, limit);
	
	for (i = 0; i < N; i++)
	{
		int randNum = arx[i];
		setPalette("BLUE");
		cout << "[" << i + 1 << "] ";
		setPalette("WHITE");
		cout << mExam[randNum].examQuestion << endl;
		for (int j = 0; j < 4; j++)
		{
			setPalette("GREEN");
			cout << "[" << asciiVal << "]";
			setPalette("WHITE");
			cout << mExam[randNum].examChoices[j] << endl;	
			asciiVal++;	
		}
		asciiVal = 65;
		cout << "[ANSWER] ";
		setPalette("GREEN");
		cin >> correctAns;
		correctAns = toUpper(correctAns);
		if (correctAns == mExam[randNum].examAnswer)
		{
			setPalette("GREEN");
			cout << correctAns << " is correct." << endl;
			score++;
		}
		else
		{
			setPalette("RED");
			cout << correctAns << " is incorrect." << endl;
		}
		cin.ignore();
	}
	if (score > (N / 2))
	{
		setPalette("GREEN");
		createDlgBox("", "You have PASSED the exam", "!", "ps");
		cout << "Score: " << score << " / " << N << endl;
		setPalette("WHITE");
	}
	else
	{
		setPalette("GREEN");
		createDlgBox("", "You have FAILED the exam", "!", "ps");
		cout << "Score: " << score << " / " << N << endl;
		setPalette("WHITE");
	}
	scoreFp = fopen("examScores.txt", "a");
	
	if (!scoreFp)
	{
		createDlgBox("", "There was an error while storing your scores.", "!", "sp");
		return 1;
	}
	
	char total[3];
	sprintf(total, "%d", score);
	
	cout << "\nStudent No." << setw(15) << "Course" << setw(15) << "Last Name" << setw(15) << "First Name"
		<< setw(15) << "Score\n" << mStudent.studentNum << setw(15) << mStudent.course << setw(15) << mStudent.lastName
		<< setw(15) << mStudent.firstName << setw(15) << total;
	fprintf(scoreFp, "%s \t %s \t %s \t %s \t %s/%d \t %s \n", mStudent.studentNum, mStudent.course, 
		mStudent.lastName, mStudent.firstName, total, N, argv[1]);
	fclose(fp);
	fclose(scoreFp);
	free(mExam);
	free(arx);
	return 0;	
	
	
}
