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
    examStruct *mExam = nullptr;
    int i = 0, N;
    char asciiVal = 65;
    if (argc != 3)
    {
        setPalette("RED");
        createDlgBox("", "Invalid command. Syntax: deleteqExam <filename>.<extension> <question-to-be-deleted>", ".", "ps");
        setPalette("WHITE");
        return 1;
    }

    if (!fp)
    {
        setPalette("RED");
        createDlgBox("", "File does not exist!", ".", "ps");
        setPalette("WHITE");
        return 1;
    }

    fread(&N, sizeof(int), 1, fp);
    mExam = (examStruct *)malloc(sizeof(examStruct) * N);
    if (!mExam)
    {
        setPalette("RED");
        createDlgBox("", "Allocation Error!", ".", "ps");
        setPalette("WHITE");
        return 1;
    }
    fread(mExam, sizeof(examStruct), N, fp);
    fclose(fp);

    int index = atoi(argv[2]);
    index = index - 1;
    for (i = index; i < N - 1; i++)
    {
        strcpy(mExam[i].examQuestion, mExam[i + 1].examQuestion);
        for (int j = 0; j < 4; j++)
        {
            strcpy(mExam[i].examChoices[j], mExam[i + 1].examChoices[j]);
        }
        mExam[i].examAnswer = mExam[i + 1].examAnswer;
    }
    N = N - 1;

    fp = fopen(argv[1], "wb");
    fwrite(&N, sizeof(int), 1, fp);
    fwrite(mExam, sizeof(examStruct), N, fp);
    fclose(fp);
    free(mExam);

    clearScreen();
    setPalette("LIGHTGREEN");
    createDlgBox("", "Deletion successful!", ".", "sp");
    return 0;
}
