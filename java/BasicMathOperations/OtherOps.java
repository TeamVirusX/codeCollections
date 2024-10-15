public class OtherOps {
    public static int getSquareRoot(int x) {
        for (int i = 0; i < x; i++) {
            if (i * i == x) {
                return i;
            } 
        }
        return -1;
    }
    public static int exponentiateNumber(int x, int powerOf) {
        int temp = 1;
        for (int i = 0; i < powerOf; i++) {
            temp *= x;
        }
        return temp;
    }
    
    public static int integerDivision(int a, int b) {
        return (int) a / b;
    }
    public static void main(String[] args) {
        System.out.println(getSquareRoot(25)); // Test
    }
}
/* C++ equiv syntax
#include <iostream>
using namespace std;

int getSquareRoot(int x)
{
    for (int i = 0; i < x; i++)
    {
        if (i * i == x)
        {
            return i;
        }
    }
    return -1;
}

int exponentiateNumber(int x, int powerOf)
{
    int temp = 1;
    for (int i = 0; i < powerOf; i++)
    {
        temp *= x;
    }
    return temp;
}

int integerDivision(int a, int b)
{
    return (int)a / b;
}

int main()
{
    cout << getSquareRoot(25);
    return 0;
} */
