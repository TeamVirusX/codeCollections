#include "./projUI.h"

struct examStruct
{
	char examQuestion[255];
	char examChoices[4][255];
	char examAnswer;
};

int main(int argc, char *argv[])
{
	clearScreen();
	FILE *fp = fopen(argv[1], "rb");
	examStruct *mExam = NULL;
	int i = 0, N;
	char asciiVal = 65;
	if (argc != 2)
	{
		setPalette("RED");
		createDlgBox("", "Invalid usage. Syntax: createExam <filename>.<extension>", ".", "ps");
		setPalette("WHITE");
		return 1;
	}
	
	if (fp)
	{
		char owChoice;
		setPalette("YELLOW");
		createDlgBox(argv[1], "already exists, do you want to overwrite", "?", "sp");
		setPalette("LIGHTGRAY");
		cin >> owChoice;
		cin.ignore();
		if (owChoice != 'Y' && owChoice != 'y')
			return 1;
		setPalette("WHITE");
	}
	
	fp = fopen(argv[1], "wb");
	clearScreen();
	setPalette("LIGHTGREEN");
	createDlgBox("", "CREATE EXAM", " ","sp");
	while (true)
	{
		mExam = (examStruct*)realloc(mExam, sizeof(examStruct) * (i + 1));
		if (!mExam)
		{
			setPalette("RED");
			createDlgBox("", "There was an error allocating memory", ".", "ps");
			setPalette("WHITE");
			return 1;
		}
		setPalette("BLUE");
		cout << "Question [" << i + 1 << "] ";
		cin.getline(mExam[i].examQuestion, 255);
		if (!strcmp(mExam[i].examQuestion, "/stop"))
			break;
		setPalette("WHITE");
		for (int j = 0; j < 4; j++)
		{
			setPalette("LIGHTGREEN");
			cout << "[" << asciiVal <<"] ";
			setPalette("WHITE");
			cin.getline(mExam[i].examChoices[j], 255);
			asciiVal++;
		}
		cout << "[ANSWER] ";
		setPalette("GREEN");
		cin >> mExam[i].examAnswer;
		cin.ignore();
		asciiVal = 65;
		i++;
	}
	N = i;
	fwrite(&N, sizeof(int), 1, fp);
	fwrite(mExam, sizeof(examStruct), N, fp);
	fclose(fp);
	free(mExam);
	clearScreen();
	setPalette("LIGHTGREEN");
	createDlgBox(argv[1], "is saved successfully", ".", "sp");
	return 0;
}