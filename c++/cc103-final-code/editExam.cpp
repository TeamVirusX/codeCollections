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
	if (argc != 3)
	{
		setPalette("RED");
		createDlgBox("", "Invalid usage. Syntax: editExam <filename>.<extension> <question-to-be-edited>", ".", "ps");
		setPalette("WHITE");
		return 1;
	}
	FILE *fp = fopen(argv[1], "rb");
	examStruct *mExam = NULL;
	int i = 0, N, editIdx = atoi(argv[2]) - 1;
	char asciiVal = 65;
	
	if (!fp)
	{
		setPalette("RED");
		createDlgBox(argv[1], "doesn't exist", ".", "sp");
		setPalette("WHITE");
		return 1;
	}
	
	fread(&N, sizeof(int), 1, fp);
	mExam = (examStruct*)malloc(sizeof(examStruct) * N);
	
	if (editIdx > N)
	{
		setPalette("RED");
		createDlgBox(argv[1], "The question you are trying to edit is more than the questions of", ".", "ps");
		setPalette("WHITE");
		return 1;
	}
	if (!mExam)
	{
		setPalette("RED");
		createDlgBox("", "There was an error allocating memory", ".", "ps");
		setPalette("WHITE");
		return 1;
	}
	fread(mExam, sizeof(examStruct), N, fp);
	fclose(fp); // 
	fp = fopen(argv[1], "wb");
	setPalette("BLUE");
	cout << "[" << editIdx + 1<< "] ";
	setPalette("WHITE");
	cin.getline(mExam[editIdx].examQuestion, 255);
	for (int j = 0; j < 4; j++)
	{
		setPalette("GREEN");
		cout << "[" << asciiVal <<"] ";
		setPalette("WHITE");
		cin.getline(mExam[editIdx].examChoices[j], 255);
		asciiVal++;
	}
	cout << "[ANSWER] ";
	setPalette("WHITE");
	cin >> mExam[editIdx].examAnswer;
	cin.ignore();
	
	
	fwrite(&N, sizeof(int), 1, fp);
	fwrite(mExam, sizeof(examStruct), N, fp);
	fclose(fp);
	free(mExam);
	clearScreen();
	setPalette("WHITE");
	createDlgBox(argv[1], "Changes saved to", ".", "ps");
	return 0;
}