#include "./projUI.h"

struct examStruct
{
	char examQuestion[255];
	char examChoices[4][255];
	char examAnswer;
};

int main(int argc, char *argv[])
{
	system("CLS");
	FILE *fp = fopen(argv[1], "rb");
	examStruct *mExam = NULL;
	int i = 0, N;
	char asciiVal = 65;
	
	if (argc != 2)
	{
		setPalette("RED");
		createDlgBox("", "Invalid usage. Syntax: appendExam <filename>.<extension>", ".", "ps");
		setPalette("WHITE");
		return 1;
	}
	
	if (!fp)
	{
		setPalette("RED");
		createDlgBox(argv[1], "doesn't exist", "!", "sp");
		setPalette("WHITE");
		return 1;
	}
	
	fread(&N, sizeof(int), 1, fp);
	mExam = (examStruct*)malloc(sizeof(examStruct) * N);
	if (!mExam)
	{
		setPalette("RED");
		createDlgBox("", "There was an error initializing memory to the mExam structure", "!", "sp");
		setPalette("WHITE");
		return 1;
	}
	fread(mExam, sizeof(examStruct), N, fp);
	i = N;
	
	fp = fopen(argv[1], "wb");
	while (true)
	{
		mExam = (examStruct*)realloc(mExam, sizeof(examStruct) * (i + 1));
		if (!mExam)
		{
			setPalette("RED");
			createDlgBox("", "There was an error allocating memory to the mExam structure", "!", "sp");
			setPalette("WHITE");
			return 1;
		}
		setPalette("BLUE");
		cout << "Question [" << i + 1 << "] ";
		setPalette("WHITE");
		cin.getline(mExam[i].examQuestion, 255);
		if (!strcmp(mExam[i].examQuestion, "/stop"))
			break;
		for (int j = 0; j < 4; j++)
		{
			setPalette("GREEN");
			cout << "[" << asciiVal <<"]";
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
	setPalette("WHITE");
	createDlgBox(argv[1], "Changes saved to", ".", "ps");
	return 0;
}
	
	
