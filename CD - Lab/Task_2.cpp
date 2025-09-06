#include <bits/stdc++.h>
using namespace std;

bool isKeyword(string s)
{
    string keywords[] = {"int", "float", "if", "else", "while", "for", "return"};
    int n = 7;
    for (int i = 0; i < n; i++)
    {
        if (s == keywords[i])
            return true;
    }
    return false;
}

bool isNumber(string s)
{
    bool hasDecimal = false;
    for (char c : s)
    {
        if (c == '.')
        {
            if (hasDecimal)
                return false;
            hasDecimal = true;
        }
        else if (!isdigit(c))
            return false;
    }
    return !s.empty();
}

bool isIdentifier(string s)
{
    if (s.empty())
        return false;
    if (!isalpha(s[0]) && s[0] != '_')
        return false;
    for (char c : s)
    {
        if (!isalnum(c) && c != '_')
            return false;
    }
    return true;
}

int main()
{
    string str = "int main() { int a = 10; float b = 3.14; if (a > b) { return 0; } }";

    string token = "";
    for (int i = 0; i < str.size(); i++)
    {
        char c = str[i];

        if (isspace(c) || ispunct(c))
        {
            if (!token.empty())
            {

                if (isKeyword(token))
                    cout << token << " -> Keyword\n";
                else if (isNumber(token))
                    cout << token << " -> Number\n";
                else if (isIdentifier(token))
                    cout << token << " -> Identifier\n";
                else
                    cout << token << " -> Unknown\n";

                token.clear();
            }

            if (ispunct(c) && c != ' ')
            {
                cout << c << " -> Operator/Symbol\n";
            }
        }
        else
        {
            token += c;
        }
    }

    if (!token.empty())
    {
        if (isKeyword(token))
            cout << token << " -> Keyword\n";
        else if (isNumber(token))
            cout << token << " -> Number\n";
        else if (isIdentifier(token))
            cout << token << " -> Identifier\n";
        else
            cout << token << " -> Unknown\n";
    }

    return 0;
}
