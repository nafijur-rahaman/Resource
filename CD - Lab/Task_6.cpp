#include <bits/stdc++.h>
using namespace std;

bool isValidIdentifier(string str)
{
    if (str.empty())
        return false;

    if (!((str[0] >= 'a' && str[0] <= 'z') ||
          (str[0] >= 'A' && str[0] <= 'Z') ||
          str[0] == '_'))
    {
        return false;
    }

    for (int i = 1; i < str.length(); i++)
    {
        if (isspace(str[i]))
            return false;

        if (!((str[i] >= 'a' && str[i] <= 'z') ||
              (str[i] >= 'A' && str[i] <= 'Z') ||
              (str[i] >= '0' && str[i] <= '9') ||
              str[i] == '_'))
        {
            return false;
        }
    }

    return true;
}

int main()
{
    cout << "\nEnter a string: ";
    string s;
    getline(cin, s);

    if (isValidIdentifier(s))
        cout << s << " is a valid C++ identifier." << endl;
    else
        cout << s << " is not a valid C++ identifier." << endl;

    return 0;
}
