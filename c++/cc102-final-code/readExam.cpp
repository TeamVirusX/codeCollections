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
		createDlgBox("", "Invalid usage. Syntax: readExam <filename>.<extension>", ".", "ps");
		setPalette("WHITE");
		return 1;
	}
	
	if (!fp)
	{
		setPalette("RED");
		createDlgBox(argv[1], "doesn't exist'", ".", "ps");
		setPalette("WHITE");
		return 1;
	}
	
	fread(&N, sizeof(int), 1, fp);
	mExam = (examStruct*)malloc(sizeof(examStruct) * N);
	if (!mExam)
	{
		setPalette("RED");
		createDlgBox("", "There was an error allocating memory", ".", "ps");
		setPalette("WHITE");
		return 1;
	}
	fread(mExam, sizeof(examStruct), N, fp);
	
	for (i = 0; i < N; i++)
	{
		setPalette("BLUE");
		cout << "[" << i + 1 << "] ";
		setPalette("WHITE");
		cout <<  mExam[i].examQuestion << endl;
		for (int j = 0; j < 4; j++)
		{
			setPalette("LIGHTGREEN");
			cout << "[" << asciiVal << "] ";
			setPalette("WHITE");
			cout << mExam[i].examChoices[j] << endl;
			asciiVal++;
		}
		asciiVal = 65;
		cout << "[CORRECT ANSWER] ";
		setPalette("GREEN");
		cout << mExam[i].examAnswer << endl;
	}
	
	free(mExam);
	fclose(fp);
	return 0;
}