// check that a given line is a comment or not
#include <bits/stdc++.h>
using namespace std;

bool isComment(string str)
{
    int length = str.length();
    char firstChar = str[0];
    char secondChar = str[1];

    char lastChar = str[str.length() - 1];
    char secondLastChar = str[str.length() - 2];

    if (length >= 2 && firstChar == '/' && secondChar == '/')
    {
        return true;
    }

    if (length >= 4 && firstChar == '/' && secondChar == '*' && secondLastChar == '*' &&
        lastChar == '/')
    {
        return true;
    }

    return false;
}

int main()
{

    string s;

    // cout << "Enter a string: ";
    // getline(cin, s);
    s = "/*GeeksForGeeks GeeksForGeeks*/";
    if (isComment(s))
    {
        cout << "\nLine is a comment" << endl;
    }
    else
    {
        cout << "\nLine is not a comment" << endl;
    }

    return 0;
}